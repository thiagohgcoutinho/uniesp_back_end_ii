package com.nexus.processnet.services;

import com.nexus.processnet.models.Cargo;
import com.nexus.processnet.models.FuncionarioModel;
import com.nexus.processnet.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class FuncionarioService extends PessoaService<FuncionarioModel> {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        super(funcionarioRepository);
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    @Override
    public Map<String, Object> update(Long id, FuncionarioModel funcionario) {
        return pessoaRepository.findById(id).map(existingFuncionario -> {
            if (funcionario.getNome() != null) existingFuncionario.setNome(funcionario.getNome());
            if (funcionario.getEmail() != null) existingFuncionario.setEmail(funcionario.getEmail());
            if (funcionario.getTelefone() != null) existingFuncionario.setTelefone(funcionario.getTelefone());
            if (funcionario.getCargo() != null) existingFuncionario.setCargo(funcionario.getCargo());
            FuncionarioModel updatedFuncionario = pessoaRepository.save(existingFuncionario);
            Map<String, Object> response = new HashMap<>();
            response.put("nome", updatedFuncionario.getNome());
            response.put("tipo", "Funcionario");
            response.put("cargo", updatedFuncionario.getCargo().name());
            response.put("idPessoa", updatedFuncionario.getIdPessoa());
            response.put("telefone", updatedFuncionario.getTelefone());
            response.put("email", updatedFuncionario.getEmail());
            response.put("cpf", updatedFuncionario.getCpf());
            return response;
        }).orElseThrow(() -> new IllegalArgumentException("Funcionário não localizado com ID: " + id));
    }

    @Transactional
    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }

    @Transactional
    public FuncionarioModel findByCargo(Cargo cargo) {
        return funcionarioRepository.findByCargo(cargo)
                .orElseThrow(() -> new IllegalArgumentException("Nenhum funcionário encontrado com o cargo: " + cargo));
    }
}
