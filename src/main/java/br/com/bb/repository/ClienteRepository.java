package br.com.bb.repository;

import br.com.bb.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {
    public List<Cliente> listComCategorias(){
        return find("FROM Cliente k JOIN FETCH k.categoria c ORDER BY k.nome").list();
    }
}
