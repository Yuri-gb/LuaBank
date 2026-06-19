package com.yurigb.luabank.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.yurigb.luabank.dto.request.LoginRequestDTO;
import com.yurigb.luabank.dto.response.LoginResponseDTO;
import com.yurigb.luabank.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "Autenticação", description = "Operações de autenticação e geração de token JWT")
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(summary = "Realizar login", description = "Autentica o usuário e retorna um token JWT válido.")
    @PostMapping("/login")
    public LoginResponseDTO login(
            @Valid @RequestBody LoginRequestDTO dados) {

        return authService.login(dados);
    }
}
