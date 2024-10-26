package com.krakedev.moduloii.evaluacionfinal.entidades;

import java.util.Date;

public class RegistroMovimiento {
	private int id;
	private Articulo articulo;
	private int cantidad;
	private Date fechaMovimiento;
	
	public RegistroMovimiento() {
		
	}
	
	
	public RegistroMovimiento(int id, Articulo articulo, int cantidad, Date fechaMovimiento) {
		this.id = id;
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.fechaMovimiento = fechaMovimiento;
	}
	
	public RegistroMovimiento(Articulo articulo, int cantidad, Date fecha) {
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.fechaMovimiento = fecha;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Articulo getArticulo() {
		return articulo;
	}


	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}


	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	@Override
	public String toString() {
		return "RegistroMovimiento [id=" + id + ", Articulo=" + articulo + ", cantidad=" + cantidad
				+ ", fechaMovimiento=" + fechaMovimiento + "]";
	}
	
	
	
}
