package Procesos.Ejercicio1;

import Modelos.Biblioteca;
import Modelos.Libro;
import Modelos.Revista;
import Modelos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioProceso {
    public static List<Libro> buscarPorTitulo(Biblioteca biblioteca, String titulo) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : biblioteca.getLibros()) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public static List<Libro> buscarPorAutor(Biblioteca biblioteca, String autor) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : biblioteca.getLibros()) {
            if (libro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public static List<Revista> buscarRevistaPorTitulo(Biblioteca biblioteca, String titulo) {
        List<Revista> resultados = new ArrayList<>();
        for (Revista revista : biblioteca.getRevistas()) {
            if (revista.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(revista);
            }
        }
        return resultados;
    }

    public static List<Revista> buscarRevistaPorAutor(Biblioteca biblioteca, String autor) {
        List<Revista> resultados = new ArrayList<>();
        for (Revista revista : biblioteca.getRevistas()) {
            if (revista.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultados.add(revista);
            }
        }
        return resultados;
    }

    public static void marcarComoFavorito(Usuario usuario, Libro libro) {
        if (libro != null && !usuario.getLibrosFavoritos().contains(libro)) {
            usuario.getLibrosFavoritos().add(libro);
        }
    }

    public static void marcarRevistaComoFavorita(Usuario usuario, Revista revista) {
        if (revista != null && !usuario.getRevistasFavoritas().contains(revista)) {
            usuario.getRevistasFavoritas().add(revista);
        }
    }
}
