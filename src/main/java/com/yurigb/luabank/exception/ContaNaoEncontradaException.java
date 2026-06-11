package com.yurigb.luabank.exception;

public class ContaNaoEncontradaException extends RuntimeException {

    public ContaNaoEncontradaException() {
        super("Conta não encontrada");
    }
}