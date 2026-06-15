package com.yurigb.luabank.exception.badrequest;

public class TelefoneInvalidoException extends RuntimeException {

    public TelefoneInvalidoException() {
        super("Telefone inválido");
    }
}