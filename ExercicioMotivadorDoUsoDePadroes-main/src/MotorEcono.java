public class MotorEcono extends Motor {

    private static final int CONSUMO_INICIAL = 20;
    private static final int CONSUMO_MINIMO = 10;
    private static final int KM_POR_REDUCAO = 5000;

    public MotorEcono() {
        super(TipoCombustivel.GASOLINA, CONSUMO_INICIAL);
    }

    @Override
    public int combustivelNecessario(int distancia) {
        int consumoAtual = getConsumoAtual();
        return distancia / consumoAtual;
    }

    private int getConsumoAtual() {
        int quilometragem = getQuilometragem();
        int reducoes = quilometragem / KM_POR_REDUCAO;
        int consumoAtual = CONSUMO_INICIAL - reducoes;
        
        if (consumoAtual < CONSUMO_MINIMO) {
            consumoAtual = CONSUMO_MINIMO;
        }
        
        return consumoAtual;
    }

    @Override
    public String toString() {
        int consumoAtual = getConsumoAtual();
        return "MotorEcono [consumoAtual=" + consumoAtual + ", quilometragem=" + getQuilometragem() + "]";
    }
}
