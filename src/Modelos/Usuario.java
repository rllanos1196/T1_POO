package Modelos;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<Libro> librosDisponibles;
    private List<Libro> librosFavoritos;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.librosDisponibles = new ArrayList<>();
        this.librosFavoritos = new ArrayList<>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public List<Libro> getLibrosDisponibles() {
        return librosDisponibles;
    }

    public List<Libro> getLibrosFavoritos() {
        return librosFavoritos;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLibrosDisponibles(List<Libro> librosDisponibles) {
        this.librosDisponibles = librosDisponibles;
    }

    public void setLibrosFavoritos(List<Libro> librosFavoritos) {
        this.librosFavoritos = librosFavoritos;
    }
}
