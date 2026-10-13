package pa2;

// Actividad 2 - Recorrido e insercion
// Usa el Nodo de la Actividad 1 (PA2.Nodo: codigo, solicitud, siguiente)
public class ListaSimple {

    PA2.Nodo cabeza;

    // Recorrido completo - O(n)
    public void recorrer() {
        PA2.Nodo actual = cabeza;
        while (actual != null) {
            System.out.print("[" + actual.codigo + " | " + actual.solicitud + "] -> ");
            actual = actual.siguiente;
        }
        System.out.println("NULL");
    }

    // Insercion al inicio - O(1)
    public void insertarInicio(String codigo, String solicitud) {
        PA2.Nodo nuevo = new PA2.Nodo(codigo, solicitud);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    // Insercion al final - O(n)
    public void insertarFinal(String codigo, String solicitud) {
        PA2.Nodo nuevo = new PA2.Nodo(codigo, solicitud);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        PA2.Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
    }

    // Insercion despues de un nodo dado - O(n)
    public void insertarDespues(String codigoDado, String codigo, String solicitud) {
        PA2.Nodo actual = cabeza;
        while (actual != null && !actual.codigo.equals(codigoDado)) {
            actual = actual.siguiente;
        }

        if (actual == null) return;

        PA2.Nodo nuevo = new PA2.Nodo(codigo, solicitud);
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
    }
    
    // Actividad 3: busqueda de una solicitud - O(n)
    public PA2.Nodo buscar(String codigoBuscado) {
        PA2.Nodo actual = cabeza;

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

        PA2.Nodo encontrado = buscar(codigoBuscado);

        if (encontrado == null) {
            return false;
        }

        encontrado.solicitud = nuevaSolicitud;
        return true;
    }
} 

