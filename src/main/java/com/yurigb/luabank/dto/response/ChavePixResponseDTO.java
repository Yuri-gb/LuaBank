package com.yurigb.luabank.dto.response;

import com.yurigb.luabank.model.TipoChavePix;

public record ChavePixResponseDTO(

        Long id,
        TipoChavePix tipo,
        String valor

) {
}