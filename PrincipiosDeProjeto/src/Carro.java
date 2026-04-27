import java.time.LocalDateTime;

public class Carro {
    private String placa;
    private LocalDateTime entrada;
    private Cobranca cobranca;

    public Carro(String placa) {
        this.placa = placa;
        this.entrada = LocalDateTime.now();
        this.cobranca = new Cobranca(entrada);
    }

    public String getPlaca() {
        return placa;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public Cobranca getCobranca() {
        return cobranca;
    }

    @Override
    public String toString() {
        return "Carro{placa='" + placa + "', entrada=" + entrada + '}';
    }
}