package com.nexus.processnet.services;

import com.nexus.processnet.models.UsuarioModel;
import com.nexus.processnet.repositories.UsuarioRepository;
import com.nexus.processnet.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService extends PessoaService<UsuarioModel> {

    @Autowired
    private ProcessoRepository processoRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
    }

    @Transactional
    public void delete(Long id) {
        UsuarioModel usuario = pessoaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada com ID: " + id));

        if (processoRepository.existsByIdResponsavel(id)) {
            throw new IllegalStateException("Não é possível excluir usuário com processos associados.");
        }

        pessoaRepository.deleteById(id);
    }
}
