package Conta;
import Cliente.PessoaJuridica;

public class ContaEmpresarial extends ContaChequeEspecial{
    private PessoaJuridica titular;

    public ContaEmpresarial(double saldo, PessoaJuridica titular) {
        super(titular,saldo, "CEM");
    }
}
