package com.aluracursos.conversormonedas.principal;

import com.aluracursos.conversormonedas.calculos.ObtenerTasasYConvertir;
import com.aluracursos.conversormonedas.modelos.DesplegarMenu;
import com.sun.source.tree.ReturnTree;

import java.util.Scanner;

public class MainConversionMonedas {
    public static void main(String[] args) {
        Double cantidad;
        Scanner scanner = new Scanner(System.in);
        ObtenerTasasYConvertir convertir = new ObtenerTasasYConvertir();

                int opcion;
                while (true) {
                    DesplegarMenu.menu();
                    opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.println("Ingresa cantidad en Quetzales: ");
                            cantidad = scanner.nextDouble();
                            System.out.println("Cantidad de Dolares: " + convertir.efectuarCambio("GTQ_USD", cantidad));
                            break;
                        case 2:
                            System.out.println("Ingresa cantidad en Dolares: ");
                            cantidad = scanner.nextDouble();
                            System.out.println("Cantidad de Quetzales: " + convertir.efectuarCambio("USD_GTQ", cantidad));
                            break;
                        case 3:
                            System.out.println("Ingresa cantidad en Pesos: ");
                            cantidad = scanner.nextDouble();
                            System.out.println("Cantidad de Dolares: " + convertir.efectuarCambio("USD_MXN", cantidad));
                            break;
                        case 4:
                            System.out.println("Ingresa cantidad en Dolares: ");
                            cantidad = scanner.nextDouble();
                            System.out.println("Cantidad de Pesos: " + convertir.efectuarCambio("MXN_USD", cantidad));
                            break;
                        case 5:
                            System.out.println("La fecha y hora actuales son: " + new java.util.Date());
                            break;
                        case 6:
                            System.out.println("Saliendo del programa...");
                            scanner.close();
                            return;
                        default:
                            System.out.println("Opción no válida. Por favor, intenta nuevamente.");
                    }
                }
            }
        }
