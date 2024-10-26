package com.krakedev.moduloii.evaluacionfinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.krakedev.excepciones.KrakeDevExcepcion;
import com.krakedev.moduloii.evaluacionfinal.entidades.*;
import com.krakedev.moduloii.evaluacionfinal.persistencia.*;
import com.krakedev.moduloii.evalucionafinal.utils.ConexionBDD;


public class ArticulosBDD {
	public void inertar(Articulo articulo) throws KrakeDevExcepcion {
		Connection con = null;
		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = null;
			con.prepareStatement("insert into articulos(idA, nombre, precio_venta, precio_compra, id_grupos, estado) values "
					+ "(?,?,?,?,?)");
			ps.setString(1, articulo.getId());
			ps.setString(2, articulo.getNombre());
			ps.setBigDecimal(3, articulo.getPrecioVenta());
			ps.setBigDecimal(4, articulo.getPrecioCompra());
			ps.setString(5, articulo.getGrupo().getId());
			ps.setBoolean(6, articulo.isEstado());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevExcepcion("Error al insertar Articulo. Detalles: "+e.getMessage());
		} catch (KrakeDevExcepcion e) {
			throw e;
		}finally {
			if(con!= null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
