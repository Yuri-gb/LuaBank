package com.yurigb.luabank.exception.notfound;

public class ChavePixNaoEncontradaException
        extends RuntimeException {

    public ChavePixNaoEncontradaException() {

        super("Chave Pix não encontrada.");
    }
}