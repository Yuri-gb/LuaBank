package com.yurigb.luabank.controller;


import org.springframework.web.bind.annotation.*;

import com.yurigb.luabank.model.Conta;
import com.yurigb.luabank.dto.ContaResponseDTO;
import com.yurigb.luabank.dto.CriarContaDTO;
import com.yurigb.luabank.service.ContaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/titulares")
public class TitularController {

    private final ContaService contaService;

    public TitularController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping("/conta/criar")
    public ContaResponseDTO criar(@Valid @RequestBody CriarContaDTO dados) {

        Conta conta = contaService.criarConta(dados);

        return new ContaResponseDTO(
                conta.getNumeroConta(),
                conta.getEmail(),
                conta.getSaldo()
        );
    }
}