package br.com.bb.dto;

import br.com.bb.model.Categoria;
import br.com.bb.model.Cliente;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "cdi")
public interface ClienteMapper {
    ClienteDTO toDomain(Cliente cliente);
    Cliente toEntity(ClienteDTO clienteDTO);

    CategoriaDTO toDomain(Categoria categoria);

    default List<ClienteDTO> toDomainList(List<Cliente> list){
        return list.stream()
                .map((k) -> {
                    ClienteDTO kDTO = toDomain(k);
                    kDTO.categoria = toDomain(k.categoria);
                    return kDTO;
                })
                .collect(Collectors.toList());
    }
}
