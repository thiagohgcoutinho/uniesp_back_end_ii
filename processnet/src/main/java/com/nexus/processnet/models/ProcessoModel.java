package com.nexus.processnet.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoProcesso tipoProcesso;

    @Column(nullable = false, length = 14)
    @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter apenas números.")
    private String cnpj;

    @Column(nullable = false, length = 250)
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "idResponsavel", referencedColumnName = "idPessoa")
    private UsuarioModel responsavel;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.AGUARDANDO;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Parecer parecer = Parecer.AGUARDANDO;
}
