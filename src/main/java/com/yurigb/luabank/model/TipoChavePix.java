package com.yurigb.luabank.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.yurigb.luabank.exception.badrequest.TipoChavePixInvalidoException;

public enum TipoChavePix {

    CPF,
    EMAIL,
    TELEFONE,
    ALEATORIA;

    @JsonCreator
    public static TipoChavePix fromString(
            String valor) {

        try {
            return TipoChavePix.valueOf(
                    valor.toUpperCase());

        } catch (Exception e) {
            throw new TipoChavePixInvalidoException();
        }
    }
}