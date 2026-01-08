package com.arbol; 

public class Main {

    static int op;
    Nodo raiz = null;

    public int Menu() {
        String Opciones = "MENU: \nSelecciona una opción: ";
        Opciones += "\n1. Insertar elementos";
        Opciones += "\n2. Listar elementos";
        Opciones += "\n3. Buscar un Elemento";
        Opciones += "\n4. Impresion pre-orden";
        Opciones += "\n5. Impresion in-orden";
        Opciones += "\n6. Impresion post-orden";
        Opciones += "\n7. Eliminar elemento";
        Opciones += "\n8. Balanceo";
        Opciones += "\n9. Salir";
        
        do {
            // Llama a 'entero' directamente porque está en el mismo paquete
            op = EntradaVentana.entero(Opciones); 
        } while (op < 1 || op > 9);
        return op;
    }

    public void eligeOpciones() {
        // Llama a 'Arbol' y 'MostrarenTabla' directamente
        Arbol ob = new Arbol();
        MostrarenTabla obm;
        
        // Valores de prueba para el árbol
        //int v[] = {35, 80, 99, 12, -5, 100, 75, 17, 20}; 
        int v[] = {7,2, 9, 8, 1, 5, 3, 4, 20,17,15,16,45,38,42,39}; 

        while ((op = Menu()) != 9) {
            switch (op) {
                case 1:
                    for (int i = 0; i < v.length; i++) {
                        raiz = ob.insertar(raiz, v[i]);
                    }
                    System.out.println("Elementos agregados!");
                    break;
                case 2:
                    System.out.println("Elementos en forma de Arbol son: ");
                    ob.mostrar(raiz, 0); // Muestra el árbol de forma lateral en consola
                    System.out.println("Su altura es: " + ob.altura(raiz));
                    
                    obm = new MostrarenTabla();
                    obm.mostrarEnVentana(obm.mostrar2(raiz, 0), ob.altura(raiz));
                    break;
                case 3:
                    int dato = EntradaVentana.entero("Numero a Buscar");
                    ob.buscarElemento(dato, raiz);
                    break;
                case 4:
                    System.out.println("\nPre-orden: ");
                    ob.preorden(raiz);
                    break;
                case 5:
                    System.out.println("\nIn-Orden: ");
                    ob.inordenIterativo(raiz);
                    break;
                case 6:
                    System.out.println("\nPos-orden: ");
                    ob.posorden(raiz);
                    break;
                case 7:
                    int A = EntradaVentana.entero("Número a eliminar");
                    raiz = ob.eliminar(raiz, A);
                    System.out.println("Elemento eliminado (si existía).");
                    break;
                case 8:
                    raiz = ob.balancear(raiz);
                    System.out.println("Elementos del Arbol después del balanceo: ");
                    ob.mostrar(raiz, 0); // Muestra el árbol de forma lateral en consola
                    System.out.println("Su altura es: " + ob.altura(raiz));
                    
                    obm = new MostrarenTabla();
                    obm.mostrarEnVentana(obm.mostrar2(raiz, 0), ob.altura(raiz));
                    break;
            } 
        } 
    } 

    public static void main(String[] a) {
        Main m = new Main();
        m.eligeOpciones();
    }
}