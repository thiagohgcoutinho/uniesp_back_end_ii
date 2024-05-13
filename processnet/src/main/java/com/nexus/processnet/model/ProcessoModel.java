package com.nexus.processnet.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "TB_PROCESSO")
@Data
@AllArgsConstructor
public class ProcessoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroProtocolo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(nullable = false, unique = true, length = 14)
    private String cnpj;

    @Column(nullable = false, length = 250)
    private String endereco;
}
