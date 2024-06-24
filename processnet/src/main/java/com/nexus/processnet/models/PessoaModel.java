package com.nexus.processnet.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FuncionarioModel.class, name = "Funcionario"),
        @JsonSubTypes.Type(value = UsuarioModel.class, name = "Usuario")
})

@Entity
@Table(name = "TB_PESSOA")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_generator")
    @SequenceGenerator(name = "pessoa_generator", sequenceName = "pessoa_seq", allocationSize = 1)
    private Long idPessoa;

    @Column(nullable = false, unique = true, length = 30)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas números.")
    private String cpf;

    @Column(nullable = false, unique = true, length = 50)
    @Email(message = "E-mail inválido.")
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false, unique = true, length = 11)
    private String telefone;
}
