package com.musiqueDobleEnlazadaCircular;
public class NodoDeDoble {
    CancionDeDoble cancion;
    NodoDeDoble siguiente;
    NodoDeDoble anterior;

    public NodoDeDoble(CancionDeDoble c) {
        this.cancion = c;
        this.siguiente = null;
        this.anterior = this;
    }

    
    
    public NodoDeDoble getSiguiente() {
        return siguiente;
    }


    public void setSiguiente(NodoDeDoble siguiente) {
        this.siguiente = siguiente;
    }
    
    public void setAnterior(NodoDeDoble anterior) {
        this.anterior = anterior;
    }



    public CancionDeDoble getCancion() {
        return cancion;
    }



    public NodoDeDoble getAnterior() {
        return anterior;
    }
}
