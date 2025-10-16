package com.misiqueueEstatica;

public class CircularQueue {

    private int[] queue;
    private int P; // Índice del frente de la cola
    private int U; // Índice del último elemento de la cola
    private int MAX; // Tamaño máximo de la cola

    public CircularQueue (int MAX) {
        this.MAX = MAX;
        this.queue = new int [MAX];
        this.P = -1;
        this.U = -1;
    }

    public boolean isVacia() {
        return P == -1 && U == -1;
    }

    public boolean isLlena() {
        return (U + 1) % MAX == P;
    }

    public void insertar (int data) {

        if (isLlena()) {
            System.out.println("La cola está llena. No se puede insertar.");
            return;
        }

        if (isVacia()) {
            P = 0;
            U = 0;
        } else {
            U = (U + 1) % MAX; //utilizando el operador módulo %
            //para asegurarse de que el índice esté
            //dentro del tamaño máximo de la cola.
        }

        queue [U] = data;
        System.out.println("Elemento insertado: " + data);
    }

    public void eliminar() {
        if (isVacia()) {
            System.out.println("La cola está vacía. No se puede eliminar.");
            return;
        }

        System.out.println("Elemento eliminado: " + queue [P]);

        if (P == U) {
            P = -1;
            U = -1;
        } else {
            P = (P + 1) % MAX;
        }
    }

    public void mostrar() {
        if (isVacia()) {
            System.out.println("La cola está vacia.");
            return;
        }

        System.out.print("Cola circular: ");
        int i = P;
        
        while (i != U) {
            System.out.print(queue [i] + " ");
            i = (i + 1) % MAX; //Calcula la posicion de i
            //para sabe si U esta atrás o delante de P
        }
        
        System.out.print(queue [U]);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue (5);

        queue.insertar(10);
        queue.insertar(20);
        queue.insertar(30);
        queue.mostrar();

        queue.eliminar();
        queue.mostrar();

        queue.insertar(40);
        queue.insertar(50);
        queue.insertar(60);
        queue.insertar(5);
        queue.mostrar();
    }
}