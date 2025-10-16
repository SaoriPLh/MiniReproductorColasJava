package com; // Asumiendo que quieres mantener este paquete para el ejecutable principal

import java.io.FileNotFoundException;

import com.musiqueue.Cancion;
import com.musiqueue.PlayList;

import javazoom.jl.decoder.JavaLayerException;

public class PruebaPila { 
    public static void main(String[] args) {
        
        PlayList playList = new PlayList();
        
        Cancion cancion = new Cancion("Amargo adios", "Inspector","amargo");
        Cancion cancion2 = new Cancion("Los dioses ocultos", "Caifanes","dioses");
        Cancion cancion3 = new Cancion("Wonderful", "Jar","wonderful"); 
        playList.agregarCancion(cancion);
        playList.agregarCancion(cancion2);
        playList.agregarCancion(cancion3);

        try {
            playList.play();
        //excepciones heredadas de play
        } catch (FileNotFoundException e) { 
            System.err.println(" ERROR: NO SE ENCONTRO EL ARCHIVO DE MUSICA " + e.getMessage());
        } catch (JavaLayerException e) {
            System.err.println(" ERROR:  CON EL ERPRODUCTOR: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println(" ERROR: REPRODUCCION INTERRUMPIDA");
        }
    }
}