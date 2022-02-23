package com.famsa.CC;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.inventario.model.Model;
import com.inventario.model.PlantasDTO;
import com.inventario.model.PlantasTableModel;
import com.inventario.model.ProductoTableModel;
import com.utils.Utilerias;

public class productosPanel extends JPanel implements ActionListener{

	private JPanel firstPanel;
	private ProductoTableModel tableModel;
	private List<PlantasDTO> list;
	private JTable jTable1;
	private JButton btnAgregar;
    private JTextField txtidproducto,txtproducto;
	
	public productosPanel() {
		setLayout(new GridLayout(2,5));
		
		firstPanel = new JPanel();
		//firstPanel.setSize(580,220);
		firstPanel.setLayout(new BorderLayout(1,5));
		
		JScrollPane jspane = new JScrollPane();
		  
		  jTable1 = new JTable();
		  list = new ArrayList();
	        //jTable1.setSize(700,400);
	        
	        tableModel = new ProductoTableModel(list);
	        jTable1.setModel(tableModel);
	        
		    jspane.setViewportView(jTable1);
		    firstPanel.add(jspane);
	        //add(firstPanel);
		  
	        
	        JPanel p2 = new JPanel();
			
			p2.setLayout(null);
			
			JLabel url = new JLabel("Id Prod :");
			url.setBounds(10,10,120,25);
			url.setLocation(4,5);
			url.setHorizontalAlignment(SwingConstants.LEFT);
			p2.add(url);
			
			txtidproducto = new JTextField();
			txtidproducto.setBounds(10,10,300,25);
			txtidproducto.setLocation(80,5);
			p2.add(txtidproducto);
			
			JLabel planta = new JLabel("Producto:");
			planta.setBounds(10, 20, 100, 25);
			planta.setLocation(4,50);
			p2.add(planta);
			
			txtproducto = new JTextField();
			txtproducto.setBounds(100, 50, 160, 25);
			txtproducto.setLocation(80,50);
			p2.add(txtproducto);
			
						
			btnAgregar = new JButton("Agregar producto");
			btnAgregar.setBounds(10, 160, 180, 25);
			btnAgregar.setLocation(4,140);
			p2.add(btnAgregar);
			
			
			add(firstPanel);
			add(p2);
			
			btnAgregar.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String resp ="",err;
		Model dao = new Model();
		int respuesta=0;
		if(e.getSource()==btnAgregar) {
	          
	          if((txtidproducto.getText().length()>0 && Utilerias.esNumero(txtidproducto)) && 
	        	  txtproducto.getText().length()>0 ){
	        	  try {
					respuesta=dao.crearProducto(Integer.parseInt(txtidproducto.getText()),txtproducto.getText());
					
					JOptionPane.showMessageDialog(this, "OK","OK se guardo",JOptionPane.OK_OPTION);
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
	               txtidproducto.requestFocusInWindow();
	               
	          }
	      }
	}

}
