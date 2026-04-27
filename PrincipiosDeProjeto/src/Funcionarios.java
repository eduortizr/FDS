import java.util.ArrayList;
import java.util.List;

public class Funcionarios {
    private Recepcionista recepcionista;
    private List<Manobrista> manobristas;
    private String turno; // Ex: "06:00-12:00", "12:00-18:00", etc.

    // Construtor para turno com 1 recepcionista e 1 manobrista
    public Funcionarios(Recepcionista recepcionista, Manobrista manobrista, String turno) {
        if (recepcionista == null) {
            throw new IllegalArgumentException("Não podemos ficar sem recepcionista");
        }
        if (manobrista == null) {
            throw new IllegalArgumentException("Deve haver pelo menos um manobrista");
        }

        this.recepcionista = recepcionista;
        this.manobristas = new ArrayList<>();
        this.manobristas.add(manobrista);
        this.turno = turno;
    }

    // Construtor para turno com 1 recepcionista e múltiplos manobristas
    public Funcionarios(Recepcionista recepcionista, List<Manobrista> manobristas, String turno) {
        if (recepcionista == null) {
            throw new IllegalArgumentException("Não podemos ficar sem recepcionista");
        }
        if (manobristas == null || manobristas.isEmpty()) {
            throw new IllegalArgumentException("Deve haver pelo menos um manobrista");
        }

        this.recepcionista = recepcionista;
        this.manobristas = new ArrayList<>(manobristas);
        this.turno = turno;
    }

    // Método legado para compatibilidade (mas agora obsoleto)
    @Deprecated
    public Funcionarios(Recepcionista recepcionista, Manobrista manobrista, Manobrista manobristaExtra) {
        this(recepcionista, manobrista, "06:00-12:00"); // turno padrão
        if (manobristaExtra != null) {
            this.manobristas.add(manobristaExtra);
        }
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public List<Manobrista> getManobristas() {
        return new ArrayList<>(manobristas); // Retorna cópia para evitar modificações externas
    }

    public Manobrista getManobristaPrincipal() {
        return manobristas.isEmpty() ? null : manobristas.get(0);
    }

    public String getTurno() {
        return turno;
    }

    public int getQuantidadeFuncionarios() {
        return 1 + manobristas.size(); // 1 recepcionista + N manobristas
    }

    public int getQuantidadeManobristas() {
        return manobristas.size();
    }

    // Adiciona um manobrista extra durante o turno
    public void adicionarManobrista(Manobrista manobrista) {
        if (manobrista != null) {
            manobristas.add(manobrista);
        }
    }

    // Remove um manobrista (se houver mais de um)
    public boolean removerManobrista(Manobrista manobrista) {
        if (manobristas.size() > 1) {
            return manobristas.remove(manobrista);
        }
        return false; // Não pode remover o último manobrista
    }

    @Override
    public String toString() {
        return "Funcionarios{" +
                "recepcionista=" + recepcionista +
                ", manobristas=" + manobristas +
                ", turno='" + turno + '\'' +
                ", quantidadeTotal=" + getQuantidadeFuncionarios() +
                '}';
    }
}
