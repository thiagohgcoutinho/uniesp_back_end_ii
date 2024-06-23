package com.nexus.processnet.controllers;

import com.nexus.processnet.models.FuncionarioModel;
import com.nexus.processnet.models.LoginModel;
import com.nexus.processnet.models.UsuarioModel;
import com.nexus.processnet.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService<UsuarioModel> usuarioService;

    @Autowired
    private PessoaService<FuncionarioModel> funcionarioService;

    @GetMapping("/verificar-cpf")
    public ResponseEntity<String> verificarCPF(@RequestParam String cpf) {
        boolean usuarioExists = usuarioService.existsByCpf(cpf);
        boolean funcionarioExists = funcionarioService.existsByCpf(cpf);

        if (usuarioExists || funcionarioExists) {
            return ResponseEntity.ok("CPF já cadastrado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CPF não cadastrado");
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody LoginModel loginRequest) {
        Optional<UsuarioModel> usuarioOpt = usuarioService.findByCpf(loginRequest.getCpf());
        if (usuarioOpt.isPresent()) {
            UsuarioModel usuario = usuarioOpt.get();
            if (usuario.getSenha().equals(loginRequest.getSenha())) {
                return ResponseEntity.ok("usuario");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
            }
        }

        Optional<FuncionarioModel> funcionarioOpt = funcionarioService.findByCpf(loginRequest.getCpf());
        if (funcionarioOpt.isPresent()) {
            FuncionarioModel funcionario = funcionarioOpt.get();
            if (funcionario.getSenha().equals(loginRequest.getSenha())) {
                return ResponseEntity.ok(funcionario.getCargo().name());
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CPF não cadastrado");
    }
}
