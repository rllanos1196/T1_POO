package Modelos.Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;

    private List<Libro> librosFavoritos;
    private List<Revista> revistasFavoritas;
    public Usuario(String nombre) {
        this.nombre = nombre;
        this.librosFavoritos = new ArrayList<>();
        this.revistasFavoritas = new ArrayList<>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    public List<Revista> getRevistasFavoritas() {
        return revistasFavoritas;
    }
    public List<Libro> getLibrosFavoritos() {
        return librosFavoritos;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLibrosFavoritos(List<Libro> librosFavoritos) {
        this.librosFavoritos = librosFavoritos;
    }

    public void setRevistasFavoritas(List<Revista> revistasFavoritas) {
        this.revistasFavoritas = revistasFavoritas;
    }
}
