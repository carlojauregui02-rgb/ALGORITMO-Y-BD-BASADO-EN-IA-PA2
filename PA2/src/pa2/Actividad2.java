package pa2;

// Prueba de la Actividad 2: recorrido e insercion
public class Actividad2 {

    public static void main(String[] args) {
        ListaSimple solicitudes = new ListaSimple();

        // Lista inicial con las 5 solicitudes de la Actividad 1
        solicitudes.insertarFinal("S001", "Matricula");
        solicitudes.insertarFinal("S002", "Constancia");
        solicitudes.insertarFinal("S003", "Certificados");
        solicitudes.insertarFinal("S004", "Consulta de notas");
        solicitudes.insertarFinal("S005", "Documentos");

        System.out.println("ACTIVIDAD 2: RECORRIDO E INSERCION");

        System.out.println("\nLista inicial:");
        solicitudes.recorrer();

        System.out.println("\nInsertar S006 al inicio (caso urgente):");
        solicitudes.insertarInicio("S006", "Reclamo urgente");
        solicitudes.recorrer();

        System.out.println("\nInsertar S007 al final (nueva solicitud):");
        solicitudes.insertarFinal("S007", "Traslado");
        solicitudes.recorrer();

        System.out.println("\nInsertar S008 despues de S002 (caso relacionado):");
        solicitudes.insertarDespues("S002", "S008", "Duplicado de constancia");
        solicitudes.recorrer();
    }
}
