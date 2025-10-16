package com.musiqueue;

public class Nodo {
    Cancion cancion;
    Nodo siguiente;

    public Nodo(Cancion c) {
        this.cancion = c;
        this.siguiente = null;
    }
    

    public Nodo getSiguiente() {
        return siguiente;
    }


    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }


    public Cancion getCancion() {
        return cancion;
    }
}
