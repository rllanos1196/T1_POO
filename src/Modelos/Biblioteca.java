package Modelos;

import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private List<Revista> revistas;

    public Biblioteca(List<Libro> libros, List<Revista> revistas) {
        this.libros = libros;
        this.revistas = revistas;
    }

    // Getters y Setters
    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Revista> getRevistas() {
        return revistas;
    }

    public void setRevistas(List<Revista> revistas) {
        this.revistas = revistas;
    }
}
