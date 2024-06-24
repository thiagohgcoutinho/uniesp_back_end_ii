package com.nexus.processnet.controllers;

import com.nexus.processnet.models.UsuarioModel;
import com.nexus.processnet.models.LoginModel;
import com.nexus.processnet.services.LoginService;
import com.nexus.processnet.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final LoginService loginService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, LoginService loginService) {
        this.usuarioService = usuarioService;
        this.loginService = loginService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> createUsuario(@RequestBody UsuarioModel usuario) {
        return ResponseEntity.ok(usuarioService.create(usuario));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateUsuario(@RequestBody LoginModel loginRequest) {
        try {
            String result = loginService.authenticateUsuario(loginRequest.getCpf(), loginRequest.getSenha());
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuario) {
        return ResponseEntity.ok(usuarioService.update(id, usuario));
    }
}
