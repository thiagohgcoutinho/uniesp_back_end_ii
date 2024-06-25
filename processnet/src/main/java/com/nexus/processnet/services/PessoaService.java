package com.nexus.processnet.services;

import com.nexus.processnet.models.PessoaModel;
import com.nexus.processnet.repositories.PessoaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class PessoaService<T extends PessoaModel> {

    protected final PessoaRepository<T> pessoaRepository;

    public PessoaService(PessoaRepository<T> pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public boolean existsByCpf(String cpf) {
        return pessoaRepository.existsByCpf(cpf);
    }

    @Transactional
    public T create(T pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public List<T> findAll() {
        return pessoaRepository.findAll();
    }

    @Transactional
    public T findById(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada com ID: " + id));
    }

    @Transactional
    public abstract Map<String, Object> update(Long id, T pessoa);

    @Transactional
    public Optional<T> findByCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }
}
