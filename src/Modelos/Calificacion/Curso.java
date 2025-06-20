package Modelos.Calificacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Curso {
    private String nombreCurso;
    private List<Alumno> alumnos;

    // Atributos estáticos
    private static int contadorCursos = 0;
    private static int contadorAlumnos = 0;

    public Curso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
        this.alumnos = new ArrayList<>();
        contadorCursos++;
    }

    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
        contadorAlumnos++;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public static int getContadorCursos() {
        return contadorCursos;
    }

    public static int getContadorAlumnos() {
        return contadorAlumnos;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    // Clase anidada no estática
    public class Asistencia {
        private Map<Alumno, Boolean> asistenciaMap = new HashMap<>();

        public void registrarAsistencia(Alumno alumno, boolean asistio) {
            asistenciaMap.put(alumno, asistio);
        }

        public Boolean getAsistencia(Alumno alumno) {
            return asistenciaMap.getOrDefault(alumno, false);
        }
    }
}
