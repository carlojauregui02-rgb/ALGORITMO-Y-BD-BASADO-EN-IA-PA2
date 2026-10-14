package pa2;

// Actividad 2 - Recorrido e insercion
// Usa el Nodo de la Actividad 1 (Actividad1.Nodo: codigo, solicitud, siguiente)
public class ListaSimple {

    Actividad1.Nodo cabeza;

    // Recorrido completo - O(n)
    public void recorrer() {
        Actividad1.Nodo actual = cabeza;
        while (actual != null) {
            System.out.print("[" + actual.codigo + " | " + actual.solicitud + "] -> ");
            actual = actual.siguiente;
        }
        System.out.println("NULL");
    }

    // Insercion al inicio - O(1)
    public void insertarInicio(String codigo, String solicitud) {
        Actividad1.Nodo nuevo = new Actividad1.Nodo(codigo, solicitud);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    // Insercion al final - O(n)
    public void insertarFinal(String codigo, String solicitud) {
       Actividad1.Nodo nuevo = new Actividad1.Nodo(codigo, solicitud);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        Actividad1.Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
    }

    // Insercion despues de un nodo dado - O(n)
    public void insertarDespues(String codigoDado, String codigo, String solicitud) {
        Actividad1.Nodo actual = cabeza;
        while (actual != null && !actual.codigo.equals(codigoDado)) {
            actual = actual.siguiente;
        }

        if (actual == null) return;

        Actividad1.Nodo nuevo = new Actividad1.Nodo(codigo, solicitud);
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
    }
    
    // Actividad 3: busqueda de una solicitud - O(n)
    public Actividad1.Nodo buscar(String codigoBuscado) {
        Actividad1.Nodo actual = cabeza;

        while (actual != null) {
            if (actual.codigo.equals(codigoBuscado)) {
                return actual;
            }
            actual = actual.siguiente;
        }

        return null;
    }

    // Actividad 3: modificacion de una solicitud - O(n)
    public boolean modificarSolicitud(
            String codigoBuscado, String nuevaSolicitud) {

        Actividad1.Nodo encontrado = buscar(codigoBuscado);

        if (encontrado == null) {
            return false;
        }

        encontrado.solicitud = nuevaSolicitud;
        return true;
    }
    
    // Actividad 3: eliminación de una solicitud - O(n)
    public boolean eliminar(String codigoBuscado) {

        // Caso 1: la lista está vacía
        if (cabeza == null) {
            return false;
        }

        // Caso 2: el nodo que se eliminará es el primero
        if (cabeza.codigo.equals(codigoBuscado)) {
            cabeza = cabeza.siguiente;
            return true;
        }

        // Caso 3: buscar el nodo anterior al que se eliminará
        Actividad1.Nodo actual = cabeza;

        while (actual.siguiente != null
                && !actual.siguiente.codigo.equals(codigoBuscado)) {
            actual = actual.siguiente;
        }

        // El código no existe en la lista
        if (actual.siguiente == null) {
            return false;
        }

        // Reajustar el enlace para excluir el nodo
        actual.siguiente = actual.siguiente.siguiente;

        return true;
    }
} 

