package com.example;

public class PruebaPILALIFO {
    public static void main(String[] args) {
        PilaLIFO pila = new PilaLIFO(5);

        pila.push(10);
        pila.push(20);
        pila.push(30);

        System.out.println("Contenido de la pila después de inserciones:");
        pila.display();

        int elementoExtraido = pila.pop();
        System.out.println("Elemento extraído: " + elementoExtraido);

        System.out.println("Contenido de la pila después de extracción:");
        pila.display();
    }
}
