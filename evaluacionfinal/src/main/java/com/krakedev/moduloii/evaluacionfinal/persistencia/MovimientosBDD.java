package com.krakedev.moduloii.evaluacionfinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.excepciones.KrakeDevExcepcion;
import com.krakedev.moduloii.evaluacionfinal.entidades.Articulo;
import com.krakedev.moduloii.evaluacionfinal.entidades.Grupo;
import com.krakedev.moduloii.evaluacionfinal.entidades.RegistroMovimiento;
import com.krakedev.moduloii.evalucionafinal.utils.ConexionBDD;

public class MovimientosBDD {
	public void insertar(RegistroMovimiento registroMovimiento) throws KrakeDevExcepcion {
		Connection con=null;
		try {
			con=ConexionBDD.obtenerConexion();
			PreparedStatement ps=
			con.prepareStatement("insert into historial_movimientos(id_articulo, cantidad, fecha_movimiento) values(?,?,?)");
			ps.setString(1, registroMovimiento.getArticulo().getId());
			ps.setInt(2, registroMovimiento.getCantidad());
			ps.setDate(3, new java.sql.Date(registroMovimiento.getFechaMovimiento().getTime()));
			ps.executeUpdate();
		} catch (KrakeDevExcepcion e) {
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevExcepcion("Error al insertar:"+e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void actualizar(RegistroMovimiento registroMovimiento) throws KrakeDevExcepcion {
		Connection con=null;
		try {
			con=ConexionBDD.obtenerConexion();
			PreparedStatement ps=
			con.prepareStatement("update historial_movimientos set id_articulo=?, cantidad=?, fecha_movimiento=? where id_historial=?");
			ps.setString(1, registroMovimiento.getArticulo().getId());
			ps.setInt(2, registroMovimiento.getCantidad());
			ps.setDate(3, new java.sql.Date(registroMovimiento.getFechaMovimiento().getTime()));
			ps.setInt(4, registroMovimiento.getId());

			ps.executeUpdate();
		} catch (KrakeDevExcepcion e) {
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevExcepcion("Error al actualizar:"+e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public RegistroMovimiento buscarPorId(int id) throws KrakeDevExcepcion {
		Connection con=null;
		RegistroMovimiento rm=null;
		ResultSet rs=null;
		try {
			con=ConexionBDD.obtenerConexion();
			PreparedStatement ps=
			con.prepareStatement("select * from historial_movimientos where id_historial=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			rs.next();
			rm=new RegistroMovimiento();
			Articulo ar=new Articulo();
			Grupo g=new Grupo();
			ar.setGrupo(g);
			rm.setArticulo(ar);
			rm.getArticulo().setId(rs.getString("id_articulo"));
			rm.setCantidad(rs.getInt("cantidad"));
			rm.setFechaMovimiento(rs.getDate("fecha_movimiento"));
			rm.setId(id);
		} catch (KrakeDevExcepcion e) {
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevExcepcion("Error al buscar por idHistorial: "+e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rm;
	}
	
	
	public ArrayList<RegistroMovimiento> buscarPorIdArticulo(String idArticulo) throws KrakeDevExcepcion {
		Connection con=null;
		RegistroMovimiento rm=null;
		ResultSet rs=null;
		ArticulosBDD artbdd=new ArticulosBDD();
		//GruposBDD gbdd=new GruposBDD();
		Articulo art=artbdd.buscarPorId(idArticulo);
		Grupo g=art.getGrupo();
		
		ArrayList<RegistroMovimiento> movimientos=new ArrayList<RegistroMovimiento>();
		try {
			con=ConexionBDD.obtenerConexion();
			PreparedStatement ps=
			con.prepareStatement("select * from historial_movimientos where id_articulo=?");
			ps.setString(1, idArticulo);
			rs=ps.executeQuery();
			while(rs.next()==true) {
				rm=new RegistroMovimiento();
				rm.setArticulo(art);
				rm.setId(rs.getInt("id_historial"));
				rm.getArticulo().setId(rs.getString("id_articulo"));
				rm.setCantidad(rs.getInt("cantidad"));
				rm.setFechaMovimiento(rs.getDate("fecha_movimiento"));
				rm.setArticulo(art);
				movimientos.add(rm);
			}
			
			
		} catch (KrakeDevExcepcion e) {
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevExcepcion("Error al buscar por idHistorial: "+e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movimientos;
	}
}
