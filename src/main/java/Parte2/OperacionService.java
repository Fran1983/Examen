package Parte2;


import Parte1.*;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/operaciones")
public class OperacionService {

    MathManagerImpl servicio;

    public OperacionService() {

        servicio=MathManagerImpl.getInstance();

    }

    @GET
    @Path("/listadoOperacionesInstituto/{instituto}")
    @Produces(MediaType.APPLICATION_JSON) //Para enviar datos
    //@Consumes para recibir datos
    public ArrayList<Operacion> getlistadoOperacionesInsituto(@PathParam("instituto") String instituto) {

        return servicio.listadoOperacionesInstituto(instituto);
    }

    @POST
    @Path("/listadoOperacionesAlumnos")
    @Consumes(MediaType.APPLICATION_JSON)

    public List<Operacion> getOperacionesAlumnos(Alumno a) {
        return servicio.listadoOperacionesAlumno(a);
    }

    @GET
    @Path("/institutosOrdenadosOperaciones")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Instituto> institutosOrdenadosOperaciones(){
        return institutosOrdenadosOperaciones();

    }

}
