package com.inventario.model;

public class PlantasDTO {

	private int id;
	private String descripcion;
	private int minprod;
	private int maxprod;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMaxprod() {
		return maxprod;
	}
	public void setMaxprod(int maxprod) {
		this.maxprod = maxprod;
	}
	public int getMinprod() {
		return minprod;
	}
	public void setMinprod(int minprod) {
		this.minprod = minprod;
	}
	
	
}
