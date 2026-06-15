package com.yurigb.luabank.exception.badrequest;

public class TransferenciaInvalidaException
        extends RuntimeException {

    public TransferenciaInvalidaException(String message) {
        super(message);
    }
}