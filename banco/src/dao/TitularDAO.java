package dao;


import java.sql.ResultSet;

import database.DatabaseUtil;
import model.Titular;

public class TitularDAO {
    public static void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS titular (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT,
                email TEXT UNIQUE,
                senha TEXT,
                cpf TEXT UNIQUE,
                idade INTEGER
                
            );
        """;

        DatabaseUtil.executar(sql);

    }

    public static void inserirTitular(String nome, String email, String cpf, int idade, String senha) {
        String sql = String.format("""
            INSERT INTO titular (nome, email, cpf, idade, senha)
            VALUES ('%s', '%s', '%s', %d, '%s');
        """, nome, email, cpf, idade, senha);

        DatabaseUtil.executar(sql);
    }

   public static Titular selecionarTitularPorEmail(String email) {

    String sql = String.format("""
        SELECT * FROM titular WHERE email = '%s';
    """, email);

    ResultSet rs = DatabaseUtil.consultar(sql); // ← FALTAVA ISSO ✔

    try {
        if (rs != null && rs.next()) {

            Titular t = new Titular();

            t.setNome(rs.getString("nome"));
            t.setEmail(rs.getString("email"));
            t.setCpf(rs.getString("cpf"));
            t.setIdade(rs.getInt("idade"));
            t.setSenha(rs.getString("senha"));

            return t;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
    }

}