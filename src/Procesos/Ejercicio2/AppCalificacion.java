package Procesos.Ejercicio2;

import Modelos.Calificacion.Alumno;
import Modelos.Calificacion.Curso;
import Modelos.Calificacion.Profesor;

import java.util.*;

public class AppCalificacion {
    private static List<Curso> cursos = new ArrayList<>();
    private static List<Alumno> alumnos = new ArrayList<>();
    private static Profesor profesor = new Profesor("Eduardo Torres", "12345678");
    public static void iniciarCalificaciones() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        generarCursos();
        generarAlumnos();
        asignarAlumnosACursos();
        simularNotas();

        do {
            System.out.println("\n===== SISTEMA DE CALIFICACIONES =====");
            System.out.println("1. Mostrar cursos y alumnos");
            System.out.println("2. Mostrar promedios individuales");
            System.out.println("3. Mostrar reportes por curso");
            System.out.println("4. Registrar asistencia");
            System.out.println("5. Mostrar resumen general");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> mostrarCursosYAlumnos();
                case 2 -> mostrarPromedios();
                case 3 -> mostrarReportesPorCurso();
                case 4 -> registrarAsistencia(sc);
                case 5 -> mostrarResumen();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private static void generarCursos() {
        cursos.add(new Curso("Cálculo III"));
        cursos.add(new Curso("Comunicación III"));
        cursos.add(new Curso("Progración Orientada a Objetos (JAVA)"));
    }

    private static void generarAlumnos() {
        alumnos.add(new Alumno("Juanito Pérez", "A001"));
        alumnos.add(new Alumno("Anabel Torres", "A002"));
        alumnos.add(new Alumno("Carlos Rojas", "A003"));
        alumnos.add(new Alumno("Lucía Salas", "A004"));
        alumnos.add(new Alumno("Susy Díaz", "A005"));

        for (Alumno a : alumnos) {
            profesor.registrarAlumno(a);
        }
    }

    private static void asignarAlumnosACursos() {
        cursos.get(0).agregarAlumno(alumnos.get(0));
        cursos.get(0).agregarAlumno(alumnos.get(1));
        cursos.get(0).agregarAlumno(alumnos.get(2));

        cursos.get(1).agregarAlumno(alumnos.get(1));
        cursos.get(1).agregarAlumno(alumnos.get(3));
        cursos.get(1).agregarAlumno(alumnos.get(4));

        cursos.get(2).agregarAlumno(alumnos.get(0));
        cursos.get(2).agregarAlumno(alumnos.get(2));
        cursos.get(2).agregarAlumno(alumnos.get(4));
    }

    private static void simularNotas() {
        Random random = new Random();
        for (Alumno a : alumnos) {
            double[] notas = new double[3];
            for (int i = 0; i < 3; i++) {
                notas[i] = 8 + random.nextDouble() * 12; // entre 8 y 20
            }
            a.agregarNota(notas);
        }
    }

    private static void mostrarCursosYAlumnos() {
        for (Curso c : cursos) {
            System.out.println("\nCurso: " + c.getNombreCurso());
            for (Alumno a : c.getAlumnos()) {
                System.out.println("- " + a.getNombre() + " (" + a.getDni() + ")");
            }
        }
    }

    private static void mostrarPromedios() {
        System.out.println("\nPromedios por alumno:");
        for (Alumno a : alumnos) {
            System.out.println(a.getNombre() + ": " + a.calcularPromedio());
        }
    }

    private static void mostrarReportesPorCurso() {
        for (Curso c : cursos) {
            System.out.println("\nCurso: " + c.getNombreCurso());
            System.out.println("Promedio general: " + Reporte.calcularPromedioGeneral(c));
            System.out.println("Aprobados (nota >= 11): " + Reporte.contarAprobados(c));
        }
    }

    private static void registrarAsistencia(Scanner sc) {
        System.out.println("\nSeleccione curso:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + ". " + cursos.get(i).getNombreCurso());
        }
        int cursoIndex = sc.nextInt() - 1;
        Curso curso = cursos.get(cursoIndex);
        Curso.Asistencia asistencia = curso.new Asistencia();

        for (Alumno a : curso.getAlumnos()) {
            System.out.print("¿" + a.getNombre() + " asistió? (s/n): ");
            String resp = sc.next();
            asistencia.registrarAsistencia(a, resp.equalsIgnoreCase("s"));
        }
    }

    private static void mostrarResumen() {
        System.out.println("\nResumen general:");
        System.out.println("Total cursos: " + Curso.getContadorCursos());
        System.out.println("Total alumnos: " + Curso.getContadorAlumnos());
    }
}
