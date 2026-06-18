package com.yurigb.luabank.service;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yurigb.luabank.dto.request.AtualizarContaDTO;
import com.yurigb.luabank.dto.request.CriarContaDTO;
import com.yurigb.luabank.exception.badrequest.CpfInvalidoException;
import com.yurigb.luabank.exception.badrequest.SaldoInsuficienteException;
import com.yurigb.luabank.exception.badrequest.TelefoneInvalidoException;
import com.yurigb.luabank.exception.badrequest.TransferenciaInvalidaException;

import com.yurigb.luabank.exception.conflict.EmailJaCadastradoException;
import com.yurigb.luabank.exception.notfound.ContaNaoEncontradaException;
import com.yurigb.luabank.model.ChavePix;
import com.yurigb.luabank.model.Conta;
import com.yurigb.luabank.model.TipoChavePix;
import com.yurigb.luabank.model.TipoOperacao;
import com.yurigb.luabank.model.Titular;
import com.yurigb.luabank.repository.ContaRepository;
import com.yurigb.luabank.repository.TitularRepository;

import jakarta.transaction.Transactional;

@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final TitularRepository titularRepository;
    private final OperacaoService operacaoService;
    private final ChavePixService chavePixService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ContaService(
            ContaRepository contaRepository,
            TitularRepository titularRepository,
            OperacaoService operacaoService,
            ChavePixService chavePixService) {

        this.contaRepository = contaRepository;
        this.titularRepository = titularRepository;
        this.operacaoService = operacaoService;
        this.chavePixService = chavePixService;
    }

    private String gerarNumeroConta() {

        String numeroConta;

        do {
            numeroConta = String.valueOf(
                    100000 + new Random().nextInt(900000));

        } while (contaRepository.existsByNumeroConta(numeroConta));

        return numeroConta;
    }

    @Transactional
    public Conta criarConta(CriarContaDTO dados) {

        String cpf = dados.cpf().replaceAll("\\D", "");

        if (cpf.length() != 11) {
            throw new CpfInvalidoException();
        }

        String telefone = dados.telefone().replaceAll("\\D", "");

        if (telefone.length() < 10 || telefone.length() > 11) {
            throw new TelefoneInvalidoException();
        }

        if (contaRepository.findByEmail(dados.email()) != null) {
            throw new EmailJaCadastradoException();
        }

        Titular titularSalvo = titularRepository.findByCpf(cpf);

        if (titularSalvo == null) {

            Titular titular = new Titular();

            titular.setNome(dados.nome());
            titular.setCpf(cpf);
            titular.setTelefone(telefone);
            titular.setIdade(dados.idade());

            titularSalvo = titularRepository.save(titular);
        }

        Conta conta = new Conta();

        conta.setEmail(dados.email());
        conta.setSaldo(BigDecimal.ZERO);
        conta.setNumeroConta(gerarNumeroConta());

        String senhaHash = passwordEncoder.encode(dados.senha());

        conta.setSenhaHash(senhaHash);
        conta.setTitular(titularSalvo);

        return contaRepository.save(conta);
    }

    @Transactional
    public void atualizarConta(AtualizarContaDTO dados, String email) {

        Conta conta = obterContaPorEmail(email);
        Titular titular = conta.getTitular();

        // Atualizar email
        if (dados.email() != null && !dados.email().isBlank()) {

            Conta contaExistente = contaRepository.findByEmail(dados.email());

            if (contaExistente != null
                    && !contaExistente.getId().equals(conta.getId())) {
                throw new EmailJaCadastradoException();
            }

            chavePixService.atualizarChave(
                    email,
                    TipoChavePix.EMAIL,
                    dados.email());

            conta.setEmail(dados.email());
        }

        // Atualizar telefone
        if (dados.telefone() != null && !dados.telefone().isBlank()) {

            String telefone = dados.telefone().replaceAll("\\D", "");

            if (telefone.length() < 10 || telefone.length() > 11) {
                throw new TelefoneInvalidoException();
            }

            chavePixService.atualizarChave(
                    email,
                    TipoChavePix.TELEFONE,
                    telefone);

            titular.setTelefone(telefone);
        }

        // Atualizar nome
        if (dados.nome() != null && !dados.nome().isBlank()) {
            titular.setNome(dados.nome());
        }

        contaRepository.save(conta);
        titularRepository.save(titular);
    }

    @Transactional
    public void deletarConta(String email) {

        Conta conta = obterContaPorEmail(email);

        Titular titular = conta.getTitular();

        long quantidadeContas = contaRepository.countByTitularId(titular.getId());

        contaRepository.delete(conta);

        if (quantidadeContas <= 1) {
            titularRepository.delete(titular);
        }
    }

    @Transactional
    public void depositar(
            BigDecimal valor,
            String email) {

        Conta conta = obterContaPorEmail(email);

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new SaldoInsuficienteException(
                    "O valor do depósito deve ser maior que zero");
        }

        conta.setSaldo(
                conta.getSaldo().add(valor));

        operacaoService.gerarOperacao(
                valor,
                TipoOperacao.DEPOSITO,
                conta);

        contaRepository.save(conta);
    }

    @Transactional
    public void sacar(
            String email,
            BigDecimal valor) {

        Conta conta = obterContaPorEmail(email);

        if (conta.getSaldo().compareTo(valor) < 0) {
            throw new SaldoInsuficienteException(
                    "Saldo insuficiente para realizar o saque");
        }

        conta.setSaldo(
                conta.getSaldo().subtract(valor));

        contaRepository.save(conta);

        operacaoService.gerarOperacao(
                valor,
                TipoOperacao.SAQUE,
                conta);
    }

    @Transactional
    public void enviarPix(
            String email,
            String chavePix,
            BigDecimal valor) {

        Conta contaOrigem = obterContaPorEmail(email);

        ChavePix chave = chavePixService.buscarPorChave(chavePix);

        Conta contaDestino = chave.getConta();

        if (contaOrigem.getId()
                .equals(contaDestino.getId())) {

            throw new TransferenciaInvalidaException(
                    "Não é possível enviar Pix para si mesmo");
        }

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {

            throw new TransferenciaInvalidaException(
                    "O valor deve ser maior que zero");
        }

        if (contaOrigem.getSaldo()
                .compareTo(valor) < 0) {

            throw new SaldoInsuficienteException(
                    "Saldo insuficiente");
        }

        contaOrigem.setSaldo(
                contaOrigem.getSaldo().subtract(valor));

        contaDestino.setSaldo(
                contaDestino.getSaldo().add(valor));

        operacaoService.gerarTransferenciaEnviada(
                valor,
                contaOrigem,
                contaDestino);

        operacaoService.gerarTransferenciaRecebida(
                valor,
                contaOrigem,
                contaDestino);

        contaRepository.save(contaOrigem);
        contaRepository.save(contaDestino);
    }

    public Conta obterContaPorEmail(String email) {

        Conta conta = contaRepository.findByEmail(email);

        if (conta == null) {
            throw new ContaNaoEncontradaException();
        }

        return conta;
    }

    public BigDecimal consultarSaldoPorEmail(String email) {

        Conta conta = obterContaPorEmail(email);

        return conta.getSaldo();
    }
}