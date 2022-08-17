package br.com.bb.service;

import br.com.bb.dto.ClienteDTO;
import br.com.bb.mapper.ClienteMapper;
import br.com.bb.repository.ClienteRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ClienteService {

    private ClienteRepository clienteRepository;

    private ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public List<ClienteDTO> findComCategorias() {
        return clienteMapper.toDomainList(
                clienteRepository.listComCategorias()
        );
    }
}
