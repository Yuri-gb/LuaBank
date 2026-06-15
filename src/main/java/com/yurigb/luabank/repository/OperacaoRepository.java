package com.yurigb.luabank.repository;

import com.yurigb.luabank.model.Conta;
import com.yurigb.luabank.model.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
    List<Operacao> findByContaOrderByDataHoraDesc(Conta conta);
}
