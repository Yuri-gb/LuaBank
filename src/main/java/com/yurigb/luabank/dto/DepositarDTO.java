package com.yurigb.luabank.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.*;


public class DepositarDTO {

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal valor;


    public DepositarDTO() {
    }

    public BigDecimal getValor() {
        return valor;
    }
}
