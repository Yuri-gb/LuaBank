package com.yurigb.luabank.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yurigb.luabank.model.Titular;

public interface TitularRepository  extends JpaRepository<Titular, Integer> {
    
    Titular findByCpf(String cpf);
}
