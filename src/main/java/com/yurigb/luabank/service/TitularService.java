package com.yurigb.luabank.service;

import org.springframework.stereotype.*;
import com.yurigb.luabank.repository.TitularRepository;
import com.yurigb.luabank.model.Titular;




@Service
public class TitularService {
    private final TitularRepository titularRepository;

    public TitularService(TitularRepository titularRepository) {
        this.titularRepository = titularRepository;
    }


    
    public Titular criarTitular(Titular titular) {
        
        return titularRepository.save(titular);
    }

}
