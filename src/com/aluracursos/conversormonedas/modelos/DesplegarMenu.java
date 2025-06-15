package com.aluracursos.conversormonedas.modelos;

public class DesplegarMenu {

    public static void menu() {
        ConsultaTiposDeCambio consulta = new ConsultaTiposDeCambio();
        RespuestaAPI respuesta = consulta.consultaRespuestaCompleta();

        System.out.println();
        System.out.println("==============================================================================================");
        System.out.println("                                     BIENVENIDO(A)");
        System.out.println("                              === CONVERSOR DE MONEDAS ===          ");
        System.out.println("  >>>>>>>   ULTIMA ACTUALIZACION TASAS DE CAMBIO: " + respuesta.time_last_update_utc()+ "   <<<<<<<");
        System.out.println("""
                OPCIONES:
                                             1. Quetzales a Dolares
                                             2. Dolares a Quetzales
                                             3. Pesos a Dolares N/A
                                             4. Dolares a Pesos N/A
                                             5. La fecha y hora actuales
                6. SALIR DEL SISTEMA
                """);
        System.out.println("==============================================================================================");
    }
}
