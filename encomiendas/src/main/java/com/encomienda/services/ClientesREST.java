/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encomienda.services;


import com.encomienda.entities.Ciudades;
import com.encomienda.entities.Clientes;
import com.encomienda.sessions.CiudadesFacade;
import com.encomienda.sessions.ClientesFacade;
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

@Path("clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientesREST {

    @EJB
    private ClientesFacade clientesEJB;

    @GET
    public List<Clientes> findAll() {

        return clientesEJB.findAll();
    }



    @GET
    @Path("{id}")
    public Clientes findById(@PathParam("id") Integer id) {
        return clientesEJB.find(id);
    }

    @POST
    public void create(Clientes c) {

  clientesEJB.create(c);

    }

    @GET
    @Path("find")
    public Clientes findByDoc(@QueryParam("numeroDocumento") String numeroDocumento) {
        return clientesEJB.findByNumDocument(numeroDocumento);
    }
    

}
