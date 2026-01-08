package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.stream.IIOByteBuffer;

public class PruebaAmazon {

    

    public static void main(String[] args) {
        

    }

    public List<Integer> vuelos (List<Integer> peliculasDuracion, int duracionVuelo){
        List<Integer> listaFinal = new ArrayList<>();

        int totalPeliculas = duracionVuelo - 30; // por ejemplo si el vuelo dura 90 min entonces la combinacion de duraciones de peliculas me debe de dar 70 para q cumpla con el requisito

        // 60 
        // --Entrada-- : [1,10,25,35,60]

        // entonces lo que planeo hacer es restar 60 - valor del elemento del arreglo y buscar si existe ese que falta por ejemplo 
        // 60 - 1 = 59 y no existe entonces 
        // 60 - 10 = 50 entonces no esta por lo tanto no es valida
        // 60 - 25 = 35 y si esta es la solucion y deberiamos devolver la solucion 

        for (int i = 0; i < peliculasDuracion.size(); i++) {

            int valorBuscado = totalPeliculas - peliculasDuracion.get(i);
            
            for (int j = i +1; j < peliculasDuracion.size(); j++) {
                if (valorBuscado == peliculasDuracion.get(i)) {

                    listaFinal.add(peliculasDuracion.get(i));
                    listaFinal.add(peliculasDuracion.get(j));
                    return listaFinal;
                } 
                
            } 
            
        }

        listaFinal.add(-1);
        listaFinal.add(-1);
        return listaFinal;

    } 

    public List<Integer> vuelosMejorOpcion(List<Integer> peliculasDuracion, int duracionVuelo) {
    List<Integer> listaFinal = new ArrayList<>();
    int totalPeliculas = duracionVuelo - 30;
    Set<Integer> vistos = new HashSet<>();

    for (int duracion : peliculasDuracion) {
        int complemento = totalPeliculas - duracion;
        if (vistos.contains(complemento)) {
            listaFinal.add(duracion);
            listaFinal.add(complemento);
            return listaFinal;
        }
        vistos.add(duracion);
    }

    listaFinal.add(-1);
    listaFinal.add(-1);
    return listaFinal;
}


public boolean movimientosValidos(int[][] matriz) {

    // Arreglo para guardar las posibles posiciones de cada robot
    // cada fila representa un robot, y cada columna una posible posición
    int[][] posicionesPosibles = new int[matriz[0].length][3];

    // recorremos el primer arreglo (tiempo t)
    int robotIndex = 0;

    for (int j = 0; j < matriz[0].length; j++) {
        if (matriz[0][j] == 1) {
            // añadimos las posiciones posibles para este robot
            asignarPosiblesMovimientos(robotIndex, j, posicionesPosibles, matriz[0].length);
            robotIndex++;
        }
    }

    // ahora verificamos la siguiente fila (tiempo t+1)
    int[] siguiente = matriz[1];

    // verificamos si las posiciones posibles de cada robot coinciden con un 1
    boolean valido = true;

    for (int r = 0; r < robotIndex; r++) {
        int p1 = posicionesPosibles[r][0];
        int p2 = posicionesPosibles[r][1];
        int p3 = posicionesPosibles[r][2];

        // si ninguna de las posiciones posibles del robot tiene un 1 → no válido
        if (!(siguiente[p1] == 1 || siguiente[p2] == 1 || siguiente[p3] == 1)) {
            valido = false;
            break;
        }
    }

    return valido;
}

public void asignarPosiblesMovimientos(int indiceRobot, int posicion, int[][] posicionesPosibles, int longitud) {
    // calculamos las posiciones posibles del robot actual y las guardamos en el arreglo

    int izquierda = posicion - 1 < 0 ? 0 : posicion - 1;
    int misma = posicion;
    int derecha = posicion + 1 >= longitud ? longitud - 1 : posicion + 1;

    posicionesPosibles[indiceRobot][0] = izquierda;
    posicionesPosibles[indiceRobot][1] = misma;
    posicionesPosibles[indiceRobot][2] = derecha;
}

}
