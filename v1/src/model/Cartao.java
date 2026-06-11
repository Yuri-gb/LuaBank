package model;


public class Cartao {

    private String numero;
    private double limite;
    private double limiteDisponivel;
    private Titular titular;

public Cartao(String numero, double limite, Titular titular) {
        this.numero = numero;
        this.limite = limite;
        this.titular = titular;
    }

    public void mostrarDados() {

        System.out.println("Titular: " + titular.getNome());
        System.out.println("Número do cartão: " + numero);
        System.out.println("Limite: " + limite);

    }

    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

}