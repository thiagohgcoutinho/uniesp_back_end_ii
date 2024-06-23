package com.nexus.processnet.services;

import com.nexus.processnet.models.PessoaModel;
import com.nexus.processnet.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class PessoaService<T extends PessoaModel> {

    protected PessoaRepository<T> pessoaRepository;

    public PessoaService(PessoaRepository<T> pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public boolean existsByCpf(String cpf) {
        return pessoaRepository.existsByCpf(cpf);
    }

    @Transactional
    public T create(T pessoa){
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public List<T> findAll(){
        return pessoaRepository.findAll();
    }

    @Transactional
    public T findById(Long id){
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada com ID: " + id));
    }

    @Transactional
    public T update(Long id, T pessoa) {
        return pessoaRepository.findById(id).map(existingPessoa -> {
            if (pessoa.getNome() != null) existingPessoa.setNome(pessoa.getNome());
            if (pessoa.getTelefone() != null) existingPessoa.setTelefone(pessoa.getTelefone());
            if (pessoa.getEmail() != null) existingPessoa.setEmail(pessoa.getEmail());
            return pessoaRepository.save(existingPessoa);
        }).orElseThrow(() -> new IllegalArgumentException("Pessoa não localizada com ID: " + id));
    }

    @Transactional
    public Optional<T> findByCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }
}
