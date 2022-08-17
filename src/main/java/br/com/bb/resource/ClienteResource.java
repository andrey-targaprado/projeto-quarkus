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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClienteDTO> list() {
        return clienteMapper.toDomainList(Cliente.listAll());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public ClienteDTO create(@Valid ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente.persist();
        return clienteMapper.toDomain(cliente);
    }

    @POST
    @Path("/sem-dto")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Cliente createSemDTO(Cliente cliente) {
        cliente.categoria.persist();
        cliente.persist();
        return cliente;
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
