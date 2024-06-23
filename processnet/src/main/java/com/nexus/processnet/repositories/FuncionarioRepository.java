package com.nexus.processnet.repositories;

import com.nexus.processnet.models.FuncionarioModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends PessoaRepository<FuncionarioModel> {
    Optional<FuncionarioModel> findByCargo(String cargo);
}
