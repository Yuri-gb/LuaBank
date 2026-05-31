package database;

import dao.ContaDAO;
import dao.TitularDAO;
import dao.TransacaoDAO;

public class DatabaseInitializer {

    public static void inicializar() {

        TitularDAO.criarTabela();

        ContaDAO.criarTabela();

        TransacaoDAO.criarTabela();

        System.out.println(
            "Banco inicializado."
        );
    }
}