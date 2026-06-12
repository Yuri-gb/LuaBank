package com.yurigb.luabank.exception;

public class TransferenciaInvalidaException
        extends RuntimeException {

    public TransferenciaInvalidaException(String message) {
        super(message);
    }
}