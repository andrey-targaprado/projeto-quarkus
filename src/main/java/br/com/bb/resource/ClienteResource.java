package br.com.bb.resource;

import br.com.bb.model.Cliente;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cliente")
public class ClienteResource {

    /*
    @GET
    @Path("/{category}")
    @Produces(MediaType.TEXT_PLAIN)
    public String user(
            @PathParam("category") String category,
            @QueryParam("tipo") String tipo
    ) {

        return "Ola " + category + tipo;
    }
    */

    @GET
    public List<Cliente> list() {
        return Cliente.listAll();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Transactional
    public Cliente create(@Valid Cliente cliente){
        cliente.persist();
        return cliente;

    }
}
