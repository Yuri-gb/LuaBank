package com.yurigb.luabank.exception.notfound;

public class ContaNaoEncontradaException extends RuntimeException {

    public ContaNaoEncontradaException() {
        super("Conta não encontrada");
    }
}