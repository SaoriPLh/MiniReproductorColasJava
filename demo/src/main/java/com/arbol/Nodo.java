package com.arbol;

public class Nodo {
    private int info;
    private Nodo nodoIzquierdo;
    private Nodo nodoDerecho;
    private Nodo padre; 

    public Nodo(int info) {
        this.info = info;
        this.nodoIzquierdo = null;
        this.nodoDerecho = null;
        this.padre = null;
    }

  
    public Nodo getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    public void setNodoIzquierdo(Nodo nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
        if (nodoIzquierdo != null) {
            nodoIzquierdo.setPadre(this); 
        }
    }

    public Nodo getNodoDerecho() {
        return nodoDerecho;
    }

    public void setNodoDerecho(Nodo nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
        if (nodoDerecho != null) {
            nodoDerecho.setPadre(this); 
        }
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }
}
