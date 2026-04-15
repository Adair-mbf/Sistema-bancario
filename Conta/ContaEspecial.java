package Conta;
import Cliente.PessoaFisica;

public class ContaEspecial extends ContaChequeEspecial{
    private PessoaFisica titular;

    public ContaEspecial(double saldo, PessoaFisica titular) {
        super(titular, saldo, "CES");
    }
}
