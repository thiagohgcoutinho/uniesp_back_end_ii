package com.nexus.processnet.controllers;

import com.nexus.processnet.models.FuncionarioModel;
import com.nexus.processnet.services.FuncionarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@Api(value = "Funcionários", tags = "Funcionários")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    @ApiOperation(value = "Obter todos os funcionários", response = List.class)
    public ResponseEntity<List<FuncionarioModel>> getAllFuncionarios() {
        return ResponseEntity.ok(funcionarioService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obter funcionário por ID", response = FuncionarioModel.class)
    public ResponseEntity<FuncionarioModel> getFuncionarioById(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.findById(id));
    }

    @PostMapping
    @ApiOperation(value = "Criar um novo funcionário", response = FuncionarioModel.class)
    public ResponseEntity<FuncionarioModel> createFuncionario(@RequestBody FuncionarioModel funcionario) {
        return ResponseEntity.ok(funcionarioService.create(funcionario));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar um funcionário", response = FuncionarioModel.class)
    public ResponseEntity<FuncionarioModel> updateFuncionario(@PathVariable Long id, @RequestBody FuncionarioModel funcionario) {
        return ResponseEntity.ok(funcionarioService.update(id, funcionario));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Excluir um funcionário")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        funcionarioService.delete(id);
        return ResponseEntity.ok().build();
    }
}
