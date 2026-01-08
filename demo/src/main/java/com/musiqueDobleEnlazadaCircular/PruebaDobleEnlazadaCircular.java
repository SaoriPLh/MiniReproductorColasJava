package com.musiqueDobleEnlazadaCircular;

import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;

public class PruebaDobleEnlazadaCircular {
    public static void main(String[] args) {
        PlaylistDeDoble playList = new PlaylistDeDoble();

        // Agregar canciones
        CancionDeDoble cancion1 = new CancionDeDoble("Paquelapasesbien", "Arcangel","bien");
        CancionDeDoble cancion2 = new CancionDeDoble("Los dioses ocultos", "Caifanes","dioses");
       
        CancionDeDoble cancion3 = new CancionDeDoble("Wonderful", "Jar","wonderful");
        CancionDeDoble cancion4= new CancionDeDoble("Lo Intentamos", "Espinoza Paz","lointentamos");
        

        CancionDeDoble cancion5= new CancionDeDoble("Amargo adios", "Inspector","amargo");
       
        
        playList.agregarCancion(cancion1);
        playList.agregarCancion(cancion2);  
        playList.agregarCancion(cancion3);
        playList.agregarCancion(cancion4);
        playList.agregarCancion(cancion5);

        // Mostrar playlist original
        System.out.println("\n=== Playlist original ===");
        playList.mostrarPlaylist();

        // Ordenar playlist con logs
        System.out.println("\n=== Ordenando playlist ===");
        playList.ordenAlfabetico();  // mergeSort interno con logs

        // Mostrar playlist ordenada
        System.out.println("\n=== Playlist ordenada ===");
        playList.mostrarPlaylist();

        // Reproducir playlist
        System.out.println("\n=== Reproduciendo playlist ===");
        try {   
            playList.play();
        } catch (FileNotFoundException e) { 
            System.err.println("ERROR: NO SE ENCONTRO EL ARCHIVO DE MUSICA " + e.getMessage());
        } catch (JavaLayerException e) {
            System.err.println("ERROR: CON EL REPRODUCTOR: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("ERROR: REPRODUCCION INTERRUMPIDA");
        }
    }
}
