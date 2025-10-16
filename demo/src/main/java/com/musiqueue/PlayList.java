package com.musiqueue;

import javazoom.jl.decoder.JavaLayerException;
import java.io.FileNotFoundException;

public class PlayList {
    private Queue cola;
    private Reproducir reproductor;

    public PlayList() {
        cola = new Queue();
        reproductor = new Reproducir();
    }

    // Agrega una canción a la cola
    public void agregarCancion(Cancion c) {
        cola.encolar(c);
        System.out.println(" Se agregó: " + c.getInformacion());
    }

    // Muestra todas las canciones de la lista
    public void mostrarPlaylist() {
        cola.mostrar();
    }
    
    // Reproduce todas las canciones en orden
    public void play() throws FileNotFoundException, JavaLayerException, InterruptedException {
        Nodo aux = cola.getFrente(); // obtiene el primer nodo de la cola
        
        if (aux == null) {
            System.out.println(" La lista está vacía.");
            return;
        }

        while (aux != null) {
            Cancion actual = aux.getCancion();
            String nombre = actual.getTitulo();
            String imagen = actual.getImagen()+".png";
            System.out.println(imagen);
            System.out.println(" REPRODUCIENDO: " + actual.getInformacion());
            
            reproductor.play(nombre, imagen);
            
            // pasa al siguiente nodo
            aux = aux.getSiguiente();
        }

        System.out.println("Se llegó al final de la lista de reproducción.");
    }
}
