public class Titular {
    private String nomeCompleto;
    private String cpf;
    private String telefone;

    public Titular(String nomeCompleto, String cpf, String telefone) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.telefone = telefone;
    }
    public String getNomeCompleto() {
        return this.nomeCompleto;
    }
}
