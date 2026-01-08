package com.algoritmos;

import java.util.Random;

public class algoritmosOrdenamiento {

    // MÉTODO DE ORDENAMIENTO BURBUJA
    public static void burbuja(int[] arr) {
        int n = arr.length;
        boolean intercambio;

        for (int i = 0; i < n - 1; i++) {
            intercambio = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    intercambio = true;
                }
            }

            if (!intercambio) break;
        }
    }

    // MÉTODO DE ORDENAMIENTO POR INSERCIÓN DIRECTA
    public static void insercionDirecta(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        int n = 1000;
        int[] datos = new int[n];

        Random rand = new Random();

        // Generar números aleatorios entre 10 y 100
        for (int i = 0; i < n; i++) {
            datos[i] = rand.nextInt(91) + 10; // 10 - 100
        }

        // Copias del vector para cada algoritmo
        int[] copiaBurbuja = datos.clone();
        int[] copiaInsercion = datos.clone();

        long inicioBurbuja = System.nanoTime();
        burbuja(copiaBurbuja);
        long finBurbuja = System.nanoTime();
        long tiempoBurbuja = finBurbuja - inicioBurbuja;

        long inicioInsercion = System.nanoTime();
        insercionDirecta(copiaInsercion);
        long finInsercion = System.nanoTime();
        long tiempoInsercion = finInsercion - inicioInsercion;

        // Mostrar resultados
        System.out.println("Tiempo de Burbuja: " + tiempoBurbuja + " ns");
        System.out.println("Tiempo de Inserción Directa: " + tiempoInsercion + " ns");
    }
}
