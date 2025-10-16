
package com.musiqueue;
public class Queue {
    private Nodo frente;
    private Nodo fin;

    public boolean estaVacia() {
        return frente == null;
    }

    
    public Nodo getFrente() {
        return frente;
    }


    public void setFrente(Nodo frente) {
        this.frente = frente;
    }


    public Nodo getFin() {
        return fin;
    }


    public void setFin(Nodo fin) {
        this.fin = fin;
    }


    public void encolar(Cancion c) {
        Nodo nuevo = new Nodo(c);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
            fin.siguiente = frente;
        }
    }

    public Cancion desencolar() {
        if (estaVacia()) {
            return null;
        }
        Cancion c = frente.getCancion();
        frente = frente.getSiguiente();
         if (frente == null) fin = null;
         
        return c;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("No hay canciones en la playlist.");
            return;
        }
        Nodo aux = frente;
        System.out.println("🎶 Playlist:");
        while (aux != null) {
            System.out.println("- " + aux.getCancion().getInformacion());
            aux = aux.siguiente;
        }
    }
}
