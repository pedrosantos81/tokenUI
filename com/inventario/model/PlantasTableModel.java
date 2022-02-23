package com.inventario.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class PlantasTableModel extends AbstractTableModel{

	private String[] columnNames = {"id","descripcion","Max prod","Min prod"};
	private List<PlantasDTO> myList;
	private Model dao;
	
	public PlantasTableModel(List<PlantasDTO> list) {
		super();
		// TODO Auto-generated constructor stub
		Model dao = new Model();
		try {
			myList = dao.getPlantas();
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
		PlantasDTO entity = null;
		entity = myList.get(rowIndex);
        switch (columnIndex) {
          case 0:
              return entity.getId();     
          case 1:
              return entity.getDescripcion();
          case 2:
              return entity.getMinprod();
          case 3:
              return entity.getMaxprod();
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
