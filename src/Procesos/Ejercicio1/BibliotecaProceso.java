package Procesos.Ejercicio1;

import Modelos.Libro;
import Modelos.Usuario;

import java.util.List;

public class BibliotecaProceso {
    public static class EstadisticaBiblioteca {

        public static double calcularPromedioPalabras(List<Libro> libros) {
            if (libros == null || libros.isEmpty()) return 0.0;

            int totalPalabras = 0;
            for (Libro libro : libros) {
                totalPalabras += LibroProceso.calcularPalabrasEstimadas(libro);
            }

            return (double) totalPalabras / libros.size();
        }

        public static int contarFavoritos(Usuario usuario) {
            int totalLibros = (usuario.getLibrosFavoritos() != null) ? usuario.getLibrosFavoritos().size() : 0;
            int totalRevistas = (usuario.getRevistasFavoritas() != null) ? usuario.getRevistasFavoritas().size() : 0;
            return totalLibros + totalRevistas;
        }
    }
}
