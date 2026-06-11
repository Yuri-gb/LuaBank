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

}