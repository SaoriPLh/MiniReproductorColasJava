package com.example;

import java.util.Random;
import java.util.Scanner;

public class SumaRecursiva {

    public static int primero = 0;
    public static int segundo = 1;
    public static long sumaR;
    public static long sumaI;
    public static String tablaFinal;




    public static int fibonacciRecursivo ( int n ){

        if( n<= 1){
            return n ;
        }

        return fibonacciRecursivo(n-1)+ fibonacciRecursivo(n-2);
       
    }


 //1234
    public static int sumaDigitos ( int digitos){

        if(digitos<10){ //
            return digitos;
        }
            //2+  1 = 3 <-- lo que nos retorno la ultima funcion
            //3+   3  = 6 <-- lo que nos retorno la ultima
            //4+  6 = 10
        System.out.println("Valor de sumaDigitos/10 "+digitos/10);
        return (digitos%10) + sumaDigitos(digitos/10);
    }

    public static int pontenciaRecursiva ( int base, int pontencia){

        // consiste en basicamente tomar la base  y multiplicarla por si misma n veces ( potencia )

        // por lo que debemos de llevar el contador de veces que seria p

        //1
        // 10

        if( pontencia == 1){
            return base;
        }

        return base * pontenciaRecursiva(base, pontencia-1);
    }





    public static int buscar( int a[], int dato , int i){

        if(i > a.length -1){
            return -1;
        }

        else {
            if (a[i] == dato) {
                return i ;
            }
            else{
                return buscar(a, dato, i+1);
            }
        }
    }



    public static void fibonacci ( int nVeces ){

        //caso base cuando nos detenemos


        if( nVeces == 0){
            return ;
        }
        else{

            System.out.println(primero+"");
            int siguiente = primero +segundo;
            primero = segundo;
            segundo = siguiente;
            fibonacci(nVeces-1);
        }
    }

    public static void main(String[] args) {

    String palabra = "galleta";
    System.out.println("La palabra es " + palabra + " Palindromo:  " +
                   isPalindromoRecursivo(palabra, "", palabra));

    }











// System.out.println(tabla(5,6));
//     System.out.println(espejo( "abccba")); // true

// System.out.println(tabla(5, 10));
    //    System.out.println( fibonacciRecursivo(5));
// tabla(5, 10);

        // System.out.println(sumaDigitos(1234));

    //     int primero = 0;
    //     int segundo = 1;
    // for( int i = 0; i < 10; i ++){

    //     System.out.println( primero+ "");

    //     int siguiente = primero + segundo;

    //     primero = segundo;
    //     segundo = siguiente;


    // }


    // fibonacci(10);


    //     long min = 1_000_000;
    //     long max = 10_000_000;
    //     final int iteraciones = 1;
    //     Random r = new Random();

    // for (int i = 0; i < iteraciones; i++) {
    //     long n = r.nextLong(min, max + 1);
    //     System.out.println("N:" +n);
    //     simulacion(n);
    // }



    //dividimos entre milisegundos despues porque para empezar nano sgundos me da mas exacto ya que si lo haacemos directamente con milisrgundos la operacion com otal del algoritmo es en si mas rappida entonces milisegundos pues nos redondea a milisegundos que en ambos casos es 0 el tiempo que se toma en miluisegundos entonces por eso manualmente lo dividimos entre milisefundos tomando en cuenta los double los decimales ya que directamente con milisegundos no nos da eso que es lo importante por eso lo hacemos manual con decimales con duble para mayor precicion, en si cambiamos todo a manual
        // DOUBLE POR QUE NECEISTAMOS LOS DECIMALES PARA MAS EXACTITUD
        // double promedioR = sumaR / 1000_000.0 / iteraciones; // 1000 iteraciones
        // double promedioI = sumaI / 1000_000.0 / iteraciones;



        // System.out.println( (promedioI < promedioR ) ? "Mas eficiente Iterativo promedio "+promedioI: "mas eficiente Recursivo promedio "+promedioR);




        // Scanner consola = new Scanner(System.in);


        // int n = consola.nextInt();
        // int suma = 0 ;

        // for ( int i = 1; i <= n; i++ ){
        //         suma += i;

        // }

        // System.out.println(suma);

        //sacar el promedio de por lo menos 10 o mil veces ded cada algoritmo para ver cual es el mas eficiente






    



public static boolean espejo(String palabra) {
    int len = palabra.length();
    String primeraMitad = palabra.substring(0, len / 2);
    String segundaMitad;

    // Dividir la palabra en segunda mitad, saltando el carácter central si es impar
    if (len % 2 == 0) {
        segundaMitad = palabra.substring(len / 2);
    } else {
        segundaMitad = palabra.substring(len / 2 + 1);
    }

    // Invertir la segunda mitad
    StringBuilder sb = new StringBuilder(segundaMitad);
    segundaMitad = sb.reverse().toString();

    // Comparar la primera mitad con la segunda mitad invertida
    return primeraMitad.equals(segundaMitad);
}


     public static String tabla(int n, int i) {
    System.out.println("Entrando con valor " + i);

    // Caso base
    if (i == 1) {
        return String.format("%d * %d = %d ", n, i, n*i);
    }

    // Llamada recursiva + concatenación
    return String.format("%d * %d = %d ", n, i, n*i) + tabla(n, i-1);
}

public static void factoresIterativo(long n ){ // de preferencia sin sout ysin mensajes porque las operaciones son rapidas si meto lo demas q es mas pesado estaria midiendo quien imprime mas rapido

    String mensaje = "";
    while(n > 0){

        mensaje = n%10+"-"+mensaje;  //checar esto

        n/=10;
    }
}

public static void factoresRecursivo(long numero, String mensaje){



if(numero >0 ){
    factoresRecursivo(numero/10,mensaje);
    mensaje = numero%10+"-"+mensaje;
}

System.out.println(mensaje);


}


public static void simulacion(long n){

    long inicio = System.nanoTime();
    factoresRecursivo(n,"");
    long fin = System.nanoTime();
    sumaR += fin - inicio;

    long inicioIterativo = System.nanoTime();
    factoresIterativo(n);
    long finIterativo = System.nanoTime();
    sumaI += finIterativo - inicioIterativo;










}

  // 345    543
    public static int esPalindromoRecursivo ( int numero,int reves){

// 12321
    if( numero == 0){ //CASO BASE
        return reves;
    }

    int residuo = numero %10;  // 345 / 10  = 34
    reves = (reves*10)+residuo;


    return esPalindromoRecursivo(numero/10,reves);

}


public static boolean isPalindromoRecursivo(String palabra, String alReves, String original) {


    
    if (palabra.length() <1) {

        return alReves.equalsIgnoreCase(original);
    }

    alReves += palabra.charAt(palabra.length() - 1);


    return isPalindromoRecursivo(palabra.substring(0, palabra.length() - 1), alReves, original);
}




public static boolean isPalin ( int n){
    int invertido = esPalindromoRecursivo(n, 0);
    return invertido == n;
}












  public static int esPalindromoRecursivoPrueba(int numero, int reves) {
    if (numero == 0) { // caso base -- > Hasta cuando termina la recursividad hasta cuando , dejo de llamar a mi funcion, hasta cuando termina este proceso
        return reves;
    }

    int residuo = numero % 10;
    reves = (reves * 10) + residuo;

    return reves + esPalindromoRecursivoPrueba(numero / 10, reves);  // recursividad
}






        public static boolean esPalindromo ( int n ){

            int numeroReves = 0;
            int original =  n;


            while(n>0){

            int residuo = n %10;
            numeroReves =( numeroReves*10)+residuo;
            n = n/10;

            }

            return numeroReves == original;

        }



        // vamos a convertirla en una funcion recursiva


        //preguntas q hacernos:  ¿Cual ?
    // leer un valor entero y calcujlar e imprimir su pontencia sin utilizar math.pow


public static int potencia ( int base, int potencia){


    if( potencia ==1){
        return base;
    }



    return base * potencia(base, potencia-1);
}




   public static int sumaRecursiva(int n) {
    // Caso base
    if (n <= 0) return 0;

    // Paso recursivo
    return n + sumaRecursiva(n - 1);
}




//factorial de un numero explicitamente


// public static int fac ( int n ){

// int factorial = 1;
//     for( int i = n; i >=1; i --){

// // 5... 5,4,3,2,1    <-- valor de i en las iteraciones
//         factorial *= i;


//     }

//     return factorial;
// }
//descomponer un numero en sus factores
// public static int factores (int numero, int factor) {


//     if( numero == 0){
//         return numero;



//     }

//     int residuo = numero/factorz
//     System.out.println(numero);

//    return  factores(numero/factor, factor);



// }


//descomponer un numero en sus factores















public static  void factores (int numero) {


    if( numero == 0){
        return  ;



    }else{

        System.out.println(numero%10);

         factores(numero/10);

    }






























}}
