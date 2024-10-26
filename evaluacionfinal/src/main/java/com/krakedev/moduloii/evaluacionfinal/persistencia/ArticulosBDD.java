package com.krakedev.moduloii.evaluacionfinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.krakedev.excepciones.KrakeDevExcepcion;
import com.krakedev.moduloii.evaluacionfinal.entidades.Articulo;
import com.krakedev.moduloii.evaluacionfinal.entidades.Grupo;
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
	
	public Articulo buscarPorId(String id) throws KrakeDevExcepcion {
		Connection con=null;
		Articulo art=null;
		ResultSet rs=null;
		try {
			con=ConexionBDD.obtenerConexion();
			PreparedStatement ps=
			con.prepareStatement("select * from articulos where id_articulo=?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			rs.next();
			art=new Articulo();
			Grupo g=new Grupo();
			art.setGrupo(g);
			art.setId(rs.getString("id_articulo"));
			art.setNombre(rs.getString("nombre"));
			art.setPrecioVenta(rs.getBigDecimal("precio_venta"));
			art.setPrecioCompra(rs.getBigDecimal("precio_compra"));
			art.getGrupo().setId(rs.getString("id_grupo"));
			art.setEstado(rs.getBoolean("estado"));
		} catch (KrakeDevExcepcion e) {
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevExcepcion("Error al buscar por idCategoria: "+e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return art;
	}
}
