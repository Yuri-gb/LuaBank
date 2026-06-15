package com.yurigb.luabank.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CriarContaDTO(

        @NotBlank String nome,

        @NotBlank String cpf,

        @NotBlank String telefone,

        @NotNull @Min(18) Integer idade,

        @NotBlank @Email @Schema(description = "Email utilizado para login", example = "user@email.com") @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Email inválido") String email,

        @NotBlank @Size(min = 6) String senha

) {
}
