package com.yurigb.luabank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yurigb.luabank.model.Conta;


public interface ContaRepository extends JpaRepository<Conta, Long> {
    boolean existsByNumeroConta(String numeroConta);
    Conta findByEmail(String email);
}
