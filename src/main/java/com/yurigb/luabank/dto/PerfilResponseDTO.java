package com.yurigb.luabank.dto;
import java.math.*;

public record PerfilResponseDTO(
        String nome,
        String email,
        String numeroConta,
        BigDecimal saldo) {
}