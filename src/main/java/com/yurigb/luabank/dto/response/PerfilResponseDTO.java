package com.yurigb.luabank.dto.response;
import java.math.*;

public record PerfilResponseDTO(
        String nome,
        String email,
        String telefone,
        String numeroConta,
        BigDecimal saldo) {
}