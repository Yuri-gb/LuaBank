package com.yurigb.luabank.model;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal saldo = BigDecimal.ZERO;

    @Column(nullable = false, unique = true)
    private String numeroConta;
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senhaHash;

    @ManyToOne
    @JoinColumn(name = "titular_id", nullable = false)

    private Titular titular;

    public Conta() {
    }

    public Conta(BigDecimal saldo, String numeroConta, String email, String senhaHash, Titular titular) {
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.email = email;
        this.senhaHash = senhaHash;
        this.titular = titular;
    }

    // ======== getters ========

    public BigDecimal getSaldo() {
        return saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public Long getId() {
        return id;
    }

    public Titular getTitular() {
        return titular;
    }

    public String getCpfTitular() {
        return titular.getCpf();
    }

    public String getEmail() {
        return email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    // ======== setters ========

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }
}