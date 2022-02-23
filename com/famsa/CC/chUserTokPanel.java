package com.famsa.CC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.famsa.CC.LogMensaje;
import com.inventario.model.Model;
import com.inventario.model.PlantasDTO;
import com.inventario.model.PlantasTableModel;
import com.utils.Utilerias;

public class chUserTokPanel extends JPanel implements ActionListener {

	  private JTextField userText = new JTextField(20);
	  private JTextField urlText = new JTextField(50);
	  
	  private JButton registerButton = new JButton("Clean");
	  private String geturl;
	  private String [][] rowDatos = new String[3][1];
	  private String datas[][] = {{"", "",""}};
	  private DefaultTableModel dm ;
	  private Vector<Object> data ;
	  private JPanel firstPanel;
	  private JPanel secondPanel;
	  private PlantasTableModel tableModel;
	  private List<PlantasDTO> list;
	  private JTable jTable1;
	  private JScrollPane jScrollPane1;
	  private JButton btnAgregar;
	  
	  
	  GridLayout experimentLayout = new GridLayout(3, 3);
	   
	  private JTextField txtidplanta,txtplanta,txtlimmax,txtlimmmin;
	    
	    
	  
	  public chUserTokPanel()
	  {
//		  final JPanel gui = new JPanel(new BorderLayout(5,5));
//          gui.setBorder( new TitledBorder("BorderLayout(5,5)") );
//
//          //JToolBar tb = new JToolBar();
//          JPanel plafComponents = new JPanel(
//              new FlowLayout(FlowLayout.RIGHT, 3,3));
//          plafComponents.setBorder(
//              new TitledBorder("FlowLayout(FlowLayout.RIGHT, 3,3)") );
//
//          final UIManager.LookAndFeelInfo[] plafInfos =
//              UIManager.getInstalledLookAndFeels();
//          String[] plafNames = new String[plafInfos.length];
//          for (int ii=0; ii<plafInfos.length; ii++) {
//              plafNames[ii] = plafInfos[ii].getName();
//          }
//          final JComboBox plafChooser = new JComboBox(plafNames);
//          plafComponents.add(plafChooser);
//
//          final JCheckBox pack = new JCheckBox("Pack on PLAF change", true);
//          plafComponents.add(pack);
//
//          
//
//          gui.add(plafComponents, BorderLayout.LINE_START);
//
//          JPanel dynamicLabels = new JPanel(new BorderLayout(4,4));
//          dynamicLabels.setBorder(
//              new TitledBorder("BorderLayout(4,4)") );
//          gui.add(dynamicLabels, BorderLayout.WEST);
//
//          final JPanel labels = new JPanel(new GridLayout(0,2,3,3));
//          labels.setBorder(
//              new TitledBorder("GridLayout(0,2,3,3)") );
//
//          JButton addNew = new JButton("Add Another Label");
//          dynamicLabels.add( addNew, BorderLayout.NORTH );
//          addNew.addActionListener( new ActionListener(){
//
//              private int labelCount = 0;
//
//              public void actionPerformed(ActionEvent ae) {
//                  labels.add( new JLabel("Label " + ++labelCount) );
//                  //frame.validate();
//              }
//          } );
//
//          dynamicLabels.add( new JScrollPane(labels), BorderLayout.CENTER );
//
//          String[] header = {"Name", "Value"};
//          String[] a = new String[0];
//          String[] names = System.getProperties().
//              stringPropertyNames().toArray(a);
//          String[][] data = new String[names.length][2];
//          for (int ii=0; ii<names.length; ii++) {
//              data[ii][0] = names[ii];
//              data[ii][1] = System.getProperty(names[ii]);
//          }
//          DefaultTableModel model = new DefaultTableModel(data, header);
//          JTable table = new JTable(model);
//          try {
//              // 1.6+
//              table.setAutoCreateRowSorter(true);
//          } catch(Exception continuewithNoSort) {
//          }
//          JScrollPane tableScroll = new JScrollPane(table);
//          Dimension tablePreferred = tableScroll.getPreferredSize();
//          tableScroll.setPreferredSize(
//              new Dimension(tablePreferred.width, tablePreferred.height/3) );
//
//          JPanel imagePanel = new JPanel(new GridBagLayout());
//          imagePanel.setBorder(
//              new TitledBorder("GridBagLayout()") );
//
//          BufferedImage bi = new BufferedImage(
//              200,200,BufferedImage.TYPE_INT_ARGB);
//          Graphics2D g = bi.createGraphics();
//          GradientPaint gp = new GradientPaint(
//              20f,20f,Color.red, 180f,180f,Color.yellow);
//          g.setPaint(gp);
//          g.fillRect(0,0,200,200);
//          ImageIcon ii = new ImageIcon(bi);
//          JLabel imageLabel = new JLabel(ii);
//          imagePanel.add( imageLabel, null );
//
//          JSplitPane splitPane = new JSplitPane(
//              JSplitPane.VERTICAL_SPLIT,
//              tableScroll,
//              new JScrollPane(imagePanel));
//          gui.add( splitPane, BorderLayout.CENTER );
//
//          add(gui);
		  
		  setLayout(new GridLayout(2,5));
		  
//		  JLabel url = new JLabel("Id :");
//			url.setBounds(10,10,80,25);
//			url.setLocation(4,5);
//			url.setHorizontalAlignment(SwingConstants.LEFT);
//			add(url);
//			
//			urlText.setBounds(10,10,300,25);
//			urlText.setText(geturl);
//			urlText.setEditable(false);
//			urlText.setLocation(40,5);
//			add(urlText);
//		    
//			this.setGeturl(geturl);
//		    
//		    JLabel userLabel = new JLabel("Nombre Planta:");
//			userLabel.setBounds(10, 20, 100, 25);
//			userLabel.setLocation(4,50);
//			add(userLabel);
//			
//			userText.setBounds(100, 50, 160, 25);
//			add(userText);	
		  
		  
			firstPanel = new JPanel();
			//firstPanel.setSize(580,220);
			firstPanel.setLayout(new BorderLayout(1,5));
			
			
			
		  JScrollPane jspane = new JScrollPane();
		  
		  jTable1 = new JTable();
		  list = new ArrayList();
	        //jTable1.setSize(700,400);
	        
	        tableModel = new PlantasTableModel(list);
	        jTable1.setModel(tableModel);
	        
		    jspane.setViewportView(jTable1);
		    firstPanel.add(jspane);
	        //add(firstPanel);
		  
	        
	        JPanel p2 = new JPanel();
			
			p2.setLayout(null);
			
			JLabel url = new JLabel("Id :");
			url.setBounds(10,10,80,25);
			url.setLocation(4,5);
			url.setHorizontalAlignment(SwingConstants.LEFT);
			p2.add(url);
			
			txtidplanta = new JTextField();
			txtidplanta.setBounds(10,10,300,25);
			txtidplanta.setText(geturl);
			txtidplanta.setLocation(40,5);
			p2.add(txtidplanta);
			
			JLabel planta = new JLabel("Nombre Planta:");
			planta.setBounds(10, 20, 100, 25);
			planta.setLocation(4,50);
			p2.add(planta);
			
			txtplanta = new JTextField();
			txtplanta.setBounds(100, 50, 160, 25);
			p2.add(txtplanta);
			
			JLabel limitemin = new JLabel("Limite min:");
			limitemin.setBounds(10, 80, 100, 25);
			limitemin.setLocation(4,80);
			p2.add(limitemin);
			
			
			txtlimmmin = new JTextField();
			txtlimmmin.setBounds(100,80,60,25);
			txtlimmmin.setLocation(80,80);
			p2.add(txtlimmmin);
			
			JLabel limitemax = new JLabel("Limite max:");
			limitemax.setBounds(10, 80, 100, 25);
			limitemax.setLocation(4,110);
			p2.add(limitemax);
			
			
			txtlimmax = new JTextField();
			txtlimmax.setBounds(100,80,60,25);
			txtlimmax.setLocation(80,110);
			p2.add(txtlimmax);
			
			btnAgregar = new JButton("Agregar nueva planta");
			btnAgregar.setBounds(10, 160, 180, 25);
			btnAgregar.setLocation(4,140);
			p2.add(btnAgregar);
			
			
			add(firstPanel);
			add(p2);
			
			btnAgregar.addActionListener(this);

	  }
	  
	  
	  public chUserTokPanel(String geturl) {

		  
		  
		  
		    setLayout(null);
		  //BorderLayout borlay = new BorderLayout();
		    //reloadDatos(rowDatos);

			JLabel url = new JLabel("URL :");
			url.setBounds(10,10,80,25);
			add(url);
			
			urlText.setBounds(100,10,300,25);
			urlText.setText(geturl);
			urlText.setEditable(false);
			
			add(urlText);
		    
			
		    
		    JLabel userLabel = new JLabel("User Id :");
			userLabel.setBounds(10, 50, 80, 25);
			add(userLabel);
			
			userText.setBounds(100, 50, 160, 25);
			add(userText);	
			
			firstPanel = new JPanel();
			firstPanel.setSize(580,220);
			firstPanel.setLocation(10,200);
	        //firstPanel.setBackground(Color.BLUE);
	        
	        jScrollPane1 = new JScrollPane();
	        jTable1 = new JTable();
	        jTable1.setSize(700,400);
	        list = new ArrayList();
	        tableModel = new PlantasTableModel(list);
	        jTable1.setModel(tableModel);
	        
//	        jTable1.setModel(new javax.swing.table.DefaultTableModel(
//		            new Object [][] {
//	
//		            },
//		            new String [] {
//		                "Id", "First Name", "Last Name", "Age"
//		            }
//		        ));
		    
	        jScrollPane1.setViewportView(jTable1);
	        firstPanel.add(jScrollPane1);
	        add(firstPanel);
	        
	        	
	          
		       
	        
			userText.addFocusListener(new FocusListener() {

//        	    @Override
//        	    public void focusGained(FocusEvent e) {
//        	        textField.setText(null); // Empty the text field when it receives focus
//        	    }
//
//        	    @Override
//        	    public void focusLost(FocusEvent e) {
//        	        // You could do something here when the field loses focus, if you like
//        	    }

				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					
				}

				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					if(userText.getText().length()>0){
					System.out.println("perdi data");
					
					
					System.out.println("datosuser: "+Utilerias.getDatosUserToken(userText.getText()));
					rowDatos = Utilerias.getDatosUserToken(userText.getText());
					System.out.println("len :"+rowDatos[0][0].toString());
					
//					for(int i=0;i<=rowDatos.length-1;i++){
//						System.out.println("d :"+rowDatos[i][0].toString());
//					}
					
					
					
					 if((rowDatos[0][0]).length()>0){
						 JOptionPane.showMessageDialog(null,userText.getText(),"OK",JOptionPane.INFORMATION_MESSAGE);
						 reloadDatos(rowDatos);
					 }else{
						 JOptionPane.showMessageDialog(null,"No existe user: "+userText.getText(),"ERROR",JOptionPane.ERROR_MESSAGE);
					 }
					
					}
				}

        	});
			
			
			
			registerButton.setBounds(180, 80, 80, 25);
			add(registerButton);
			
			
			registerButton.addActionListener(this);
			
			
//			String col[] = {"Sr. No", "Name"};
//			JPanel paneltable = new JPanel(new FlowLayout());
//		
//			
//			JTable table = new JTable(data,col);
//			table.setBounds(10, 120, 100, 80);
//			
//			add(table);
//
//			setVisible(true);
//			setSize(300,300);
			
			
	  }

	private void setViewportView(JTable table) {
		// TODO Auto-generated method stub
		
	}
	
	private void reloadDatos(String [][] datos){
		
		String[] columnNames = {"Usuario","Password", "No Serie Token"};
		JPanel panel = new JPanel();
        panel.setSize(580,220);
        
        //String[][] data = new String[0][0];
        JTable tabla = new JTable(3,1);
        //tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
//        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//        //DefaultTableModel model = (DefaultTableModel)tabla.getModel();
//        //for (int d=0;d<datos.length;d++){
//         if(datos.length>0){
//        	   model.addRow(new Object[]{datos[0][0],datos[1][0],datos[2][0]});
//        	   tabla.setModel(model);
//         }
//        //}
         
        //DefaultTableModel dm = new DefaultTableModel()
        //{
//        	public boolean isCellEditable(int row, int col) {
//        		   return false;
//        		 }
        //};
        dm = new DefaultTableModel();
        String header[] = new String[] { "Status", "Task Title", "Start",
                "Pause", "Stop", "Statulses" };
        //dm.setColumnIdentifiers(header);
        dm.setColumnIdentifiers(columnNames);
        tabla.setModel(dm);

        //tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //resizeColumnWidth(tabla);
        if(datos.length>0){
        	data = new Vector<Object>();
        for (int count = 0; count <= datos.length-1; count++) {
        	//data = ;
//            data.add(count);
//            data.add("Project Title" + count);
//            data.add("Start");
//            data.add("Stop");
//            data.add("Pause");
//            data.add("Status");
            data.add(datos[count][0]);
//            System.out.println("test :- " + count);
            
        }
        dm.addRow(data);
        }
       
        
        
        JScrollPane scrollPane = new JScrollPane(tabla);
        panel.add(scrollPane);
        //panel.add(titleLabel);

        JPanel pa= new JPanel(new FlowLayout());
        pa.setBounds(10,150,580,100);
        pa.add(panel);
        add(pa);
		
	}
	
	public void resizeColumnWidth(JTable table) {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 50; // Min width
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String resp ="",err;
		Model dao = new Model();
	  if(arg0.getSource()==btnAgregar) {
          System.out.println("check "+userText.getText());
          if((txtidplanta.getText().length()>0 && Utilerias.esNumero(txtidplanta)) && 
        	  txtplanta.getText().length()>0 && Utilerias.esNumero(txtlimmmin) &&
        	  Utilerias.esNumero(txtlimmax)){
        	  try {
				dao.crearPlanta(Integer.parseInt(txtidplanta.getText()),txtplanta.getText(),
						  Integer.parseInt(txtlimmmin.getText()),Integer.parseInt(txtlimmax.getText()));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				err=Utilerias.getStackTrace(e1);
				JOptionPane.showMessageDialog(this, err,"Error",JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				e1.printStackTrace();
				err=Utilerias.getStackTrace(e1);
				JOptionPane.showMessageDialog(this, err,"Error",JOptionPane.ERROR_MESSAGE);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				e1.printStackTrace();
				err=Utilerias.getStackTrace(e1);
				JOptionPane.showMessageDialog(this, err,"Error",JOptionPane.ERROR_MESSAGE);
			}
        	  
        	  
        	  
          }else{JOptionPane.showMessageDialog(this,"Llene el campo");
               txtidplanta.requestFocusInWindow();
               
          }
      }else if(arg0.getSource()==registerButton){
      	
      	userText.setText("");
      	data.removeAllElements();
      	dm.fireTableDataChanged();
      	System.out.println("rw: "+dm.getRowCount());
      	if (dm.getRowCount() > 0) {
            for (int i = dm.getRowCount() - 1; i > -1; i--) {
                dm.removeRow(i);
            }
        }
      }
	}
	

	public String[][] getRowDatos() {
		return rowDatos;
	}

	public void setRowDatos(String[][] rowDatos) {
		this.rowDatos = rowDatos;
	}

	
}