package com.krakedev.moduloii.evalucionafinal.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.krakedev.excepciones.KrakeDevExcepcion;

public class ConexionBDD {

	public static Connection obtenerConexion() throws KrakeDevExcepcion {
		Context ctx = null;
		DataSource ds = null;
		Connection con = null;
		try {
			ctx = new InitialContext();
			// JNDI
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/conexionPG");

			con = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			throw new KrakeDevExcepcion("Error de conexión");
		} 
		return con;
	}
}
