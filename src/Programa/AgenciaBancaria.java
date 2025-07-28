package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }
    public static void operacoes() {
        System.out.println("________________________________________________");
        System.out.println("_________________BANCO WEX______________________ ");
        System.out.println("***SELECIONE A OPERACAO QUE DESEJA EXECUTAR******");
        System.out.println("_________________________________________________");
        System.out.println("|      1. Criar Conta        |");
        System.out.println("|      2.Depositar           |");
        System.out.println("|      3. Sacar              |");
        System.out.println("|      4. Transferir         |");
        System.out.println("|      5. Listar             |");
        System.out.println("|      6.Sair                |");

        int operacao = input.nextInt();
        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("Obrigada por escolher a Wex!");
                System.exit(0);
            default:
                System.out.println("Opcao Invalida");
                operacoes();
                break;

        }
    }

    public static void criarConta() {
        input.nextLine(); // limpa o \n deixado pelo nextInt

        System.out.println("\nNome: ");
        String nome = input.nextLine();

        System.out.println("\nCPF: ");
        String cpf = input.nextLine();

        System.out.println("\nEmail: ");
        String email = input.nextLine();

        Pessoa pessoa = new Pessoa(nome, cpf, email);
        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println(" Sua conta foi criada com sucesso!");

        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for (Conta c: contasBancarias) {
                if (conta.getNumeroConta() == numeroConta){
                  return c;
                }
            }
            } return null;
        }
    public static void depositar() {
        System.out.println(" Numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor deseja depositar?");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Valor depositado com sucesso!");
        } else{
            System.out.println("Conta nao encontrada!");
        }
        operacoes();

    }

    public static void sacar() {
        System.out.println("Numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null){
            System.out.println("Qual valor deseja sacar?");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);

        }else {
            System.out.println(" Valor nao encontrado!");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Digite o numero da sua conta: ");
        int numeroContaRemetente = input.nextInt();
        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente!= null) {
            System.out.println("Digite o numero da conta do destinatario: ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario!= null) {
                System.out.println("Valor a ser transferido:  ");
                Double valor = input.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);
            }
        }
        operacoes();

    }


    public static void listarContas() {
        if(contasBancarias.size() > 0) {
            for(Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        } else{
            System.out.println("Conta sem cadastro!");
        }
        operacoes();

    }

}
