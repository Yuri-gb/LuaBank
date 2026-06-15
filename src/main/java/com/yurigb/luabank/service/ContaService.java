package com.yurigb.luabank.service;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yurigb.luabank.dto.request.CriarContaDTO;
import com.yurigb.luabank.exception.badrequest.CpfInvalidoException;
import com.yurigb.luabank.exception.badrequest.SaldoInsuficienteException;
import com.yurigb.luabank.exception.badrequest.TelefoneInvalidoException;
import com.yurigb.luabank.exception.badrequest.TransferenciaInvalidaException;
import com.yurigb.luabank.exception.conflict.CpfJaCadastradoException;
import com.yurigb.luabank.exception.conflict.EmailJaCadastradoException;
import com.yurigb.luabank.exception.notfound.ContaNaoEncontradaException;
import com.yurigb.luabank.model.Conta;
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

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ContaService(
            ContaRepository contaRepository,
            TitularRepository titularRepository,
            OperacaoService operacaoService) {

        this.contaRepository = contaRepository;
        this.titularRepository = titularRepository;
        this.operacaoService = operacaoService;
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

        if (titularRepository.findByCpf(cpf) != null) {
            throw new CpfJaCadastradoException();
        }

        if (contaRepository.findByEmail(dados.email()) != null) {
            throw new EmailJaCadastradoException();
        }

        Titular titular = new Titular();

        titular.setNome(dados.nome());
        titular.setCpf(cpf);
        titular.setTelefone(telefone);
        titular.setIdade(dados.idade());

        Titular titularSalvo = titularRepository.save(titular);

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
    public void transferir(
            String email,
            long numeroContaDestino,
            BigDecimal valor) {

        Conta contaOrigem = obterContaPorEmail(email);

        Long numeroContaOrigem = Long.parseLong(contaOrigem.getNumeroConta());

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new TransferenciaInvalidaException(
                    "O valor da transferência deve ser maior que zero");
        }

        if (numeroContaOrigem.equals(numeroContaDestino)) {
            throw new TransferenciaInvalidaException(
                    "Não é possível transferir para a mesma conta");
        }

        Conta contaDestino = contaRepository.findByNumeroConta(numeroContaDestino);

        if (contaDestino == null) {
            throw new ContaNaoEncontradaException();
        }

        if (contaOrigem.getSaldo().compareTo(valor) < 0) {
            throw new SaldoInsuficienteException(
                    "Saldo insuficiente para realizar a transferência");
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