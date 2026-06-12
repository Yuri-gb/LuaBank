package com.yurigb.luabank.controller;

import org.springframework.web.bind.annotation.*;

import com.yurigb.luabank.model.Conta;
import com.yurigb.luabank.dto.ContaResponseDTO;
import com.yurigb.luabank.dto.CriarContaDTO;
import com.yurigb.luabank.dto.SacarDTO;
import com.yurigb.luabank.dto.DepositarDTO;

import com.yurigb.luabank.service.ContaService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping("/criar")
    public ContaResponseDTO criar(@Valid @RequestBody CriarContaDTO dados) {

        Conta conta = contaService.criarConta(dados);

        return new ContaResponseDTO(
                conta.getNumeroConta(),
                conta.getEmail(),
                conta.getSaldo());
    }

    @PostMapping("/sacar")
    public void sacar(@Valid @RequestBody SacarDTO dados) {
        contaService.sacar(dados.getNumeroConta(), dados.getValor());

    }

    @PostMapping("/depositar")
    public void depositar(@Valid @RequestBody DepositarDTO dados) {
        contaService.depositar(dados.getNumeroConta(), dados.getValor());
    }

}