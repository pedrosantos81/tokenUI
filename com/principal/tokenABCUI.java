package com.principal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.famsa.CC.StockPlantaPanel;
import com.famsa.CC.activarTokPanel;
import com.famsa.CC.asignUserTokPanel;
import com.famsa.CC.autentificacionTokPanel;
import com.famsa.CC.chUserTokPanel;
import com.famsa.CC.createUserTokPanel;
import com.famsa.CC.desactivaTokPanel;
import com.famsa.CC.productosPanel;
import com.famsa.CC.reasginTokPanel;
import com.famsa.CC.sincronizerTokPanel;


public class tokenABCUI extends JFrame {
	
	private String checkuserRSA = "";
	private String createUserToken = "";
	private String asignTokentoUser ="";
	private String activarTokentoUser="";
	private String desactivarTokentoUser ="";
	private String reasignarTokentoUser="";
	private String sincronizarToken="";
	private String sendToken="";
	
	public void ini(){
		
		Properties prop = new Properties();
		InputStream input = null;
	 
		try {
	 
			input = new FileInputStream(System.getProperty("user.dir") +"\\urls.properties");
	 
			// load a properties file
			prop.load(input);
	 
			// get the property value and print it out
			System.out.println(prop.getProperty("message"));
			System.out.println(prop.getProperty("checkuserRSA"));
			checkuserRSA = prop.getProperty("checkuserRSA");
			System.out.println(prop.getProperty("createTokenUser"));
			createUserToken = prop.getProperty("createTokenUser");
			asignTokentoUser = prop.getProperty("asignTokentoUser");
			activarTokentoUser = prop.getProperty("activarTokentoUser");
			desactivarTokentoUser = prop.getProperty("desactivarTokentoUser");
			reasignarTokentoUser = prop.getProperty("reasignarTokentoUser");
			sincronizarToken = prop.getProperty("sincronizarToken");
			sendToken = prop.getProperty("autentificacionToken");
			
			//System.out.println(prop.getProperty("dbpassword"));
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
    public tokenABCUI() {
        
        setTitle("ABC Tokens");
        JTabbedPane jtp = new JTabbedPane();
        getContentPane().add(jtp);
        //String checkuserRSA = getConfiguracion("checkuserRSA");
        ini();
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JLabel label1 = new JLabel();
        label1.setText("You are in area of Tab1");
        JLabel label2 = new JLabel();
        label2.setText("You are in area of Tab2");
        jp1.add(label1);
        jp2.add(label2);
        
        
        jtp.addTab("Agregar Plantas", new chUserTokPanel());
        jtp.addTab("Create Producto", new productosPanel());
        jtp.addTab("Asignar stock ",new StockPlantaPanel());
//        jtp.addTab("Activar Token User",new activarTokPanel(getActivarTokentoUser()));
//        jtp.addTab("Desactivar Token User",new desactivaTokPanel(getDesactivarTokentoUser()));

        //setLayout(new FlowLayout(1,2,1));
    }
    public static void main(String[] args) {
        
    	tokenABCUI tp = new tokenABCUI();
        tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tp.setVisible(true);
        tp.setSize(1300,400);
        
    }
    
   

	public String getCheckuserRSA() {
		return checkuserRSA;
	}

	public void setCheckuserRSA(String checkuserRSA) {
		this.checkuserRSA = checkuserRSA;
	}

	public String getCreateUserToken() {
		return createUserToken;
	}

	public void setCreateUserToken(String createUserToken) {
		this.createUserToken = createUserToken;
	}

	public String getAsignTokentoUser() {
		return asignTokentoUser;
	}

	public void setAsignTokentoUser(String asignTokentoUser) {
		this.asignTokentoUser = asignTokentoUser;
	}

	public String getActivarTokentoUser() {
		return activarTokentoUser;
	}

	public void setActivarTokentoUser(String activarTokentoUser) {
		this.activarTokentoUser = activarTokentoUser;
	}

	public String getDesactivarTokentoUser() {
		return desactivarTokentoUser;
	}

	public void setDesactivarTokentoUser(String desactivarTokentoUser) {
		this.desactivarTokentoUser = desactivarTokentoUser;
	}

	public String getReasignarTokentoUser() {
		return reasignarTokentoUser;
	}

	public void setReasignarTokentoUser(String reasignarTokentoUser) {
		this.reasignarTokentoUser = reasignarTokentoUser;
	}

	public String getSincronizarToken() {
		return sincronizarToken;
	}

	public void setSincronizarToken(String sincronizarToken) {
		this.sincronizarToken = sincronizarToken;
	}

	public String getSendToken() {
		return sendToken;
	}

	public void setSendToken(String sendToken) {
		this.sendToken = sendToken;
	}
}


class CitiesPanel extends JPanel {

	  public CitiesPanel() {

	    JButton b1 = new JButton("New York");
	    add(b1);
	    JButton b2 = new JButton("London");
	    add(b2);
	    JButton b3 = new JButton("Hong Kong");
	    add(b3);
	    JButton b4 = new JButton("Tokyo");
	    add(b4);
	  }
	}



class ColorsPanel extends JPanel {

	  public ColorsPanel() {

		  setLayout(null);

			JLabel userLabel = new JLabel("User");
			userLabel.setBounds(10, 10, 80, 25);
			add(userLabel);

			JTextField userText = new JTextField(20);
			userText.setBounds(100, 10, 160, 25);
			add(userText);

			JLabel passwordLabel = new JLabel("Password");
			passwordLabel.setBounds(10, 40, 80, 25);
			add(passwordLabel);

			JPasswordField passwordText = new JPasswordField(20);
			passwordText.setBounds(100, 40, 160, 25);
			add(passwordText);

			JButton loginButton = new JButton("login");
			loginButton.setBounds(10, 80, 80, 25);
			add(loginButton);
			
			JButton registerButton = new JButton("register");
			registerButton.setBounds(180, 80, 80, 25);
			add(registerButton);
	  }
	}

	class FlavorsPanel extends JPanel {

	  public FlavorsPanel() {

	    JComboBox jcb = new JComboBox();
	    jcb.addItem("Vanilla");
	    jcb.addItem("Chocolate");
	    jcb.addItem("Strawberry");
	    add(jcb);
	  }
	}

	
	class PanelDatos extends JPanel {
		
		private JTextField campoNombre = new JTextField();
		static JFrame frame;
		
		public PanelDatos() {
		setLayout(new GridLayout(4, 2));
		JLabel etiquetaNombre = new JLabel("Nombre: ", JLabel.RIGHT);
		
		add(etiquetaNombre);
		add(campoNombre);
		JLabel etiquetaApellidos = new JLabel("Apellidos:", JLabel.RIGHT);
		JTextField campoApellidos = new JTextField();
		add(etiquetaApellidos);
		add(campoApellidos);
		JLabel etiquetaNP = new JLabel("Número Personal:", JLabel.RIGHT);
		JTextField campoNP = new JTextField();
		add(etiquetaNP);
		add(campoNP);
		JButton b1 = new JButton("New York");
		JButton b2 = new JButton("New York");
		add(b1);
		add(b2);
		ButtonGroup grupoBotones = new ButtonGroup();
		JRadioButton mañana = new JRadioButton("Grupo Mañana", true);
		JRadioButton tarde = new JRadioButton("Grupo Tarde");
		grupoBotones.add(mañana);
		grupoBotones.add(tarde);
		add(mañana);
		add(tarde);
		
		b1.addActionListener(new ActionListener()
				{
			  public void actionPerformed(ActionEvent e)
			  {
			    // display/center the jdialog when the button is pressed
			    JDialog d = new JDialog(frame, "Hello", true);
			    d.setLocationRelativeTo(frame);
			    d.setVisible(true);
			  }
			});
		b2.addActionListener(new ActionListener()
				{
			  public void actionPerformed(ActionEvent e)
			  {
			    // display/center the jdialog when the button is pressed
			    JDialog d = new JDialog(frame, "Hello", true);
			    d.setLocationRelativeTo(frame);
			    d.setVisible(true);
			  }
			});
		}
		}

	
	


	