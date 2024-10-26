package com.krakedev.moduloii.evaluacionfinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.krakedev.excepciones.KrakeDevExcepcion;
import com.krakedev.moduloii.evaluacionfinal.entidades.Grupo;
import com.krakedev.moduloii.evalucionafinal.utils.ConexionBDD;

public class GrupoBDD {
	
	public  void insertar(Grupo grupo) throws KrakeDevExcepcion {
		Connection con=null;
		try {
			con=ConexionBDD.obtenerConexion();
			PreparedStatement ps = con.prepareStatement("insert into grupo (id,nombre) values(?,?)");
			ps.setString(1, grupo.getId());
			ps.setString(2, grupo.getNombre());
			ps.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevExcepcion("Error al insertar");
		} catch (KrakeDevExcepcion e) {
			e.printStackTrace();
		}
		
	}
	
	public void eliminar(String CodGrupo) throws Exception {
	    Connection con = null;
	    PreparedStatement ps = null;

	    String sqlRegistroMovimiento = "DELETE FROM Registro_movimiento WHERE id_articulo IN (SELECT id FROM Articulos WHERE id_grupo = ?)";
	    String sqlArticulos = "DELETE FROM Articulos WHERE id_grupo = ?";
	    String sqlGrupo = "DELETE FROM Grupo WHERE id = ?";

	    try {
	        con = ConexionBDD.obtenerConexion();
	        con.setAutoCommit(false); // 

	       
	        ps = con.prepareStatement(sqlRegistroMovimiento);
	        ps.setString(1, CodGrupo);
	        ps.executeUpdate();

	        ps = con.prepareStatement(sqlArticulos);
	        ps.setString(1, CodGrupo);
	        ps.executeUpdate();

	        ps = con.prepareStatement(sqlGrupo);
	        ps.setString(1, CodGrupo);
	        ps.executeUpdate();

	        System.out.println("Eliminación exitosa");
	    } catch (Exception e) {

	        throw e;
	    } finally {
	    	con.close();
	    }
	}
	
}
