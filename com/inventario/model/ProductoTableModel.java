package com.inventario.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProductoTableModel extends AbstractTableModel{
	
	private String[] columnNames = {"id","producto"};
	private List<ProductosDTO> myList;
	private Model dao;
	
	
	public ProductoTableModel(List<PlantasDTO> list) {
		
		Model dao = new Model();
		try {
			myList = dao.getProductos();
			System.out.println("tam: "+myList.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getRowCount() {
		int size;
	      if (myList == null) {
	         size = 0;
	      }
	      else {
	         size = myList.size();
	      }
	      return size;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		ProductosDTO entity = null;
		entity = myList.get(rowIndex);
        switch (columnIndex) {
          case 0:
              return entity.getIdprod();     
          case 1:
              return entity.getDescprod();
        }
        return entity;
	}
	
//	 needed to show column names in JTable
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	public Class getColumnClass(int col) {
		if (col == 2) {
			return Double.class;
		}
		else {
			return String.class;
		}
	}

}
