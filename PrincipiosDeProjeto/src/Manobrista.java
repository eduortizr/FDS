public class Manobrista {
    private String nome;

    public Manobrista(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Manobrista{nome='" + nome + "'}";
    }
}
