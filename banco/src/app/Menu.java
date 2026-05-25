package app;

import java.util.Scanner;

import auth.AuthService;
import banco.dao.TitularDAO;
import model.Titular;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {

        TitularDAO.criarTabela();

        int opcao = 0;

        while (opcao != 3) {

            System.out.println("\n=== BANCO ===");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Fazer login");
            System.out.println("3 - Sair");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada inválida!");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1 -> criarConta();
                case 2 -> login();
                case 3 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void criarConta() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (AuthService.emailExiste(email)) {
            System.out.println("Email já existe!");
        } else {
            TitularDAO.inserirTitular(nome, email, cpf, idade, senha);
            System.out.println("Conta criada!");
        }
    }

    private void login() {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Titular t = AuthService.login(email, senha);

        if (t != null) {
            System.out.println("Login realizado!");
            menuBanco(t); // 🔥 chama o menu interno
        } else {
            System.out.println("Erro no login!");
        }
    }

    // 🔥 MENU DO BANCO (o que faltava)
    private void menuBanco(Titular titular) {

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n=== MENU BANCO ===");
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Ver dados do cartão");
            System.out.println("0 - Sair");

            try {
                opcao = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada inválida!");
                scanner.nextLine();
                opcao = -1;
                continue;
            }

            switch (opcao) {

                case 1:
                    System.out.println("Saldo: " + titular.getConta().getSaldo());
                    break;

                case 2:
                    System.out.println("Valor para depositar:");
                    double deposito = scanner.nextDouble();
                    titular.getConta().depositar(deposito);
                    break;

                case 3:
                    System.out.println("Valor para sacar:");
                    double saque = scanner.nextDouble();
                    titular.getConta().sacar(saque);
                    break;

                case 4:
                    titular.getConta().mostrarCartao(); // 🔥 polimorfismo
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}