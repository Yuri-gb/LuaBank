package com.yurigb.luabank.model;

import jakarta.persistence.*;

@Entity
public class ChavePix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoChavePix tipo;

    @Column(nullable = false, unique = true)
    private String valor;

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta;

    public ChavePix() {
    }

    public Long getId() {
        return id;
    }

    public TipoChavePix getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }

    public Conta getConta() {
        return conta;
    }

    public void setTipo(TipoChavePix tipo) {
        this.tipo = tipo;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}