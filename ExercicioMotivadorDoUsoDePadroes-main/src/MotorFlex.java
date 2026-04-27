public class MotorFlex extends Motor {

    private int consumoGasolina;
    private int consumoAlcool;

    public MotorFlex(int consumoGasolina, int consumoAlcool) {
        super(TipoCombustivel.FLEX, consumoGasolina); // consumo padrão é gasolina
        this.consumoGasolina = consumoGasolina;
        this.consumoAlcool = consumoAlcool;
    }

    @Override
    public int combustivelNecessario(int distancia, TipoCombustivel tipoCombustivel) {
        if (tipoCombustivel == TipoCombustivel.ALCOOL) {
            return distancia / consumoAlcool;
        } else {
            return distancia / consumoGasolina;
        }
    }

    @Override
    public int combustivelNecessario(int distancia) {
        // Usa consumo de gasolina por padrão
        return distancia / consumoGasolina;
    }

    @Override
    public String toString() {
        return "MotorFlex [consumoGasolina=" + consumoGasolina + ", consumoAlcool=" + consumoAlcool
                + ", quilometragem=" + getQuilometragem() + "]";
    }
}
