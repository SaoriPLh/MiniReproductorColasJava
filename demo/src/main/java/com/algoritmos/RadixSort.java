/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estructuradedatosu_5;

import java.util.ArrayList;

public class RadixSort {

    // Método principal que ejecuta Radix Sort
    public static void radixSort(int[] arr) {

        // 1. Encontrar el número con más dígitos
        int max = obtenerMaximo(arr);

        // 2. 'dig' indica el dígito actual: unidades=1, decenas=10, centenas=100 ...
        int dig = 1;

        // Repetir por cada dígito del número más grande
        while (max / dig > 0) {

            // Crear 10 urnas (listas) para los dígitos 0–9
            ArrayList<ArrayList<Integer>> urnas = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                urnas.add(new ArrayList<>()); // urna vacía
            }

            // Distribuir los elementos en las urnas según el dígito actual
            for (int i = 0; i < arr.length; i++) {
                int indiceUrna = (arr[i] / dig) % 10; // extrae el dígito
                urnas.get(indiceUrna).add(arr[i]);
            }

            // Reconstruir el arreglo tomando las urnas en orden 0 → 9
            int j = 0;
            for (int i = 0; i < 10; i++) {
                for (Integer num : urnas.get(i)) {
                    arr[j] = num;
                    j++;
                }
            }

            // Pasar al siguiente dígito (unidades → decenas → centenas)
            dig *= 10;
        }
    }

    // Función para encontrar el número más grande del arreglo
    private static int obtenerMaximo(int[] arr) {
        int max = arr[0];
        for (int n : arr) {
            if (n > max) max = n;
        }
        return max;
    }

    // Mostrar arreglo
    private static void imprimir(int[] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Ejemplos reales de ejecución
    public static void main(String[] args) {

        // EJEMPLO 1: números del PDF
        int[] ejemplo1 = {329, 248, 123, 423, 226, 825, 132, 335, 231, 432, 256, 218};
        System.out.println("Ejemplo 1 (del PDF):");
        imprimir(ejemplo1);
        radixSort(ejemplo1);
        System.out.println("Ordenado con Radix Sort:");
        imprimir(ejemplo1);

        // EJEMPLO 2: ejemplo pequeño (35, 40, 25, 8, 7)
        int[] ejemplo2 = {35, 40, 25, 8, 7};
        System.out.println("\nEjemplo 2 (diapositivas):");
        imprimir(ejemplo2);
        radixSort(ejemplo2);
        System.out.println("Ordenado con Radix Sort:");
        imprimir(ejemplo2);

        // EJEMPLO 3: otro ejemplo generado
        int[] ejemplo3 = {170, 45, 90, 802, 24, 2, 66};
        System.out.println("\nEjemplo 3:");
        imprimir(ejemplo3);
        radixSort(ejemplo3);
        System.out.println("Ordenado con Radix Sort:");
        imprimir(ejemplo3);
    }
}

/*  
    ============================================================
                       EXPLICACIÓN AMPLIA DEL CÓDIGO
                         IMPLEMENTACIÓN RADIX SORT
    ============================================================

    Este programa implementa el algoritmo de ordenamiento 
    conocido como **Radix Sort (Radix Directo)**, tal como se 
    muestra en las diapositivas del tema.

    ❖ ¿Qué es Radix Sort?
      Radix Sort es un algoritmo de ordenamiento estable que 
      funciona organizando los números por **dígitos**, empezando 
      desde el dígito de las **unidades**, luego las **decenas**, 
      después las **centenas**, y así sucesivamente hasta que todos 
      los dígitos hayan sido procesados.

      Es especialmente útil para ordenar números enteros, pues no 
      realiza comparaciones entre ellos, sino clasificaciones por 
      cada posición decimal.

    ------------------------------------------------------------
    ❖ IDEA PRINCIPAL DEL ALGORITMO (Radix Directo)
    ------------------------------------------------------------

    1. Se identifica cuántos dígitos tiene el número más grande en 
       el arreglo. Esto sirve para saber cuántas pasadas se deben 
       realizar.

    2. Se crean **10 urnas** (listas o "canastas"), una por cada 
       posible dígito: 0, 1, 2, 3, 4, 5, 6, 7, 8 y 9.

    3. En cada pasada, se toma un dígito específico:
           • 1ª pasada → unidades (dig = 1)
           • 2ª pasada → decenas   (dig = 10)
           • 3ª pasada → centenas  (dig = 100)
         Y así sucesivamente...

    4. Cada número del arreglo se coloca dentro de su urna 
       correspondiente según el dígito que se está analizando.
       Ejemplo: si estamos en las unidades y el número es 248,
       entonces (248 / 1) % 10 = 8 → va a la urna 8.

    5. Después de llenar las urnas, se reconstruye el arreglo
       tomando los valores en orden:
           urna 0 → urna 1 → urna 2 → ... → urna 9
       Esto garantiza el orden estable.

    6. Se incrementa el valor de "dig" multiplicándolo por 10 para 
       pasar al siguiente dígito (unidades → decenas → centenas).

    ------------------------------------------------------------
    ❖ RELACIÓN CON EL PSEUDOCÓDIGO DE LAS DIAPOSITIVAS
    ------------------------------------------------------------

    El pseudocódigo menciona:

        Crear urnas (0 al 9)
        Dig = 1
        repetir hasta máximo de dígitos:
            limpiar urnas
            distribuir elementos según (valor / dig) % 10
            recopilar valores en orden
            dig = dig * 10

    Este programa sigue exactamente esa lógica:
        • Usa ArrayList para representar las urnas.
        • Aplica la fórmula (valor / dig) % 10 para obtener el dígito.
        • Recorre las urnas en orden ascendente para reconstruir el arreglo.
        • Usa un bucle while para repetir el proceso tantas veces como dígitos tenga el número mayor.

    ------------------------------------------------------------
    ❖ MÉTODOS PRINCIPALES DEL CÓDIGO
    ------------------------------------------------------------

    ➤ obtenerMaximo(arr)
        • Recorre el arreglo y devuelve el número más grande.
        • Permite determinar cuántas veces se repetirá el ordenamiento.

    ➤ radixSort(arr)
        • Implementa Radix Sort completo.
        • Crea las urnas.
        • Distribuye los números según el dígito.
        • Reconstruye el arreglo después de cada pasada.
        • Avanza al siguiente dígito multiplicando dig por 10.

    ➤ imprimir(arr)
        • Muestra el arreglo en pantalla para seguir la ejecución.

    ➤ main()
        • Incluye 3 ejemplos de prueba, incluyendo los mismos 
          valores utilizados en las diapositivas (329, 248, 123, etc.)
          para demostrar que el código produce exactamente el 
          mismo resultado.

    ------------------------------------------------------------
    ❖ RESUMEN FINAL
    ------------------------------------------------------------

    Este código es una implementación fiel del Radix Sort visto en 
    clase, aplicando el concepto de distribuir y recolectar números 
    según cada dígito decimal, desde unidades hasta el dígito más 
    significativo.

    Gracias a la estructura de urnas y pasadas sucesivas, el 
    ordenamiento es estable y muy eficiente para listas de números 
    enteros.

    ============================================================
*/
