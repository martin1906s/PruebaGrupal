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
			PreparedStatement ps = con.prepareStatement("insert into grupos (id_grupo,nombre) values(?,?)");
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
}
