package Banco;
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected double saldoTotal;
    private double limite;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.atualizaSaldoTotal();
    }

    public Cliente getCliente(){
        return cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
        this.atualizaSaldoTotal();
    }

    public double saldoTotal() {
        return saldoTotal;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
        this.atualizaSaldoTotal();
    }

    private void atualizaSaldoTotal(){
        this.saldoTotal = saldo + limite;
    }

    @Override
    public String toString(){
        return String.format("Número da Conta: %d\nAgência: %d\nCliente: %s\nSaldo: %.2f",
                numero, agencia, cliente.getNome(), saldo);
    }

    @Override
    public void sacar(double valor) {
        if(valor > 0 && this.getSaldo() >= valor){
            if(this.getSaldo() >= valor){
                this.saldo = this.getSaldo() - valor;
                this.atualizaSaldoTotal();
                System.out.println("Saque efetuado com sucesso!!");
            }else{
                double restante = this.getSaldo() - valor;
                this.limite = this.getLimite() + restante;
                this.saldo = 0.0;
                this.atualizaSaldoTotal();
                System.out.println("Saque efetuado com sucesso!!");
            }
        }else{
            System.out.println("Saque não efetuado. Tente novamente.");
        }
    }

    @Override
    public void depositar(double valor) {
        if(valor > 0) {
            this.saldo = this.getSaldo() + valor;
            this.atualizaSaldoTotal();
            System.out.println("Depósito efetuado com sucesso!!");
        }else{
            System.out.println("Depósito não efetuado. Tente novamente.");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(valor > 0 && this.getSaldo() >= valor) {
			if(this.getSaldo() >= valor) {
				this.saldo = this.getSaldo() - valor;
				contaDestino.saldo = contaDestino.getSaldo() + valor;
				this.atualizaSaldoTotal();
				contaDestino.atualizaSaldoTotal();
				System.out.println("Transeferência realizada com sucesso!");
			}else {
				Double restante = this.getSaldo() - valor;
				this.limite = this.getLimite() + restante;
				this.saldo = 0.0;
				contaDestino.saldo = contaDestino.getSaldo() + valor;
				this.atualizaSaldoTotal();
				contaDestino.atualizaSaldoTotal();
				System.out.println("Transferência realizada com sucesso!");
			}
		}else {
			System.out.println("Transferência não realizada. Tente novamente.");
		}
        
    }

    protected void imprimirInfoComuns(){
        System.out.println(String.format("Títular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
