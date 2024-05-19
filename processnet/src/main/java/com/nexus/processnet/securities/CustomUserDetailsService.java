package com.nexus.processnet.securities;

import com.nexus.processnet.models.PessoaModel;
import com.nexus.processnet.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        PessoaModel pessoa = pessoaRepository.findByCpf(cpf)
                .orElseThrow(() -> new UsernameNotFoundException("Pessoa não encontrada com o CPF: " + cpf));

        return new User(pessoa.getCpf(), pessoa.getSenha(), Collections.emptyList());
    }
}
