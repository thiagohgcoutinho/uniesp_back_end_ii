package com.nexus.processnet.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TB_USUARIO")
@PrimaryKeyJoinColumn(name = "idPessoa")
@Data
@DiscriminatorValue("Usuario")
@JsonTypeName("Usuario")
public class UsuarioModel extends PessoaModel {

    public UsuarioModel() {
        super();
    }
}
