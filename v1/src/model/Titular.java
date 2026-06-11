package model;



public class Titular{
    private int id;
    private String nome;
    private int idade;
    private String cpf;
    private String email;
    private String senha;

    private Conta conta;

    //  Construtor completo (quando cria manualmente)
    public Titular( String nome, int idade, String cpf, String email, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;

    }

    //  Construtor vazio (IMPORTANTE pro DAO)
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

    public String getSenha() {
        return senha;
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


}
