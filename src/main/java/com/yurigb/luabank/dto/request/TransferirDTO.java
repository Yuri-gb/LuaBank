package com.yurigb.luabank.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record TransferirDTO(

        @NotNull(message = "Número da conta de destino é obrigatório") Long contaDestino,

        @NotNull(message = "Valor da transferência é obrigatório") @DecimalMin(value = "0.01", message = "O valor da transferência deve ser positivo") BigDecimal valor

) {
}
