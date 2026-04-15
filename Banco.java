import java.util.ArrayList;
import Conta.Conta;

public class Banco {
    private String agencia;
    private String nome;
    private ArrayList<Conta> contas;

    public Banco(String agencia, String nome) {
        this.agencia = agencia;
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void cadastrarConta(Conta conta){
        this.contas.add(conta);
        System.out.println("Conta cadastrada com sucesso!");
        System.out.println("O número da sua conta é: " + conta.getNumeroConta() + "\n");
    }
    public Conta buscarConta(String numeroConta){
        for(int i = 0; i < contas.size(); i++){
            if(numeroConta.equals(contas.get(i).getNumeroConta())){
                return contas.get(i);
            }
        }
        System.out.println("Conta não encontrada!");
        return null;
    }
}
