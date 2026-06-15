package com.yurigb.luabank.dto.response;

import java.math.BigDecimal;

public record ContaResponseDTO(
        String numeroConta,
        String email,
        BigDecimal saldo) {
}
