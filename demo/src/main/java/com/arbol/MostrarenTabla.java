package com.arbol;

import javax.swing.JOptionPane;

public class MostrarenTabla {

    String mos[][] = new String[40][40];
    int col = 39;

    public String[][] mostrar2(Nodo nodo, int eb) {
        if (nodo == null) { // casobase
            return null;
        } else {
            // Recorrido Inverso (Derecha -> Raíz -> Izquierda)
            //Primera llamada siendo arbol binario que recorre a la derecha primero
            mostrar2(nodo.getNodoDerecho(), eb + 1);
            mos[eb][col] = String.valueOf(nodo.getInfo());//inserta datos en la matriz
            col--; // Decrementa la columna para que el árbol se centre o se mueva a la izquierda
             //Segunda llamada siendo arbol binario que recorre a la izquierda
            mostrar2(nodo.getNodoIzquierdo(), eb + 1);
        }
        return mos;
    }

    public String generarCadenaMatriz(String mos[][], int altura) {
        String cadenaTotal = "Representación del Árbol:\n";
        String cadenaFila;
        
        // El bucle de filas debe ir hasta la altura (nivel máximo) del árbol.
        // La matriz se llena desde la fila 0 (raíz) hasta la altura-1.
        for (int i = 0; i < altura; i++) {
            cadenaFila = "";
            for (int j = 0; j < mos[i].length; j++) {
                if (mos[i][j] == null) {
                    cadenaFila += "  "; // Dos espacios para simular el formato
                } else {
                    cadenaFila += String.format("%2s", mos[i][j]) + " "; // Formato para alinear
                }
            }
            cadenaTotal += cadenaFila + "\n";
        }
        return cadenaTotal;
    }
    
    public void imprimirMatriz(String mos[][], int altura) {
        String cadena = generarCadenaMatriz(mos, altura);
        System.out.println(cadena);
    }
    
    public void mostrarEnVentana(String mos[][], int altura) {
        String cadena = generarCadenaMatriz(mos, altura);
        JOptionPane.showMessageDialog(null, cadena, "Árbol Binario de Búsqueda", JOptionPane.PLAIN_MESSAGE);
    }
}