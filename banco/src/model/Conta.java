package model;

public class Conta {

    protected double saldo;
    protected int numeroConta;
    protected Titular titular;
    private int id;

    // Construtor
    public Conta(Titular titular) {
        this.titular = titular;
        this.saldo = 0;
    }

    // ================= GETTERS =================

    public double getSaldo() {
        return saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Titular getTitular() {
        return titular;
    }
    public int getId() {
        return id;
    }

    // ================= SETTERS =================

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setId(int id) {
        this.id = id;
    }

    // ================= MÉTODOS =================



    // Isso aqui vai ser movido para o service do cartão mais por enquanto vai ficar por aqui 
    public void credito(double valor) {
        System.out.println("Crédito não disponível para esta conta.");
    }

    // 
    public void mostrarCartao() {
        System.out.println("Conta não possui cartão.");
    }
}