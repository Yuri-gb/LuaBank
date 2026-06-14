package com.yurigb.luabank.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.yurigb.luabank.model.Conta;
import com.yurigb.luabank.model.Operacao;
import com.yurigb.luabank.model.TipoOperacao;
import com.yurigb.luabank.repository.OperacaoRepository;

@Service
public class OperacaoService {

    private final OperacaoRepository operacaoRepository;

    public OperacaoService(
            OperacaoRepository operacaoRepository) {

        this.operacaoRepository = operacaoRepository;
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
}