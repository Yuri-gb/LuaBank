package dao;

import database.Conexao;
import database.DatabaseUtil;
import model.Titular;

public class TitularDAO {

    public static void criarTabela() {

        String sql = """
            CREATE TABLE IF NOT EXISTS titular (

                id INTEGER PRIMARY KEY AUTOINCREMENT,

                nome TEXT NOT NULL,

                email TEXT NOT NULL UNIQUE,

                senha TEXT NOT NULL,

                cpf TEXT NOT NULL UNIQUE,

                idade INTEGER NOT NULL

            );
        """;

        DatabaseUtil.executar(sql);
    }

    // Inserir titular
    public static void inserirTitular(
        String nome,
        String email,
        String cpf,
        int idade,
        String senha
    ) {

        String sql = String.format("""
            INSERT INTO titular
            (nome, email, cpf, idade, senha)

            VALUES
            ('%s', '%s', '%s', %d, '%s');
        """,
        nome,
        email,
        cpf,
        idade,
        senha
        );

        DatabaseUtil.executar(sql);
    }

    // Buscar titular por email
    public static Titular selecionarTitularPorEmail(
        String email
    ) {

        String sql = String.format("""
            SELECT * FROM titular
            WHERE email = '%s';
        """, email);

        try (
            java.sql.Connection conn =
                Conexao.conectar();

            java.sql.Statement stmt =
                conn.createStatement();

            java.sql.ResultSet rs =
                stmt.executeQuery(sql)
        ) {

            if (rs.next()) {

                Titular t = new Titular();

                t.setId(
                    rs.getInt("id"));

                t.setNome(
                    rs.getString("nome")
                );

                t.setEmail(
                    rs.getString("email")
                );

                t.setCpf(
                    rs.getString("cpf")
                );

                t.setIdade(
                    rs.getInt("idade")
                );

                t.setSenha(
                    rs.getString("senha")
                );
                

                return t;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}