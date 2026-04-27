public class Carro {

    private String modelo;
    private Motor motor;
    private TanqueCombustivel tanque;

    public Carro(String modelo, TipoCombustivel tipoCombustivel, TipoTanque tipoTanque, int consumoMotor, int capacidadeTanque) {
        this.modelo = modelo;
        motor = new Motor(tipoCombustivel, consumoMotor);
        tanque = new TanqueCombustivel(tipoTanque == TipoTanque.FLEX ? TipoCombustivel.FLEX : tipoCombustivel, capacidadeTanque);
    }

    // Construtor que aceita um Motor customizado (para MotorFlex, MotorEcono, etc)
    public Carro(String modelo, Motor motor, TipoTanque tipoTanque, int capacidadeTanque) {
        this.modelo = modelo;
        this.motor = motor;
        TipoCombustivel tipoCombustivel = motor.getTipoMotor();
        tanque = new TanqueCombustivel(tipoTanque == TipoTanque.FLEX ? TipoCombustivel.FLEX : tipoCombustivel, capacidadeTanque);
    }

    public String getModelo() {
        return modelo;
    }

    public int getCombustivelDisponivel() {
        return tanque.getCombustivelDisponivel();
    }

    // Retorna a quantidade efetivamente abastecida
    public int abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        int capacidadeLivre = tanque.getCapacidade() - tanque.getCombustivelDisponivel();
        if (capacidadeLivre < quantidade) {
            tanque.abastece(tipoCombustivel, capacidadeLivre);
            return capacidadeLivre;
        } else {
            tanque.abastece(tipoCombustivel, quantidade);
            return quantidade;
        }
    }

    // Retorna a distancia que consegue viajar com o combustivel remanescente
    public int verificaSePodeViajar(int distancia) {
        int combustivelNecessario = getCombustivelNecessario(distancia);
        if (tanque.getCombustivelDisponivel() >= combustivelNecessario) {
            return distancia;
        } else {
            return tanque.getCombustivelDisponivel() * motor.getConsumo();
        }
    }

    // Método auxiliar para calcular combustível necessário
    // Para motores FLEX, considera o tipo de combustível atual do tanque
    private int getCombustivelNecessario(int distancia) {
        if (motor instanceof MotorFlex) {
            MotorFlex motorFlex = (MotorFlex) motor;
            return motorFlex.combustivelNecessario(distancia, tanque.getTipoCombustvelAtual());
        } else {
            return motor.combustivelNecessario(distancia);
        }
    }

    // Retorna true se conseguiu viajar
    public boolean viaja(int distancia) {
        if (verificaSePodeViajar(distancia) >= distancia) {
            motor.percorre(distancia);
            tanque.gasta(getCombustivelNecessario(distancia));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Carro:\n  Modelo=" + modelo + "\n  Motor=" + motor + "\n  Tanque=" + tanque;
    }
}
