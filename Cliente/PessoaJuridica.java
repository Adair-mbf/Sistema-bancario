package Cliente;
public class PessoaJuridica extends Titular{
    private String cnpj;

    public PessoaJuridica(String nome, String telefone, String cnpj) {
        super(nome, telefone, "PJ");
        this.cnpj = cnpj;
    }
    public String getCnpj() {
        return cnpj;
    }
}
