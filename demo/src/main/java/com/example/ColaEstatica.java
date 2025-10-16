package com.example;

public class ColaEstatica { 

    // insertar, remover, esta llena, esta vacia - > metodos para estatica y dinamica en las colas 

    private int[] elementos; 
    private int inicio;
    private int fin ; 

    public ColaEstatica (int tamaño) {

        this.elementos = new int[tamaño];
        this.inicio = -1;
        this.fin = -1;
    
    }

    public boolean isLlena(){
        return fin == elementos.length-1;
    }
      public boolean isVacia () {

        return inicio == -1;

    }

    public void remover (){

        if(isVacia()){
           return;
        }

        if(inicio == fin){
           inicio = fin = -1;
        }
        else{
            
           inicio ++;

        }
    }
    // cuando insertamos la insertamos al final 



  
    public void insertarElemento(int elemento) {
    if (isLlena()) {
        return;
    }

    if (isVacia()) {
        inicio = fin = 0;
    } else {
        fin++;
    }

    elementos[fin] = elemento;
}

    

    // cuando liberamos sacamos al de enfrente de la cola osea el inicio 


}
