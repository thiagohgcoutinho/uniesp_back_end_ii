package com.nexus.processnet.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TB_FUNCIONARIO")
@Data
@NoArgsConstructor
public class FuncionarioModel extends PessoaModel{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Cargo cargo;

    @Id
    @JoinColumn
    @Override
    public Long getIdPessoa() {
        return super.getIdPessoa();
    }

    @Override
    public void setIdPessoa(Long id) {
        super.setIdPessoa(id);
    }


}
