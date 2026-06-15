package com.yurigb.luabank.exception.conflict;

public class CpfJaCadastradoException extends RuntimeException {

    public CpfJaCadastradoException() {
        super("CPF já cadastrado");
    }
}