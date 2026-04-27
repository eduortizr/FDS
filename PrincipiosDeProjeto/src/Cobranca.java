import java.time.Duration;
import java.time.LocalDateTime;

public class Cobranca {
    private static final int VALOR_POR_HORA = 10; // Valor fixo por hora
    private static final int TOLERANCIA_MINUTOS = 5; // Tolerância de 5 minutos

    private LocalDateTime entrada;
    private LocalDateTime saida;

    public Cobranca(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public void registrarSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    // Calcula o número de horas cheias com tolerância
    public int calcularHorasCheias() {
        if (saida == null) {
            throw new IllegalStateException("Saída não registrada");
        }

        Duration duracao = Duration.between(entrada, saida);
        long minutosTotais = duracao.toMinutes();

        // Calcula horas cheias
        int horas = (int) (minutosTotais / 60);

        // Verifica se há minutos excedentes além da tolerância
        int minutosExcedentes = (int) (minutosTotais % 60);
        if (minutosExcedentes > TOLERANCIA_MINUTOS) {
            horas += 1;
        }

        // Mínimo de 1 hora se ficou pelo menos 1 minuto
        return Math.max(1, horas);
    }

    // Calcula o valor total a ser cobrado
    public double calcularValorTotal() {
        int horas = calcularHorasCheias();
        return horas * VALOR_POR_HORA;
    }

    // Processa o pagamento
    public boolean processarPagamento(String metodoPagamento, double valorPago) {
        double valorDevido = calcularValorTotal();

        if (valorPago < valorDevido) {
            return false; // Pagamento insuficiente
        }

        // Aqui seria implementada a lógica específica para cada método
        switch (metodoPagamento.toLowerCase()) {
            case "dinheiro":
                // Lógica para pagamento em dinheiro
                System.out.println("Pagamento em dinheiro processado. Troco: " + (valorPago - valorDevido));
                break;
            case "pix":
                // Lógica para PIX
                System.out.println("Pagamento via PIX processado.");
                break;
            case "cartao":
                // Lógica para cartão
                System.out.println("Pagamento via cartão processado.");
                break;
            default:
                System.out.println("Método de pagamento inválido.");
                return false;
        }

        return true;
    }

    // Getters para informações
    public LocalDateTime getEntrada() {
        return entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    @Override
    public String toString() {
        return "Cobranca{" +
                "entrada=" + entrada +
                ", saida=" + saida +
                ", horasCheias=" + (saida != null ? calcularHorasCheias() : "N/A") +
                ", valorTotal=" + (saida != null ? calcularValorTotal() : "N/A") +
                '}';
    }
}
