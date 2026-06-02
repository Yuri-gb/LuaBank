package model;

import java.time.LocalDateTime;

public class Transacao {
    private int id;
    private TipoTransacao tipo;
    private double valor;
    private LocalDateTime data;
    private Conta contaOrigem;
    private Conta contaDestino;

    //  Construtor vazio (IMPORTANTE pro DAO)
    public  Transacao() {
    }

    public Transacao( TipoTransacao tipo, double valor, Conta contaOrigem, Conta contaDestino) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = LocalDateTime.now();
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

    // ================= GETTERS =================
    
    public int getId() {
        return id;
    }
    public TipoTransacao getTipo() {
        return tipo;
    }
    public double getValor() {
        return valor;
    }
    public LocalDateTime getData() {
        return data;
    }
    public Conta getContaOrigem() {
        return contaOrigem;
    }
    public Conta getContaDestino() {
        return contaDestino;
    }

    // ================ SETTERS =================


    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }
    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }

}
