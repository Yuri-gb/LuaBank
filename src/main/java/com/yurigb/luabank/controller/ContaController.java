package com.yurigb.luabank.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.data.domain.Sort;

import com.yurigb.luabank.dto.request.CriarContaDTO;
import com.yurigb.luabank.dto.request.DepositarDTO;
import com.yurigb.luabank.dto.request.SacarDTO;
import com.yurigb.luabank.dto.response.ContaResponseDTO;
import com.yurigb.luabank.dto.response.ExtratoResponseDTO;
import com.yurigb.luabank.dto.response.PerfilResponseDTO;
import com.yurigb.luabank.dto.request.AtualizarContaDTO;
import com.yurigb.luabank.model.Conta;
import com.yurigb.luabank.service.ContaService;
import com.yurigb.luabank.service.OperacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/contas")
public class ContaController {

        private final ContaService contaService;
        private final OperacaoService operacaoService;

        public ContaController(
                        ContaService contaService,
                        OperacaoService operacaoService) {

                this.contaService = contaService;
                this.operacaoService = operacaoService;
        }

        private String obterEmailLogado() {
                return SecurityContextHolder
                                .getContext()
                                .getAuthentication()
                                .getName();
        }

        @PostMapping("/criar")
        public ContaResponseDTO criar(
                        @Valid @RequestBody CriarContaDTO dados) {

                Conta conta = contaService.criarConta(dados);

                return new ContaResponseDTO(
                                conta.getNumeroConta(),
                                conta.getEmail(),
                                conta.getSaldo());
        }

        @PutMapping("/atualizar")
        public void atualizar(@RequestBody AtualizarContaDTO dados) {

                contaService.atualizarConta(dados, obterEmailLogado());
        }

        @GetMapping("/perfil")
        public PerfilResponseDTO perfil() {

                Conta conta = contaService.obterContaPorEmail(
                                obterEmailLogado());

                return new PerfilResponseDTO(
                                conta.getTitular().getNome(),
                                conta.getEmail(),
                                conta.getTitular().getTelefone(),
                                conta.getNumeroConta(),
                                conta.getSaldo());
        }

        @GetMapping("/saldo")
        public String consultarSaldo() {

                return "Saldo: " +
                                contaService.consultarSaldoPorEmail(
                                                obterEmailLogado());
        }

        @GetMapping("/extrato")
        public Page<ExtratoResponseDTO> consultarExtrato(
                        @PageableDefault(size = 10, sort = "dataHora", direction = Sort.Direction.DESC) Pageable pageable) {

                return operacaoService
                                .consultarExtrato(
                                                obterEmailLogado(),
                                                pageable)
                                .map(op -> new ExtratoResponseDTO(
                                                op.getTipo(),
                                                op.getValor(),
                                                op.getDataHora(),
                                                op.getNomeRemetente(),
                                                op.getNomeDestinatario(),
                                                op.getNumeroContaOrigem(),
                                                op.getNumeroContaDestino()));
        }

        @PostMapping("/depositar")
        public void depositar(
                        @Valid @RequestBody DepositarDTO dados) {

                contaService.depositar(
                                dados.valor(),
                                obterEmailLogado());
        }

        @PostMapping("/sacar")
        public void sacar(
                        @Valid @RequestBody SacarDTO dados) {

                contaService.sacar(
                                obterEmailLogado(),
                                dados.valor());
        }

}
