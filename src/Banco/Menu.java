package Banco;
import java.util.Scanner;

public class Menu {
    private Banco banco;
    private Scanner teclado;

    public Menu(Banco banco) {
        this.banco = banco;
        this.teclado = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            options();
        }
    }

    private void options() {
        System.out.println("=========================================");
        System.out.println("=================== ATM =================");
        System.out.println("Selecione uma opção no menu: ");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Efetuar saque");
        System.out.println("3 - Efetuar depósito");
        System.out.println("4 - Efetuar transferência");
        System.out.println("5 - Listar contas");
        System.out.println("6 - Sair do sistema");

        int opcao = Integer.parseInt(teclado.nextLine());

        switch (opcao) {
            case 1 -> criarConta();
            case 2 -> efetuarSaque();
            case 3 -> efetuarDeposito();
            case 4 -> efetuarTransferencia();
            case 5 -> banco.listarContas();
            case 6 -> {
                System.out.println("Até a próxima!");
                System.exit(0);
            }
            default -> System.out.println("Opção inválida.");
        }
    }

    private void criarConta() {
        System.out.println("Digite o nome do cliente: ");
        String nome = teclado.nextLine();

        System.out.println("Digite o email do cliente: ");
        String email = teclado.nextLine();

        System.out.println("Escolha o tipo de conta (corrente/poupanca): ");
        String tipoConta = teclado.nextLine();

        Cliente cliente = new Cliente(nome, email);
        banco.criarConta(cliente, tipoConta);
    }

    private void efetuarSaque() {
        Conta conta = buscarConta();
        if (conta != null) {
            System.out.println("Digite o valor a ser sacado: ");
            double valor = Double.parseDouble(teclado.nextLine());
            conta.sacar(valor);
        }
    }

    private void efetuarDeposito() {
        Conta conta = buscarConta();
        if (conta != null) {
            System.out.println("Digite o valor a ser depositado: ");
            double valor = Double.parseDouble(teclado.nextLine());
            conta.depositar(valor);
        }
    }

    private void efetuarTransferencia() {
        Conta contaOrigem = buscarConta();
        if (contaOrigem != null) {
            System.out.println("Digite o número da conta destino: ");
            int numeroContaDestino = Integer.parseInt(teclado.nextLine());
            Conta contaDestino = banco.buscarConta(numeroContaDestino);

            if (contaDestino != null) {
                System.out.println("Digite o valor a ser transferido: ");
                double valor = Double.parseDouble(teclado.nextLine());
                contaOrigem.transferir(valor, contaDestino);
            } else {
                System.out.println("Conta destino não encontrada.");
            }
        }
    }

    private Conta buscarConta() {
        System.out.println("Digite o número da conta: ");
        int numeroConta = Integer.parseInt(teclado.nextLine());
        Conta conta = banco.buscarConta(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
        }
        return conta;
    }
}
