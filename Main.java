import java.util.Scanner;

import Cliente.PessoaFisica;
import Cliente.PessoaJuridica;
import Conta.Conta;
import Conta.ContaCorrente;
import Conta.ContaEmpresarial;
import Conta.ContaEspecial;
import Conta.ContaPoupanca;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Banco banco1 = new Banco("BB-809", "Banco do Brasil");
        byte opcao;
        System.out.println("Bem vindo!\n");
        do{
            System.out.println("O que você deseja fazer?");
            System.out.println("1- Criar uma nova conta");
            System.out.println("2- Exibir o extrato de uma conta");
            System.out.println("3- Sacar o valor de uma conta");
            System.out.println("4- Depositar o valor em uma conta");
            System.out.println("5- Transferir valores de uma conta para outra");
            System.out.println("0- Sair\n");

            opcao = leitor.nextByte();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o tipo de cliente:");
                    System.out.println("1- Pessoa física");
                    System.out.println("2- Pessoa juridíca");
                    byte opcaoCliente = leitor.nextByte();
                    leitor.nextLine();
                    switch (opcaoCliente) {
                        case 1:{
                            System.out.println("Digite o seu nome completo:");
                            String nome = leitor.nextLine();
                            System.out.println("Digite o seu telefone:");
                            String telefone = leitor.nextLine();
                            System.out.println("Digite o seu CPF:");
                            String cpf = leitor.nextLine();
                            PessoaFisica titular = new PessoaFisica(nome, telefone, cpf);
                            System.out.println("Escolha o tipo de conta que deseja criar:");
                            System.out.println("1- Conta corrente");
                            System.out.println("2- Conta especial");
                            System.out.println("3- Conta poupança");
                            byte opcaoConta = leitor.nextByte();
                            leitor.nextLine();
                            switch(opcaoConta){
                                case 1:{
                                    ContaCorrente conta = new ContaCorrente(0, titular);
                                    banco1.cadastrarConta(conta);
                                    break;
                                }
                                case 2:{
                                    ContaEspecial conta = new ContaEspecial(0, titular);
                                    banco1.cadastrarConta(conta);
                                    break;
                                }
                                case 3:{
                                    ContaPoupanca conta = new ContaPoupanca(0, titular);
                                    banco1.cadastrarConta(conta);
                                    break;
                                }
                                default:
                                    System.out.println("Opção inválida\n");
                                    break;
                            }
                            break;
                        }
                        case 2:{
                            System.out.println("Digite o nome da empresa:");
                            String nome = leitor.nextLine();
                            System.out.println("Digite o telefone da empresa:");
                            String telefone = leitor.nextLine();
                            System.out.println("Digite o CNPJ da empresa:");
                            String cnpj = leitor.nextLine();
                            PessoaJuridica titular = new PessoaJuridica(nome, telefone, cnpj);
                            ContaEmpresarial conta = new ContaEmpresarial(0,titular);
                            banco1.cadastrarConta(conta);
                            break;
                        }
                        default:
                            System.out.println("Opção inválida\n");
                            break;
                    }
                    break;
                case 2:{
                    Conta conta = interacaoBuscarConta(banco1, leitor);
                    if (conta != null){
                        conta.exibirExtrato();
                    }
                    break;
                }
                case 3:{
                    Conta conta = interacaoBuscarConta(banco1, leitor);
                    if (conta != null) {
                        System.out.println("Quanto você deseja sacar?");
                        double valorSaque = leitor.nextDouble();
                        leitor.nextLine();
                        conta.sacar(valorSaque);
                        System.out.println("Saldo atual:");
                        System.out.println("R$ " + conta.getSaldo() + "\n");
                    }
                    break;
                }
                case 4:{
                    Conta conta = interacaoBuscarConta(banco1, leitor);
                    if (conta != null) {
                        System.out.println("Quanto você deseja depositar?");
                        double valorDeposito = leitor.nextDouble();
                        leitor.nextLine();
                        conta.depositar(valorDeposito);
                        System.out.println("Saldo atual:");
                        System.out.println("R$ " + conta.getSaldo() + "\n");
                    }
                    break;
                }
                case 5:{
                    Conta conta = interacaoBuscarConta(banco1, leitor);
                    if (conta != null){
                        System.out.println("Quanto você deseja transferir");
                        double valorTransferencia = leitor.nextDouble();
                        leitor.nextLine();
                        System.out.println("Informe o número da conta para qual deseja transferir");
                        String numeroConta2 = leitor.nextLine();
                        Conta conta2 = banco1.buscarConta(numeroConta2);
                        if (conta2 != null) {
                            conta.transferir(conta2, valorTransferencia);
                            System.out.println("Saldo atual:");
                            System.out.println("R$ " + conta.getSaldo() + "\n");
                        }
                    }
                    break;
                }
                case 0:{
                    System.out.println("Saindo...\n");
                    break;
                }
                default:
                    System.out.println("Opção inválida!\n");
                    break;
            }
        }while (opcao!=0);
        leitor.close();
    }
    private static Conta interacaoBuscarConta(Banco banco, Scanner leitor){
        System.out.println("Informe o número da conta:");
        String numeroConta = leitor.nextLine();
        return banco.buscarConta(numeroConta);
    }
}