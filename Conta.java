public class Conta {
    private static int geradorNumeroConta = 1000;
    private Titular titular;
    private float saldo;
    private int numeroConta;

    public Conta(Titular titular, float saldo) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroConta = geradorNumeroConta++;
    }
    public int getNumeroConta() {
        return numeroConta;
    }
    public void exibirExtrato(){
        System.out.println("Número da conta:");
        System.out.println(this.numeroConta);
        System.out.println("Nome completo do títular:");
        System.out.println(this.titular.getNomeCompleto());
        System.out.println("Saldo da conta:");
        System.out.println("R$ " + this.saldo + "\n");
    }
    public float sacar(float valorSaque){
        if(this.saldo >= valorSaque && valorSaque > 0){
            this.saldo = this.saldo - valorSaque;
            System.out.println("Saque realizado!\n");
            return this.saldo;
        }
        System.out.println("Saque inválido!\n");
        return this.saldo;
    }
    public float depositar(float valorDeposito){
        if (valorDeposito > 0){
            this.saldo += valorDeposito;
            System.out.println("Depósito realizado!\n");
            return this.saldo;
        }
        System.out.println("Depósito inválido!\n");
        return this.saldo;
    }
    public void transferir(Conta conta2, float valorTransferencia){
        if(this.saldo >= valorTransferencia && valorTransferencia > 0){
            this.sacar(valorTransferencia);
            conta2.depositar(valorTransferencia);
            System.out.println("Transferência realizada!\n");
        }
        else{
            System.out.println("Transferência inválida!\n");
        }
    }
}
