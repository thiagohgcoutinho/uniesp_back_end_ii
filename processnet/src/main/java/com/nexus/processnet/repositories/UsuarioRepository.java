package com.nexus.processnet.repositories;

import com.nexus.processnet.models.UsuarioModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends PessoaRepository<UsuarioModel> {

}
