package com.yurigb.luabank.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;

public class TransferirDTO {

    @NotNull(message = "Número da conta de origem é obrigatório")
    private Long contaOrigem;
    @NotNull(message = "Número da conta de destino é obrigatório")
    private Long contaDestino;
    @NotNull(message = "Valor da transferência é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor da transferência deve ser positivo")
    private BigDecimal valor;

    public TransferirDTO() {
    }

    // getters e setters

    public Long getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Long contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Long getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Long contaDestino) {
        this.contaDestino = contaDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}