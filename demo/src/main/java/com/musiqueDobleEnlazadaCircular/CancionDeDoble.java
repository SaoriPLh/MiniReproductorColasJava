package com.musiqueDobleEnlazadaCircular;


public class CancionDeDoble {
    private String titulo, artista, imagen;
    
    public CancionDeDoble() {}

    public CancionDeDoble(String titulo, String artista, String imagen) {
        this.titulo = titulo;
        this.artista = artista;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen () {return imagen;}
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
    
    public String getInformacion() {
        return titulo + " - " + artista;
    }

    @Override
    public String toString() {
        return getInformacion();
    }
}
