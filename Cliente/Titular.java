package Cliente;
public abstract class Titular {
    private String nome;
    private String telefone;
    private String id;
    private static int geradorId = 1000;

    public Titular(String nome, String telefone, String posfixo) {
        this.nome = nome;
        this.telefone = telefone;
        this.id = geradorId++ + "-" + posfixo;
    }
    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }
}
