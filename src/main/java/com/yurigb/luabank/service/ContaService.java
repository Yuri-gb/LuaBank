package com.yurigb.luabank.service;

import com.yurigb.luabank.controller.AuthController;
import java.math.BigDecimal;
import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yurigb.luabank.dto.CriarContaDTO;
import com.yurigb.luabank.exception.ContaNaoEncontradaException;
import com.yurigb.luabank.exception.CpfInvalidoException;
import com.yurigb.luabank.exception.CpfJaCadastradoException;
import com.yurigb.luabank.exception.EmailJaCadastradoException;
import com.yurigb.luabank.exception.SaldoInsuficienteException;
import com.yurigb.luabank.exception.TelefoneInvalidoException;
import com.yurigb.luabank.exception.TransferenciaInvalidaException;
import com.yurigb.luabank.model.Conta;
import com.yurigb.luabank.model.Titular;
import com.yurigb.luabank.repository.ContaRepository;
import com.yurigb.luabank.repository.TitularRepository;

import jakarta.transaction.Transactional;

@Service
public class ContaService {
    private final ContaRepository contaRepository;
    private final TitularRepository titularRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ContaService(ContaRepository contaRepository, TitularRepository titularRepository) {
        this.contaRepository = contaRepository;
        this.titularRepository = titularRepository;
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

        String cpf = dados.getCpf().replaceAll("\\D", "");

        if (cpf.length() != 11) {
            throw new CpfInvalidoException();
        }

        String telefone = dados.getTelefone().replaceAll("\\D", "");

        if (telefone.length() < 10 || telefone.length() > 11) {
            throw new TelefoneInvalidoException();
        }

        if (titularRepository.findByCpf(cpf) != null) {
            throw new CpfJaCadastradoException();
        }

        if (contaRepository.findByEmail(dados.getEmail()) != null) {
            throw new EmailJaCadastradoException();
        }

        Titular titular = new Titular();

        titular.setNome(dados.getNome());
        titular.setCpf(cpf);
        titular.setTelefone(telefone);
        titular.setIdade(dados.getIdade());

        Titular titularSalvo = titularRepository.save(titular);

        Conta conta = new Conta();

        conta.setEmail(dados.getEmail());
        conta.setSaldo(BigDecimal.ZERO);
        conta.setNumeroConta(gerarNumeroConta());

        String senhaHash = passwordEncoder.encode(dados.getSenha());

        conta.setSenhaHash(senhaHash);
        conta.setTitular(titularSalvo);

        return contaRepository.save(conta);
    }

    @Transactional
    public void sacar(String email, BigDecimal valor) {
        Conta conta = obterContaPorEmail(email);

        if (conta.getSaldo().compareTo(valor) < 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque");
        }

        conta.setSaldo(conta.getSaldo().subtract(valor));
        contaRepository.save(conta);
    }

    @Transactional
    public void depositar(BigDecimal valor, String email) {

        Conta conta = obterContaPorEmail(email);

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new SaldoInsuficienteException("O valor do depósito deve ser maior que zero");
        }

        conta.setSaldo(conta.getSaldo().add(valor));
        contaRepository.save(conta);
    }

    @Transactional
    public void transferir(
            String email,
            long numeroContaDestino,
            BigDecimal valor) {

        Conta conta = obterContaPorEmail(email);
        Long numeroContaOrigem = Long.parseLong(conta.getNumeroConta());

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new TransferenciaInvalidaException(
                    "O valor da transferência deve ser maior que zero");
        }

        if (numeroContaOrigem == numeroContaDestino) {
            throw new TransferenciaInvalidaException(
                    "Não é possível transferir para a mesma conta");
        }

        Conta contaOrigem = contaRepository.findByNumeroConta(numeroContaOrigem);

        Conta contaDestino = contaRepository.findByNumeroConta(numeroContaDestino);

        if (contaOrigem == null || contaDestino == null) {
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
