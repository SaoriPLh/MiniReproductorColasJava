package com.example;


public class LIstita {
 // C A S E = herramientas asisitidas por computadora para ing. software  
    private Nodito primero,ultimo;

    public void insertar(Nodito nuevoNodo){

      
        if(primero == null){
            primero = nuevoNodo;
            ultimo = primero;
            
        }else {
             ultimo.setSig(nuevoNodo);
             ultimo = nuevoNodo;
        }
    }


//investigar parche para vs code q me genere el diagrama de secuencia y clases
//¿por quee cuando usamos autixilares no primero muevo el elemento indice y luego el auziliar por ejemplo en el ordenaminto burbuja es decir si muevi ek eklemento para delante se queda en null el q viene atras? ?



    public void eliminar(String nombrePais){

        Nodito aux1= primero, aux2=null;
        if(nombrePais.equalsIgnoreCase(aux1.getIfo().getNombre())){
            primero = primero.getSig();
            return;
        }
        while (aux1!=null) {

            if(!nombrePais.equalsIgnoreCase(aux1.getIfo().getNombre())){
                aux2 = aux1;
                aux1 = aux1.getSig();
            }else{
                System.out.println();
                aux2.setSig(aux1.getSig());
                if(aux2.getSig()==null){
                ultimo =  aux2;
                }
                return;
            
            }
            
        }

        System.out.println("No existe ese pais");
    }

    public void buscar (String nombrePais){

        Nodito aux = primero;
        while(aux!=null){
            if(nombrePais.equalsIgnoreCase(aux.getIfo().getNombre())){
                System.out.println(aux.getIfo().getCapital());
                return;
            }else{
                aux=aux.getSig();
            }

            System.out.println("No existe este pais");
        }
    }


    public void mostrar(){ 
        Nodito aux = primero;

        while(aux!=ultimo){

            System.out.println(aux.getIfo().getNombre());
            aux=aux.getSig();
        
        }
    }
}
