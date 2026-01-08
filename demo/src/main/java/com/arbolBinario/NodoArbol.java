package com.arbolBinario;

public class NodoArbol {

    private int info;
    private NodoArbol izquierda;
    private NodoArbol derecha;
    private NodoArbol padre;


    public NodoArbol (int info){
        this.info = info;
        this.izquierda = null;
        this.derecha = null;
        this.padre = null;
    }


    public int getInfo() {
        return info;
    }


    public void setInfo(int info) {
        this.info = info;
    }


    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol izquierda) {
    this.izquierda = izquierda;
    if (izquierda != null) {
        izquierda.setPadre(this);
    }
}

public void setDerecha(NodoArbol derecha) {
    this.derecha = derecha;
    if (derecha != null) {
        derecha.setPadre(this);
    }
}


 


    public NodoArbol getDerecha() {
        return derecha;
    }




    public NodoArbol getPadre() {
        return padre;
    }


    public void setPadre(NodoArbol padre) {
        this.padre = padre;
    } 
    

}
