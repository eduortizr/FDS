import java.time.LocalDateTime;

public class TesteCobranca {
    public static void main(String[] args) {
        // Exemplo 1: 1 hora e 4 minutos (dentro da tolerância)
        LocalDateTime entrada1 = LocalDateTime.of(2023, 10, 1, 10, 0);
        LocalDateTime saida1 = LocalDateTime.of(2023, 10, 1, 11, 4);
        Cobranca cobranca1 = new Cobranca(entrada1);
        cobranca1.registrarSaida(saida1);
        System.out.println("Exemplo 1: " + cobranca1);
        System.out.println("Valor: R$ " + cobranca1.calcularValorTotal());

        // Exemplo 2: 1 hora e 6 minutos (excede tolerância)
        LocalDateTime entrada2 = LocalDateTime.of(2023, 10, 1, 10, 0);
        LocalDateTime saida2 = LocalDateTime.of(2023, 10, 1, 11, 6);
        Cobranca cobranca2 = new Cobranca(entrada2);
        cobranca2.registrarSaida(saida2);
        System.out.println("\nExemplo 2: " + cobranca2);
        System.out.println("Valor: R$ " + cobranca2.calcularValorTotal());

        // Exemplo 3: 2 horas e 30 minutos
        LocalDateTime entrada3 = LocalDateTime.of(2023, 10, 1, 10, 0);
        LocalDateTime saida3 = LocalDateTime.of(2023, 10, 1, 12, 30);
        Cobranca cobranca3 = new Cobranca(entrada3);
        cobranca3.registrarSaida(saida3);
        System.out.println("\nExemplo 3: " + cobranca3);
        System.out.println("Valor: R$ " + cobranca3.calcularValorTotal());

        // Teste de pagamento
        System.out.println("\nTeste de pagamento:");
        boolean pago = cobranca3.processarPagamento("dinheiro", 50.0);
        System.out.println("Pagamento realizado: " + pago);
    }
}