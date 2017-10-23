/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encomienda.services;


import com.encomienda.entities.Ciudades;
import com.encomienda.sessions.CiudadesFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ciudades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CiudadesREST {

    @EJB
    private CiudadesFacade ciudadesEJB;

    @GET
    public List<Ciudades> findAll() {

        return ciudadesEJB.findAll();
    }



    @GET
    @Path("{id}")
    public Ciudades findById(@PathParam("id") Integer id) {
        return ciudadesEJB.find(id);
    }

    @POST
    public void create(Ciudades ciudad) {

  ciudadesEJB.create(ciudad);

    }

  
    

}
