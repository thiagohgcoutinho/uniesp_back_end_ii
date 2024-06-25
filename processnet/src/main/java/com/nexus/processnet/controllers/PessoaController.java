package com.nexus.processnet.controllers;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.nexus.processnet.models.FuncionarioModel;
import com.nexus.processnet.models.LoginModel;
import com.nexus.processnet.models.PessoaModel;
import com.nexus.processnet.models.UsuarioModel;
import com.nexus.processnet.services.FuncionarioService;
import com.nexus.processnet.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = UsuarioModel.class, name = "Usuario"),
        @JsonSubTypes.Type(value = FuncionarioModel.class, name = "Funcionario")
})
public class PessoaController {

    private final UsuarioService usuarioService;
    private final FuncionarioService funcionarioService;

    @Autowired
    public PessoaController(UsuarioService usuarioService, FuncionarioService funcionarioService) {
        this.usuarioService = usuarioService;
        this.funcionarioService = funcionarioService;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePessoa(@PathVariable Long id, @RequestBody PessoaModel pessoa) {
        try {
            if (pessoa instanceof UsuarioModel) {
                return ResponseEntity.ok(usuarioService.update(id, (UsuarioModel) pessoa));
            } else if (pessoa instanceof FuncionarioModel) {
                return ResponseEntity.ok(funcionarioService.update(id, (FuncionarioModel) pessoa));
            } else {
                throw new IllegalArgumentException("Tipo de pessoa desconhecido");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar pessoa: " + e.getMessage());
        }
    }

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
                Map<String, Object> response = new HashMap<>();
                response.put("nome", usuario.getNome());
                response.put("tipo", "Usuario");
                response.put("idPessoa", usuario.getIdPessoa());
                response.put("telefone", usuario.getTelefone());
                response.put("email", usuario.getEmail());
                response.put("cpf", usuario.getCpf());
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
            }
        }

        Optional<FuncionarioModel> funcionarioOpt = funcionarioService.findByCpf(loginRequest.getCpf());
        if (funcionarioOpt.isPresent()) {
            FuncionarioModel funcionario = funcionarioOpt.get();
            if (funcionario.getSenha().equals(loginRequest.getSenha())) {
                Map<String, Object> response = new HashMap<>();
                response.put("nome", funcionario.getNome());
                response.put("tipo", "Funcionario");
                response.put("cargo", funcionario.getCargo().name());
                response.put("idPessoa", funcionario.getIdPessoa());
                response.put("telefone", funcionario.getTelefone());
                response.put("email", funcionario.getEmail());
                response.put("cpf", funcionario.getCpf());
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CPF não cadastrado");
    }
}
