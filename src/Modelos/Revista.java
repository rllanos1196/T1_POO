package Modelos;

public class Revista extends Publicacion{
    private int numeroEdicion;

    public Revista(String titulo, String autor, int anio, String codigoISBN, int numeroEdicion) {
        super(titulo, autor, anio, codigoISBN);
        this.numeroEdicion = numeroEdicion;
    }

    // Getter y Setter
    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }
}
