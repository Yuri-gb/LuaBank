package com.yurigb.luabank.service;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.stereotype.*;
import com.yurigb.luabank.repository.ContaRepository;
import com.yurigb.luabank.model.Conta;
import com.yurigb.luabank.model.Titular;
import com.yurigb.luabank.repository.TitularRepository;
import com.yurigb.luabank.dto.CriarContaDTO;
import jakarta.transaction.Transactional;



@Service
public class ContaService {
    private final ContaRepository contaRepository;
    private final TitularRepository titularRepository;

    public ContaService(ContaRepository contaRepository, TitularRepository titularRepository) {
        this.contaRepository = contaRepository;
        this.titularRepository = titularRepository;
    }


    private String gerarNumeroConta() {

    String numeroConta;

    do {
        numeroConta = String.valueOf(
                100000 + new Random().nextInt(900000)
        );
    } while (contaRepository.existsByNumeroConta(numeroConta));

    return numeroConta;
}

    @Transactional
    public Conta criarConta(CriarContaDTO dados) {

        Titular titular = new Titular();

        titular.setNome(dados.getNome());
        titular.setCpf(dados.getCpf());
        titular.setTelefone(dados.getTelefone());
        titular.setIdade(dados.getIdade());

        Titular titularSalvo = titularRepository.save(titular);

        Conta conta = new Conta();

        conta.setEmail(dados.getEmail());
        conta.setSaldo(BigDecimal.ZERO);
        conta.setNumeroConta(gerarNumeroConta());
        conta.setSenhaHash(dados.getSenha()); // depois BCrypt

        conta.setTitular(titularSalvo);

        return contaRepository.save(conta);

    }
}

