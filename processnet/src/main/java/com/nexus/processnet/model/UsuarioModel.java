package com.nexus.processnet.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TB_USUARIO")
@Data
public class UsuarioModel extends PessoaModel{

    public UsuarioModel() {
        super();
    }

}
