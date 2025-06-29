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
                                             5. Real Brasileño a Dolares
                                             6. Dolares a Real Brasileño
                                             7. La fecha y hora actuales
                8. SALIR DEL SISTEMA
                """);
        System.out.println("==============================================================================================");
    }
    public static void limpiarPantalla() {
        // Imprime 50 líneas vacías para "empujar" el contenido anterior hacia arriba
        System.out.print("\033[H\033[2J");
        System.out.flush();  // A veces ayuda a que el código ANSI surta efecto en algunas consolas
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }
}
