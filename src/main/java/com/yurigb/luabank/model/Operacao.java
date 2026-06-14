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

    private String nomeRemetente;

    private String numeroContaOrigem;

    private String nomeDestinatario;

    private String numeroContaDestino;

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta;

    public Operacao() {
    }

    public Operacao(
            BigDecimal valor,
            LocalDateTime dataHora,
            TipoOperacao tipo,
            Conta conta) {

        this.valor = valor;
        this.dataHora = dataHora;
        this.tipo = tipo;
        this.conta = conta;
    }

    public Long getId() {
        return id;
    }

    public TipoOperacao getTipo() {
        return tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Conta getConta() {
        return conta;
    }

    public String getNomeRemetente() {
        return nomeRemetente;
    }

    public String getNumeroContaOrigem() {
        return numeroContaOrigem;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public String getNumeroContaDestino() {
        return numeroContaDestino;
    }

    public void setTipo(TipoOperacao tipo) {
        this.tipo = tipo;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public void setNomeRemetente(String nomeRemetente) {
        this.nomeRemetente = nomeRemetente;
    }

    public void setNumeroContaOrigem(String numeroContaOrigem) {
        this.numeroContaOrigem = numeroContaOrigem;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public void setNumeroContaDestino(String numeroContaDestino) {
        this.numeroContaDestino = numeroContaDestino;
    }
}