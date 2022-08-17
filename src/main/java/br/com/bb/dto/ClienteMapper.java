package br.com.bb.dto;

import br.com.bb.model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface ClienteMapper {
    ClienteDTO toDomain(Cliente cliente);
    Cliente toEntity(ClienteDTO clienteDTO);
}
