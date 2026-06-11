package com.yurigb.luabank.dto;

import java.math.BigDecimal;

public class ContaResponseDTO {

    private String numeroConta;
    private String email;
    private BigDecimal saldo;

    public ContaResponseDTO(String numeroConta, String email, BigDecimal saldo) {
        this.numeroConta = numeroConta;
        this.email = email;
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}