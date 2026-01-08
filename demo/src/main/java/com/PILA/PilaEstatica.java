package com.PILA;

public class PilaEstatica {
// se caracteriza por Firt input las output primero en entrar ultimo en salir

    // tiene un conjunto de elementos, tiene un tamaño fijo estatico 
    int datos[];
    int tope; 

    public PilaEstatica (int tamaño) {
    
        datos = new int[tamaño];
        this.tope = -1;
    } 

    public boolean estaLLena () {
        return tope == datos.length -1 ; 
    }

    public void push (int dato) {
        if (estaLLena()){
         return;
        } 
        tope++;
        datos[tope] = dato;    
    } 
    public boolean isVacia (){  return tope == -1;}

    public int pop () {
        if (isVacia()){
            return -1;
        }

        
        return datos[tope--];

    }

}
