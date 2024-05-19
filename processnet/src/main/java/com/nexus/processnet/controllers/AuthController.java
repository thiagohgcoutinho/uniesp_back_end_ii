package com.nexus.processnet.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Api(value = "Autenticação", tags = "Autenticação")
public class AuthController {

    @GetMapping("/login")
    @ApiOperation(value = "Login", notes = "Retorna uma mensagem de login.")
    public String login() {
        return "Por favor, faça login.";
    }
}
