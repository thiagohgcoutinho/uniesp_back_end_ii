package com.nexus.processnet.controllers;

import com.nexus.processnet.models.*;
import com.nexus.processnet.services.ProcessoService;
import com.nexus.processnet.services.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processos")
@Api(value = "Processos", tags = "Processos")
public class ProcessoController {

    @Autowired
    private ProcessoService processoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @ApiOperation(value = "Obter todos os processos", response = List.class)
    public ResponseEntity<List<ProcessoModel>> getAllProcessos() {
        return ResponseEntity.ok(processoService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obter processo por ID", response = ProcessoModel.class)
    public ResponseEntity<ProcessoModel> getProcessoById(@PathVariable Long id) {
        return ResponseEntity.ok(processoService.findById(id));
    }

    @PostMapping("/{usuarioId}")
    @ApiOperation(value = "Criar um novo processo", response = ProcessoModel.class)
    public ResponseEntity<ProcessoModel> createProcesso(@PathVariable Long usuarioId, @RequestBody ProcessoModel processo) {
        UsuarioModel usuario = usuarioService.findById(usuarioId); // Encontra o usuário
        ProcessoModel novoProcesso = processoService.create(processo, usuario);
        return ResponseEntity.ok(novoProcesso);
    }

    @PutMapping("/{id}/status")
    @ApiOperation(value = "Atualizar o status de um processo", response = ProcessoModel.class)
    public ResponseEntity<ProcessoModel> updateProcessoStatus(@PathVariable Long id, @RequestParam Status status) {
        processoService.updateStatus(id, status);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/parecer")
    @ApiOperation(value = "Atualizar o parecer de um processo", response = ProcessoModel.class)
    public ResponseEntity<ProcessoModel> updateProcessoParecer(@PathVariable Long id, @RequestParam Parecer parecer) {
        processoService.updateParecer(id, parecer);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/responsavel/{idPessoa}")
    @ApiOperation(value = "Obter processos por responsável", response = List.class)
    public ResponseEntity<List<ProcessoModel>> getProcessosByResponsavel(@PathVariable Long idPessoa) {
        List<ProcessoModel> processos = processoService.findByResponsavel(idPessoa);
        return ResponseEntity.ok(processos);
    }

    @GetMapping("/tipo/{tipo}")
    @ApiOperation(value = "Obter processos por tipo", response = List.class)
    public ResponseEntity<List<ProcessoModel>> getProcessosByTipo(@PathVariable TipoProcesso tipo) {
        List<ProcessoModel> processos = processoService.findByTipoProcesso(tipo);
        return ResponseEntity.ok(processos);
    }

    @GetMapping("/status/{status}")
    @ApiOperation(value = "Obter processos por status", response = List.class)
    public ResponseEntity<List<ProcessoModel>> getProcessosByStatus(@PathVariable Status status) {
        List<ProcessoModel> processos = processoService.findByStatus(status);
        return ResponseEntity.ok(processos);
    }
}
