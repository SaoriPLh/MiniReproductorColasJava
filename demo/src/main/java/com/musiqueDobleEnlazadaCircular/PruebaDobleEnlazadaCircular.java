package com.musiqueDobleEnlazadaCircular;

import java.io.FileNotFoundException;


import javazoom.jl.decoder.JavaLayerException;

public class PruebaDobleEnlazadaCircular {
    public static void main(String[] args) {
        PlaylistDeDoble playList = new  PlaylistDeDoble();
        
        CancionDeDoble cancion = new CancionDeDoble("Amargo adios", "Inspector","amargo");
        CancionDeDoble cancion2 = new CancionDeDoble("Los dioses ocultos", "Caifanes","dioses");
        CancionDeDoble cancion3 = new CancionDeDoble("Wonderful", "Jar","wonderful"); 
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
