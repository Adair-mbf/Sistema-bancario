package Conta;
import Cliente.PessoaFisica;

public class ContaPoupanca extends Conta{
    private PessoaFisica titular;
    
    public ContaPoupanca(double saldo, PessoaFisica titular) {
        super(titular,saldo, "CP");
    }
    public double render(){
        double taxaRendimento = this.saldo * 0.005;
        return this.saldo += (taxaRendimento);
    }
}
