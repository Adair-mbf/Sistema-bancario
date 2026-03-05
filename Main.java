import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Banco banco1 = new Banco();

        int opcao;

        do {
            System.out.println("O que você deseja fazer?");
            System.out.println("1- Criar uma nova conta");
            System.out.println("2- Exibir o extrato de uma conta");
            System.out.println("3- Sacar o valor de uma conta");
            System.out.println("4- Depositar o valor em uma conta");
            System.out.println("5- Transferir valores de uma conta para outra");
            System.out.println("0- Sair");

            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1: {
                    System.out.println("Informe o seu nome completo:");
                    String nomeCompleto = leitor.nextLine();
                    System.out.println("Informe o seu CPF:");
                    String cpf = leitor.nextLine();
                    System.out.println("informe o seu Telefone:");
                    String telefone = leitor.nextLine();

                    Titular titular1 = new Titular(nomeCompleto, cpf, telefone);
                    Conta conta1 = new Conta(titular1, 0);

                    banco1.cadastrarConta(conta1);
                    break;
                }
                case 2: {
                    System.out.println("Informe o número da conta: ");
                    int numeroConta = leitor.nextInt();
                    Conta conta1 = banco1.buscarConta(numeroConta);
                    if (conta1 != null) {
                        conta1.exibirExtrato();
                    } else {
                        System.out.println("A conta não existe");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Informe o número da conta: ");
                    int numeroConta = leitor.nextInt();
                    Conta conta1 = banco1.buscarConta(numeroConta);
                    if (conta1 != null) {
                        System.out.println("Quanto você deseja sacar?");
                        float valorSaque = leitor.nextFloat();
                        conta1.sacar(valorSaque);
                    }
                    break;
                }
                case 4: {
                    System.out.println("Informe o número da conta: ");
                    int numeroConta = leitor.nextInt();
                    Conta conta1 = banco1.buscarConta(numeroConta);
                    if (conta1 != null) {
                        System.out.println("Quanto você deseja depositar?");
                        float valorDeposito = leitor.nextFloat();
                        conta1.depositar(valorDeposito);
                    }
                    break;
                }
                case 5: {
                    System.out.println("Informe o número da conta:");
                    int numeroConta = leitor.nextInt();
                    Conta conta1 = banco1.buscarConta(numeroConta);
                    if (conta1 != null) {
                        System.out.println("Quanto você deseja transferir?");
                        float valorTransferencia = leitor.nextFloat();
                        System.out.println("Informe o número da conta que receberá a transferência:");
                        int numeroConta2 = leitor.nextInt();
                        Conta conta2 = banco1.buscarConta(numeroConta2);
                        if (conta2 != null) {
                            conta1.transferir(conta2, valorTransferencia);
                        }
                    }
                    break;
                }
                case 0:
                    System.out.println("Saindo...\n");
                    break;
                default:
                    System.out.println("Opção inválida!\n");
                    break;
            }
        } while (opcao != 0);

        leitor.close();
    }
}
