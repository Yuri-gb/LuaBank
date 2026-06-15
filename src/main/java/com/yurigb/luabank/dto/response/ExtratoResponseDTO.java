package com.yurigb.luabank.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yurigb.luabank.model.TipoOperacao;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ExtratoResponseDTO(
                TipoOperacao tipo,
                BigDecimal valor,
                @JsonFormat(pattern = "dd-MM-yyyy  HH:mm:ss") LocalDateTime dataHora,
                String nomeRemetente,
                String nomeDestinatario,
                String numeroContaOrigem,
                String numeroContaDestino) {
}