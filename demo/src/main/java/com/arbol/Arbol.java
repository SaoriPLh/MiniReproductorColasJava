/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arbol  ;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Arbol {

    //  Insertar Nodo 
    public Nodo insertar(Nodo actual, int valorInsertar) {
        if (actual == null) {
            actual = new Nodo(valorInsertar);
            System.out.println(actual.getInfo() + " raiz");
        } else {
            if (valorInsertar < actual.getInfo()) {
                actual.setNodoIzquierdo(insertar(actual.getNodoIzquierdo(), valorInsertar));
                System.out.println(actual.getInfo() + " izq");
            } else if (valorInsertar > actual.getInfo()) {
                actual.setNodoDerecho(insertar(actual.getNodoDerecho(), valorInsertar));
                System.out.println(actual.getInfo() + " der");
            }
        }
        return actual;
    }
    public void posorden(Nodo nodo) {
        if (nodo == null) {
            return;
        } else {
            posorden(nodo.getNodoIzquierdo());
            posorden(nodo.getNodoDerecho());
            System.out.print(nodo.getInfo() + " ");
        }
    }   
public void mostrar(Nodo nodo, int nivel) {
        if (nodo == null) {
            return;
        }

        // 1. Recorre el subárbol derecho (lo imprime arriba)
        mostrar(nodo.getNodoDerecho(), nivel + 1);

        // 2. Imprime el prefijo (espacios para el nivel)
        for (int i = 0; i < nivel; i++) {
            System.out.print("    "); // 4 espacios por nivel
        }
        
        // 3. Imprime el valor del nodo actual
        System.out.println("--- " + nodo.getInfo());

        // 4. Recorre el subárbol izquierdo (lo imprime abajo)
        mostrar(nodo.getNodoIzquierdo(), nivel + 1);
    }
public void inordenIterativoLimpio(Nodo nodo) {
    if (nodo == null) return;

    Nodo actual = nodo;
    Nodo padre = null;

    // Ir al nodo más a la izquierda
    while (actual.getNodoIzquierdo() != null) {
        actual = actual.getNodoIzquierdo();
    }

    // Recorrer el árbol
    while (actual != null) {
        System.out.print(actual.getInfo() + " ");

        if (actual.getNodoDerecho() != null) {
            actual = actual.getNodoDerecho();
            while (actual.getNodoIzquierdo() != null) {
                actual = actual.getNodoIzquierdo();
            }
        } else {
            padre = actual.getPadre();
            while (padre != null && actual == padre.getNodoDerecho()) {
                actual = padre;
                padre = padre.getPadre();
            }
            actual = padre;
        }
    }
}

    public void inordenIterativo(Nodo nodo) {
    // Si el nodo es null, el árbol está vacío, así que salgo inmediatamente
    if (nodo == null) return;

    // Creo un puntero 'actual' que apunta al nodo raíz
    // Esto es importante porque si modifico 'nodo' directamente, perdería la referencia original
    Nodo actual = nodo;

    // Declaro una variable 'padre' que usaré más adelante para navegar hacia arriba en el árbol
    Nodo padre = null;

    // FASE 1: Voy al nodo más a la izquierda del árbol
    // Este será el primer nodo que debo imprimir en recorrido inorden
    while (actual.getNodoIzquierdo() != null) {
        actual = actual.getNodoIzquierdo();
    }

    // FASE 2: Recorro todo el árbol hasta que no queden nodos por visitar
    while (actual != null) {

        // Imprimo el valor del nodo actual (esta es la "visita" del nodo)
        System.out.print(actual.getInfo() + " ");

        // CASO 1: Si el nodo actual tiene un hijo derecho
        if (actual.getNodoDerecho() != null) {
            // Me muevo al hijo derecho
            actual = actual.getNodoDerecho();

            // Y desde ahí, bajo hasta el nodo más a la izquierda
            // (porque en inorden, después de visitar un nodo y antes de procesar su subárbol derecho,
            // debo procesar primero el nodo más pequeño de ese subárbol derecho)
            while (actual.getNodoIzquierdo() != null) {
                actual = actual.getNodoIzquierdo();
            }
        }

        // CASO 2: Si el nodo actual NO tiene hijo derecho
        else {
            // Necesito retroceder hacia arriba en el árbol para encontrar el siguiente nodo
            // Obtengo el padre del nodo actual
            padre = actual.getPadre();

            // Subo por el árbol mientras se cumplan dos condiciones:
            // 1. Que exista un padre (no he llegado a la raíz)
            // 2. Que yo (actual) sea el hijo DERECHO de mi padre
            // (esto significa que ya visité a mi padre y su subárbol derecho, debo seguir subiendo)
            while (padre != null && actual == padre.getNodoDerecho()) {
                actual = padre; // Subo un nivel
                padre = padre.getPadre(); // Actualizo el padre para seguir subiendo si es necesario
            }

            // Cuando salgo del ciclo, 'padre' es el siguiente nodo a visitar
            // (o null si ya terminé el recorrido)
            actual = padre;
        }
    }
}

/** Explicación del algoritmo completo:
 * 
 * Este código hace un recorrido **inorden iterativo** (sin recursión) de un árbol binario.
 * El recorrido inorden visita los nodos en orden ascendente.
 * 
 * **La clave del algoritmo:**
 * 1. Empiezo en el nodo más a la izquierda (el más pequeño)
 * 2. Lo visito (imprimo)
 * 3. Si tiene hijo derecho, voy al más izquierdo de ese subárbol
 * 4. Si NO tiene hijo derecho, subo al padre (pero solo si vengo del hijo izquierdo,
 *    porque si vengo del derecho sigo subiendo)
 * 
 * **Ejemplo con el árbol:**
 * 
 *         5
 *        / \
 *       3   7
 *      / \
 *     1   4
 */

    public int altura(Nodo nodo) {
        int izq, der;
        if (nodo == null) {
            return 0;
        }
        der = altura(nodo.getNodoDerecho());
        izq = altura(nodo.getNodoIzquierdo());
        return 1 + (izq > der ? izq : der);
    }
    
    
    public void preorden(Nodo nodo) {
        if (nodo == null) {
            return;
        } else {
            System.out.print(nodo.getInfo() + " ");
            preorden(nodo.getNodoIzquierdo());
            preorden(nodo.getNodoDerecho());
        }
    }

   
    // --- Buscar Elemento ---
    public void buscarElemento(int numero, Nodo p) {
        if (p == null) {
            JOptionPane.showMessageDialog(null, "Valor no hallado");
            return;
        }
        
        if (p.getInfo() == numero) {
            System.out.println("Numero encontrado");
            JOptionPane.showMessageDialog(null, "Numero " + p.getInfo() + " encontrado");
            return;
        } else if (numero > p.getInfo()) {
            buscarElemento(numero, p.getNodoDerecho());
        } else {
            buscarElemento(numero, p.getNodoIzquierdo());
        }
    }

    // --- Eliminar Nodo ---
    public Nodo eliminar(Nodo raiz, int NumeroBli) {
        if (raiz == null) {
            System.out.println("No existe el elemento");
        } else if (NumeroBli < raiz.getInfo()) {
            raiz.setNodoIzquierdo(eliminar(raiz.getNodoIzquierdo(), NumeroBli));
        } else if (NumeroBli > raiz.getInfo()) {
            raiz.setNodoDerecho(eliminar(raiz.getNodoDerecho(), NumeroBli));
        } else { // Encontró el nodo a eliminar
            
            // Caso 1: No tiene hijo izquierdo
            if (raiz.getNodoIzquierdo() == null) {
                raiz = raiz.getNodoDerecho();
            // Caso 2: No tiene hijo derecho
            } else if (raiz.getNodoDerecho() == null) {
                raiz = raiz.getNodoIzquierdo();
            // Caso 3: Tiene ambos hijos
            } else {
                Nodo d = raiz.getNodoIzquierdo();
                Nodo a = null;
                
                while (d.getNodoDerecho() != null) {
                    a = d;
                    d = d.getNodoDerecho();
                }
                
                raiz.setInfo(d.getInfo());
                
                if (a == null) {
                    raiz.setNodoIzquierdo(d.getNodoIzquierdo());
                } else {
                    if(a.getNodoDerecho() == d) {
                        a.setNodoDerecho(d.getNodoIzquierdo());
                    } 
                }
            }
        }
        return raiz;
    }
    
    private void inordenRec(Nodo nodo, List<Integer> elementos) {
        if (nodo == null) {
            return;
        }
        inordenRec(nodo.getNodoIzquierdo(), elementos);
        elementos.add(nodo.getInfo());
        inordenRec(nodo.getNodoDerecho(), elementos);
    }
    
    /**
     * 2. Construye un nuevo árbol perfectamente balanceado a partir de la lista.
     * Toma el elemento central como raíz y repite para los subarreglos.
     */
    private Nodo listaABalanceado(List<Integer> elementos, int inicio, int fin) {
        if (inicio > fin) {
            return null;
        }
        
        // El elemento central será la raíz
        int medio = inicio + (fin - inicio) / 2;
        int valor = elementos.get(medio);
        
        // Crea el nodo, pero NO usamos el método 'insertar' para mantener el balanceo.
        Nodo nodo = new Nodo(valor);
        System.out.println("Creando nodo balanceado: " + valor);

        // Constrúyete recursivamente el subárbol izquierdo y derecho
        nodo.setNodoIzquierdo(listaABalanceado(elementos, inicio, medio - 1));
        nodo.setNodoDerecho(listaABalanceado(elementos, medio + 1, fin));
        
        return nodo;
    }

    /** * 3. Método principal de balanceo (Reemplaza al anterior).
     */
    public Nodo balancear(Nodo nodo) {
        if (nodo == null) {
            return null;
        }
        
        List<Integer> elementosOrdenados = new ArrayList<>();
        
        // Paso 1: Recolectar todos los elementos en orden
        inordenRec(nodo, elementosOrdenados);
        
        // Paso 2: Construir el nuevo árbol balanceado
        if (elementosOrdenados.isEmpty()) {
            return null;
        }
        
        System.out.println("Balanceando el árbol a partir de " + elementosOrdenados.size() + " elementos.");
        
        // Devuelve la nueva raíz del árbol perfectamente balanceado
        return listaABalanceado(elementosOrdenados, 0, elementosOrdenados.size() - 1);
    }
}