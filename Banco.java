import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas =  new ArrayList<>();

    public Banco() {
        this.contas = new ArrayList<>();
    }
    public void cadastrarConta(Conta conta1){
        this.contas.add(conta1);
        System.out.println("Conta cadastrada com sucesso!");
        System.out.println("O número da sua conta é: " + conta1.getNumeroConta() + "\n");
    }
    public Conta buscarConta(int numeroConta){
        for(int i = 0; i < contas.size(); i++){
            if(numeroConta == contas.get(i).getNumeroConta()){
                return contas.get(i);
            }
        }
        return null;
    }
}
