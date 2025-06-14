import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.HashMap;

public class MainConversionMonedas {
    public static void main(String[] args) {
        ConsultaTiposDeCambio consulta = new ConsultaTiposDeCambio();
        RespuestaAPI respuesta = consulta.consultaRespuestaCompleta();


        System.out.println("Ultima Actualización: " + respuesta.time_last_update_utc());
        System.out.println("USD: " + respuesta.conversion_rates().USD());
        System.out.println("GTQ: " + respuesta.conversion_rates().GTQ());
        System.out.println("EUR: " + respuesta.conversion_rates().EUR());
        System.out.println("MXN: " + respuesta.conversion_rates().MXN());


        Double cantidadDolares = 100.00;
        Double totalQuetzales = respuesta.conversion_rates().GTQ() * cantidadDolares;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        System.out.println("Total de $100.00 a Quetzales: " + decimalFormat.format(totalQuetzales));

        HashMap<String, Double> tasasDeCambio;

        tasasDeCambio = new HashMap<>();
        tasasDeCambio.put("GTQ_USD", respuesta.conversion_rates().GTQ());
        tasasDeCambio.put("EUR_USD", respuesta.conversion_rates().EUR());
        tasasDeCambio.put("MXN_USD", respuesta.conversion_rates().MXN());
        tasasDeCambio.put("USD_GTQ", (1/tasasDeCambio.get("GTQ_USD")));
        tasasDeCambio.put("USD_EUR", (1/tasasDeCambio.get("EUR_USD")));
        tasasDeCambio.put("USD_MXN", (1/tasasDeCambio.get("MXN_USD")));


        System.out.println("Quetzales a Dolares: " + (tasasDeCambio.get("GTQ_USD")));
        System.out.println("Dolares a Quetzales: " + (tasasDeCambio.get("USD_GTQ")));

        //BigDecimal tasaGTQtoUSD = BigDecimal.valueOf(1.00 / 7.6767); // Invertir la tasa
        BigDecimal tasaGTQtoUSD = BigDecimal.valueOf(tasasDeCambio.get("USD_GTQ")); // Invertir la tasa
        BigDecimal cantidadGTQ = BigDecimal.valueOf(122.15);

        BigDecimal resultado = cantidadGTQ.multiply(tasaGTQtoUSD);
        resultado = resultado.setScale(2, RoundingMode.HALF_UP); // Aproximar a 2 decimales

        System.out.println("100 GTQ a USD: " + resultado);

        BigDecimal tasasinhash = BigDecimal.valueOf(1.00 / 7.6767);

        System.out.println("sin hashMap: " + tasasinhash);
        System.out.println("hashmap:     " + tasaGTQtoUSD);;


    }
}

