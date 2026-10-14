package pa2;

// Prueba de la Actividad 3: Búsqueda y Modificación
public class Actividad3 {

    public static void main(String[] args) {
        ListaSimple solicitudes = new ListaSimple();

        // 1. Cargar la lista inicial con las solicitudes
        solicitudes.insertarFinal("S001", "Matricula");
        solicitudes.insertarFinal("S002", "Constancia");
        solicitudes.insertarFinal("S003", "Certificados");
        solicitudes.insertarFinal("S004", "Consulta de notas");
        solicitudes.insertarFinal("S005", "Documentos");

        System.out.println("=== ACTIVIDAD 3: BUSQUEDA Y MODIFICACION ===");
        System.out.println("\nLista original:");
        solicitudes.recorrer();

        // 2. Probar la Búsqueda
        System.out.println("\n--- Probando Busqueda (Buscando S003) ---");
        Actividad1.Nodo encontrado = solicitudes.buscar("S003");
        if (encontrado != null) {
            System.out.println("¡Encontrado con exito! -> Código: " + encontrado.codigo + " | Solicitud: " + encontrado.solicitud);
        } else {
            System.out.println("No se encontro el codigo.");
        }

        // 3. Probar la Modificación
        System.out.println("\n--- Probando Modificacion (Modificando S003 a 'Certificado de Estudios') ---");
        boolean modificado = solicitudes.modificarSolicitud("S003", "Certificado de Estudios");
        
        if (modificado) {
            System.out.println("Estado: Modificacion realizada correctamente.");
        } else {
            System.out.println("Estado: No se pudo realizar la modificacion.");
        }

        // 4. Mostrar la lista final con los cambios aplicados
        System.out.println("\nLista despues de la modificacion:");
        solicitudes.recorrer();
    }
}
