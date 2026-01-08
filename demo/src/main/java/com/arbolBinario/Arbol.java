package com.arbolBinario;

public class Arbol {

    private NodoArbol raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void insertar(NodoArbol nodo, NodoArbol recorrido) {
        // Caso base: si el árbol está vacío
        if (raiz == null) {
            raiz = nodo;
            return;
        }

        // Si el valor es menor, va a la izquierda
        if (nodo.getInfo() < recorrido.getInfo()) {
            if (recorrido.getIzquierda() == null) {
                recorrido.setIzquierda(nodo);
                nodo.setPadre(recorrido);
            } else {
                insertar(nodo, recorrido.getIzquierda());
            }
        }

        // Si el valor es mayor, va a la derecha
        else if (nodo.getInfo() > recorrido.getInfo()) {
            if (recorrido.getDerecha() == null) {
                recorrido.setDerecha(nodo);
                nodo.setPadre(recorrido);
            } else {
                insertar(nodo, recorrido.getDerecha());
            }
        }
    }
}
