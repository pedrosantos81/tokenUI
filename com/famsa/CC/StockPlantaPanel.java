package com.famsa.CC;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.inventario.model.ErrorMensaje;
import com.inventario.model.Model;
import com.inventario.model.PlantasDTO;
import com.inventario.model.ProductoTableModel;
import com.utils.Utilerias;

public class StockPlantaPanel extends JPanel implements ActionListener{

	private JPanel panel;
	private ProductoTableModel tableModel;
	private List<PlantasDTO> list;
	private JTable jTable1;
	private JButton btnAgregar;

    private JLabel l, l1;
    private JComboBox c1;
    private JTextField txtidproducto,txtproducto,txtcantstock;
    
    private static JComboBox comboBox;
    private static JTextField textField;
    
    private JLabel label1,label2,label3;
    private JComboBox combo1,combo2,combo3;
    private JButton boton1;
    private Model model;
    
	public StockPlantaPanel() {
		
		//setLayout(null);
		
		Model mq = new Model();
		
		setLayout(null);
        label1=new JLabel("Plantas:");
        label1.setBounds(10,10,100,30);
        add(label1);
        combo1=new JComboBox();
        combo1.setBounds(120,10,100,30);
        
        HashMap<String, Integer> mapplantas = new HashMap<String,Integer>();
		try {
			mapplantas = mq.getCmboxPlantas();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        for(String s : mapplantas.keySet()){
        	combo1.addItem(s);
        }
        add(combo1);
        
        label2=new JLabel("Productos:");
        label2.setBounds(10,50,100,30);
        add(label2);
        combo2=new JComboBox();
        combo2.setBounds(120,50,80,30);
        
        HashMap<String, Integer> mapproductos = new HashMap<String,Integer>();
		try {
			mapproductos = mq.getCmboxProductos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for(String s : mapproductos.keySet()){
        	combo2.addItem(s);
        }
        add(combo2);
        
        label3 = new JLabel("Cant prod:");
        label3.setBounds(10,90,100,30);
        add(label3);
        
        txtcantstock = new JTextField();
        txtcantstock.setBounds(120,90,50,30);
        add(txtcantstock);
        
//        label3=new JLabel("Azul:");
//        label3.setBounds(10,90,100,30);
//        add(label3);
//        combo3=new JComboBox();
//        combo3.setBounds(120,90,50,30);
//        for(int f=0;f<=255;f++) {
//            combo3.addItem(String.valueOf(f));
//        }
//        add(combo3);
        
        
        
        boton1=new JButton("Agregar Stock producto a planta");
        boton1.setBounds(10,130,260,30);
        add(boton1);
        boton1.addActionListener(this);
//		
        combo1.addActionListener(this);
        combo2.addActionListener(this);
//		panel = new JPanel();
//		//firstPanel.setSize(580,220);
//		panel.setLayout(new GridBagLayout());
//		
//		GridBagConstraints gbc = new GridBagConstraints();
//		gbc.gridwidth = GridBagConstraints.REMAINDER;
//		panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
//		
////		 array of string containing cities
//        String s1[] = { "Jalpaiguri", "Mumbai", "Noida", "Kolkata", "New Delhi" };
// 
//        // create checkbox
//        c1 = new JComboBox(s1);
//        
//        //c1.setLocation(2,5);
// 
//        
//        l = new JLabel("select your city ");
//        l1 = new JLabel("Jalpaiguri selected");
//        
//        panel.add(l);
//        
//        // add combobox to panel
//        panel.add(c1);
//        
// 
//        panel.add(l1);
//        
////      add ItemListener
//        c1.addActionListener(new ActionListener() {
//			//@Override
//			public void actionPerformed(ActionEvent e) {
//				//tf.setText(combo.getSelectedItem().toString());
//			}
//		});
//        
//        add(panel);
        
		//super(new BorderLayout());
        // Panel for the labels
//        JPanel labelPanel = new JPanel(new GridLayout(2, 1)); // 2 rows 1 column
//        add(labelPanel, BorderLayout.WEST);
//
//        // Panel for the fields
//        JPanel fieldPanel = new JPanel(new GridLayout(2, 1)); // 2 rows 1 column
//        add(fieldPanel, BorderLayout.CENTER);
//
//        // Combobox
//        JLabel labelCombo = new JLabel("Bank Code");
//
//        // Options in the combobox
//        String[] options = { "Option1", "Option2", "Option3", "Option4", "Option15" };
//        comboBox = new JComboBox(options);
//        comboBox.addActionListener(new ActionListener() {
//
//            //@Override
//            public void actionPerformed(ActionEvent e) {
//                // Do something when you select a value
//
//            }
//        });
//
//        // Textfield
//        JLabel labelTextField = new JLabel("Bank account number");
//        textField = new JTextField();
//
//        // Add labels
//        labelPanel.add(labelCombo);
//        labelPanel.add(labelTextField);
//
//        // Add fields
//        fieldPanel.add(comboBox);
//        fieldPanel.add(textField);


		
	}
	
	
	
	public void BindCombo() throws SQLException{
        Model mq = new Model();
        HashMap<String, Integer> mapplantas = mq.getCmboxPlantas();
        
        for(String s : mapplantas.keySet()){
        	combo1.addItem(s);
        }
        
        HashMap<String, Integer> mapproductos = mq.getCmboxProductos();
        for(String s : mapproductos.keySet()){
        	combo2.addItem(s);
        }
        
    }

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		boolean b=false;
		model = new Model();
		int idplanta=0,idprodu=0;
		ErrorMensaje msj = null;
		if(o.equals(combo1)){
			
			try {
				HashMap<String,Integer >map = model.getCmboxPlantas();
				System.out.println(map.get(combo1.getSelectedItem().toString()).toString());
				idplanta = map.get(combo1.getSelectedItem().toString());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 //JOptionPane.showMessageDialog(null, informacionAplicacion,"INFORMACION",JOptionPane.INFORMATION_MESSAGE);
		}else if (o.equals(combo2)){
			
			try {
				HashMap<String,Integer >map = model.getCmboxProductos();
				System.out.println(map.get(combo2.getSelectedItem().toString()).toString());
				idprodu = map.get(combo2.getSelectedItem().toString());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(o.equals(boton1)){
			
			HashMap<String, Integer> mapplantas;
			HashMap<String,Integer >mapprod;
			try {
				mapplantas = model.getCmboxPlantas();
				mapprod = model.getCmboxProductos();
				
				idplanta = mapplantas.get(combo1.getSelectedItem().toString());
				idprodu = mapprod.get(combo2.getSelectedItem().toString());
				
				System.out.println("idplanta:"+idplanta+",idprod:"+idprodu+",cant stock: "+txtcantstock.getText());
				
				if(Utilerias.esNumero(txtcantstock)){
				   try {
					msj=model.getCheckLimit(idplanta,Integer.parseInt(txtcantstock.getText()),idprodu);
					System.out.println(msj.toString());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			//model.getCheckLimit()
			
		}
	}

}
