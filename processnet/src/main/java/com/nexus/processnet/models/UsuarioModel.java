package com.nexus.processnet.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TB_USUARIO")
@Data
public class UsuarioModel extends PessoaModel{

    public UsuarioModel() {
        super();
    }

    @Id
    @Override
    public Long getIdPessoa() {
        return super.getIdPessoa();
    }

    @Override
    public void setIdPessoa(Long id) {
        super.setIdPessoa(id);
    }

}
