package com.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.rmi.RemoteException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.xml.rpc.ServiceException;


import com.famsa.service.DatosTokenServicioImplServiceLocator;

public class Utilerias {
	
	public static String getStackTrace(Throwable t) {
	    StringWriter sw = new StringWriter();
	    t.printStackTrace(new PrintWriter(sw));
	    return sw.toString();
	}
	
	public static boolean esNumero(JTextField field) {

	    Pattern pt = Pattern.compile("\\d+");
	    Matcher mt = pt.matcher(field.getText());
	    return mt.find();
	}
	
	public static String [][] getDatosUserToken(String iduser){
		
		DatosTokenServicioImplServiceLocator port = new DatosTokenServicioImplServiceLocator();
		String[][] rowData = new String[3][1];
		String datos="",user="",pass,numserie="";
		try{
			System.out.println("iduser: "+iduser);
			datos = port.getdatosTokenServicioImpl().datosTokenService(iduser);
			System.out.println("datos de "+iduser+": "+datos);
			//String p []= datos.split("!");
			
			datos = datos.equals("0")?"":datos;
			System.out.println("d: "+datos);
			if(datos.length()>0){
			 user = datos.substring(0,datos.indexOf("!"));
			 datos = datos.substring(datos.indexOf("!") + 1);
		     numserie = datos.substring(0, datos.indexOf("!"));
		     datos = datos.substring(datos.indexOf("!") + 1);
		     pass = datos.substring(0, datos.indexOf("!"));
		     datos = datos.substring(datos.indexOf("!") + 1);
		     
		     
		    
		   System.out.println("us: "+user+", numserie:"+numserie+", pass: "+pass );
		    
		   //rowData [][ ] = user;
		   rowData  [0][0] = user;
		   rowData  [1][0] = pass;
		   rowData  [2][0] = numserie;
//		   for(int i=0;i<p.length;i++){
//			   System.out.println(p[i]);
//			   rowData[i][0] = p[i];
//		   }
			}else{
				rowData [0][0] = "";
			}
		    	//rowData  = {{"1.", "ABC","151"}};
		    	 
			
		}catch(ServiceException e1){
			e1.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rowData;
	}

}
