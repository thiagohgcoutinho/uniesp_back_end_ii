package com.aula_springBoot.api.controller;

import com.aula_springBoot.api.model.Cliente;
import com.aula_springBoot.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.status(200).body(clienteService.criarCliente(cliente));
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Cliente>> buscarTodosClientes() {
        return ResponseEntity.ok(clienteService.buscarTodosClientes());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Cliente> buscarClienteId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarClienteId(id));
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
