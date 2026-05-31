package dao;

import database.Conexao;
import database.DatabaseUtil;
import model.Conta;
import model.Titular;

public class ContaDAO {

    // Criar tabela
    public static void criarTabela() {

        String sql = """
            CREATE TABLE IF NOT EXISTS conta (

                id INTEGER PRIMARY KEY AUTOINCREMENT,

                numero_conta INTEGER UNIQUE,

                saldo REAL NOT NULL,

                titular_id INTEGER NOT NULL,

                FOREIGN KEY (titular_id)
                    REFERENCES titular(id)

            );
        """;

        DatabaseUtil.executar(sql);
    }

    // Inserir conta
    public static void inserirConta(
        Conta conta,
        int titularId
    ) {

        String sql = String.format(
            java.util.Locale.US,

            """
            INSERT INTO conta
            (saldo, titular_id)

            VALUES
            (%f, %d);
            """,

            conta.getSaldo(),
            titularId
        );

        DatabaseUtil.executar(sql);
    }

    // Buscar conta pelo titular
   public static Conta buscarPorTitular(
    int titularId,
    Titular titular
) {

    String sql = String.format("""
        SELECT * FROM conta
        WHERE titular_id = %d;
    """, titularId);

    try (
        java.sql.Connection conn =
            Conexao.conectar();

        java.sql.Statement stmt =
            conn.createStatement();

        java.sql.ResultSet rs =
            stmt.executeQuery(sql)
    ) {

        if (rs.next()) {

            Conta conta =
                new Conta(titular);

            conta.setId(
                rs.getInt("id")
            );

            conta.setSaldo(
                rs.getDouble("saldo")
            );

            conta.setNumeroConta(
                rs.getInt("numero_conta")
            );

            return conta;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}
    // Atualizar saldo
     public static void atualizarSaldo(
        Conta conta
    ) {

        String sql = String.format(
            java.util.Locale.US,

            """
            UPDATE conta
            SET saldo = %f
            WHERE numero_conta = %d;
            """,

            conta.getSaldo(),
            conta.getNumeroConta()
        );

        DatabaseUtil.executar(sql);
    }


    public static void atualizarNumeroConta(
        int id,
        int numeroConta
) {

    String sql = String.format(
        """
        UPDATE conta
        SET numero_conta = %d
        WHERE id = %d;
        """,
        numeroConta,
        id
    );

    DatabaseUtil.executar(sql);
}

    // Deletar conta
    public static void deletarConta(
        int id
    ) {

        String sql = String.format("""
            DELETE FROM conta
            WHERE id = %d;
        """, id);
        DatabaseUtil.executar(sql);
    }

}