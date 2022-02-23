package com.inventario.config;

import java.sql.*;

public class ConexionJDBC {

	Connection conexionBD = null;

	//private Controlador control;

	public static final String URL = "jdbc:jtds:sqlserver://localhost:1433/UNIS;useNTLMv2=true;";
	public static final String USUARIO = "";
	public static final String PASSWORD = "";

	public Connection getConexion() throws ClassNotFoundException {

		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conexionBD = DriverManager.getConnection(URL, USUARIO, PASSWORD);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getCause());
		}

		return conexionBD;
	}

}
