package Modelos.Calificacion;

import java.util.ArrayList;
import java.util.List;

public class Alumno extends Persona {
    private List<Double> calificaciones;

    public Alumno(String nombre, String dni) {
        super(nombre, dni);
        this.calificaciones = new ArrayList<>();
    }

    public void agregarNota(double nota) {
        calificaciones.add(nota);
    }

    // Método sobrecargado para agregar notas en lote
    public void agregarNota(double[] notas) {
        for (double nota : notas) {
            calificaciones.add(nota);
        }
    }

    public double calcularPromedio() {
        if (calificaciones.isEmpty()) return 0;
        double suma = 0;
        for (double nota : calificaciones) {
            suma += nota;
        }
        return Math.round(suma / calificaciones.size());
    }

    public List<Double> getCalificaciones() {
        return calificaciones;
    }
}
