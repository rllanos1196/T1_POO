package Procesos.Ejercicio1;

import Modelos.Libro;
import Modelos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioProceso {
    public static List<Libro> buscarPorTitulo(Usuario usuario, String titulo) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : usuario.getLibrosDisponibles()) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public static List<Libro> buscarPorAutor(Usuario usuario, String autor) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : usuario.getLibrosDisponibles()) {
            if (libro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public static void marcarComoFavorito(Usuario usuario, Libro libro) {
        if (libro != null && !usuario.getLibrosFavoritos().contains(libro)) {
            usuario.getLibrosFavoritos().add(libro);
        }
    }
}
