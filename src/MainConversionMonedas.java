public class MainConversionMonedas {
    public static void main(String[] args) {
        ConsultaTiposDeCambio consulta = new ConsultaTiposDeCambio();
        TiposDeCambio tipos = consulta.consultaTipos();

        System.out.println("USD: " + tipos.USD());
        System.out.println("GTQ: " + tipos.GTQ());
        System.out.println("EUR: " + tipos.EUR());
    }
}

