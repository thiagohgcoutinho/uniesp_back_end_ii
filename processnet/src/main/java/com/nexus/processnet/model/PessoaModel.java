package com.nexus.processnet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "TB_PESSOA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPessoa;

    @Column(nullable = false, unique = true, length = 30)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false, unique = true, length = 11)
    private String telefone;

}
