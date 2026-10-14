/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa2;

public class Actividad4 {

    // LISTA DOBLEMENTE ENLAZADA

    static class NodoDoble {
        String codigo;
        String solicitud;
        NodoDoble anterior;
        NodoDoble siguiente;

        public NodoDoble(String codigo, String solicitud) {
            this.codigo = codigo;
            this.solicitud = solicitud;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    static class ListaDoble {
        NodoDoble cabeza;
        NodoDoble cola;

        public ListaDoble() {
            cabeza = null;
            cola = null;
        }

        public void insertarFinal(String codigo, String solicitud) {
            NodoDoble nuevo = new NodoDoble(codigo, solicitud);

            if (cabeza == null) {
                cabeza = nuevo;
                cola = nuevo;
            } else {
                cola.siguiente = nuevo;
                nuevo.anterior = cola;
                cola = nuevo;
            }
        }

        public void mostrarAdelante() {
            NodoDoble actual = cabeza;

            System.out.println("\nRECORRIDO HACIA ADELANTE:");

            if (actual == null) {
                System.out.println("La lista esta vacia.");
                return;
            }

            while (actual != null) {
                System.out.println(
                    actual.codigo + " - " + actual.solicitud
                );
                actual = actual.siguiente;
            }
        }

        public void mostrarAtras() {
            NodoDoble actual = cola;

            System.out.println("\nRECORRIDO HACIA ATRAS:");

            if (actual == null) {
                System.out.println("La lista esta vacia.");
                return;
            }

            while (actual != null) {
                System.out.println(
                    actual.codigo + " - " + actual.solicitud
                );
                actual = actual.anterior;
            }
        }
    }

    // LISTA CIRCULAR

    static class NodoCircular {
        String codigo;
        String solicitud;
        NodoCircular siguiente;

        public NodoCircular(String codigo, String solicitud) {
            this.codigo = codigo;
            this.solicitud = solicitud;
            this.siguiente = null;
        }
    }

    static class ListaCircular {
        NodoCircular ultimo;

        public ListaCircular() {
            ultimo = null;
        }

        public void insertarFinal(String codigo, String solicitud) {
            NodoCircular nuevo = new NodoCircular(codigo, solicitud);

            if (ultimo == null) {
                ultimo = nuevo;
                nuevo.siguiente = nuevo;
            } else {
                nuevo.siguiente = ultimo.siguiente;
                ultimo.siguiente = nuevo;
                ultimo = nuevo;
            }
        }

        public void mostrar() {
            System.out.println("\nRECORRIDO DE LA LISTA CIRCULAR:");

            if (ultimo == null) {
                System.out.println("La lista esta vacia.");
                return;
            }

            NodoCircular primero = ultimo.siguiente;
            NodoCircular actual = primero;

            do {
                System.out.println(
                    actual.codigo + " - " + actual.solicitud
                );
                actual = actual.siguiente;
            } while (actual != primero);

            System.out.println("El ultimo nodo vuelve al primero.");
        }
    }

    // METODO PRINCIPAL

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println(" ACTIVIDAD 4: LISTAS ENLAZADAS");
        System.out.println("====================================");

        // LISTA DOBLEMENTE ENLAZADA

        System.out.println("\nCASO 1: LISTA DOBLEMENTE ENLAZADA");
        System.out.println(
            "Permite revisar solicitudes hacia adelante y hacia atras."
        );

        ListaDoble listaDoble = new ListaDoble();

        listaDoble.insertarFinal("S001", "Matricula");
        listaDoble.insertarFinal("S002", "Constancia");
        listaDoble.insertarFinal("S003", "Certificados");
        listaDoble.insertarFinal("S004", "Consulta de notas");
        listaDoble.insertarFinal("S005", "Documentos");

        listaDoble.mostrarAdelante();
        listaDoble.mostrarAtras();

        // LISTA CIRCULAR

        System.out.println("\n====================================");
        System.out.println("CASO 2: LISTA CIRCULAR");
        System.out.println(
            "Permite revisar solicitudes continuamente por turnos."
        );

        ListaCircular listaCircular = new ListaCircular();

        listaCircular.insertarFinal("S001", "Matricula");
        listaCircular.insertarFinal("S002", "Constancia");
        listaCircular.insertarFinal("S003", "Certificados");
        listaCircular.insertarFinal("S004", "Consulta de notas");
        listaCircular.insertarFinal("S005", "Documentos");

        listaCircular.mostrar();

        System.out.println("\n====================================");
        System.out.println("FIN DEL PROGRAMA");
        System.out.println("====================================");
    }
}