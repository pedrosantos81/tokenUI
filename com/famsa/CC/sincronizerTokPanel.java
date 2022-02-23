package com.famsa.CC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.famsa.CC.LogMensaje;
import com.utils.Utilerias;

public class sincronizerTokPanel extends JPanel implements ActionListener{

	private JTextField userText = new JTextField(20);
	private JTextField numserieText = new JTextField(30);
	private JTextField keyone = new JTextField(30);
	private JTextField keytwo = new JTextField(30);
	private JTextField urlText = new JTextField(50);
	private JButton loginButton = new JButton("Sincronizer Token User");
	private JButton registerButton = new JButton("Clean");
	private String geturl;
	
	public sincronizerTokPanel(String geturl) {

	    setLayout(null);

		JLabel url = new JLabel("URL :");
		url.setBounds(10,10,120,25);
		add(url);
		
		urlText.setBounds(100,10,300,25);
		urlText.setText(geturl);
		urlText.setEditable(false);
		add(urlText);
	    
		this.setGeturl(geturl);
		
		JLabel iduser = new JLabel("Id User :");
		iduser.setBounds(10,50,80,25);
		add(iduser);
		
		userText.setBounds(210, 50, 160, 25);
		add(userText);
	    

		JLabel numserietok = new JLabel("Num serie Token :");
		numserietok.setBounds(10, 80, 180, 25);
		add(numserietok);
		
		numserieText.setBounds(210,80,160,25);
		add(numserieText);
		
		JLabel key_one = new JLabel("key dinamic 1 :");
		key_one.setBounds(10,110,180,25);
		add(key_one);
		
		keyone.setBounds(210,110,160,25);
		add(keyone);
		
		JLabel key_two = new JLabel("key dinamic 2 :");
		key_two.setBounds(10,140,90,25);
		add(key_two);
		
		keytwo.setBounds(210, 140, 160, 25);
		add(keytwo);	
		
		loginButton.setBounds(10, 200, 180, 25);
		add(loginButton);
		
		registerButton.setBounds(220, 200, 80, 25);
		add(registerButton);
		
		loginButton.addActionListener(this);
		registerButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String resp ="",err;
		if(arg0.getSource()==loginButton) {
	          System.out.println("check "+userText.getText());
	          if(userText.getText().length()>0){
	        	  URL url;
				try {
					url = new URL(this.getGeturl());
					resp=sincronizarTokentoUser(url,userText.getText().trim(),numserieText.getText().trim(),keyone.getText().trim(),keytwo.getText().trim());
					JOptionPane.showMessageDialog(this,resp,"OK",JOptionPane.INFORMATION_MESSAGE);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					err=Utilerias.getStackTrace(e);
					JOptionPane.showMessageDialog(this, err,"Error",JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					err=Utilerias.getStackTrace(e);
					JOptionPane.showMessageDialog(this, err,"Error",JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
	        	  
	          }
	      }else if(arg0.getSource()==registerButton){
	      	System.out.println("clean "+this.getGeturl());
	      	numserieText.setText("");
	      	keyone.setText("");
	      	keytwo.setText("");
	      	userText.setText("");
	      }
	}
	
	public static String sincronizarTokentoUser(URL url,String iduser,String numserietoken,String keydinamic1,String keydinamic2) throws IOException 
	{
		//URL	   url  = new URL("http://192.168.182.51:8080/rsa/rsaval.jsp"); //QA:172.17.15.159 Prod:192.168.182.51
		//URL	   url  = new URL("http://172.17.15.159:8080/rsa/rsaval.jsp"); //QA
		//URL url = new URL("http://172.17.15.159:8080/rsa/sincToken.jsp");
		System.out.println("sincronizar token to user "+iduser);
		LogMensaje logger = new LogMensaje();
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String validacion="";
        StringBuffer response = new StringBuffer();
        StringBuffer resvalida = new StringBuffer();
        String msgdesc ="";
        try{
    	//  Enviamos los datos asociados a la petición
    	connection.setDoOutput(true);
    	connection.setDoInput(true);
    	//connection.setRequestProperty("Content-Type", "text/xml");
    	//connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    	connection.setRequestMethod("POST");
		//connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
		
        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
        wr.write(URLEncoder.encode("operacion", "UTF-8") + "=" + URLEncoder.encode("Sincronizar", "UTF-8"));
        wr.write("&");
        wr.write(URLEncoder.encode("token", "UTF-8") + "=" + URLEncoder.encode(keydinamic1, "UTF-8"));
        wr.write("&");
        wr.write(URLEncoder.encode("serie", "UTF-8") + "=" + URLEncoder.encode(numserietoken, "UTF-8"));
        wr.write("&");
        wr.write(URLEncoder.encode("token2", "UTF-8") + "=" + URLEncoder.encode(keydinamic2, "UTF-8"));
        wr.flush();
        logger.guardarMensajeError("sincronizando token: "+numserietoken+" a iduser: "+iduser,"",1,"","");
        
        //para parsear response
        Pattern pat = Pattern.compile("(<Error>[0-9]</Error>)(<Descripcion>(.*?)(\\w+)(.*)</Descripcion>)");
        Matcher mat = null;
        
        String code ="";
        String desc = "";
        
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK){
			// Leemos el contenido de la respuesta y lo mostramos por la salida estándar
    		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String		   line   = reader.readLine();
			//while (line != null) {
			while ((line = reader.readLine()) != null) {	
				response.append(line);
			}
			reader.close();
			
			mat = pat.matcher(response.toString());
			 while (mat.find()) {
	        	   System.out.println("Code Error: " + mat.group(1) + " - Desc: "+mat.group(2));
	        	   
	        	   msgdesc = mat.group(1).replace("<Error>","").trim().replace("</Error>","").trim();
	        	   code = mat.group(1).replace("<Error>","").trim().replace("</Error>","").trim();
	        	   desc = mat.group(2).replace("<Descripcion>","").trim().replace("</Descripcion>","").trim();
	        	   msgdesc = msgdesc +"!"+mat.group(2).replace("<Descripcion>","").trim().replace("</Descripcion>","").trim()+"!";
	        	  }
	        System.out.println("code:" +code+" ,desc: "+desc);
	        System.out.println("resp:" +response);
	        
	        if(code.equals("0")){
				//logger.guardarMensajeError("token activado :"+iduser,"",1,"","");
				logger.guardarMensajeError("OK num token sincronizado: "+numserietoken +" a iduser: "+iduser,"",1,"","");
				logger.guardarMensajeError(response.toString(),"",1,"","");
			}else{
				logger.guardarMensajeError("FALLA al sincronizar num token: "+numserietoken+" a iduser: "+iduser,"",1,"","");
				logger.guardarMensajeError(response.toString(),"",1,"","");
			}
			
		} else {
			System.out.println(connection.getResponseCode()+ " - "+connection.getResponseMessage());
			logger.guardarMensajeError("ERROR - "+connection.getResponseCode()+connection.getResponseMessage()+": FALLO sincronizacion de num token: "+numserietoken,"",1,"","");
		}
        
    	// Cerramos la conexión
    	connection.disconnect();
        }catch(IOException e){
        	logger.guardarMensajeExc(e,connection.getResponseMessage(),1,"","");
        }
        return response.toString();
	}

	public String getGeturl() {
		return geturl;
	}

	public void setGeturl(String geturl) {
		this.geturl = geturl;
	}

}
