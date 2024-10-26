package com.krakedev.moduloii.evaluacionfinal.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.excepciones.KrakeDevExcepcion;
import com.krakedev.moduloii.evaluacionfinal.entidades.Grupo;
import com.krakedev.moduloii.evaluacionfinal.persistencia.GrupoBDD;
@Path("grupos")

public class ServiciosGrupo {
	
	
	@Path("probarInsertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)

	public Response insertar(Grupo grup){
		GrupoBDD grupo = new GrupoBDD();
		try {
			grupo.insertar(grup);
			return Response.ok().build();
		} catch (KrakeDevExcepcion e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	
	@Path("probarEliminar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)

	public Response eliminar(String codGrupo) {
		GrupoBDD grupo = new GrupoBDD();
		try {
			grupo.eliminar(codGrupo);
			return Response.ok().build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	
	}
	
}
