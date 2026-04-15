package Conta;
import Cliente.PessoaFisica;

public class ContaEspecial extends ContaChequeEspecial{
    public ContaEspecial(double saldo, PessoaFisica titular) {
        super(titular, saldo, "CES");
    }
}
