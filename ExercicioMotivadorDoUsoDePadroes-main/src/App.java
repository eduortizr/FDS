public class App {
    public static void main(String[] args) throws Exception {

        // 1. Esportivo: gasolina, 6 Km/litro, tanque 45 litros
        Carro esportivo = new Carro("Esportivo", TipoCombustivel.GASOLINA, TipoTanque.MONOCOMBUSTIVEL, 6, 45);

        // 2. Utilitario: diesel, 5 Km/litro, tanque 70 litros
        Carro utilitario = new Carro("Utilitario", TipoCombustivel.DIESEL, TipoTanque.MONOCOMBUSTIVEL, 5, 70);

        // 3. SUV: motor gasolina 8 Km/litro, tanque 55 litros FLEX
        Carro suv = new Carro("SUV", TipoCombustivel.GASOLINA, TipoTanque.FLEX, 8, 55);

        // 4. SUVFlex: motor FLEX (8 Km/l gasolina, 6 Km/l álcool), tanque 65 litros FLEX
        Carro suvFlex = new Carro("SUVFlex", new MotorFlex(8, 6), TipoTanque.FLEX, 65);

        // 5. Econo: gasolina, tanque 55 litros, consumo econômico (20 Km/l inicial, reduz 1 a cada 5000 Km, mín 10 Km/l)
        Carro econo = new Carro("Econo", new MotorEcono(), TipoTanque.MONOCOMBUSTIVEL, 55);

        // 0. Basico para referência: gasolina, 10 Km/litro, tanque 55 litros
        Carro basico = new Carro("Basico", TipoCombustivel.GASOLINA, TipoTanque.MONOCOMBUSTIVEL, 10, 55);

        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║           MODELOS DE CARROS - TESTES INICIAIS             ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");

        exibirModelo(basico);
        exibirModelo(esportivo);
        exibirModelo(utilitario);
        exibirModelo(suv);
        exibirModelo(suvFlex);
        exibirModelo(econo);

        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║              TESTES DE ABASTECIMENTO E VIAGEM             ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");

        testarCarro(basico, TipoCombustivel.GASOLINA, 55);
        testarCarro(esportivo, TipoCombustivel.GASOLINA, 45);
        testarCarro(utilitario, TipoCombustivel.DIESEL, 70);
        testarCarro(suv, TipoCombustivel.GASOLINA, 55);
        testarCarroFlex(suvFlex);
        testarCarroEcono(econo);
    }

    private static void exibirModelo(Carro carro) {
        System.out.println("─ " + carro.getModelo());
        System.out.println(carro);
        System.out.println();
    }

    private static void testarCarro(Carro carro, TipoCombustivel combustivel, int quantidade) {
        System.out.println("═ TESTANDO: " + carro.getModelo() + " ═");
        System.out.println("Abastecendo com " + combustivel + ": " + quantidade + "L");
        carro.abastece(combustivel, quantidade);
        System.out.println(carro);

        System.out.println("\nViajando 300 Km...");
        if (carro.viaja(300)) {
            System.out.println("✓ Viagem realizada com sucesso!");
        } else {
            System.out.println("✗ Combustível insuficiente!");
        }
        System.out.println(carro);
        System.out.println();
    }

    private static void testarCarroFlex(Carro carro) {
        System.out.println("═ TESTANDO: " + carro.getModelo() + " (FLEX) ═");

        // Teste com gasolina
        System.out.println("\n--- Abastecendo com GASOLINA: 65L");
        carro.abastece(TipoCombustivel.GASOLINA, 65);
        System.out.println(carro);

        System.out.println("\nViajando 400 Km com gasolina...");
        if (carro.viaja(400)) {
            System.out.println("✓ Viagem realizada com sucesso!");
        } else {
            System.out.println("✗ Combustível insuficiente!");
        }
        System.out.println(carro);

        // Teste com álcool
        System.out.println("\n--- Abastecendo com ÁLCOOL: 50L");
        carro.abastece(TipoCombustivel.ALCOOL, 50);
        System.out.println(carro);

        System.out.println("\nViajando 250 Km com álcool...");
        if (carro.viaja(250)) {
            System.out.println("✓ Viagem realizada com sucesso!");
        } else {
            System.out.println("✗ Combustível insuficiente!");
        }
        System.out.println(carro);
        System.out.println();
    }

    private static void testarCarroEcono(Carro carro) {
        System.out.println("═ TESTANDO: " + carro.getModelo() + " (ECONÔMICO) ═");
        System.out.println("Abastecendo com GASOLINA: 55L");
        carro.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(carro);

        // Primeira viagem - consumo inicial 20 Km/l
        System.out.println("\n--- Viagem 1: 100 Km (consumo 20 Km/l)");
        if (carro.viaja(100)) {
            System.out.println("✓ Viagem realizada!");
        }
        System.out.println(carro);

        // Segunda viagem - após 5000 Km de uso, consumo reduz
        System.out.println("\n--- Viagem 2: 5100 Km (passa do limite de redução)");
        if (carro.viaja(5100)) {
            System.out.println("✓ Viagem realizada!");
        }
        System.out.println(carro);

        // Terceira viagem - consumo mínimo
        System.out.println("\n--- Viagem 3: 50 Km (consumo estabilizado em 10 Km/l)");
        if (carro.viaja(50)) {
            System.out.println("✓ Viagem realizada!");
        }
        System.out.println(carro);
        System.out.println();
    }
}
