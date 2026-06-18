package com.yurigb.luabank.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CriarContaDTO(

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "O CPF é obrigatório")
        String cpf,

        @NotBlank(message = "O telefone é obrigatório")
        String telefone,

        @NotNull(message = "A idade é obrigatória")
        @Min(value = 18, message = "É necessário ser maior de idade")
        Integer idade,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Email inválido")
        @Schema(
                description = "Email utilizado para login",
                example = "user@email.com"
        )
        @Pattern(
                regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
                message = "Email inválido"
        )
        String email,

        @NotBlank(message = "A senha é obrigatória")
        @Size(
                min = 6,
                max = 50,
                message = "A senha deve possuir entre 6 e 50 caracteres"
        )
        String senha

) {
}
