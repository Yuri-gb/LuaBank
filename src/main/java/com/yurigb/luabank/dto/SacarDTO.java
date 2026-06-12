package com.yurigb.luabank.dto;
import java.math.BigDecimal;
import jakarta.validation.constraints.*;

public class SacarDTO {
    
    @NotNull
    private long numeroConta;

    @NotNull
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero")
    private BigDecimal valor;

    public SacarDTO(long numeroConta, BigDecimal valor) {
        this.numeroConta = numeroConta;
        this.valor = valor;
    }

    public SacarDTO() {
    }

    public long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
