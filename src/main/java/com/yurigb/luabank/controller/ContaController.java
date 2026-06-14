package com.yurigb.luabank.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.yurigb.luabank.model.Conta;

import com.yurigb.luabank.dto.ContaResponseDTO;
import com.yurigb.luabank.dto.CriarContaDTO;
import com.yurigb.luabank.dto.SacarDTO;
import com.yurigb.luabank.dto.DepositarDTO;
import com.yurigb.luabank.dto.TransferirDTO;
import com.yurigb.luabank.dto.PerfilResponseDTO;
import java.util.*;

import com.yurigb.luabank.service.ContaService;
import com.yurigb.luabank.service.ExtratoResponseDTO;
import com.yurigb.luabank.service.OperacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/contas")
public class ContaController {

        private final ContaService contaService;
        private final OperacaoService operacaoService;

        public ContaController(ContaService contaService, OperacaoService operacaoService) {
                this.contaService = contaService;
                this.operacaoService = operacaoService;

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
                String email = SecurityContextHolder
                                .getContext()
                                .getAuthentication()
                                .getName();

                contaService.sacar(email, dados.getValor());

        }

        @PostMapping("/depositar")
        public void depositar(@Valid @RequestBody DepositarDTO dados) {

                String email = SecurityContextHolder
                                .getContext()
                                .getAuthentication()
                                .getName();

                contaService.depositar(dados.getValor(), email);
        }

        @PostMapping("/transferir")
        public void transferir(@Valid @RequestBody TransferirDTO dados) {
                String email = SecurityContextHolder
                                .getContext()
                                .getAuthentication()
                                .getName();

                contaService.transferir(
                                email,
                                dados.getContaDestino(),
                                dados.getValor());
        }

        @GetMapping("/saldo")
        public String consultarSaldo() {

                String email = SecurityContextHolder
                                .getContext()
                                .getAuthentication()
                                .getName();

                return "Saldo: " +
                                contaService.consultarSaldoPorEmail(email);
        }

        @GetMapping("/extrato")
        public List<ExtratoResponseDTO> consultarExtrato() {

                String email = SecurityContextHolder
                                .getContext()
                                .getAuthentication()
                                .getName();

                return operacaoService.consultarExtrato(email)
                                .stream()
                                .map(op -> new ExtratoResponseDTO(
                                                op.getTipo(),
                                                op.getValor(),
                                                op.getDataHora(),
                                                op.getNomeRemetente(),
                                                op.getNomeDestinatario(),
                                                op.getNumeroContaOrigem(),
                                                op.getNumeroContaDestino()))
                                .toList();
        }

        @GetMapping("/perfil")
        public PerfilResponseDTO perfil() {

                String email = SecurityContextHolder
                                .getContext()
                                .getAuthentication()
                                .getName();

                Conta conta = contaService.obterContaPorEmail(email);

                return new PerfilResponseDTO(
                                conta.getTitular().getNome(),
                                conta.getEmail(),
                                conta.getNumeroConta(),
                                conta.getSaldo());
        }
}