package com.nexus.processnet.controllers;

import com.nexus.processnet.models.FuncionarioModel;
import com.nexus.processnet.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioModel>> findAll() {
        List<FuncionarioModel> funcionarios = funcionarioService.findAll();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<FuncionarioModel> createFuncionario(@RequestBody FuncionarioModel funcionario) {
        FuncionarioModel novoFuncionario = funcionarioService.create(funcionario);
        return ResponseEntity.ok(novoFuncionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateFuncionario(@PathVariable Long id, @RequestBody FuncionarioModel funcionario) {
        Map<String, Object> updatedFuncionario = funcionarioService.update(id, funcionario);
        return ResponseEntity.ok(updatedFuncionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        funcionarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
