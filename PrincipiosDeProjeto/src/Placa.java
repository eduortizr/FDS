public class Placa {
    private String placa;

    public Placa(String placa) {
        this.placa = placa;
    }

        public static boolean validar(String placa) {
        if (placa == null) {
            return false;
        } else if (placa.matches("^[A-Z]{3}-\\d{4}$")) {
            return true;
        } else {
            return false;
        }
    }

}