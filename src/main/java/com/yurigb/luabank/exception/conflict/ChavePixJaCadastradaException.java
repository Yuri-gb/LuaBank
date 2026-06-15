package com.yurigb.luabank.exception.conflict;

public class ChavePixJaCadastradaException
        extends RuntimeException {

    public ChavePixJaCadastradaException() {

        super("Esta chave Pix já está cadastrada.");
    }
}