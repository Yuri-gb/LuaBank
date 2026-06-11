package com.yurigb.luabank.controller;


import org.springframework.web.bind.annotation.*;

import com.yurigb.luabank.model.Conta;
import com.yurigb.luabank.dto.CriarContaDTO;
import com.yurigb.luabank.service.ContaService;

@RestController
@RequestMapping("/titulares")
public class TitularController {

    private final ContaService contaService;

    public TitularController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping("/conta/criar")
    public Conta criar(@RequestBody CriarContaDTO dados) {
        return contaService.criarConta(dados);
    }
}