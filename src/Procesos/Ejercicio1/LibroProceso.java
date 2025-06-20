package Procesos.Ejercicio1;

import Modelos.Biblioteca.Libro;

import java.util.Random;

public class LibroProceso {
    // Estimación con rango aleatorio de 250–400 palabras por página
    public static int calcularPalabrasEstimadas(Libro libro) {
        Random random = new Random();
        int palabrasPorPagina = 200 + random.nextInt(151); // [250,400]
        return palabrasPorPagina * libro.getPaginas();
    }

    // Sobrecarga con parámetros personalizados
    public static int calcularPalabrasEstimadas(Libro libro, int min, int max) {
        if (min >= max) return -1;
        Random random = new Random();
        int palabrasPorPagina = min + random.nextInt(max - min + 1);
        return palabrasPorPagina * libro.getPaginas();
    }
}
