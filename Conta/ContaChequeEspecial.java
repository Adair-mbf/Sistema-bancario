package Conta;
import Cliente.Titular;
public abstract class ContaChequeEspecial extends Conta{
    private int chequeEspecial;

    public ContaChequeEspecial(Titular titular, double saldo, String prefixo) {
        super(titular, saldo, prefixo);
        this.chequeEspecial = 2000;
    }
    @Override
    public double sacar(double valorSaque){
        if(valorSaque <= 0){
            System.out.println("Valor inválido!");
            return this.saldo;
        }
        if(this.saldo - valorSaque >= -this.chequeEspecial){
            return this.saldo -= valorSaque;
        }
        System.out.println("Saldo e cheque especial insuficientes!");
        return this.saldo;
    }
    @Override
    public void transferir(Conta conta2, double valorTransferencia){
        if((this.saldo + chequeEspecial) >= valorTransferencia && valorTransferencia > 0){
            this.saldo -= valorTransferencia;
            conta2.depositar(valorTransferencia);
            System.out.println("Transferência realizada!");
        }
        else{
            System.out.println("Transferência inválida!");
        }
    }
}