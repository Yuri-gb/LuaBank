package com.yurigb.luabank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yurigb.luabank.dto.request.CriarChavePixDTO;
import com.yurigb.luabank.dto.response.ChavePixResponseDTO;
import com.yurigb.luabank.exception.conflict.ChavePixJaCadastradaException;
import com.yurigb.luabank.exception.notfound.ChavePixNaoEncontradaException;
import com.yurigb.luabank.exception.notfound.ContaNaoEncontradaException;
import com.yurigb.luabank.model.ChavePix;
import com.yurigb.luabank.model.Conta;
import com.yurigb.luabank.repository.ChavePixRepository;
import com.yurigb.luabank.repository.ContaRepository;

@Service
public class ChavePixService {

    private final ChavePixRepository chavePixRepository;
    private final ContaRepository contaRepository;

    public ChavePixService(
            ChavePixRepository chavePixRepository,
            ContaRepository contaRepository) {

        this.chavePixRepository = chavePixRepository;
        this.contaRepository = contaRepository;
    }

    public void cadastrarChave(
            String email,
            CriarChavePixDTO dados) {

        Conta conta = contaRepository.findByEmail(email);

        if (conta == null) {
            throw new ContaNaoEncontradaException();
        }

        if (chavePixRepository.existsByValor(dados.valor())) {
            throw new ChavePixJaCadastradaException();
        }

        ChavePix chavePix = new ChavePix();

        chavePix.setTipo(dados.tipo());
        chavePix.setValor(dados.valor());
        chavePix.setConta(conta);

        chavePixRepository.save(chavePix);
    }

    public List<ChavePixResponseDTO> listarChaves(
            String email) {

        Conta conta = contaRepository.findByEmail(email);

        if (conta == null) {
            throw new ContaNaoEncontradaException();
        }

        return chavePixRepository
                .findByConta(conta)
                .stream()
                .map(chave -> new ChavePixResponseDTO(
                        chave.getId(),
                        chave.getTipo(),
                        chave.getValor()))
                .toList();
    }

    public void removerChave(
            Long id,
            String email) {

        Conta conta = contaRepository.findByEmail(email);

        if (conta == null) {
            throw new ContaNaoEncontradaException();
        }

        ChavePix chavePix = chavePixRepository
                .findById(id)
                .orElseThrow(
                        ChavePixNaoEncontradaException::new);

        if (!chavePix.getConta().getId()
                .equals(conta.getId())) {

            throw new ChavePixNaoEncontradaException();
        }

        chavePixRepository.delete(chavePix);
    }

    public ChavePix buscarPorChave(
            String chavePix) {

        ChavePix chave = chavePixRepository
                .findByValor(chavePix);

        if (chave == null) {
            throw new ChavePixNaoEncontradaException();
        }

        return chave;
    }
}