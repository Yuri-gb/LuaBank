package com.yurigb.luabank.dto.request;

import com.yurigb.luabank.model.TipoChavePix;


import jakarta.validation.constraints.NotNull;

public record CriarChavePixDTO(

        @NotNull
        TipoChavePix tipo

) {
}