import java.text.DecimalFormat;

public class MainConversionMonedas {
    public static void main(String[] args) {
        ConsultaTiposDeCambio consulta = new ConsultaTiposDeCambio();
        RespuestaAPI respuesta = consulta.consultaRespuestaCompleta();


        System.out.println("Ultima Actualización: " + respuesta.time_last_update_utc());
        System.out.println("USD: " + respuesta.conversion_rates().USD());
        System.out.println("GTQ: " + respuesta.conversion_rates().GTQ());
        System.out.println("EUR: " + respuesta.conversion_rates().EUR());


        Double cantidadDolares = 100.00;
        Double totalQuetzales = respuesta.conversion_rates().GTQ() * cantidadDolares;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        System.out.println("Total de $100.00 a Quetzales: " + decimalFormat.format(totalQuetzales));
    }
}

