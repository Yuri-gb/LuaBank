package com.yurigb.luabank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yurigb.luabank.model.Conta;
import com.yurigb.luabank.model.Operacao;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
    Page<Operacao> findByConta(
        Conta conta,
        Pageable pageable);
}
