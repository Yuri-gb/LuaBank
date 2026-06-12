package com.yurigb.luabank.dto;
import java.math.BigDecimal;

public class DepositarDTO {
    private long numeroConta;
    private BigDecimal valor;

    public DepositarDTO(long numeroConta, BigDecimal valor) {
        this.numeroConta = numeroConta;
        this.valor = valor;
    }

    public DepositarDTO() {
    }

    public long getNumeroConta() {
        return numeroConta;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
