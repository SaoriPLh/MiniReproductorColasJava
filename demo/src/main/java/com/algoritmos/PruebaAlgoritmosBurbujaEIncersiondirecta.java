/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estructuradedatosu_5;

import java.util.Random;

/**
 *
 * @author huert
 */
public class PruebaAlgoritmosBurbujaEIncersiondirecta {

    public static void main(String[] args) {
        int[] K = new int[1000];
        Random rand = new Random();

        for (int i = 0; i < K.length; i++) {
            K[i] = rand.nextInt(91) + 10; 
            // nextInt(91) genera 0-90 → +10 lo convierte en 10-100
        }

        int[] copia1 = K.clone();
        int[] copia2 = K.clone();
        int[] copia3 = K.clone();
        int[] copia4 = K.clone();

        long inicioInsercion = System.nanoTime();
        insercionDirecta(copia1);
        long finInsercion = System.nanoTime();
        
        long tiempoInsercion = finInsercion - inicioInsercion;

        long inicioBurbuja = System.nanoTime();
        burbuja(copia2);
        long finBurbuja = System.nanoTime();

        long tiempoBurbuja = finBurbuja - inicioBurbuja;

        long inicioShellSort = System.nanoTime();
        shellSort(copia3);
        long finShellSort = System.nanoTime();

        long tiempoShellSort = finShellSort - inicioShellSort;

        long inicioQuickSort = System.nanoTime();
        Quicksort(copia4, 0, copia4.length - 1);
        long finQuickSort = System.nanoTime();

        long tiempoQuickSort = finQuickSort - inicioQuickSort;

        /*System.out.println("Tiempos en nanosegundos:\n");
        System.out.println("Tiempo Inserción Directa: " + tiempoInsercion + " ns");
        System.out.println("Tiempo Burbuja: " + tiempoBurbuja + " ns");
        System.out.println("Tiempo ShellSort: " + tiempoShellSort + " ns");
        System.out.println("Tiempo QuickSort: " + tiempoQuickSort + " ns");

        System.out.println("Tiempos en milisegundos:\n");
        System.out.println("Inserción Directa: " + (tiempoInsercion / 1_000_000.0) + " ms");
        System.out.println("Burbuja: " + (tiempoBurbuja / 1_000_000.0) + " ms");
        System.out.println("ShellSort: " + (tiempoShellSort / 1_000_000.0) + " ms");
        System.out.println("QuickSort: " + (tiempoQuickSort / 1_000_000.0) + " ms");*/

        double[] Tiempos = {(tiempoInsercion / 1_000_000.0),(tiempoBurbuja / 1_000_000.0),
             (tiempoShellSort / 1_000_000.0),(tiempoQuickSort / 1_000_000.0)};
        
        String[] Nom = {"insercion","Burbuja","Shell","Quick"};
        shellSort(Tiempos, Nom);
        for(int i=0;i<Tiempos.length;i++){
            System.out.println(Nom[i]+" "+Tiempos[i]);
        }
    }

    public static void insercionDirecta ( int []K ){
        int v, j;
        for(int i=0;i<K.length;i++){
            v=K[i];
            j=i-1;
            while(j>=0 && K[j]>v){
                K[j+1]=K[j];
                j--;
            }
            K[j+1]=v;
        }
    }

    public static void burbuja(int[] K) {
        int n = K.length;
        int t;

        // i = 1 ; i < n ; i++
        for (int i = 1; i < n; i++) {

            // j = 0 ; j < n - i ; j++
            for (int j = 0; j < n - i; j++) {

                // si (k[j] > k[j+1])
                if (K[j] > K[j + 1]) {
                    t = K[j];
                    K[j] = K[j + 1];
                    K[j + 1] = t;
                }
            }
        }
    }

    public static void shellSort(int[] k) {
        int[] grupo = {21, 7, 3, 1};  // tus incrementos
        int H = grupo.length;
        int n = k.length;
        for (int g = 0; g < H; g++) {
            int h = grupo[g];

            for (int i = h; i < n; i++) {
                int v = k[i];
                int j = i;
                // Inserción modificada
                    while (j >= h && k[j - h] > v) {
                        k[j] = k[j - h];
                            j = j - h;
                    }
                    k[j] = v;
            }
        }      
    }

    public static void shellSort(double[] k, String[]N) {
        int[] grupo = {21, 7, 3, 1};  // tus incrementos
        int H = grupo.length;
        int n = k.length;
        for (int g = 0; g < H; g++) {
            int h = grupo[g];

            for (int i = h; i < n; i++) {
                double v = k[i];
                String vs = N[i];
                int j = i;
                // Inserción modificada
                    while (j >= h && k[j - h] > v) {
                        k[j] = k[j - h];
                        N[j] = N[j - h];
                            j = j - h;
                    }
                    k[j] = v;
                    N[j] = vs;
            }
        }      
    }

    public static void Quicksort(int K[], int izq, int der) {

    int pivote=K[izq]; // se toma primer elemento como pivote
    int i=izq; // i realiza la búsqueda de izquierda a derecha
    int j=der; // j realiza la búsqueda de derecha a izquierda
    int aux;

    while(i<j){ // mientras no se crucen las búsquedas
        while(K[i]<=pivote && i<j) i++; // busca elemento mayor que pivote
            while(K[j]>pivote) j--; // busca elemento menor que pivote
                if (i<j) { // si no se han cruzado
                    aux= K[i]; // los intercambia
                    K[i]=K[j];
                    K[j]=aux;
                }
            }
            K[izq]=K[j]; // se coloca el pivote en su lugar de forma que se tiene
            K[j]=pivote; // los menores a su izquierda y los mayores a su derecha     
            if(izq<j-1)
                Quicksort(K,izq,j-1); // se ordena el sub-arreglo izquierdo
                    if(j+1 <der)
                        Quicksort(K,j+1,der); // se ordena el sub-arreglo derecho
    }
}
