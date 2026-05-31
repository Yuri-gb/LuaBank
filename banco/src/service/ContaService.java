package service;

import dao.ContaDAO;
import model.Conta;
import model.Titular;

public class ContaService {

    // Criar conta
    public static Conta criarConta(
            Titular titular
    ) {

        Conta conta =
                new Conta(titular);

        ContaDAO.inserirConta(
                conta,
                titular.getId()
        );

        conta =
                ContaDAO.buscarPorTitular(
                        titular.getId(),
                        titular
                );

        int numeroConta =
                1000 + conta.getId();

        conta.setNumeroConta(
                numeroConta
        );

        ContaDAO.atualizarNumeroConta(
                conta.getId(),
                numeroConta
        );

        return conta;
    }

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

            return true;
        }

        System.out.println(
                "Saldo insuficiente."
        );

        return false;
    }
}