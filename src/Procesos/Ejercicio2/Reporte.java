package Procesos.Ejercicio2;

import Modelos.Calificacion.Alumno;
import Modelos.Calificacion.Curso;

import java.util.List;

public class Reporte {
    // Promedio general de todos los alumnos de un curso
    public static double calcularPromedioGeneral(Curso curso) {
        List<Alumno> alumnos = curso.getAlumnos();
        if (alumnos.isEmpty()) return 0;

        double suma = 0;
        for (Alumno alumno : alumnos) {
            suma += alumno.calcularPromedio();
        }

        return Math.round(suma / alumnos.size());
    }

    // Cantidad de alumnos aprobados (nota >= 11)
    public static int contarAprobados(Curso curso) {
        int contador = 0;
        for (Alumno alumno : curso.getAlumnos()) {
            if (alumno.calcularPromedio() >= 11) {
                contador++;
            }
        }
        return contador;
    }
}
