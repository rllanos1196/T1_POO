package Procesos.Ejercicio1;

import Modelos.Biblioteca;
import Modelos.Libro;
import Modelos.Revista;
import Modelos.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppBiblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear biblioteca general con libros y revistas cargados
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.getLibros().addAll(generarLibrosDePrueba());
        biblioteca.getRevistas().addAll(generarRevistasDePrueba());
        mostrarPublicacionesDisponibles(biblioteca);

        // Crear usuario (sin publicaciones asignadas)
        Usuario usuario = new Usuario("Carlos");

        int opcion;
        do {
            System.out.println("\n>>> MENÚ BIBLIOTECA DIGITAL");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Buscar libro por autor");
            System.out.println("3. Ver libros favoritos");
            System.out.println("4. Marcar libro como favorito");
            System.out.println("5. Registrar nueva publicación");
            System.out.println("6. Ver estadísticas");
            System.out.println("7. Buscar revista por título");
            System.out.println("8. Buscar revista por autor");
            System.out.println("9. Ver revistas favoritas");
            System.out.println("10. Marcar revista como favorita");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt(); scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    List<Libro> encontrados = UsuarioProceso.buscarPorTitulo(biblioteca, titulo);
                    mostrarResultados(encontrados);
                }
                case 2 -> {
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    List<Libro> encontrados = UsuarioProceso.buscarPorAutor(biblioteca, autor);
                    mostrarResultados(encontrados);
                }
                case 3 -> {
                    System.out.println("Libros favoritos:");
                    mostrarResultados(usuario.getLibrosFavoritos());
                }
                case 4 -> {
                    System.out.print("Ingrese el título del libro para marcar como favorito: ");
                    String tituloFav = scanner.nextLine();
                    List<Libro> encontrados = UsuarioProceso.buscarPorTitulo(biblioteca, tituloFav);
                    if (!encontrados.isEmpty()) {
                        UsuarioProceso.marcarComoFavorito(usuario, encontrados.get(0));
                        System.out.println("Libro agregado a favoritos.");
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                }
                case 5 -> registrarPublicacion(scanner, biblioteca);
                case 6 -> {
                    double promedio = BibliotecaProceso.EstadisticaBiblioteca.calcularPromedioPalabras(biblioteca.getLibros());
                    int totalFavs = BibliotecaProceso.EstadisticaBiblioteca.contarFavoritos(usuario);
                    System.out.println("Promedio de palabras por libro: " + promedio);
                    System.out.println("Total publicaciones favoritas: " + totalFavs);
                    System.out.println("Libros favoritos: " + usuario.getLibrosFavoritos().size());
                    System.out.println("Revistas favoritas: " + usuario.getRevistasFavoritas().size());
                }
                case 7 -> {
                    System.out.print("Ingrese el título de la revista: ");
                    String titulo = scanner.nextLine();
                    List<Revista> resultados = UsuarioProceso.buscarRevistaPorTitulo(biblioteca, titulo);
                    mostrarRevistas(resultados);
                }
                case 8 -> {
                    System.out.print("Ingrese el autor de la revista: ");
                    String autor = scanner.nextLine();
                    List<Revista> resultados = UsuarioProceso.buscarRevistaPorAutor(biblioteca, autor);
                    mostrarRevistas(resultados);
                }
                case 9 ->{
                    System.out.println("Revistas favoritas:");
                    mostrarRevistas(usuario.getRevistasFavoritas());
                }
                case 10->{
                    System.out.print("Ingrese el título de la revista para marcar como favorita: ");
                    String titulo = scanner.nextLine();
                    List<Revista> resultados = UsuarioProceso.buscarRevistaPorTitulo(biblioteca, titulo);
                    if (!resultados.isEmpty()) {
                        UsuarioProceso.marcarRevistaComoFavorita(usuario, resultados.get(0));
                        System.out.println("Revista agregada a favoritos.");
                    } else {
                        System.out.println("Revista no encontrada.");
                    }
                }
                case 11 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 7);
    }

    private static void mostrarResultados(List<Libro> lista) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("No se encontraron resultados.");
        } else {
            for (Libro l : lista) {
                int palabras = LibroProceso.calcularPalabrasEstimadas(l);
                System.out.println("- " + l.getTitulo() + " (" + l.getAutor() + ") - Palabras estimadas: " + palabras);
            }
        }
    }

    private static void registrarPublicacion(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("¿Qué desea registrar?");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        System.out.print("Seleccione: ");
        int tipo = scanner.nextInt(); scanner.nextLine();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Año: ");
        int anio = scanner.nextInt(); scanner.nextLine();
        System.out.print("Código ISBN: ");
        String isbn = scanner.nextLine();

        if (tipo == 1) {
            System.out.print("Cantidad de páginas: ");
            int paginas = scanner.nextInt(); scanner.nextLine();
            Libro nuevoLibro = new Libro(titulo, autor, anio, isbn, paginas);
            biblioteca.getLibros().add(nuevoLibro);
            System.out.println("Libro registrado.");
        } else if (tipo == 2) {
            System.out.print("Número de edición: ");
            int edicion = scanner.nextInt(); scanner.nextLine();
            Revista nuevaRevista = new Revista(titulo, autor, anio, isbn, edicion);
            biblioteca.getRevistas().add(nuevaRevista);
            System.out.println("Revista registrada.");
        } else {
            System.out.println("Opción inválida.");
        }
    }

    private static List<Libro> generarLibrosDePrueba() {
        List<Libro> libros = new ArrayList<>();
        libros.add(new Libro("El Principito", "Antoine de Saint-Exupéry", 1943, "978-0156013987", 90));
        libros.add(new Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967, "978-0307474728", 417));
        libros.add(new Libro("Rayuela", "Julio Cortázar", 1963, "978-8437604947", 250));
//        for (int i = 4; i <= 50; i++) {
//            libros.add(new Libro("Libro " + i, "Autor " + i, 2000 + (i % 20), "ISBN-" + i, 100 + i));
//        }
        return libros;
    }

    private static List<Revista> generarRevistasDePrueba() {
        List<Revista> revistas = new ArrayList<>();
        revistas.add(new Revista("National Geographic", "Editorial NG", 2023, "NG-2023-01", 101));
        revistas.add(new Revista("Muy Interesante", "Ediciones MI", 2022, "MI-2022-04", 202));
        revistas.add(new Revista("Scientific American", "Springer", 2023, "SA-2023-07", 303));
        revistas.add(new Revista("Time", "Time Inc", 2021, "TI-2021-09", 404));
        revistas.add(new Revista("Forbes", "Forbes Media", 2022, "FB-2022-06", 505));
//        for (int i = 6; i <= 10; i++) {
//            revistas.add(new Revista("Revista " + i, "Editorial " + i, 2010 + i, "RV-" + i, 100 + i));
//        }
        return revistas;
    }

    private static void mostrarRevistas(List<Revista> lista) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("No se encontraron revistas.");
        } else {
            for (Revista r : lista) {
                System.out.println("- " + r.getTitulo() + " (" + r.getAutor() + ") - Edición: " + r.getNumeroEdicion());
            }
        }
    }

    //Mostrar libros y revistas
    private static void mostrarPublicacionesDisponibles(Biblioteca biblioteca) {
        System.out.println("PUBLICACIONES DISPONIBLES EN LA BIBLIOTECA:");

        for (Libro libro : biblioteca.getLibros()) {
            System.out.println("[LIBRO] " + libro.getTitulo() + " | Autor: " + libro.getAutor() +
                    " | Año: " + libro.getAnio() + " | ISBN: " + libro.getCodigoISBN());
        }

        for (Revista revista : biblioteca.getRevistas()) {
            System.out.println("[REVISTA] " + revista.getTitulo() + " | Autor: " + revista.getAutor() +
                    " | Año: " + revista.getAnio() + " | ISBN: " + revista.getCodigoISBN());
        }
    }
}
