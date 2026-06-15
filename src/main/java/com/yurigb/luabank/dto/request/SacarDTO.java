package com.yurigb.luabank.dto.request;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;

public record SacarDTO(
        @NotNull @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero") BigDecimal valor) {

}
