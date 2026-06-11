package service;

import java.util.List;

import dao.ContaDAO;
import model.Conta;

import model.Transacao;
import model.TipoTransacao;
import dao.TransacaoDAO;

public class TransacaoService {
        // Depositar
    public static boolean depositar(
            Conta conta,
            double valor
    ) {

        if (valor <= 0) {

            System.out.println(
                    "Valor inválido para depósito."
            );

            return false;
        }

        conta.setSaldo(
                conta.getSaldo() + valor
        );

        ContaDAO.atualizarSaldo(
                conta
        );

        Transacao transacao = new Transacao(
                TipoTransacao.DEPOSITO,
                valor,
                null,
                conta
        );

        TransacaoDAO.inserirTransacao(transacao);

        return true;
    }

    // Sacar
    public static boolean sacar(
            Conta conta,
            double valor
    ) {

        if (valor <= 0) {

            System.out.println(
                    "Valor inválido."
            );

            return false;
        }

        if (conta.getSaldo() >= valor) {

            conta.setSaldo(
                    conta.getSaldo() - valor
            );

            ContaDAO.atualizarSaldo(
                    conta
            );

        Transacao transacao = new Transacao(
            TipoTransacao.SAQUE,
            valor,
            conta,
            null
            );

            TransacaoDAO.inserirTransacao(transacao);

            return true;
        }

        System.out.println(
                "Saldo insuficiente."
        );

        return false;
    }


    public static boolean transferir(
        Conta contaOrigem,
        Conta contaDestino,
        double valor
    ) {

        if (valor <= 0) {

            System.out.println(
                    "Valor inválido."
            );

            return false;
        }

        if (contaOrigem.getSaldo() >= valor) {

            contaOrigem.setSaldo(
                    contaOrigem.getSaldo() - valor
            );

            contaDestino.setSaldo(
                    contaDestino.getSaldo() + valor
            );

            ContaDAO.atualizarSaldo(
                    contaOrigem
            );

            ContaDAO.atualizarSaldo(
                    contaDestino
            );

        Transacao transacao = new Transacao(
            TipoTransacao.TRANSFERENCIA,
            valor,
            contaOrigem,
            contaDestino
            );

            TransacaoDAO.inserirTransacao(transacao);

            return true;
        }
         System.out.println(
                "Saldo insuficiente."
        );

        return false;
    }

public static void verExtrato(
        Conta conta
) {

    List<Transacao> transacoes =
        TransacaoDAO.buscarPorConta(
            conta.getId()
        );

    System.out.println(
        "\n=== EXTRATO ==="
    );

    if (transacoes.isEmpty()) {

        System.out.println(
            "Nenhuma transação encontrada."
        );

        return;
    }

    for (Transacao transacao : transacoes) {

        System.out.println(
            transacao.getData()
            + " | "
            + transacao.getTipo()
            + " | R$ "
            + transacao.getValor()
        );
    }
}
}
