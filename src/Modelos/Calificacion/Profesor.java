package Modelos.Calificacion;

import java.util.ArrayList;

public class Profesor extends Persona {
    private ArrayList<Alumno> alumnosAsignados;

    public Profesor() {
        this.alumnosAsignados = new ArrayList<>();
    }

    public Profesor(String nombre, String dni) {
        super(nombre, dni);
        this.alumnosAsignados = new ArrayList<>();
    }

    public ArrayList<Alumno> getAlumnosAsignados() {
        return alumnosAsignados;
    }

    public void setAlumnosAsignados(ArrayList<Alumno> alumnosAsignados) {
        this.alumnosAsignados = alumnosAsignados;
    }

    public void registrarAlumno(Alumno alumno) {
        this.alumnosAsignados.add(alumno);
    }
}
