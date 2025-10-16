package com.example;

public class PilaEstatica {

    private int[]pila;
    private int top;

// pila con memoria dinamica (listas) clase nodo por que tope es el primer nodo ? es por que asi se recorre la lista ? por que el tope es el nuevo nodo ? el tope de una lista dinamica es el ultimo elemento no ? diferencia con arreglo pila donde es el ultimo pero primero 
    public PilaEstatica(int capacidad){

        pila = new int[capacidad];
        top = -1;
    }
    public static void main(String[] args) {
        
    }

    public boolean isEmpty(){
        return top == -1;
    } 

    public boolean isFull(){
        return top == pila.length-1;
    }

    public void push ( int elemento){
        if(isFull()){
            System.out.println("la pila esta llena no se puede insertar");
            return;
        }

        top ++;
        pila[top] = elemento;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("la pila esta vacia no se puede extraer");
            return -1;
        }

        // int elemento = pila[top];
        // top--;
        // return elemento;   // practicar cosas asi para hacer mas reducido el codigo (logica y sintaxis)
        return pila[top--];  
    }

    public void display(){
        if(isEmpty()){
            System.out.println("la pila esta vacia");
            return;
        }

        System.out.println("Contenido de la pila desde el tope hacia abajo");
        for (int i = top; i >= 0; i--) {
            System.out.println(pila[i]);
            
        }
    }
}
