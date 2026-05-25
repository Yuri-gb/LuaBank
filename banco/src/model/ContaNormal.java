package model;


public class ContaNormal extends Conta {

    private Cartao cartao;

    public ContaNormal(Titular titular) {
        super(titular);
        this.cartao = new Cartao("0000-1111", 1000, titular);
    }

    @Override
    public void credito(double valor) {
        saldo += valor;
        System.out.println("Crédito aprovado!");
    }

    @Override
    public void mostrarCartao() {
        cartao.mostrarDados();
    }
}