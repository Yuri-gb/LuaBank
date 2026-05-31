package dao;

/* import java.time.LocalDateTime;

import model.Transacao; */

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

    /**public static void inserirTransacao(Transacao transacao) {

        Integer contaOrigem =
            (transacao.getContaOrigem() != null)
                ? transacao.getContaOrigem().getId()
                : null;

        Integer contaDestino =
            (transacao.getContaDestino() != null)
                ? transacao.getContaDestino().getId()
                : null;

        String sql = String.format("""
            
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
    }*/
}