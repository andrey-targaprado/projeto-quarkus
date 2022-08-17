package br.com.bb.resource;

import br.com.bb.dto.ClienteDTO;
import br.com.bb.dto.ClienteMapper;
import br.com.bb.model.Cliente;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cliente")
public class ClienteResource {

    @Inject
    public ClienteMapper clienteMapper;
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
    public ClienteDTO create(@Valid Cliente cliente){
        cliente.persist();
        return clienteMapper.toDomain(cliente);

    }
}
