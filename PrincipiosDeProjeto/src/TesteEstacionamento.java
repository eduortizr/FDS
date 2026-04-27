import java.util.concurrent.TimeUnit;

public class TesteEstacionamento {
    public static void main(String[] args) throws InterruptedException {
        Estacionamento estacionamento = new Estacionamento();

        System.out.println("=== TESTE DO ESTACIONAMENTO ===");
        System.out.println(estacionamento);
        System.out.println();

        // Entrada de veículos
        System.out.println("--- Registrando entradas ---");
        estacionamento.registrarEntrada("ABC-1234");
        estacionamento.registrarEntrada("XYZ-5678");
        estacionamento.registrarEntrada("DEF-9999");

        System.out.println("\n" + estacionamento);
        estacionamento.listarVeiculosEstacionados();
        System.out.println();

        // Simula tempo de permanência
        System.out.println("--- Aguardando 2 segundos (simulando tempo de permanência) ---");
        TimeUnit.SECONDS.sleep(2);

        // Saída e cobrança
        System.out.println("--- Registrando saídas ---");
        double valor1 = estacionamento.registrarSaida("ABC-1234");
        if (valor1 >= 0) {
            estacionamento.processarPagamento("ABC-1234", "dinheiro", valor1);
        }

        System.out.println("\n" + estacionamento);
        estacionamento.listarVeiculosEstacionados();
        System.out.println();

        // Tentativa de saída de veículo não existente
        System.out.println("--- Tentativa de saída de veículo não existente ---");
        estacionamento.registrarSaida("INVALIDO-0000");

        // Entrada de mais um veículo
        estacionamento.registrarEntrada("GHI-1111");
        System.out.println("\n" + estacionamento);
    }
}