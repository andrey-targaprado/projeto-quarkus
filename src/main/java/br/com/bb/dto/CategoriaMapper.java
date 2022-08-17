package br.com.bb.dto;

import br.com.bb.model.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface CategoriaMapper {
    CategoriaDTO toDomain(Categoria categoria);
    Categoria toEntity(CategoriaDTO categoriaDTO);
}
