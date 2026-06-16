package com.yurigb.luabank.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoOperacao {

    DEPOSITO,
    SAQUE,
    PIX_ENVIADO,
    PIX_RECEBIDO;

    @JsonCreator
    public static TipoChavePix fromString(String valor) {

        try {
            return TipoChavePix.valueOf(
                    valor.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Tipo de chave Pix inválido");
        }
    }

}
