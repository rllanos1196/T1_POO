package Procesos;

import Procesos.Ejercicio1.AppBiblioteca;
import Procesos.Ejercicio2.AppCalificacion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("===================================");
            System.out.println("  SISTEMAS - EXAMEN FINAL POO JAVA");
            System.out.println("===================================");
            System.out.println("1. Sistema de Biblioteca Digital");
            System.out.println("2. Sistema de Calificaciones en Línea");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar Buffer

            switch (opcion) {
                case 1:
                    AppBiblioteca.iniciarBiblioteca();
                    break;
                case 2:
                    AppCalificacion.iniciarCalificaciones();
                    break;
                case 0:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
