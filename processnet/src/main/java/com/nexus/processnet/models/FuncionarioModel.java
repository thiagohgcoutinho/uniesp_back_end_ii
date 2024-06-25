package com.nexus.processnet.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TB_FUNCIONARIO")
@PrimaryKeyJoinColumn(name = "idPessoa")
@Data
@NoArgsConstructor
@DiscriminatorValue("Funcionario")
@JsonTypeName("Funcionario")
public class FuncionarioModel extends PessoaModel {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Cargo cargo;
}
