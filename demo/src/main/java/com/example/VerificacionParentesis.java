package com.example;

import java.util.Stack;

class VerificacionParentesis {
    public static void main(String arg[]) {
        String cadenaNo = "(Cadena no equilibrada en paréntesis(()()()))))";
        String cadenaSi = "(Cadena equilibrada en paréntesis())";
        System.out.println("Verificación equilibrado en paréntesis para cadenaNo:");
        System.out.println(verificaParentesis(cadenaNo));
        System.out.println("Verificación equilibrado en paréntesis para cadenaSi:");
        System.out.println(verificaParentesis(cadenaSi));
    }

    public static boolean verificaParentesis(String cadena) {
        Stack<String> pila = new Stack<String>();
        int i = 0;
        while (i < cadena.length()) { // Se recorre la expresión carácter a carácter
            if (cadena.charAt(i) == '(')
                pila.push("("); // Si el paréntesis es de apertura apilamos siempre
            else if (cadena.charAt(i) == ')') { // Si el paréntesis se realizan las siguientes acciones
                if (!pila.empty())
                    pila.pop(); // Si la pila no está vacía se vacía la pila
                else {
                    pila.push(")");
                    break;
                } // La pila no puede empezar con un cierre, apilamos y salimos
            }
            i++;
        }
        return pila.empty() ? true : false;
    }
}
