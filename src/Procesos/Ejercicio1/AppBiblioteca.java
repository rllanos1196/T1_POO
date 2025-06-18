package Procesos.Ejercicio1;

import Modelos.Libro;
import Modelos.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppBiblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear libros predefinidos

        // Crear usuario
        Usuario usuario = new Usuario("Carlos");
        usuario.getLibrosDisponibles().addAll(generarLibrosDePrueba());
//        usuario.getLibrosDisponibles().addAll(Arrays.asList(libro1, libro2, libro3));

        int opcion;
        do {
            System.out.println("\n>>>MENU BIBLIOTECA DIGITAL");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Buscar libro por autor");
            System.out.println("3. Buscar en libros favoritos");
            System.out.println("4. Marcar libro como favorito");
            System.out.println("5. Ver estadísticas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // consumir salto de línea

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el título: ");
                    String titulo = scanner.nextLine();
                    List<Libro> resultado = UsuarioProceso.buscarPorTitulo(usuario, titulo);
                    mostrarResultados(resultado);
                }
                case 2 -> {
                    System.out.print("Ingrese el autor: ");
                    String autor = scanner.nextLine();
                    List<Libro> resultado = UsuarioProceso.buscarPorAutor(usuario, autor);
                    mostrarResultados(resultado);
                }
                case 3 -> {
                    System.out.print("Ingrese el título del libro favorito: ");
                    String tituloFav = scanner.nextLine();
                    List<Libro> resultado = new ArrayList<>();
                    for (Libro l : usuario.getLibrosFavoritos()) {
                        if (l.getTitulo().toLowerCase().contains(tituloFav.toLowerCase())) {
                            resultado.add(l);
                        }
                    }
                    mostrarResultados(resultado);
                }
                case 4 -> {
                    System.out.print("Ingrese el título del libro para marcar como favorito: ");
                    String titulo = scanner.nextLine();
                    List<Libro> encontrados = UsuarioProceso.buscarPorTitulo(usuario, titulo);
                    if (!encontrados.isEmpty()) {
                        UsuarioProceso.marcarComoFavorito(usuario, encontrados.get(0));
                        System.out.println("Marcado como favorito: " + encontrados.get(0).getTitulo());
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                }
                case 5 -> {
                    double promedio = BibliotecaProceso.EstadisticaBiblioteca.calcularPromedioPalabras(usuario.getLibrosDisponibles());
                    int totalFavs = BibliotecaProceso.EstadisticaBiblioteca.contarFavoritos(usuario);
                    System.out.println("Promedio de palabras por libro: " + promedio);
                    System.out.println("Total libros favoritos: " + totalFavs);
                }
                case 6 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 6);
    }

    private static void mostrarResultados(List<Libro> lista) {
        if (lista.isEmpty()) {
            System.out.println("No se encontraron resultados.");
        } else {
            System.out.println("Resultados encontrados:");
            for (Libro l : lista) {
                System.out.println("- " + l.getTitulo() + " (" + l.getAutor() + ")");
                int palabras = LibroProceso.calcularPalabrasEstimadas(l);
                System.out.println("  ↪ Palabras estimadas: " + palabras);
            }
        }
    }
    private static List<Libro> generarLibrosDePrueba() {
        List<Libro> libros = new ArrayList<>();

        // Libros conocidos
        libros.add(new Libro("El Principito", "Antoine de Saint-Exupéry", 1943, "978-0156013987", 90));
        libros.add(new Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967, "978-0307474728", 417));
        libros.add(new Libro("Rayuela", "Julio Cortázar", 1963, "978-8437604947", 250));
        libros.add(new Libro("1984", "George Orwell", 1949, "978-0451524935", 328));
        libros.add(new Libro("Fahrenheit 451", "Ray Bradbury", 1953, "978-1451673319", 194));
        libros.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 1605, "978-8491050292", 863));
        libros.add(new Libro("La Odisea", "Homero", -700, "978-0140268867", 541));
        libros.add(new Libro("Crimen y castigo", "Fiódor Dostoyevski", 1866, "978-0140449136", 671));
        libros.add(new Libro("Matar a un ruiseñor", "Harper Lee", 1960, "978-0061120084", 336));
        libros.add(new Libro("Orgullo y prejuicio", "Jane Austen", 1813, "978-1503290563", 432));

        // Libros simulados del 11 al 50
        for (int i = 11; i <= 50; i++) {
            libros.add(new Libro(
                    "Libro " + i,
                    "Autor " + i,
                    2000 + (i % 20),
                    "ISBN-" + i,
                    100 + (i * 2)
            ));
        }

        return libros;
    }
}
