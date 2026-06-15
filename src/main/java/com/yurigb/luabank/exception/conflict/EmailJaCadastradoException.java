package com.yurigb.luabank.exception.conflict;

public class EmailJaCadastradoException extends RuntimeException {

    public EmailJaCadastradoException() {
        super("Email já cadastrado");
    }
}