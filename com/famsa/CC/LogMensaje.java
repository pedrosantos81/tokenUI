package com.famsa.CC;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogMensaje {

	
	/**
     * Guarda un mensaje en una archivo de texto para futuras rastreo de errores.
     *
     * @param mensaje recibe el mensaje que sera guardado en el archivo de texto.
     * @param tipoMensaje (1) para mensaje valido y (0)para mensaje invalidos
     * @return void
     */
	public  final String UBICACION_ARCHIVO_RECURSOS_CONFIGURACION = "com.famsa.CC.rutas";
	public  final ResourceBundle rbMensajes= ResourceBundle.getBundle(UBICACION_ARCHIVO_RECURSOS_CONFIGURACION);
	
	public void guardarMensaje(String mensaje, int tipoMensaje) {

        String tipoArchivo = "";

        if (tipoMensaje == 1) {
            tipoArchivo = getConfiguracion("success");//bundle.getString("ruta.archivo.validos");

        } else {
            tipoArchivo = getConfiguracion("failure");//bundle.getString("ruta.archivo.no_validos");
        }

        try {

            BufferedWriter out = null;

            if (new File(tipoArchivo).exists()) {
                out = new BufferedWriter(new FileWriter(tipoArchivo, true));
            } else {
                out = new BufferedWriter(new FileWriter(tipoArchivo));
            }
            try {

                //out.write( "-Date: " + now("dd/MM/yyyy HH:MM:ss")+ " -- " + mensaje);
                out.write(  mensaje);
                out.newLine();

            } catch (IOException e) {

            } finally {
            	
                out.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(LogMensaje.class.getName()).log(Level.SEVERE, "", ex);

        }

     }
	
	public void guardarMensajeError(Exception e,String mensaje, int tipoMensaje,String fecha,String hora) {

        String tipoArchivo = "";

        if (tipoMensaje == 1) {
            tipoArchivo = getConfiguracion("errorexc");//bundle.getString("ruta.archivo.validos");

        } 

        try {

            BufferedWriter out = null;
            
            if (new File(tipoArchivo).exists()) {
                out = new BufferedWriter(new FileWriter(tipoArchivo, true));
            } else {
                out = new BufferedWriter(new FileWriter(tipoArchivo));
            }
            try {

            	if(fecha.equalsIgnoreCase("") && hora.equalsIgnoreCase("")){
                //out.write( "-Date: " + now("dd/MM/yyyy HH:MM:ss")+ " -- " + mensaje);
            	PrintWriter pWriter = new PrintWriter(out, true);
            	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            	Date date = new Date();
            	String timeNow = dateFormat.format(date); // pretty date
            	pWriter.write("["+timeNow + "] " );
                //out.write( mensaje);
                e.printStackTrace(pWriter);
                out.write(  mensaje);
            	}
            	else{
               // out.write( "-Date: " + fecha +" " +hora+ " -- " + mensaje);
                out.write(  mensaje);
            	}
                out.newLine();

            } catch (IOException ex) {

            } finally {
            	
                out.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(LogMensaje.class.getName()).log(Level.SEVERE, "", ex);

        }

     }
	
    public void guardarMensaje(String mensaje, int tipoMensaje,String fecha,String hora) {

        String tipoArchivo = "";

        if (tipoMensaje == 1) {
            tipoArchivo = getConfiguracion("success");//bundle.getString("ruta.archivo.validos");

        } else {
            tipoArchivo = getConfiguracion("failure");//bundle.getString("ruta.archivo.no_validos");
        }

        try {

            BufferedWriter out = null;

            if (new File(tipoArchivo).exists()) {
                out = new BufferedWriter(new FileWriter(tipoArchivo, true));
            } else {
                out = new BufferedWriter(new FileWriter(tipoArchivo));
            }
            try {

            	if(fecha.equalsIgnoreCase("") && hora.equalsIgnoreCase("")){
                //out.write( "-Date: " + now("dd/MM/yyyy HH:MM:ss")+ " -- " + mensaje);
                out.write( mensaje);
            	}
            	else{
               // out.write( "-Date: " + fecha +" " +hora+ " -- " + mensaje);
                out.write(  mensaje);
            	}
                out.newLine();

            } catch (IOException e) {

            } finally {
            	
                out.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(LogMensaje.class.getName()).log(Level.SEVERE, "", ex);

        }

     }
    
    public void guardarMensajeError(String e,String mensaje, int tipoMensaje,String fecha,String hora) {

        String tipoArchivo = "";

        if (tipoMensaje == 1) {
            tipoArchivo = getConfiguracion("success");//bundle.getString("ruta.archivo.validos");

        } 

        try {

            BufferedWriter out = null;
            
            if (new File(tipoArchivo).exists()) {
                out = new BufferedWriter(new FileWriter(tipoArchivo, true));
            } else {
                out = new BufferedWriter(new FileWriter(tipoArchivo));
            }
            try {

            	//if(fecha.equalsIgnoreCase("") && hora.equalsIgnoreCase("")){
                //out.write( "-Date: " + now("dd/MM/yyyy HH:MM:ss")+ " -- " + mensaje);
            	//PrintWriter pWriter = new PrintWriter(out, true);
            	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            	Date date = new Date();
            	String timeNow = dateFormat.format(date); // pretty date
            	//pWriter.write("["+timeNow + "] " );
                //out.write( mensaje);
               // e.printStackTrace(pWriter);
            	//}
            	//else{
               // out.write( "-Date: " + fecha +" " +hora+ " -- " + mensaje);
                out.write(  "["+timeNow + "] "+e);
            	//}
                out.newLine();

            } catch (IOException ex) {

            } finally {
            	
                out.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(LogMensaje.class.getName()).log(Level.SEVERE, "", ex);

        }

     }
    
    public void guardarMensaje(String dia,String cuenta,String user,String tipocartera,String fecha,String hora,String plaza, int tipoMensaje) {

        String tipoArchivo = "";
        //System.out.println("entro write msj");
        if (tipoMensaje == 1) {
            tipoArchivo = getConfiguracion("success");//bundle.getString("ruta.archivo.validos");

        } else if(tipoMensaje == 0) {
            tipoArchivo = getConfiguracion("failure");//bundle.getString("ruta.archivo.no_validos");
        } else if(tipoMensaje == 2){
            tipoArchivo = getConfiguracion("reportes");//bundle.getString("ruta.archivo.no_validos");
        }

        try {

            BufferedWriter out = null;

            if (new File(tipoArchivo).exists()) {
                out = new BufferedWriter(new FileWriter(tipoArchivo, true));
            } else {
                out = new BufferedWriter(new FileWriter(tipoArchivo));
            }
            try {

                //out.write( "-Date: " + now("dd/MM/yyyy HH:MM:ss")+ " -- " + mensaje);
                //out.write( "- Dia: "+dia+ "  CuentaCte: "+cuenta+"  Usuario: "+user + " Tipo: "+tipocartera+"  Fecha: "+fecha+"  Horaenvio: "+ hora+"  Plaza: "+plaza);
                //out.write(String.format("%-16.20s %-40.40s %-20.30s %-25.30s %-20.30s %-20.30s %-20.30s","-Dia: "+dia,"CuentaCte: "+cuenta,"Usuario: "+user,"Tipo: "+tipocartera,"Fecha: "+fecha,"Horaenvio: "+ hora,"Plaza: "+plaza));
                out.write(String.format("%-16.20s %-30.30s %-20.30s %-25.30s %-20.30s %-20.30s %-20.30s",dia,cuenta,user,tipocartera,fecha, hora,plaza));
                out.newLine();

            } catch (IOException e) {
            	e.printStackTrace();

            } finally {
            	
                out.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(LogMensaje.class.getName()).log(Level.SEVERE, "", ex);

        }

     }
    
    public void guardarMensajeExc(Exception e,String mensaje, int tipoMensaje,String fecha,String hora) {

        String tipoArchivo = "";

        if (tipoMensaje == 1) {
            tipoArchivo = getConfiguracion("success");//bundle.getString("ruta.archivo.validos");

        } 

        try {

            BufferedWriter out = null;
            
            if (new File(tipoArchivo).exists()) {
                out = new BufferedWriter(new FileWriter(tipoArchivo, true));
            } else {
                out = new BufferedWriter(new FileWriter(tipoArchivo));
            }
            try {

            	if(fecha.equalsIgnoreCase("") && hora.equalsIgnoreCase("")){
                    //out.write( "-Date: " + now("dd/MM/yyyy HH:MM:ss")+ " -- " + mensaje);
                	PrintWriter pWriter = new PrintWriter(out, true);
                	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                	Date date = new Date();
                	String timeNow = dateFormat.format(date); // pretty date
                	pWriter.write("["+timeNow + "] " );
                    //out.write( mensaje);
                    e.printStackTrace(pWriter);
                	}
                	else{
                   // out.write( "-Date: " + fecha +" " +hora+ " -- " + mensaje);
                    out.write(  mensaje);
                	}
                out.newLine();

            } catch (IOException ex) {

            } finally {
            	
                out.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(LogMensaje.class.getName()).log(Level.SEVERE, "", ex);

        }

     }



    protected String getConfiguracion(String recurso) {
      return rbMensajes.getString(recurso);

      }
    
    public String now(String dateFormat) {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	    
	    Locale l = new Locale("es","MX");
	    Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("America/Mexico_City"),l);
	    
	    return sdf.format(cal2.getTime());
	}

    

}
