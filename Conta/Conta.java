package Conta;
import Cliente.Titular;

public abstract class Conta {
    private Titular titular;
    private double saldo;
    private String numeroConta;
    private static int geradorNumeroConta = 1000;

    public Conta(Titular titular, double saldo, String prefixo){
        this.titular = titular;
        this.saldo = saldo;
        this.numeroConta = prefixo + "-" + geradorNumeroConta++;
    }
    public double getSaldo() {
        return saldo;
    }
    public String getNumeroConta() {
        return numeroConta;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double depositar(double valorDeposito){
        if(valorDeposito <= 0){
            System.out.println("Valor inválido!");
            return this.saldo;
        }
        return this.saldo += valorDeposito;
    }
    public double sacar(double valorSaque){
        if (valorSaque <= 0) {
            System.out.println("Valor inválido!");
            return this.saldo;
        }
        if(this.saldo < valorSaque){
            System.out.println("Saldo insuficiente!");
            return this.saldo;
        }
        return this.saldo -= valorSaque;
    }
    public void transferir(Conta conta2, double valorTransferencia){
        if(this.saldo >= valorTransferencia && valorTransferencia > 0){
            this.sacar(valorTransferencia);
            conta2.depositar(valorTransferencia);
        }
        else{
            System.out.println("Transferência inválida!");
        }
    }
    public void exibirExtrato(){
        System.out.println("\nNúmero da conta:");
        System.out.println(this.numeroConta);
        System.out.println("Cliente:");
        System.out.println(this.titular.getNome());
        System.out.println("Saldo da conta:");
        System.out.println("R$ " + this.saldo + "\n");
    }
}
