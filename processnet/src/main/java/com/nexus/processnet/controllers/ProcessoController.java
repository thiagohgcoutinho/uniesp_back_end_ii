package com.nexus.processnet.controllers;

import com.nexus.processnet.models.*;
import com.nexus.processnet.services.ProcessoService;
import com.nexus.processnet.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/processos")
public class ProcessoController {

    @Autowired
    private ProcessoService processoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<ProcessoModel>> getAllProcessos() {
        return ResponseEntity.ok(processoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessoModel> getProcessoById(@PathVariable Long id) {
        return ResponseEntity.ok(processoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProcessoModel> createProcesso(@RequestBody ProcessoModel processo) {
        try {
            if (processo.getResponsavel() == null || processo.getResponsavel().getIdPessoa() == null) {
                throw new IllegalArgumentException("Responsável não informado corretamente");
            }
            UsuarioModel responsavel = usuarioService.findById(processo.getResponsavel().getIdPessoa());
            if (responsavel == null) {
                throw new IllegalArgumentException("Usuário responsável não encontrado");
            }
            processo.setResponsavel(responsavel);
            ProcessoModel novoProcesso = processoService.create(processo);
            return ResponseEntity.ok(novoProcesso);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcessoModel> updateProcesso(@PathVariable Long id, @RequestBody ProcessoModel processo) {
        try {
            ProcessoModel processoAtualizado = processoService.update(id, processo);
            return ResponseEntity.ok(processoAtualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ProcessoModel> updateProcessoStatus(@PathVariable Long id, @RequestParam Status status) {
        processoService.updateStatus(id, status);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/parecer")
    public ResponseEntity<?> updateProcessoParecer(@PathVariable Long id, @RequestBody Map<String, String> payload) {
        try {
            Parecer parecer = Parecer.valueOf(payload.get("parecer").toUpperCase());
            processoService.updateParecer(id, parecer);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}/selecionar")
    public ResponseEntity<?> selectProcesso(@PathVariable Long id, @RequestBody Map<String, Object> payload) {
        try {
            Long idPessoa = ((Number) payload.get("idPessoa")).longValue();
            Cargo cargo = Cargo.valueOf((String) payload.get("cargo"));

            FuncionarioModel funcionario = new FuncionarioModel();
            funcionario.setIdPessoa(idPessoa);
            funcionario.setCargo(cargo);

            processoService.selectProcesso(id, funcionario);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProcesso(@PathVariable Long id) {
        try {
            processoService.delete(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/responsavel/{idPessoa}")
    public ResponseEntity<List<ProcessoModel>> getProcessosByResponsavel(@PathVariable Long idPessoa) {
        List<ProcessoModel> processos = processoService.findByResponsavel(idPessoa);
        return ResponseEntity.ok(processos);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<ProcessoModel>> getProcessosByTipo(@PathVariable TipoProcesso tipo) {
        List<ProcessoModel> processos = processoService.findByTipoProcesso(tipo);
        return ResponseEntity.ok(processos);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ProcessoModel>> getProcessosByStatus(@PathVariable Status status) {
        List<ProcessoModel> processos = processoService.findByStatus(status);
        return ResponseEntity.ok(processos);
    }
}
