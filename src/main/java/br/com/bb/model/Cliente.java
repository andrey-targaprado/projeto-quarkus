package br.com.bb.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.validation.constraints.*;

@Entity
public class Cliente extends PanacheEntity {

    @NotBlank(message = "Obrigatorio")
    @Size(min = 5, max = 100, message = "Nome deve ter entre 5 e 100 caracteres.")
    public String nome;

    @Min(value = 18, message = "Minimo 18 anos")
    public Integer idade;

    @Pattern(regexp = "[A-Z]{2}\\d{5}", message = "Obrigatorio no formato XX99999")
    public String vatNumber;

    @Email(message = "Deve registrar um email valido")
    public String email;

    //public Categoria categoria;
}
