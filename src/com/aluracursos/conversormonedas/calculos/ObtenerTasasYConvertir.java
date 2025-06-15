package com.aluracursos.conversormonedas.calculos;

import com.aluracursos.conversormonedas.modelos.ConsultaTiposDeCambio;
import com.aluracursos.conversormonedas.modelos.RespuestaAPI;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class ObtenerTasasYConvertir {

    public BigDecimal efectuarCambio(String tasaDeCambio, Double cantidad) {
        ConsultaTiposDeCambio consulta = new ConsultaTiposDeCambio();
        RespuestaAPI respuesta = consulta.consultaRespuestaCompleta();
        HashMap<String, Double> tasasDeCambio;
        tasasDeCambio = new HashMap<>();
        tasasDeCambio.put("GTQ_USD", respuesta.conversion_rates().GTQ());
        tasasDeCambio.put("EUR_USD", respuesta.conversion_rates().EUR());
        tasasDeCambio.put("MXN_USD", respuesta.conversion_rates().MXN());
        tasasDeCambio.put("USD_GTQ", (1 / tasasDeCambio.get("GTQ_USD")));
        tasasDeCambio.put("USD_EUR", (1 / tasasDeCambio.get("EUR_USD")));
        tasasDeCambio.put("USD_MXN", (1 / tasasDeCambio.get("MXN_USD")));

        BigDecimal tasaGTQtoUSD = BigDecimal.valueOf(tasasDeCambio.get(tasaDeCambio)); // Invertir la tasa
        BigDecimal cantidadGTQ = BigDecimal.valueOf(cantidad);

        BigDecimal resultado = cantidadGTQ.multiply(tasaGTQtoUSD);
        resultado = resultado.setScale(2, RoundingMode.HALF_UP); // Aproximar a 2 decimales

        return resultado;

    }
}




















//
//        BigDecimal tasaGTQtoUSD = BigDecimal.valueOf(tasasDeCambio.get("USD_GTQ")); // Invertir la tasa
//        BigDecimal cantidadGTQ = BigDecimal.valueOf(100);
//
//        BigDecimal resultado = cantidadGTQ.multiply(tasaGTQtoUSD);
//        resultado = resultado.setScale(2, RoundingMode.HALF_UP); // Aproximar a 2 decimales
//
//        System.out.println("Resultado del cambio: " + resultado);

//        System.out.println("Tasa de Quetzales a Dolares: " + (tasasDeCambio.get("GTQ_USD")));
//        System.out.println("Tasa de Dolares a Quetzales: " + (tasasDeCambio.get("USD_GTQ")));
//



