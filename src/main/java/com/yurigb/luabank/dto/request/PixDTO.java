package com.yurigb.luabank.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PixDTO(

        @NotBlank
        String chavePix,

        @NotNull
        @DecimalMin("0.01")
        BigDecimal valor

) {
}