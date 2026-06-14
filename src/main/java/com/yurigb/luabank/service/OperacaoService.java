package com.yurigb.luabank.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yurigb.luabank.model.Conta;
import com.yurigb.luabank.model.Operacao;
import com.yurigb.luabank.model.TipoOperacao;
import com.yurigb.luabank.repository.ContaRepository;
import com.yurigb.luabank.repository.OperacaoRepository;

@Service
public class OperacaoService {

    private final ContaRepository contaRepository;
    private final OperacaoRepository operacaoRepository;

    public OperacaoService(
            OperacaoRepository operacaoRepository,
            ContaRepository contaRepository) {

        this.operacaoRepository = operacaoRepository;
        this.contaRepository = contaRepository;
    }

    public void gerarOperacao(
            BigDecimal valor,
            TipoOperacao tipoOperacao,
            Conta conta) {

        Operacao operacao = new Operacao();

        operacao.setValor(valor);
        operacao.setTipo(tipoOperacao);
        operacao.setConta(conta);
        operacao.setDataHora(LocalDateTime.now());

        operacaoRepository.save(operacao);
    }

    public void gerarTransferenciaEnviada(
            BigDecimal valor,
            Conta contaOrigem,
            Conta contaDestino) {

        Operacao operacao = new Operacao();

        operacao.setTipo(
                TipoOperacao.TRANSFERENCIA_ENVIADA);

        operacao.setValor(valor);
        operacao.setConta(contaOrigem);
        operacao.setDataHora(LocalDateTime.now());

        operacao.setNomeDestinatario(
                contaDestino.getTitular().getNome());

        operacao.setNumeroContaDestino(
                contaDestino.getNumeroConta());

        operacaoRepository.save(operacao);
    }

    public void gerarTransferenciaRecebida(
            BigDecimal valor,
            Conta contaOrigem,
            Conta contaDestino) {

        Operacao operacao = new Operacao();

        operacao.setTipo(
                TipoOperacao.TRANSFERENCIA_RECEBIDA);

        operacao.setValor(valor);
        operacao.setConta(contaDestino);
        operacao.setDataHora(LocalDateTime.now());

        operacao.setNomeRemetente(
                contaOrigem.getTitular().getNome());

        operacao.setNumeroContaOrigem(
                contaOrigem.getNumeroConta());

        operacaoRepository.save(operacao);
    }

    public List<Operacao> consultarExtrato(String email) {

        Conta conta = contaRepository.findByEmail(email);

        return operacaoRepository
                .findByContaOrderByDataHoraDesc(conta);
    }

}