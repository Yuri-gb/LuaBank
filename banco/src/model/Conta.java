package model;

public class Conta {

    protected double saldo;
    protected int numeroConta;
    protected Titular titular;

    private static int contador = 1; // 🔥 gera número automático

    // 🔹 Construtor
    public Conta(Titular titular) {
        this.titular = titular;
        this.numeroConta = contador++; // número único
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

    // ================= MÉTODOS =================

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido.");
            return false;
        }

        if (saldo >= valor) {
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente.");
            return false;
        }
    }

    // 🔥 Base para polimorfismo (crédito)
    public void credito(double valor) {
        System.out.println("Crédito não disponível para esta conta.");
    }

    // 🔥 Base para polimorfismo (cartão)
    public void mostrarCartao() {
        System.out.println("Conta não possui cartão.");
    }
}