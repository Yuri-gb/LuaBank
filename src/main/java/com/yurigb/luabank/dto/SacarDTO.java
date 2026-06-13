package com.yurigb.luabank.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;

public class SacarDTO {

    @NotNull
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero")
    private BigDecimal valor;

    public SacarDTO() {
    }

    public SacarDTO(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
