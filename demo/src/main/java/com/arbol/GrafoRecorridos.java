package com.arbol;

public class GrafoRecorridos {
    public static void main(String[] args) {
        // Crear un grafo  dirigido con 5 vértices
        int numVertices = 7;
        int[][] grafo = new int[numVertices][numVertices];

        // Agregar aristas al grafo
        /*agregarArista(grafo, 0, 1);
        agregarArista(grafo, 0, 2);
        agregarArista(grafo, 1, 3);
        agregarArista(grafo, 2, 4);*/

        agregarArista(grafo, 3, 1);
        agregarArista(grafo, 3, 2);
        agregarArista(grafo, 1, 4);
        agregarArista(grafo, 2, 5);
        agregarArista(grafo, 5, 4);
        agregarArista(grafo, 4, 0);
        agregarArista(grafo, 4, 3);
        agregarArista(grafo, 4, 6);

        // Imprimir el grafo
        System.out.println("Grafo:");
        imprimirGrafo(grafo);

        // Realizar recorrido en profundidad (DFS)
        System.out.println("\nRecorrido en Profundidad (DFS):");
        //dfs(grafo, 0, new boolean[numVertices]);
        dfs(grafo, 3, new boolean[numVertices]);

        // Realizar recorrido por anchura (BFS)
        System.out.println("\nRecorrido por Anchura (BFS):");
        //bfs(grafo, 0);
        bfs(grafo, 3);
    }

    // Método para agregar una arista al grafo no dirigido
    private static void agregarArista(int[][] grafo, int origen, int destino) {
        grafo[origen][destino] = 1;
        //grafo[destino][origen] = 1; // Para un grafo no dirigido
    }

    // Método para imprimir el grafo
    private static void imprimirGrafo(int[][] grafo) {
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[i].length; j++) {
                System.out.print(grafo[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Recorrido en profundidad (DFS)
    private static void dfs(int[][] grafo, int nodo, boolean[] visitado) {
        System.out.print(nodo + " ");
        visitado[nodo] = true;

        for (int vecino = 0; vecino < grafo.length; vecino++) {
            if (grafo[nodo][vecino] == 1 && !visitado[vecino]) {
                dfs(grafo, vecino, visitado);
            }
        }
    }

    // Recorrido por anchura (BFS)
    private static void bfs(int[][] grafo, int inicio) {
        int[] cola = new int[grafo.length];
        int frente = 0; // Índice del frente de la cola
        int fin = 0;    // Índice del final de la cola
        boolean[] visitado = new boolean[grafo.length];

        cola[fin++] = inicio;
        visitado[inicio] = true;

        while (frente != fin) {
            int nodo = cola[frente++];
            System.out.print(nodo + " ");

            for (int vecino = 0; vecino < grafo.length; vecino++) {
                if (grafo[nodo][vecino] == 1 && !visitado[vecino]) {
                    cola[fin++] = vecino;
                    visitado[vecino] = true;
                }
            }
        }
    }
}
