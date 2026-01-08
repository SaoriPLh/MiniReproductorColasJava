/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arbol;

import javax.swing.JOptionPane;

public class EntradaVentana {

    public static int entero(String mensaje) {
        String entrada;
        int numero = 0;
        boolean esValido = false;

        while (!esValido) {
            try {
                entrada = JOptionPane.showInputDialog(mensaje);
                
                if (entrada == null) {
                    return 9; 
                }
                
                numero = Integer.parseInt(entrada);
                esValido = true; 
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero.", "Error de formato", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return numero;
    }
}