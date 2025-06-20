package Modelos.Biblioteca;

public abstract class Publicacion {
    private String titulo;
    private String autor;
    private int anio;
    private String codigoISBN;

    public Publicacion(String titulo, String autor, int anio, String codigoISBN) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del autor no puede estar vacío.");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.codigoISBN = codigoISBN;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public String getCodigoISBN() {
        return codigoISBN;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del autor no puede estar vacío.");
        }
        this.autor = autor;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setCodigoISBN(String codigoISBN) {
        this.codigoISBN = codigoISBN;
    }
}
