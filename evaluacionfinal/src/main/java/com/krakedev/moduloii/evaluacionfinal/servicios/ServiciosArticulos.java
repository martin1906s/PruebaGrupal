package com.krakedev.moduloii.evaluacionfinal.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.excepciones.KrakeDevExcepcion;
import com.krakedev.moduloii.evaluacionfinal.entidades.Articulo;
import com.krakedev.moduloii.evaluacionfinal.persistencia.ArticulosBDD;


@Path("articulo")
public class ServiciosArticulos {
	@Path("insertar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertar(Articulo articulo) {
    	System.out.println(">>>>>>>>>"+articulo);
    	ArticulosBDD art = new ArticulosBDD();
    	try {
			art.inertar(articulo);
			return Response.ok().build();
		} catch (KrakeDevExcepcion e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
    	
    }
}
