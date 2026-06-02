package app;

import java.util.Scanner;


import database.DatabaseInitializer;

import model.Titular;
import service.AuthService;
import service.ContaService;
import service.TransacaoService;

public class Menu {

    private void mostrarMenu(
        String[] menu
) {

    for (String linha : menu) {

        System.out.println(
            linha
        );
    }
}

    private Scanner scanner = new Scanner(System.in);

    // Iniciar o menu
    public void iniciar() {
        DatabaseInitializer.inicializar();
        int opcao = 0;

        while (opcao != 3) {

            mostrarMenu(
                new String[] {

                    "\n=== BANCO ===",

                    "1 - Criar conta",

                    "2 - Fazer login",

                    "3 - Sair"
                }
            );
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

    // criar conta
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

        Titular titular =
            AuthService.addConta(
                nome,
                email,
                cpf,
                idade,
                senha
            );

        if (titular != null) {

            System.out.println(
                "Conta criada!"
            );
        }

    }

    // Login
    private void login() {

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Titular t = AuthService.login(email, senha);

        if (t != null) {

            System.out.println("Login realizado!");
            menuBanco(t); //  chama o menu interno

        } else {
            System.out.println("Erro no login!");
        }
    }

    //  MENU DO BANCO
    private void menuBanco(Titular titular) {

        int opcao = -1;

        while (opcao != 0) {

            mostrarMenu(
                new String[] {

                    "\n=== MENU BANCO ===",

                    "1 - Ver saldo",

                    "2 - Depositar",

                    "3 - Sacar",

                    "4 - Ver extrato",

                    "0 - Sair"
                }
            );

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
                    TransacaoService.depositar(titular.getConta(), deposito);
                    break;

                case 3:
                    System.out.println("Valor para sacar:");
                    double saque = scanner.nextDouble();
                    TransacaoService.sacar(titular.getConta(), saque);
                    break;

                case 4:
                    TransacaoService.verExtrato(titular.getConta());
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