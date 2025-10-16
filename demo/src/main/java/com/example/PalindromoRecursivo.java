package com.example;

public class PalindromoRecursivo {
    public static void main(String[] args) {

    String palabra = "galleta";
    System.out.println("La palabra es " + palabra + " Palindromo:  " +
                   isPalindromoRecursivo(palabra, "", palabra));

    }
    public static boolean isPalindromoRecursivo(String palabra, String alReves, String original) {


        
        if (palabra.length() <1) {

            return alReves.equalsIgnoreCase(original);
        }

        alReves += palabra.charAt(palabra.length() - 1);


        return isPalindromoRecursivo(palabra.substring(0, palabra.length() - 1), alReves, original);
    }
}
