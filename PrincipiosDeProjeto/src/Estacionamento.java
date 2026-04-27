import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Estacionamento {
    private static final int CAPACIDADE_MAXIMA = 100;
    private Map<String, Carro> carrosEstacionados;
    private int vagasOcupadas;

    public Estacionamento() {
        this.carrosEstacionados = new HashMap<>();
        this.vagasOcupadas = 0;
    }

    // Registra entrada de um veículo
    public boolean registrarEntrada(String placa) {
        if (vagasOcupadas >= CAPACIDADE_MAXIMA) {
            System.out.println("Estacionamento lotado! Não há vagas disponíveis.");
            return false;
        }

        if (carrosEstacionados.containsKey(placa)) {
            System.out.println("Veículo com placa " + placa + " já está estacionado.");
            return false;
        }

        Carro carro = new Carro(placa);
        carrosEstacionados.put(placa, carro);
        vagasOcupadas++;
        System.out.println("Veículo " + placa + " entrou no estacionamento.");
        return true;
    }

    // Registra saída de um veículo e calcula cobrança
    public double registrarSaida(String placa) {
        Carro carro = carrosEstacionados.get(placa);

        if (carro == null) {
            System.out.println("Veículo com placa " + placa + " não encontrado no estacionamento.");
            return -1; // Indica erro
        }

        // Registra saída na cobrança
        carro.getCobranca().registrarSaida(LocalDateTime.now());

        // Calcula valor
        double valor = carro.getCobranca().calcularValorTotal();

        // Remove veículo do estacionamento
        carrosEstacionados.remove(placa);
        vagasOcupadas--;

        System.out.println("Veículo " + placa + " saiu do estacionamento.");
        System.out.println("Valor a pagar: R$ " + valor);

        return valor;
    }

    // Processa pagamento
    public boolean processarPagamento(String placa, String metodoPagamento, double valorPago) {
        Carro carro = carrosEstacionados.get(placa);

        if (carro == null) {
            System.out.println("Veículo com placa " + placa + " não encontrado.");
            return false;
        }

        return carro.getCobranca().processarPagamento(metodoPagamento, valorPago);
    }

    // Consulta informações de um veículo
    public Carro consultarVeiculo(String placa) {
        return carrosEstacionados.get(placa);
    }

    // Retorna número de vagas disponíveis
    public int getVagasDisponiveis() {
        return CAPACIDADE_MAXIMA - vagasOcupadas;
    }

    // Retorna número de vagas ocupadas
    public int getVagasOcupadas() {
        return vagasOcupadas;
    }

    // Lista todos os veículos estacionados
    public void listarVeiculosEstacionados() {
        if (carrosEstacionados.isEmpty()) {
            System.out.println("Nenhum veículo estacionado.");
            return;
        }

        System.out.println("Veículos estacionados:");
        for (Carro carro : carrosEstacionados.values()) {
            System.out.println("- " + carro);
        }
    }

    @Override
    public String toString() {
        return "Estacionamento{" +
                "capacidade=" + CAPACIDADE_MAXIMA +
                ", vagasOcupadas=" + vagasOcupadas +
                ", vagasDisponiveis=" + getVagasDisponiveis() +
                '}';
    }
}
