package com.example;

public class PilaLIFO {

    
    private int[] elementos;
    private int tope;
    private int capacidad;

    public PilaLIFO(int capacidad) {
        this.capacidad = capacidad;
        elementos = new int[capacidad];
        tope = -1;
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public boolean estaLlena() {
        return tope == capacidad - 1;
    }

    // Operación PUSH - Insertar elemento
    public void push(int elemento) {
        if (estaLlena()) {
            System.out.println("Pila llena, no se puede insertar");
            return;
        }
        tope++;
        elementos[tope] = elemento;
    }

    // Operación POP - Eliminar elemento
    public int pop() {
        if (estaVacia()) {
            System.out.println("Pila vacía, no se puede eliminar");
            return -1;
        }
        int elemento = elementos[tope];
        tope--;
        return elemento;
    }

    // Operación PEEK - Ver elemento del tope sin eliminarlo
    public int peek() {
        if (estaVacia()) {
            System.out.println("Pila vacía");
            return -1;
        }
        return elementos[tope];
    }

    public int tamanio() {
        return tope + 1;
    }

    public void limpiar() {
        tope = -1;
    }

    // Método display para mostrar la pila
    public void display() {
        if (estaVacia()) {
            System.out.println("Pila vacía");
            return;
        }
        System.out.print("Pila (tope -> base): ");
        for (int i = tope; i >= 0; i--) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }

    public void mostrar() {
        display();
    }
}

