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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.famsa.CC.LogMensaje;
import com.utils.Utilerias;

public class desactivaTokPanel extends JPanel implements ActionListener{

	private JTextField userText = new JTextField(20);
	private JTextField numserieText = new JTextField(30);
	private JTextField urlText = new JTextField(50);
	private JButton loginButton = new JButton("Desactivate Token User");
	private JButton registerButton = new JButton("Clean");
	private String geturl;
	
	public desactivaTokPanel(String geturl) {

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
		iduser.setBounds(10, 50, 80, 25);
		add(iduser);
		
		
		userText.setBounds(120,50,160,25);
		add(userText);
		
		JLabel numserie = new JLabel("Num Serie Token :");
		numserie.setBounds(10,80,130,25);
		add(numserie);
		
		numserieText.setBounds(120,80,160,25);
		add(numserieText);
		
		
		loginButton.setBounds(10, 140, 180, 25);
		add(loginButton);
		
		registerButton.setBounds(210, 140, 80, 25);
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
					resp=desactivarTokentoUser(url,numserieText.getText(),userText.getText().trim());
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
	      	userText.setText("");
	      	numserieText.setText("");
	      	
	      }
	}

	public String getGeturl() {
		return geturl;
	}

	public void setGeturl(String geturl) {
		this.geturl = geturl;
	}
	
	public static String desactivarTokentoUser(URL url,String numserietoken,String iduser) throws IOException 
	{
		//URL	   url  = new URL("http://192.168.182.51:8080/rsa/rsaval.jsp"); //QA:172.17.15.159 Prod:192.168.182.51
		//URL	   url  = new URL("http://172.17.15.159:8080/rsa/rsaval.jsp"); //QA
		//URL url = new URL("http://172.17.15.159:8080/rsa/sincToken.jsp");
		System.out.println("desactivar token to user "+iduser);
		LogMensaje logger = new LogMensaje();
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String validacion="";
        StringBuffer response = new StringBuffer();
        StringBuffer resvalida = new StringBuffer();
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
        wr.write(URLEncoder.encode("operacion", "UTF-8") + "=" + URLEncoder.encode("Desactivar", "UTF-8"));
        wr.write("&");
        wr.write(URLEncoder.encode("serie", "UTF-8") + "=" + URLEncoder.encode(numserietoken, "UTF-8"));
        wr.flush();
        logger.guardarMensajeError("desactivar token: "+numserietoken+ " a iduser: "+iduser,"",1,"","");
        
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK){
			// Leemos el contenido de la respuesta y lo mostramos por la salida estándar
    		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String		   line   = reader.readLine();
			//while (line != null) {
			while ((line = reader.readLine()) != null) {	
				validacion = line;
				//line = line.replace("<Validacion>","").trim().replace("</Validacion>","").replaceAll("<ValToken>true</ValToken>","").replaceAll("<ValToken>false</ValToken>","");
				//validacion = validacion.replace("<Validacion>","").replace("</Validacion>","").replace("<Error>","").replace("</Error>","").replaceAll("\\d+", "").trim();
				System.out.println(line);
				
				//line = reader.readLine();  
				response.append(line);
				resvalida.append(validacion);
			}
			reader.close();
			System.out.println("token desactivado :"+iduser);
			logger.guardarMensajeError("num token desactivado :"+numserietoken +" iduser: "+iduser,"",1,"","");
			logger.guardarMensajeError(response.toString(),"",1,"","");
			//System.out.println("error: "+response.toString());
			//System.out.println("validacion: "+resvalida.toString());
		} else {
			System.out.println(connection.getResponseMessage());
			logger.guardarMensajeError(connection.getResponseCode()+" - "+connection.getResponseMessage()+": para activar token para iduser: "+iduser +" ,numserietoken: "+numserietoken,"",1,"","");
		}
        
    	// Cerramos la conexión
    	connection.disconnect();
        }catch(IOException e){
        	logger.guardarMensajeExc(e,connection.getResponseMessage(),1,"","");
        }
        return response.toString();
	}

}
