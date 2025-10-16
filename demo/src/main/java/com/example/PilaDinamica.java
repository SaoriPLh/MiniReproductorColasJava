package com.example;

public class PilaDinamica {
    private NodoPIla tope;
    private int tamano;

    public PilaDinamica() {
        this.tope = null;
        this.tamano = 0;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    // Operación PUSH
    public void push(char elemento) {
        NodoPIla nuevoNodo = new NodoPIla(elemento);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
        tamano++;
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
        tamano--;
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

    public int tamanio() {
        return tamano;
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