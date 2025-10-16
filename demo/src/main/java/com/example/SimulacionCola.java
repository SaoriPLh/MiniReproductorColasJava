package com.example;

public class SimulacionCola {
    public static void main(String[] args) {
        int[] elementos = new int[5];
        int inicio = -1;
        int fin = -1;

        // Paso 1: Cola vacía
        System.out.println("=== Estado inicial ===");
        imprimir(elementos, inicio, fin);

        // Paso 2: Insertar primer elemento
        inicio = fin = 0;
        elementos[fin] = 10;
        System.out.println("\n=== Insertar 10 ===");
        imprimir(elementos, inicio, fin);

        // Paso 3: Insertar segundo elemento
        fin++;
        elementos[fin] = 20;
        System.out.println("\n=== Insertar 20 ===");
        imprimir(elementos, inicio, fin);

        // Paso 4: Insertar tercer elemento
        fin++;
        elementos[fin] = 30;
        System.out.println("\n=== Insertar 30 ===");
        imprimir(elementos, inicio, fin);

        // Paso 5: Remover (inicio++)
        inicio++;
        System.out.println("\n=== Remover (inicio++) ===");
        imprimir(elementos, inicio, fin);

        // Paso 6: Remover otro
        inicio++;
        System.out.println("\n=== Remover otro (inicio++) ===");
        imprimir(elementos, inicio, fin);
    }

    // Método auxiliar para imprimir el estado actual
    public static void imprimir(int[] elementos, int inicio, int fin) {
        System.out.print("Arreglo: ");
        for (int i = 0; i < elementos.length; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();

        System.out.println("inicio = " + inicio + "   fin = " + fin);

        if (inicio == -1) {
            System.out.println("Cola vacía.");
        } else {
            System.out.print("Cola lógica: ");
            for (int i = inicio; i <= fin; i++) {
                System.out.print(elementos[i] + " ");
            }
            System.out.println();
        }
    }
}
