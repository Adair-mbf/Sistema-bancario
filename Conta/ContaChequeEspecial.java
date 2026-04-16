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
            return getSaldo();
        }
        if(valorSaque <= (getSaldo() + chequeEspecial)){
            double mudarSaldo = getSaldo() - valorSaque;
            setSaldo(mudarSaldo);
            return getSaldo();
        }
        System.out.println("Saldo e cheque especial insuficientes!");
        return getSaldo();
    }
    @Override
    public void transferir(Conta conta2, double valorTransferencia){
        if((getSaldo() + chequeEspecial) >= valorTransferencia && valorTransferencia > 0){
            double mudarSaldo = getSaldo() - valorTransferencia;
            setSaldo(mudarSaldo);
            conta2.depositar(valorTransferencia);
            System.out.println("Transferência realizada!");
        }
        else{
            System.out.println("Transferência inválida!");
        }
    }
}