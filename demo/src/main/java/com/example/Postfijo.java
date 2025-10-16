package com.example;

import java.util.Stack;
// Replicar con algoritmo de pila manual la clase de la pila

// insertar, remover, esta llena, esta vacia - > metodos para estatica y dinamica en las colas 

// cola circular como controlarla en memoria dinamica y estatica

// sobre el procesador y sus procesos del sistema y del usuario flujo en el que lo realizas
public class Postfijo {
     // Método para obtener la precedencia de los operadores
    private static int obtenerPrecedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    // Método para verificar si un carácter es un operador
    private static boolean esOperador(char caracter) {
        return caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/';
    }

    // Método para convertir expresión infija a posfija
    public static String convertirInfijaAPosfija(String expresionInfija) {
        StringBuilder expresionPosfija = new StringBuilder();
        Stack<Character> pila = new Stack<>();

        for (char caracter : expresionInfija.toCharArray()) {
            if (Character.isLetterOrDigit(caracter)) {
                // Si quieres separar números de múltiples dígitos, agrega un espacio después
                expresionPosfija.append(caracter);
            } else if (caracter == '(') {
                pila.push(caracter);
            } else if (caracter == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    expresionPosfija.append(pila.pop());
                }
                if (!pila.isEmpty()) pila.pop(); // sacar '(' de la pila
            } else if (esOperador(caracter)) {
                while (!pila.isEmpty() && obtenerPrecedencia(caracter) <= obtenerPrecedencia(pila.peek())) {
                    expresionPosfija.append(pila.pop());
                }
                pila.push(caracter);
            } else if (Character.isWhitespace(caracter)) {
                // Ignorar espacios
                continue;
            } else {
                // Caracter no reconocido: puedes manejar errores aquí si lo deseas
            }
        }

        while (!pila.isEmpty()) {
            expresionPosfija.append(pila.pop());
        }

        return expresionPosfija.toString();
    }

    public static void main(String[] args) {
        String expresionInfija = "((A+B)*C-D)/(E+F)*10";
        System.out.println("Expresión infija: " + expresionInfija);

        String expresionPosfija = convertirInfijaAPosfija(expresionInfija);
        System.out.println("Expresión posfija: " + expresionPosfija);
    }


    // Metodo para evaluar si es un operador 



    // 
}
