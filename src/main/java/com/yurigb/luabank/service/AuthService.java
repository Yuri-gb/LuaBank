package com.yurigb.luabank.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yurigb.luabank.dto.LoginDTO;
import com.yurigb.luabank.dto.LoginResponseDTO;
import com.yurigb.luabank.exception.CredenciaisInvalidasException;
import com.yurigb.luabank.model.Conta;
import com.yurigb.luabank.repository.ContaRepository;

@Service
public class AuthService {

    private final ContaRepository contaRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public LoginResponseDTO login(LoginDTO dados) {

        Conta conta = contaRepository.findByEmail(dados.getEmail());

        if (conta == null) {
            throw new CredenciaisInvalidasException();
        }

        boolean senhaValida = passwordEncoder.matches(
                dados.getSenha(),
                conta.getSenhaHash());

        if (!senhaValida) {
            throw new CredenciaisInvalidasException();
        }

        return new LoginResponseDTO(
                "Login realizado com sucesso");
    }
}
