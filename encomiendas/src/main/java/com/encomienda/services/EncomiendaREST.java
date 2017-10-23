/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encomienda.services;



import com.encomienda.entities.Encomienda;
import com.encomienda.sessions.EncomiendaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("encomiendas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EncomiendaREST {

    @EJB
    private EncomiendaFacade encomiendaEJB;

    @GET
    public List<Encomienda> findAll() {

        return encomiendaEJB.findAll();
    }



    @GET
    @Path("{id}")
    public Encomienda findById(@PathParam("id") Integer id) {
        return encomiendaEJB.find(id);
    }

    @POST
    public void create(Encomienda c) {

  encomiendaEJB.create(c);

    }

    @GET
    @Path("findEncomienda")
    public List<Encomienda> findByidCliente(@QueryParam("idClienteReceptor") Integer idClienteReceptor) {
        return encomiendaEJB.findEncomienda(idClienteReceptor);
    }
    

}
