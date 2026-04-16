package Conta;
import Cliente.PessoaFisica;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(double saldo, PessoaFisica titular) {
        super(titular,saldo, "CP");
    }
    public double render(){
        double taxaRendimento = getSaldo() * 0.005;
        double mudarSaldo = getSaldo() + taxaRendimento;
        setSaldo(mudarSaldo);
        return getSaldo();
    }
}
