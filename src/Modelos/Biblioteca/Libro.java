package Modelos.Biblioteca;

import java.util.Random;

public class Libro extends Publicacion {
    private int paginas;

    public Libro(String titulo, String autor, int anio, String codigoISBN, int paginas) {
        super(titulo, autor, anio, codigoISBN);
        this.paginas = paginas;
    }

    // Getter y Setter
    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    // Método que calcula el número estimado de palabras
    public int calcularPalabrasEstimadas() {
        Random random = new Random();
        // Supongamos que un libro tiene entre 250 y 400 palabras por página
        int palabrasPorPagina = 250 + random.nextInt(151); // 250 + [0,150] = [250,400]
        return paginas * palabrasPorPagina;
    }

    // Sobrecarga (opcional) del método para especificar rango
    public int calcularPalabrasEstimadas(int minPorPagina, int maxPorPagina) {
        if (minPorPagina >= maxPorPagina) return -1;
        Random random = new Random();
        int palabrasPorPagina = minPorPagina + random.nextInt(maxPorPagina - minPorPagina + 1);
        return paginas * palabrasPorPagina;
    }
}
