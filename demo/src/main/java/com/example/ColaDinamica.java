package com.example;

public class ColaDinamica {


    private NodoCola primero;
    private NodoCola ultimo;




    public ColaDinamica (){

        this.primero = null;
        this.ultimo = null;
    }


    public boolean isVacia () {

        return primero == null;
    }
    public void insertar(NodoCola nodo){

        if(isVacia()){
            primero = nodo;
            
            ultimo = nodo;
        }
        else{

            ultimo.setSig(nodo);
            ultimo = nodo;
        }


    }

    public void eliminar () {

    if(isVacia()){
        return;
    }

    primero = primero.getSig();

    if(primero == null){  
        ultimo = null;
    }
}

    

}
