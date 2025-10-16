package com.example;

import java.util.Arrays;
import java.util.Scanner;

public class Recursividad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalCorgis = sc.nextInt();  // número de elementos

        // Guardamos los atributos de cada corgi en arreglos paralelos
        int[] altura = new int[totalCorgis];
        int[] energia = new int[totalCorgis];
        int[] carisma = new int[totalCorgis];

        for (int i = 0; i < totalCorgis; i++) {
            altura[i] = sc.nextInt();
            energia[i] = sc.nextInt();
            carisma[i] = sc.nextInt();
        }

        System.out.println("Corgis iniciales:");
        for (int i = 0; i < totalCorgis; i++) {
            System.out.println("Corgi " + i + ": Altura=" + altura[i] + ", Energia=" + energia[i] + ", Carisma=" + carisma[i]);
        }

        // Creamos un arreglo con los índices para ordenar sin perder referencias
        Integer[] indices = new Integer[totalCorgis];
        for (int i = 0; i < totalCorgis; i++) {
            indices[i] = i;
        }

        // Ordenamos por altura, luego por energía y finalmente por carisma
        Arrays.sort(indices, (i, j) -> {
            if (altura[i] != altura[j]) return altura[i] - altura[j];
            if (energia[i] != energia[j]) return energia[i] - energia[j];
            return carisma[i] - carisma[j];
        });

        System.out.println("\nIndices después de ordenar (por altura, energia, carisma): " + Arrays.toString(indices));
        System.out.println("Corgis ordenados:");
        for (int i = 0; i < totalCorgis; i++) {
            int idx = indices[i];
            System.out.println("Corgi " + idx + ": Altura=" + altura[idx] + ", Energia=" + energia[idx] + ", Carisma=" + carisma[idx]);
        }

        // dp[k] = longitud máxima de cadena terminando en el corgi indices[k]
        int[] maxCadenaHasta = new int[totalCorgis];
        Arrays.fill(maxCadenaHasta, 1);

        // Calculamos la longitud máxima paso a paso
        for (int i = 0; i < totalCorgis; i++) {
            int idxActual = indices[i];
            for (int j = 0; j < i; j++) {
                int idxPrevio = indices[j];
                if (energia[idxPrevio] < energia[idxActual] &&
                    carisma[idxPrevio] < carisma[idxActual]) {
                    maxCadenaHasta[i] = Math.max(maxCadenaHasta[i], maxCadenaHasta[j] + 1);
                    System.out.println("Corgi " + idxPrevio + " -> Corgi " + idxActual + " | maxCadenaHasta[" + i + "] ahora es " + maxCadenaHasta[i]);
                }
            }
        }

        System.out.println("\nMax cadena hasta cada corgi: " + Arrays.toString(maxCadenaHasta));

        // Calculamos la respuesta final
        int longitudMaxima = 0;
        for (int longitud : maxCadenaHasta) {
            longitudMaxima = Math.max(longitudMaxima, longitud);
        }

        System.out.println("\nLongitud máxima de cadena: " + longitudMaxima);
    }
}
