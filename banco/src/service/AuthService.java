package service;

import dao.ContaDAO;
import dao.TitularDAO;
import model.Conta;
import model.Titular;

public class AuthService {

    // Validação de cadastro
    public static boolean validarCadastro(
            String nome,
            String email,
            String cpf,
            int idade,
            String senha) {

        String[] campos = {
                nome,
                email,
                cpf,
                senha
        };

        String[] nomesCampos = {
                "Nome",
                "Email",
                "CPF",
                "Senha"
        };

        for (int i = 0; i < campos.length; i++) {

            if (campos[i] == null || campos[i].isBlank()) {

                System.out.println(
                        nomesCampos[i] + " obrigatório."
                );

                return false;
            }
        }

        if (idade < 1 || idade > 120) {

            System.out.println("Idade inválida.");

            return false;
        }

        if (!email.contains("@")) {

            System.out.println("Email inválido.");

            return false;
        }

        cpf = cpf.replaceAll("\\D", "");
        
        if (cpf.length() != 11) {

            System.out.println(
                    "CPF deve possuir 11 dígitos."
            );

            return false;
        }

        if (emailExiste(email)) {

            System.out.println(
                    "Email já cadastrado."
            );

            return false;
        }

        return true;
    }

    // Verifica se email já existe
    public static boolean emailExiste(String email) {

        if (email == null || email.isBlank()) {
            return false;
        }

        return TitularDAO
                .selecionarTitularPorEmail(email)
                != null;
    }

    // Autentica um titular
    public static boolean autenticar(
            Titular titular,
            String senha) {

        return titular != null
                && senha != null
                && senha.equals(
                        titular.getSenha()
                );
    }



    //Login
    public static Titular login(
            String email,
            String senha) {

        Titular titular =
            TitularDAO.selecionarTitularPorEmail(email);

        if (!autenticar(titular, senha)) {
            return null;
        }

        Conta conta =
            ContaDAO.buscarPorTitular(
                titular.getId(),
                titular
            );

        titular.setConta(conta);

        return titular;
        }



    // Registrar titular e criar conta
    public static Titular addConta(

            String nome,
            String email,
            String cpf,
            int idade,
            String senha

    ) {

        if (!validarCadastro(
                nome,
                email,
                cpf,
                idade,
                senha
        )) {

            return null;
        }

        TitularDAO.inserirTitular(
                nome,
                email,
                cpf,
                idade,
                senha
        );

        Titular titular =
                TitularDAO
                        .selecionarTitularPorEmail(
                                email
                        );

        Conta conta =
                ContaService
                        .criarConta(
                                titular
                        );

        titular.setConta(
                conta
        );

        return titular;
    }
}