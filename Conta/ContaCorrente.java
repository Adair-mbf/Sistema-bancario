package Conta;

import Cliente.PessoaFisica;

public class ContaCorrente extends Conta {
    public ContaCorrente(double saldo, PessoaFisica titular) {
        super(titular, saldo, "CC");
    }
}

