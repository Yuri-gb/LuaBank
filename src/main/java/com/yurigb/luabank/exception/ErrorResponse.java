package com.yurigb.luabank.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

    private String mensagem;
    private LocalDateTime dataHora;

    public ErrorResponse(String mensagem) {
        this.mensagem = mensagem;
        this.dataHora = LocalDateTime.now();
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}