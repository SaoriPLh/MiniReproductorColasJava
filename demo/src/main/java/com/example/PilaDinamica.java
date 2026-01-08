package com.example;

public class PilaDinamica {
    private NodoPIla tope;

    public PilaDinamica() {
        this.tope = null;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    // Operación PUSH
    public void push(char elemento) {
        NodoPIla nuevoNodo = new NodoPIla(elemento);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
        System.out.println("Elemento " + elemento + " insertado");
    }

    // Operación POP
    public int pop() {
        if (estaVacia()) {
            System.out.println("Pila vacía");
            return -1;
        }
        int elemento = tope.dato;
        tope = tope.siguiente;
        return elemento;
    }

    // Operación PEEK
    public char peek() {
        if (estaVacia()) {
            System.out.println("Pila vacía");
            return '\u0000';  // carácter nulo (Unicode 0)

        }
        return tope.dato;
    }

    

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Pila vacía");
            return;
        }
        NodoPIla actual = tope;
        System.out.print("Pila (tope -> base): ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }}