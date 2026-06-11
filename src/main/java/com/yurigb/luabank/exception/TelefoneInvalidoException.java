package com.yurigb.luabank.exception;

public class TelefoneInvalidoException extends RuntimeException {

    public TelefoneInvalidoException() {
        super("Telefone inválido");
    }
}