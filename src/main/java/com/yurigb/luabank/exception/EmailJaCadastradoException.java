package com.yurigb.luabank.exception;

public class EmailJaCadastradoException extends RuntimeException {

    public EmailJaCadastradoException() {
        super("Email já cadastrado");
    }
}