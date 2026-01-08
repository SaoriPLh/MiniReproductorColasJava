package com.musiqueDobleEnlazadaCircular;


import javazoom.jl.decoder.JavaLayerException;
import java.io.FileNotFoundException;

import com.example.NodoPIla;
import com.musiqueue.Nodo;

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
public NodoDeDoble encontrarMedio(NodoDeDoble frente) {
    System.out.println("Encontrando mitad de "+frente.getCancion().getTitulo());
    if (frente == null) return null;

    System.out.println("pasando a la sgbda etapa de encontrar mitad");

    NodoDeDoble lento = frente;
    NodoDeDoble rapido = frente.getSiguiente(); // empezar desde siguiente
    System.out.println("entrando al while");

    while (rapido != null && rapido.getSiguiente() != null) {
        lento = lento.getSiguiente();
        rapido = rapido.getSiguiente().getSiguiente();
    }
    System.out.println("saliendo del while");

    return lento;
}


  public NodoDeDoble mergeSort(NodoDeDoble elemento) {
    System.out.println("mergeSort llamado con: " + (elemento != null ? elemento.getCancion().getTitulo() : "null"));

    if (elemento == null || elemento.getSiguiente() == null) {
        if (elemento != null) {
            System.out.println("Base case reached: " + elemento.getCancion().getTitulo());
        } else {
            System.out.println("Base case reached: null");
        }
        return elemento;
    }

    // Encontrar el nodo medio
    NodoDeDoble mitad = encontrarMedio(elemento);
    System.out.println("Encontramos mitad1");
    NodoDeDoble derecha = mitad.getSiguiente();
    System.out.println("Encontramos mitad2");

    // Separar las dos mitades
    mitad.setSiguiente(null);
    if (derecha != null) {
        derecha.setAnterior(null);
    }

    System.out.println("Dividing list: izquierda hasta '" + mitad.getCancion().getTitulo() + "', derecha desde '" 
                       + (derecha != null ? derecha.getCancion().getTitulo() : "null") + "'");

    // Recursión correcta: izquierda recibe desde el frente hasta mitad
    NodoDeDoble izquierdaOrdenada = mergeSort(elemento);
    NodoDeDoble derechaOrdenada = mergeSort(derecha);

    System.out.println("Merging listas: izquierda frente '" 
                       + (izquierdaOrdenada != null ? izquierdaOrdenada.getCancion().getTitulo() : "null") + "', derecha frente '" 
                       + (derechaOrdenada != null ? derechaOrdenada.getCancion().getTitulo() : "null") + "'");

    NodoDeDoble resultado = merge(izquierdaOrdenada, derechaOrdenada);

    // Mostrar lista después de merge
    System.out.print("Resultado del merge: ");
    NodoDeDoble actual = resultado;
    while (actual != null) {
        System.out.print(actual.getCancion().getTitulo() + " ");
        actual = actual.getSiguiente();
    }
    System.out.println("\n");

    return resultado;
}

 
    
public NodoDeDoble merge(NodoDeDoble lista1, NodoDeDoble lista2) {
    // casos base
    if (lista1 == null) return lista2;
    if (lista2 == null) return lista1;

    NodoDeDoble frenteResultado;

    // inicializar frente
    if (lista1.getCancion().getTitulo().compareToIgnoreCase(lista2.getCancion().getTitulo()) <= 0) {
        frenteResultado = lista1;
        lista1 = lista1.getSiguiente();
    } else {
        frenteResultado = lista2;
        lista2 = lista2.getSiguiente();
    }

    NodoDeDoble ultimo = frenteResultado; // puntero al último nodo agregado

    // recorrer ambas listas y enlazar en orden
    while (lista1 != null && lista2 != null) {
        if (lista1.getCancion().getTitulo().compareTo(lista2.getCancion().getTitulo()) <= 0) {
            ultimo.setSiguiente(lista1);
            lista1.setAnterior(ultimo);
            ultimo = lista1;
            lista1 = lista1.getSiguiente();
        } else {
            ultimo.setSiguiente(lista2);
            lista2.setAnterior(ultimo);
            ultimo = lista2;
            lista2 = lista2.getSiguiente();
        }
    }

    // agregar nodos restantes
    if (lista1 != null) {
        ultimo.setSiguiente(lista1);
        lista1.setAnterior(ultimo);
    }
    if (lista2 != null) {
        ultimo.setSiguiente(lista2);
        lista2.setAnterior(ultimo);
    }
    System.out.println("Listas fusionadas el frente es "+frenteResultado.getCancion().getTitulo());

    return frenteResultado; // nodo frente de la lista fusionada
}

public void ordenAlfabetico() {
    System.out.println("\nEntrando al método ordenAlfabetico");

    // obtener el frente de la cola
    NodoDeDoble frente = cola.getFrente();  

    System.out.println("Usaremos merge sort...");
    frente = mergeSort(frente);
    System.out.println("Saliendo de merge sort");

    // actualizar el frente y el fin de la cola
    cola.setFrente(frente);

    // actualizar fin recorriendo hasta el último nodo
    NodoDeDoble actual = frente;
    NodoDeDoble ultimo = null;
    System.out.println("Actualizando fin de la cola...");
    while (actual != null) {
        ultimo = actual;
        actual = actual.getSiguiente();
    }
    cola.setFin(ultimo);

    System.out.println("Playlist ordenada alfabéticamente.\n");
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
        while (aux != null) {

            CancionDeDoble actual = aux.getCancion();
            String nombre = actual.getTitulo();
            String imagen = actual.getImagen()+".png";
            System.out.println(imagen);
            System.out.println(" REPRODUCIENDO: " + actual.getInformacion());
            
            boolean anterior = reproductor.play(nombre, imagen);

            if (anterior){aux = aux.getAnterior();}
            else if (aux == cola.getFin() && !anterior) {
                aux = cola.getFrente();
            } 
            else {aux = aux.getSiguiente();}  
            
            //// aux = anterior ? aux.getAnterior() : aux.getSiguiente();
        }



        // --  ORIGINAL --
        // while (aux != null) {
        //     CancionDeDoble actual = aux.getCancion();
        //     String nombre = actual.getTitulo();
        //     String imagen = actual.getImagen()+".png";
        //     System.out.println(imagen);
        //     System.out.println(" REPRODUCIENDO: " + actual.getInformacion());
            
        //     boolean anterior = reproductor.play(nombre, imagen);
            
        //     aux = anterior ? aux.getAnterior() : aux.getSiguiente();
        // }

        System.out.println("Se llegó al final de la lista de reproducción.");
    }
}
