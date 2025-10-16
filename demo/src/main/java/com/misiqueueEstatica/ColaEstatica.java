package com.misiqueueEstatica;

public class ColaEstatica {

    private int primero;
    private int ultimo;
    private int tamaño; 
    private Cancion[] canciones; 


    public ColaEstatica (int tamaño ) {
     
        this.primero = -1; 
        this.ultimo = -1; 
        this.tamaño = tamaño;
        canciones = new Cancion[tamaño];
    }

    public boolean isVacia(){
        return primero == -1 && ultimo == -1 ;
    }

    public boolean isLlena () {

        return ( (ultimo + 1) % tamaño == primero);
    }

    public void eliminar () {

        if(isVacia()){
            return; 
        }

        if (primero == ultimo){
            primero = ultimo = -1;
        } else {

            // aca  lo mismo es para casos donde el primero sea el "ultimo indice de la cola" entonces cuando lo eliminemos se supone q tiene q volverse al inciio, eso lo logramos con % tamaño
            primero = (primero + 1) % tamaño ; 
        }  


    }
    public void agregar(Cancion c ) {
        if(isLlena()){
            return;
        }else if (isVacia()){
            primero = ultimo = 0;
            canciones[primero] = c;
        } else {

            // aca basicamente es como decir  "el indice donde deberia de ir el siguiente es ultimo + 1 el residuo siempre me dara como tal el mismo INDICE de la suma por ejemplo si quierro insertar desde la pososcion ultima por ejemplo 4 ( mi maximo es 6 elementos ) seria 4+1 = 6 entonces el residuo me devolvera ese 4, siempre, hasta que me tope con   5+1 = 6, entonces ahi es cuando reiniciamos los indices 6 % 6 = 0 entonfces se recinia"


            // cuando hablamos de verificar si esta llena es lo mismo, por ejemplo si ultimo + 1 (simulando insertar otro elemento) % tamañoMaximoDelArreglo == el primero significa que esta llena por qie ? por que supongamos (ejemplo sin eliminar elemetnos) 5 + 1 % 6 = 0, y mi primer elemento esta marcado como 0 entonces mi cola esta llena por que el sigueinte salto seria el primer elemento por lo tanto esta llena
            ultimo = (ultimo + 1 ) % tamaño;
        } 

        canciones[ultimo] = c;
        System.out.println("Elemento insertado correctamente.");

    } 

    public void mostrar () {
        if (isVacia()){return ; } 

        System.out.println("Canciones de la playlist");

        // aca tenemos una auxiliar por que no podemos modificar la variable de instancia ya que debemos de avanzar en uno en uno 
        int aux = primero ;


        while (aux != ultimo){

            System.out.println("La cancion es "+canciones[aux].getNombre()+ " Del artista: "+canciones[aux].getArtista());


            // -- VERSION MENOS OPTIMIZADA PROPIA MIA -- 
            // aux += 1;
            // // if(aux == tamaño){
            // //     aux %= tamaño;  
            // // }

            aux = (aux + 1) % tamaño;


        } 



    }




}
