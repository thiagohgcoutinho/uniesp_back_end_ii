package com.nexus.processnet.services;

import com.nexus.processnet.models.UsuarioModel;
import com.nexus.processnet.repositories.UsuarioRepository;
import com.nexus.processnet.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioService extends PessoaService<UsuarioModel> {

    private final ProcessoRepository processoRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, ProcessoRepository processoRepository) {
        super(usuarioRepository);
        this.processoRepository = processoRepository;
    }

    @Transactional
    public void delete(Long idPessoa) {
        UsuarioModel usuario = pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada com ID: " + idPessoa));

        if (processoRepository.existsByResponsavel_IdPessoa(idPessoa)) {
            throw new IllegalStateException("Não é possível excluir usuário com processos associados.");
        }

        pessoaRepository.deleteById(idPessoa);
    }

    @Transactional
    @Override
    public Map<String, Object> update(Long id, UsuarioModel usuario) {
        return pessoaRepository.findById(id).map(existingUsuario -> {
            if (usuario.getNome() != null) existingUsuario.setNome(usuario.getNome());
            if (usuario.getTelefone() != null) existingUsuario.setTelefone(usuario.getTelefone());
            if (usuario.getEmail() != null) existingUsuario.setEmail(usuario.getEmail());
            UsuarioModel updatedUsuario = pessoaRepository.save(existingUsuario);
            Map<String, Object> response = new HashMap<>();
            response.put("nome", updatedUsuario.getNome());
            response.put("tipo", "Usuario");
            response.put("idPessoa", updatedUsuario.getIdPessoa());
            response.put("telefone", updatedUsuario.getTelefone());
            response.put("email", updatedUsuario.getEmail());
            response.put("cpf", updatedUsuario.getCpf());
            return response;
        }).orElseThrow(() -> new IllegalArgumentException("Pessoa não localizada com ID: " + id));
    }
}
