package com.grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class grafo {
    private Map<String, List<String>> adyacencia;

    public grafo () {
        this.adyacencia = new HashMap<>();
    } 

    public void agregarArista(String origen, String destino) {
    // Si el vértice origen no existe, lo creamos
    if (!adyacencia.containsKey(origen)) {
        adyacencia.put(origen, new ArrayList<>());
    }

    // Si el vértice destino no existe, también lo creamos
    if (!adyacencia.containsKey(destino)) {
        adyacencia.put(destino, new ArrayList<>());
    }

    // Agregamos la conexión en ambos sentidos (grafo no dirigido)
    adyacencia.get(origen).add(destino);
    adyacencia.get(destino).add(origen);
}

    
}
