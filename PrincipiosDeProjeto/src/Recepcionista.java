public class Recepcionista {
    private String nome;

    public Recepcionista(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Recepcionista{nome='" + nome + "'}";
    }
}
