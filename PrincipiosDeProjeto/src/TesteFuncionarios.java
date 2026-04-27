import java.util.Arrays;

public class TesteFuncionarios {
    public static void main(String[] args) {
        System.out.println("=== TESTE DA CLASSE FUNCIONARIOS ===\n");

        // Criando funcionários
        Recepcionista recepcionista = new Recepcionista("Maria Silva");
        Manobrista manobrista1 = new Manobrista("João Santos");
        Manobrista manobrista2 = new Manobrista("Pedro Oliveira");

        // Teste 1: Turno com 1 recepcionista e 1 manobrista
        System.out.println("--- Teste 1: Turno básico ---");
        Funcionarios turnoBasico = new Funcionarios(recepcionista, manobrista1, "06:00-12:00");
        System.out.println(turnoBasico);
        System.out.println("Quantidade total: " + turnoBasico.getQuantidadeFuncionarios());
        System.out.println("Quantidade manobristas: " + turnoBasico.getQuantidadeManobristas());
        System.out.println();

        // Teste 2: Turno com múltiplos manobristas
        System.out.println("--- Teste 2: Turno com múltiplos manobristas ---");
        Funcionarios turnoMultiplo = new Funcionarios(recepcionista, Arrays.asList(manobrista1, manobrista2), "12:00-18:00");
        System.out.println(turnoMultiplo);
        System.out.println("Quantidade total: " + turnoMultiplo.getQuantidadeFuncionarios());
        System.out.println("Quantidade manobristas: " + turnoMultiplo.getQuantidadeManobristas());
        System.out.println();

        // Teste 3: Adicionando manobrista extra
        System.out.println("--- Teste 3: Adicionando manobrista extra ---");
        Manobrista manobrista3 = new Manobrista("Carlos Mendes");
        turnoBasico.adicionarManobrista(manobrista3);
        System.out.println("Após adicionar manobrista:");
        System.out.println(turnoBasico);
        System.out.println("Quantidade total: " + turnoBasico.getQuantidadeFuncionarios());
        System.out.println();

        // Teste 4: Tentativa de remover manobrista (deve falhar se deixar apenas um)
        System.out.println("--- Teste 4: Tentativa de remover manobrista ---");
        boolean removido = turnoBasico.removerManobrista(manobrista1);
        System.out.println("Remoção do manobrista principal: " + (removido ? "Sucesso" : "Falhou"));
        System.out.println(turnoBasico);
        System.out.println();

        // Teste 5: Validação de construtor (erro esperado)
        System.out.println("--- Teste 5: Validação de construtor ---");
        try {
            Funcionarios turnoInvalido = new Funcionarios(null, manobrista1, "18:00-24:00");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        try {
            Funcionarios turnoInvalido2 = new Funcionarios(recepcionista, Arrays.asList(), "18:00-24:00");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}