package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;


import database.Conexao;
import model.Conta;
import model.TipoTransacao;
import model.Transacao; 

public class TransacaoDAO {

    public static void criarTabela() {

        String sql = """
            CREATE TABLE IF NOT EXISTS transacao (

                id INTEGER PRIMARY KEY AUTOINCREMENT,

                tipo TEXT NOT NULL,

                valor REAL NOT NULL,

                data TEXT NOT NULL,

                conta_origem INTEGER,

                conta_destino INTEGER,

                FOREIGN KEY (conta_origem)
                    REFERENCES conta(id),

                FOREIGN KEY (conta_destino)
                    REFERENCES conta(id)

            );
        """;

        database.DatabaseUtil.executar(sql);
    }

    public static void inserirTransacao(Transacao transacao) {

        Integer contaOrigem =
            (transacao.getContaOrigem() != null)
                ? transacao.getContaOrigem().getId()
                : null;

        Integer contaDestino =
            (transacao.getContaDestino() != null)
                ? transacao.getContaDestino().getId()
                : null;

        String sql = String.format(
            java.util.Locale.US,
            """
            INSERT INTO transacao
            (tipo, valor, data, conta_origem, conta_destino)

            VALUES
            ('%s', %f, '%s', %s, %s);
            """,

            transacao.getTipo().name(),
            transacao.getValor(),
            transacao.getData(),

            (contaOrigem != null)
                ? contaOrigem.toString()
                : "NULL",

            (contaDestino != null)
                ? contaDestino.toString()
                : "NULL"
        );

                database.DatabaseUtil.executar(sql);
            }
public static List<Transacao> buscarPorConta(int contaId) {

    List<Transacao> transacoes =
            new ArrayList<>();

    String sql = String.format(
        """
        SELECT
            tipo,
            valor,
            data

        FROM transacao

        WHERE
            conta_origem = %d
            OR conta_destino = %d

        ORDER BY data DESC;
        """,

        contaId,
        contaId
    );

    try (
        Connection conn = Conexao.conectar();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)
    ) {

        while (rs.next()) {

            Transacao transacao =
                    new Transacao();

            transacao.setTipo(
                TipoTransacao.valueOf(
                    rs.getString("tipo")
                )
            );

            transacao.setValor(
                rs.getDouble("valor")
            );

            transacao.setData(
                LocalDateTime.parse(
                    rs.getString("data")
                )
            );

            transacoes.add(
                transacao
            );
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return transacoes;
}
}
    