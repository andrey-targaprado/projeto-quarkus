package br.com.bb.resource;

import br.com.bb.dto.CategoriaDTO;
import br.com.bb.mapper.CategoriaMapper;
import br.com.bb.model.Categoria;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/categoria")
public class CategoriaResources {

    @Inject
    CategoriaMapper categoriaMapper;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void create(@Valid CategoriaDTO categoriaDTO){
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        categoria.persist();
    }
}
