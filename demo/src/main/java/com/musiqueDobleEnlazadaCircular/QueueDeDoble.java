package com.musiqueDobleEnlazadaCircular;

public class QueueDeDoble {
    private NodoDeDoble frente;
    private NodoDeDoble fin;


    public boolean estaVacia() {
        return frente == null;
    }

    
    public NodoDeDoble getFrente() {
        return frente;
    }


    public void setFrente(NodoDeDoble frente) {
        this.frente = frente;
    }


    public NodoDeDoble getFin() {
        return fin;
    }


    public void setFin(NodoDeDoble fin) {
        this.fin = fin;
    }


    public void encolar(CancionDeDoble c) {
        NodoDeDoble nuevo = new NodoDeDoble(c);
        if (estaVacia()) {
            frente = fin = nuevo;
            fin.setSiguiente(frente);
            fin.setAnterior(frente);
        } else {

            nuevo.setAnterior(fin);
            fin.setSiguiente(nuevo);
            fin = nuevo;
            // --DESCOMENTA CUANDO TERMINES LA PRUBEA SIN QUE SEA CIRCULAR INTENTANDO DE OTRA MANERA -- 

            // aca acaba lo de circular
            // fin.setSiguiente(frente);

            // esto es para mantener lo de circular y doble enlace

            frente.setAnterior(fin);


            // fin.setSiguiente(nuevo);
            // fin = nuevo;
          
            // fin.setSiguiente(frente);
            

        }
   

    }

    public CancionDeDoble desencolar() {
        if (estaVacia()) {
            return null;
        }
        CancionDeDoble c = frente.getCancion();

        if (frente == fin){
            frente = fin = null;
        } 
        else {
            frente = frente.getSiguiente();
            frente.setAnterior(fin);

            //DESCOMENTA DESPUES
            // fin.setSiguiente(frente);
        } 
        

         
        return c;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("No hay canciones en la playlist.");
            return;
        }
        NodoDeDoble aux = frente;
        System.out.println("🎶 Playlist:");
        while (aux != fin) {
            System.out.println("- " + aux.getCancion().getInformacion());
            aux = aux.siguiente;
        }
    }
}
