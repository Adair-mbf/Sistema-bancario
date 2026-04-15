package Cliente;
public class PessoaFisica extends Titular{
    private String cpf;

    public PessoaFisica(String nome, String telefone, String cpf) {
        super(nome, telefone, "PF");
        this.cpf = cpf;
    }
    public String getCpf() {
        return cpf;
    }
    
}
