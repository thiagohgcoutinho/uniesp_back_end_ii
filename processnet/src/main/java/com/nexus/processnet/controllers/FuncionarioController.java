package com.nexus.processnet.controllers;

import com.nexus.processnet.models.FuncionarioModel;
import com.nexus.processnet.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<FuncionarioModel> createFuncionario(@RequestBody FuncionarioModel funcionario) {
        return ResponseEntity.ok(funcionarioService.create(funcionario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFuncionario(@PathVariable Long id, @RequestBody FuncionarioModel funcionario) {
        return ResponseEntity.ok(funcionarioService.update(id, funcionario));
    }
}
