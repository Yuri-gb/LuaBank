package com.yurigb.luabank.exception;

public class CpfJaCadastradoException extends RuntimeException {

    public CpfJaCadastradoException() {
        super("CPF já cadastrado");
    }
}