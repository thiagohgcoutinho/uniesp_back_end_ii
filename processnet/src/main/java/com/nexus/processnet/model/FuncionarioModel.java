package com.nexus.processnet.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TB_FUNCIONARIO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioModel extends PessoaModel{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Cargo cargo;
}
