package com.aula_springBoot.api.service;

import com.aula_springBoot.api.model.Cliente;
import com.aula_springBoot.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente criarCliente (Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarTodosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClienteId(Long id) {

        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    public void deletarCliente(Long id) {

        clienteRepository.deleteById(id);

    }

}
