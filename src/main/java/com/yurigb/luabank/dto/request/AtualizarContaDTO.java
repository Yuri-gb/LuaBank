package com.yurigb.luabank.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;


public record AtualizarContaDTO(
        String nome,
        String telefone,
        @Email @Schema(description = "Email utilizado para login", example = "user@email.com") @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Email inválido") String email

) {}
