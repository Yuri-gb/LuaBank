package com.yurigb.luabank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoOperacao tipo;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta;

    public Operacao(BigDecimal valor, LocalDateTime dataHora, TipoOperacao tipoOperacao, Conta numeroConta) {
        this.dataHora = dataHora;
        this.tipo = tipoOperacao;
        this.valor = valor;
        this.conta = numeroConta;


    }

    public Operacao(){

    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getdataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setTipo(TipoOperacao tipo) {
        this.tipo = tipo;
    }

        public void setConta(Conta  conta) {
        this.conta = conta;
    }
}