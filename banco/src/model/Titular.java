package model;

import auth.Autenticavel;

public class Titular implements Autenticavel {

    private int id;
    private String nome;
    private int idade;
    private String cpf;
    private String email;
    private String senha;

    private Conta conta;

    // 🔹 Construtor completo (quando cria manualmente)
    public Titular(int id, String nome, int idade, String cpf, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;

        // 🔥 Define o tipo de conta automaticamente
        if (idade < 18) {
            this.conta = new ContaMenor(this);
        } else {
            this.conta = new ContaNormal(this);
        }
    }

    // 🔹 Construtor vazio (IMPORTANTE pro DAO)
    public Titular() {
    }

    // ================= GETTERS =================

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public Conta getConta() {
        return conta;
    }

    // ================= SETTERS =================

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    // ================= LOGIN =================

    @Override
    public boolean autenticar(String email, String senha) {
        return email != null && senha != null &&
               email.equals(this.email) &&
               senha.equals(this.senha);
    }

    public void inicializarConta() {
        if (idade < 18) {
            this.conta = new ContaMenor(this);
        } else {
            this.conta = new ContaNormal(this);
        }
}
}