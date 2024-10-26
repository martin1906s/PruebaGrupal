package com.krakedev.moduloii.evaluacionfinal.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.excepciones.KrakeDevExcepcion;
import com.krakedev.moduloii.evaluacionfinal.entidades.RegistroMovimiento;
import com.krakedev.moduloii.evaluacionfinal.persistencia.MovimientosBDD;


@Path("movimientos")
public class ServicioMovimientos {

		@Path("probarInsertar")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response insertar(RegistroMovimiento movimiento) {
			System.out.println(">>>>>"+movimiento);
			MovimientosBDD his=new MovimientosBDD();
			try {
				his.insertar(movimiento);
				return Response.ok().build();
			} catch (KrakeDevExcepcion e) {
				e.printStackTrace();
				return Response.serverError().build();
			}
		}
		
		@Path("probarBuscar/{idArt}")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response buscarPorId(@PathParam("idArt") String idArticulo) {
			MovimientosBDD his=new MovimientosBDD();
			RegistroMovimiento cat=null;
			System.out.println("Ingresa>> "+idArticulo);
			try {
				ArrayList<RegistroMovimiento> movimiento=his.buscarPorIdArticulo(idArticulo);
				return Response.ok(movimiento).build();
			} catch (KrakeDevExcepcion e) {
				e.printStackTrace();
				return Response.serverError().build();
			}
			
		}

}

