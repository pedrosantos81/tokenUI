package com.inventario.model;

public class ErrorMensaje {
	
	private String iderror;
	private String descriperr;
	public String getDescriperr() {
		return descriperr;
	}
	public void setDescriperr(String descriperr) {
		this.descriperr = descriperr;
	}
	public String getIderror() {
		return iderror;
	}
	public void setIderror(String iderror) {
		this.iderror = iderror;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return iderror+"-"+descriperr;
	}

}
