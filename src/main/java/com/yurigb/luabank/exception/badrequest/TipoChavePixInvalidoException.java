package com.yurigb.luabank.exception.badrequest;

public class TipoChavePixInvalidoException
        extends RuntimeException {

    public TipoChavePixInvalidoException() {
        super("Tipo de chave Pix inválido");
    }
}