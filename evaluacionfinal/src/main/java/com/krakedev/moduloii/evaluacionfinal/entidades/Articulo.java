package com.krakedev.moduloii.evaluacionfinal.entidades;

import java.math.BigDecimal;



public class Articulo {
	private String id;
	private String nombre;
	private BigDecimal precioVenta;
	private BigDecimal precioCompra;
	private Grupo grupo;
	private boolean estado;
	
	public Articulo() {
		
	}
	
public Articulo(String id, Grupo grupo) {
	this.id = id;
	this.grupo = grupo;

	}

	public Articulo(String id, String nombre, BigDecimal precioVenta, BigDecimal precioCompra, Grupo grupo, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.precioCompra = precioCompra;
		this.grupo = grupo;
		this.estado=estado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public BigDecimal getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}


	

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", nombre=" + nombre + ", precioVenta=" + precioVenta + ", precioCompra="
				+ precioCompra + ", Grupo=" + grupo.getId() + ", estado=" + estado + "]";
	}
	

	
}


