package com.example;

import java.util.Scanner;

public class ListaExample {
  private Producto[] compras;
  private int espacio;


  public ListaExample(int totProd) {
    this.compras = new Producto[totProd];
    this.espacio = -1;
    
  }

  public void insertar(Producto nuevo){
    if(espacio<compras.length){
        espacio++;
        compras[espacio] = nuevo;
        System.out.println("Se ha insertado el nodo");
    }else{
        System.out.println("Lista llena");
    }
  }

  public void sumarTotal(){

    float total = 0;
    for(int i = 0; i<=espacio; i++){
        if(compras[i].isComprado()){
            total+=compras[i].getTotalCompra();

        }
    
    }
    System.out.println("El total de suma total es: : "+total);

  }

  public int buscar(String nombreProducto){

    for(int i = 0; i<=espacio; i++){
        if(compras[i].getNombre().equalsIgnoreCase(nombreProducto)){
            return i;
            
        }

       
    }
     return -1;
  }
  public void mostrar(){
    String salida = "Los datos de los productos de la lista son: \n";
     for(int i = 0; i<=espacio; i++){
        salida+=compras[i].info();
     }
     System.out.println(salida);
  }

  public void eliminar(String nombPro){
    int pos = buscar(nombPro);
    if(pos!=-1){
      for(int i = pos; i <=espacio; i++){
      compras[i]=compras[i+1];
      espacio--;

      return;
    }
    System.out.println("No se encuentra en la lista");
    }
    
  }
  
  public void comprar(String nombreProducto){
    int pos = buscar(nombreProducto);
    if(pos!= -1){
            compras[pos].setComprado(true);
            System.out.println("Cuanto cuesta el kilo de "+nombreProducto+" ?");
            Scanner scaner = new Scanner(System.in);
            float precio = scaner.nextFloat();
            compras[pos].setTotalCompra(precio*compras[pos].getCantidad());
            return;
         
          
    }
    System.out.println("No es parte de la lista");
  }
}



