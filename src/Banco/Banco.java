package Banco;
import java.util.List;
import java.util.ArrayList;

public class Banco {

    private List<Conta> contas;

    public Banco(String nome) {
        this.contas = new ArrayList<>();
    }

    public void criarConta(Cliente cliente, String tipoConta) {
        Conta conta = null;
        if (tipoConta.equalsIgnoreCase("corrente")) {
            conta = new ContaCorrente(cliente);
        } else if (tipoConta.equalsIgnoreCase("poupanca")) {
            conta = new ContaPoupanca(cliente);
        }

        if (conta != null) {
            contas.add(conta);
            System.out.println("Conta criada com sucesso!");
        } else {
            System.out.println("Tipo de conta inválido.");
        }
    }

    public Conta buscarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada.");
        } else {
            for (Conta conta : contas) {
                System.out.println(conta);
            }
        }
    }
}
