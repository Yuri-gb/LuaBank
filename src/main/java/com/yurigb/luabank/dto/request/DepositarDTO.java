package com.yurigb.luabank.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;

public record DepositarDTO(@NotNull @DecimalMin("0.01") BigDecimal valor) {

}
