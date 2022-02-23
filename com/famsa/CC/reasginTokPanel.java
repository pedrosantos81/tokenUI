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

public class reasginTokPanel extends JPanel implements ActionListener{

	private JTextField userText = new JTextField(20);
	private JTextField numtokbefore = new JTextField(30);
	private JTextField numtokenafter = new JTextField(30);
	private JTextField urlText = new JTextField(50);
	private JButton loginButton = new JButton("Reasign Token User");
	private JButton registerButton = new JButton("Clean");
	private String geturl;
	
	public reasginTokPanel(String geturl) {

	    setLayout(null);

		JLabel url = new JLabel("URL :");
		url.setBounds(10,10,120,25);
		add(url);
		
		urlText.setBounds(100,10,300,25);
		urlText.setText(geturl);
		urlText.setEditable(false);
		add(urlText);
	    
		this.setGeturl(geturl);
	    
	    JLabel keyone = new JLabel("Num serie token anterior :");
	    keyone.setBounds(10, 50, 180, 25);
		add(keyone);
		
		
		numtokbefore.setBounds(210,50,160,25);
		add(numtokbefore);
		
		JLabel keytwo = new JLabel("Num serie token nuevo :");
		keytwo.setBounds(10,80,180,25);
		add(keytwo);
		
		numtokenafter.setBounds(210,80,160,25);
		add(numtokenafter);
		
		JLabel iduser = new JLabel("Id User :");
		iduser.setBounds(10,110,80,25);
		add(iduser);
		
		userText.setBounds(210, 110, 160, 25);
		add(userText);	
		
		loginButton.setBounds(10, 140, 150, 25);
		add(loginButton);
		
		registerButton.setBounds(180, 140, 80, 25);
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
					resp=reasignarTokentoUser(url,numtokbefore.getText(),numtokenafter.getText(),userText.getText().trim());
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
	      	numtokbefore.setText("");
	      	numtokenafter.setText("");
	      	userText.setText("");
	      }
	}
	
	public static String reasignarTokentoUser(URL url,String numtokenAntes,String numtokenNuevo,String iduser) throws IOException 
	{
		//URL	   url  = new URL("http://192.168.182.51:8080/rsa/rsaval.jsp"); //QA:172.17.15.159 Prod:192.168.182.51
		//URL	   url  = new URL("http://172.17.15.159:8080/rsa/rsaval.jsp"); //QA
		//URL url = new URL("http://172.17.15.159:8080/rsa/sincToken.jsp");
		System.out.println("reasignar token to user "+iduser);
		LogMensaje logger = new LogMensaje();
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String validacion="";
        StringBuffer response = new StringBuffer();
        StringBuffer resvalida = new StringBuffer();
        try{
    	//  Enviamos los datos asociados a la petici�n
    	connection.setDoOutput(true);
    	connection.setDoInput(true);
    	//connection.setRequestProperty("Content-Type", "text/xml");
    	//connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    	connection.setRequestMethod("POST");
		//connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
		
        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
        wr.write(URLEncoder.encode("operacion", "UTF-8") + "=" + URLEncoder.encode("Reasignar", "UTF-8"));
        wr.write("&");
        wr.write(URLEncoder.encode("serie", "UTF-8") + "=" + URLEncoder.encode(numtokenAntes, "UTF-8"));
        wr.write("&");
        wr.write(URLEncoder.encode("serieNuevo", "UTF-8") + "=" + URLEncoder.encode(numtokenNuevo, "UTF-8"));
        wr.flush();
        logger.guardarMensajeError("token antes: "+numtokenAntes+" ,reasignar nuevo token: "+numtokenNuevo+" a iduser: "+iduser,"",1,"","");
        
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK){
			// Leemos el contenido de la respuesta y lo mostramos por la salida est�ndar
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
			System.out.println("token reasignacion :"+iduser);
			logger.guardarMensajeError("num token reasignado :"+numtokenNuevo +" a iduser :"+iduser,"",1,"","");
			logger.guardarMensajeError(response.toString(),"",1,"","");
			//System.out.println("error: "+response.toString());
			//System.out.println("validacion: "+resvalida.toString());
		} else {
			System.out.println(connection.getResponseCode()+ " - "+connection.getResponseMessage());
			logger.guardarMensajeError(connection.getResponseMessage()+": para reasignar token para iduser: "+iduser +" ,numserietoken nuevo: "+numtokenNuevo+", numtokenantes"+numtokenAntes,"",1,"","");
		}
        
    	// Cerramos la conexi�n
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