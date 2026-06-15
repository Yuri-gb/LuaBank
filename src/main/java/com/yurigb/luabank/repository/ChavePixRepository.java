package com.yurigb.luabank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yurigb.luabank.model.ChavePix;
import com.yurigb.luabank.model.Conta;

public interface ChavePixRepository
        extends JpaRepository<ChavePix, Long> {

    boolean existsByValor(String valor);

    ChavePix findByValor(String valor);

    List<ChavePix> findByConta(Conta conta);
}