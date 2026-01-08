package com.algoritmos;

import java.util.Random;

public class algoritmosOrdenamiento1 {

   
    // MÉTODO SHELL SORT (basado EN TU PDF)
    public static void shellSort(int[] arr) {
        int n = arr.length;

        // Secuencia de incrementos (puedes cambiarla si gustas)
        int[] gaps = { 21, 7, 3, 1 };

        for (int gap : gaps) {

            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                // Comparaciones cada "gap"
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = temp;
            }
        }}
   
    public static void quicksort(int[] arr, int izq, int der) {

        int pivote = arr[izq];
        int i = izq;
        int j = der;
        int aux;

        while (i < j) {

            while (arr[i] <= pivote && i < j) i++;
            while (arr[j] > pivote) j--;

            if (i < j) {
                aux = arr[i];
                arr[i] = arr[j];
                arr[j] = aux;
            }
        }

        arr[izq] = arr[j];
        arr[j] = pivote;

        if (izq < j - 1)
            quicksort(arr, izq, j - 1);

        if (j + 1 < der)
            quicksort(arr, j + 1, der);
    }


    // MAIN PARA PROBAR TODOS LOS ALGORITMOS
    public static void main(String[] args) {

        int n = 1000;
        int[] datos = new int[n];

        Random rand = new Random();

        // Generar números aleatorios entre 10 y 100
        for (int i = 0; i < n; i++) {
            datos[i] = rand.nextInt(91) + 10;
        }

        
        int[] copiaShell = datos.clone();
        int[] copiaQuick = datos.clone();

       

        long inicioShell = System.nanoTime();
        shellSort(copiaShell);
        long tiempoShell = System.nanoTime() - inicioShell;

        long inicioQuick = System.nanoTime();
        quicksort(copiaQuick, 0, copiaQuick.length - 1);
        long tiempoQuick = System.nanoTime() - inicioQuick;

       
        System.out.println("Tiempo de Shell Sort: " + tiempoShell + " ns");
        System.out.println("Tiempo de Quicksort: " + tiempoQuick + " ns");
    }
}
