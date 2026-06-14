package com.yurigb.luabank.repository;

import com.yurigb.luabank.model.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OperacaoRepository extends JpaRepository<Operacao, Long>  {

}
