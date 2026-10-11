/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pa2;

public class PA2 {

    // Estructura de cada nodo
    static class Nodo {
        String codigo;
        String solicitud;
        Nodo siguiente;

        public Nodo(String codigo, String solicitud) {
            this.codigo = codigo;
            this.solicitud = solicitud;
            this.siguiente = null;
        }
    }

    public static void main(String[] args) {

        // Crear cinco nodos
        Nodo n1 = new Nodo("S001", "Matricula");
        Nodo n2 = new Nodo("S002", "Constancia");
        Nodo n3 = new Nodo("S003", "Certificados");
        Nodo n4 = new Nodo("S004", "Consulta de notas");
        Nodo n5 = new Nodo("S005", "Documentos");

        // Enlazar los nodos
        n1.siguiente = n2;
        n2.siguiente = n3;
        n3.siguiente = n4;
        n4.siguiente = n5;

        // Recorrer la lista desde el primer nodo
        Nodo actual = n1;

        System.out.println("ACTIVIDAD 1: LISTA ENLAZADA");

        while (actual != null) {
            System.out.println(
                actual.codigo + " - " + actual.solicitud
            );

            actual = actual.siguiente;
        }

        System.out.println("Fin de la lista.");
    }
}