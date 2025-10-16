package com.musiqueDobleEnlazadaCircular;


import javazoom.jl.decoder.JavaLayerException;
import java.io.FileNotFoundException;

public class PlaylistDeDoble {
    private QueueDeDoble cola;
    private ReproducirDeDoble reproductor;

    public PlaylistDeDoble() {
        cola = new QueueDeDoble();
        reproductor = new ReproducirDeDoble();
    }

    // Agrega una canción a la cola
    public void agregarCancion(CancionDeDoble c) {
        cola.encolar(c);
        System.out.println(" Se agregó: " + c.getInformacion());
    }

    // Muestra todas las canciones de la lista
    public void mostrarPlaylist() {
        cola.mostrar();
    }
    
    // Reproduce todas las canciones en orden
    public void play() throws FileNotFoundException, JavaLayerException, InterruptedException {
        NodoDeDoble aux = cola.getFrente(); // obtiene el primer nodo de la cola
        
        if (aux == null) {
            System.out.println(" La lista está vacía.");
            return;
        }


        //     boolean retrocediendo = false;
            
        //     while (aux != null) {
            
        //     CancionDeDoble actual = aux.getCancion();
        //     String nombre = actual.getTitulo();
        //     String imagen = actual.getImagen()+".png";
        //     System.out.println(imagen);
        //     System.out.println(" REPRODUCIENDO: " + actual.getInformacion());
            
        //     boolean anterior = reproductor.play(nombre, imagen);

        //     if (anterior){aux = aux.getAnterior();}

        //     else if (aux == cola.getFin() && !anterior) {
        //         retrocediendo = true;
        //         aux = aux.getAnterior();
        //     } 
        //     else if (retrocediendo){
        //         aux = aux.getAnterior();

        //         if( aux == cola.getFrente()){
        //             retrocediendo = false;
        //         } 

        //     }  
        
        //     else {aux = aux.getSiguiente();}  
            
        //     //// aux = anterior ? aux.getAnterior() : aux.getSiguiente();
        // }
    
        // --SIMULACION DE COLA CIRCULAR --
        // while (aux != null) {

        //     CancionDeDoble actual = aux.getCancion();
        //     String nombre = actual.getTitulo();
        //     String imagen = actual.getImagen()+".png";
        //     System.out.println(imagen);
        //     System.out.println(" REPRODUCIENDO: " + actual.getInformacion());
            
        //     boolean anterior = reproductor.play(nombre, imagen);

        //     if (anterior){aux = aux.getAnterior();}
        //     else if (aux == cola.getFin() && !anterior) {
        //         aux = cola.getFrente();
        //     } 
        //     else {aux = aux.getSiguiente();}  
            
        //     //// aux = anterior ? aux.getAnterior() : aux.getSiguiente();
        // }



        // --  ORIGINAL --
        while (aux != null) {
            CancionDeDoble actual = aux.getCancion();
            String nombre = actual.getTitulo();
            String imagen = actual.getImagen()+".png";
            System.out.println(imagen);
            System.out.println(" REPRODUCIENDO: " + actual.getInformacion());
            
            boolean anterior = reproductor.play(nombre, imagen);
            
            aux = anterior ? aux.getAnterior() : aux.getSiguiente();
        }

        System.out.println("Se llegó al final de la lista de reproducción.");
    }
}
