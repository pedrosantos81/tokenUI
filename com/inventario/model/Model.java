package com.inventario.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.inventario.config.ConexionJDBC;

public class Model {
	
	private ConexionJDBC conex;    
    private ResultSet rs,rs1; 
    private Statement st,st1;
    private PlantasDTO wh;
    private ProductosDTO productos;
    
	public Model()
	{
		conex = new ConexionJDBC();
	}
	
	public Connection getInventario() throws Exception{
		return conex.getConexion();
	}
	
	public List<PlantasDTO> getPlantas() throws SQLException {
		rs = null;
		st = null;
		Connection con=null;
		List<PlantasDTO> lstwh = new ArrayList<PlantasDTO>();
		
		try {
			con = conex.getConexion();
			st = con.createStatement();
			rs = st.executeQuery("select *from plantas");
			
			while(rs.next()){
				
				wh = new PlantasDTO();
				wh.setId(rs.getInt(1));
				wh.setDescripcion(rs.getString(2));
				wh.setMaxprod(rs.getInt(3));
				wh.setMinprod(rs.getInt(4));
				
				lstwh.add(wh);
				
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(st!=null && con!=null && rs!=null) st.close();con.close(); rs.close();
		}
		return lstwh;
	} 
	
	public HashMap<String, Integer> getCmboxPlantas() throws SQLException {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		rs = null;
		st = null;
		Connection con=null;
		
		ComboItemGenerico cmbgen = null;
		try {
			con = conex.getConexion();
			st = con.createStatement();
			rs = st.executeQuery("SELECT [id] ,[descripcion]  FROM [plantas]");
			
			while(rs.next()){
				
				cmbgen = new ComboItemGenerico(rs.getInt(1),rs.getString(2));
				map.put(cmbgen.getValue(),cmbgen.getKey());
			}
			
			System.out.println(map.size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			if(st!=null && con!=null && rs!=null) st.close();con.close(); rs.close();
		}
		return map;
	}
	
	public HashMap<String, Integer> getCmboxProductos() throws SQLException {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		rs = null;
		st = null;
		Connection con=null;
		
		ComboItemGenerico cmbgen = null;
		try {
			con = conex.getConexion();
			st = con.createStatement();
			rs = st.executeQuery("SELECT [idproducto] ,[producto]  FROM [productos]");
			
			while(rs.next()){
				
				cmbgen = new ComboItemGenerico(rs.getInt(1),rs.getString(2));
				map.put(cmbgen.getValue(),cmbgen.getKey());
			}
			
			System.out.println(map.size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			if(st!=null && con!=null && rs!=null) st.close();con.close(); rs.close();
		}
		return map;
	} 
	
	public List<ProductosDTO> getProductos() throws SQLException {
		rs = null;
		st = null;
		Connection con=null;
		List<ProductosDTO> lstwh = new ArrayList<ProductosDTO>();
		
		try {
			con = conex.getConexion();
			st = con.createStatement();
			rs = st.executeQuery("select *from productos");
			
			while(rs.next()){
				
				productos = new ProductosDTO();
				productos.setIdprod(rs.getInt(1));
				productos.setDescprod(rs.getString(2));
				
				lstwh.add(productos);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(st!=null && con!=null && rs!=null) st.close();con.close(); rs.close();
		}
		return lstwh;
	} 
	
	public int crearPlanta(int idplanta,String planta,int limitemin,int limmax) throws SQLException {
		st = null;
		rs = null;
		int resultado=0;
		Connection con=null;
		try {
			con = conex.getConexion();
			st = con.createStatement();
			resultado = st.executeUpdate("insert into plantas values ("+idplanta+",'"+planta+"',"+limitemin+","+limmax+")");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(st!=null && con!=null) st.close();con.close();
		}
		
		return resultado;
	}
	
	public int crearProducto(int idproducto,String nombreproducto) throws SQLException {
		st = null;
		int resultado=0;
		Connection con=null;
		try {
			con = conex.getConexion();
			st = con.createStatement();
			resultado = st.executeUpdate("insert into productos values ("+idproducto+",'"+nombreproducto+"')");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(st!=null && con!=null) st.close();con.close();
		}
		
		return resultado;
	}
	
	public ErrorMensaje getCheckLimit(int idplanta,int limit,int producto) throws Exception{
		st = null;
		rs = null;
		int minstockprod=0,maxstockprod=0,sumbyplanta=0;
		Connection con=null;
		boolean ins=false;
		ErrorMensaje msj = new ErrorMensaje();
		
		con=conex.getConexion();
		st=con.createStatement();
		
		rs = st.executeQuery("select sum(stockproducto) from relplantaprodstock where idplanta = "+idplanta+" group by idplanta");
		
			while(rs.next()){
				sumbyplanta=rs.getInt(1);
				
			}
		rs = st.executeQuery("select [minproduc],[maxprod] from [plantas] where id="+idplanta);	
		    while(rs.next()){
		    	minstockprod = rs.getInt(1);
		    	maxstockprod = rs.getInt(2);
		    }
		
			
			
			if((minstockprod>=limit && maxstockprod<=limit) && sumbyplanta<=limit ){
				st.executeUpdate("insert into relplantaprodstock values("+idplanta+","+producto+","+limit+")");
				msj.setIderror("1");
				msj.setDescriperr("Se guardo stock para producto");
				return msj;
				//return ins=true;
			}else{
				msj.setIderror("0");
				msj.setDescriperr("El stock esta mal ,revisarlo");
				return msj;
			}
			
			//return msj;
		
	}
	
		
	

}
