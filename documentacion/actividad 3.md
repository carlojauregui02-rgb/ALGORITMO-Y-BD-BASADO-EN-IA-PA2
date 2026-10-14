ACTIVIDAD 3: BÚSQUEDA, MODIFICACIÓN Y ELIMINACIÓN

## Introducción
Una vez que tenemos nuestra lista de solicitudes enlazada, es muy común que necesitemos buscar una solicitud específica por su código para revisar su información o actualizarla si el usuario lo requiere (por ejemplo, cambiar el detalle de un trámite). Como la lista no tiene índices numéricos directos como un vector, debemos recorrerla nodo por nodo hasta encontrar la coincidencia exacta.

---

## 1. Búsqueda de una solicitud
Este algoritmo sirve para localizar un nodo dentro de la lista utilizando su atributo `codigo` como criterio de búsqueda. Se inicia desde la `cabeza` y se avanza mediante el apuntador `siguiente` hasta encontrar el código buscado o llegar al final (`NULL`).

Algoritmo Buscar(codigoBuscado)
Inicio
    actual <- cabeza
    Mientras actual <> NULL hacer
        Si actual.codigo = codigoBuscado entonces
            Retornar actual
        Fin Si
        actual <- actual.siguiente
    Fin Mientras
    Retornar NULL
Fin

¿Qué cambia en la lista? Absolutamente nada, la estructura de los nodos y las flechas se mantiene intacta, ya que solo es una operación de lectura. ¿Qué tan rápido es? O(n): En el peor de los casos (si el elemento está al final o no existe), el algoritmo debe recorrer toda la longitud de la lista.
## 2. Modificación de una solicitud
Permite cambiar el contenido de un trámite o solicitud una vez que ha sido localizado. Para lograrlo de forma limpia, este método reutiliza la lógica del algoritmo de búsqueda.

Primero buscamos el nodo por su código; si el resultado no es nulo, sobrescribimos el campo `solicitud` con el nuevo texto proporcionado.

Algoritmo ModificarSolicitud(codigoBuscado, nuevaSolicitud)
Inicio
    encontrado <- Buscar(codigoBuscado)
    Si encontrado = NULL entonces
        Retornar Falso
    Fin Si
    encontrado.solicitud <- nuevaSolicitud
    Retornar Verdadero
Fin

¿Qué cambia en la lista? El campo `solicitud` del nodo encontrado cambia su valor por el nuevo texto actualizado, manteniendo su misma posición y sus enlaces intactos. ¿Qué tan rápido es? O(n): Su velocidad depende principalmente de la operación previa de búsqueda lineal.
## Resultado al ejecutar el programa
Al ejecutar las pruebas correspondientes a la Actividad 3 sobre nuestra lista de solicitudes, el comportamiento en la consola es el siguiente:

=== ACTIVIDAD 3: BUSQUEDA Y MODIFICACION ===

Lista original:
[S001 | Matricula] -> [S002 | Constancia] -> [S003 | Certificados] -> [S004 | Consulta de notas] -> [S005 | Documentos] -> NULL

--- Probando Busqueda (Buscando S003) ---
¡Encontrado con exito! -> Código: S003 | Solicitud: Certificados

--- Probando Modificacion (Modificando S003 a 'Certificado de Estudios') ---
Estado: Modificacion realizada correctamente.

Lista despues de la modificacion:
[S001 | Matricula] -> [S002 | Constancia] -> [S003 | Certificado de Estudios] -> [S004 | Consulta de notas] -> [S005 | Documentos] -> NULL

## Conclusión
La búsqueda y la modificación son operaciones fundamentales para la gestión dinámica de datos en una lista enlazada. Aunque la búsqueda requiere un recorrido lineal por la estructura (O(n)) debido a que no podemos acceder directamente por posiciones de memoria, nos permite interactuar de manera segura con nodos específicos sin alterar el orden ni romper las referencias de los demás elementos de la fila.

## 3. Eliminación de una solicitud

Este algoritmo permite eliminar una solicitud de la lista utilizando su código como criterio. Primero comprueba si la lista está vacía. Si la solicitud que se desea eliminar está al inicio, se actualiza la referencia `cabeza` para que apunte al siguiente nodo. Si está en otra posición, se recorre la lista hasta encontrar el nodo anterior al que se quiere eliminar.

Una vez localizado, se actualiza su apuntador `siguiente` para que apunte al nodo posterior al que se elimina. De esta manera, los demás nodos continúan conectados.

**Algoritmo Eliminar(codigoBuscado)**

Inicio

- Si cabeza = NULL entonces
  - Retornar Falso
- Fin Si
- Si cabeza.codigo = codigoBuscado entonces
  - cabeza <- cabeza.siguiente
  - Retornar Verdadero
- Fin Si
- actual <- cabeza
- Mientras actual.siguiente <> NULL y actual.siguiente.codigo <> codigoBuscado hacer
  - actual <- actual.siguiente
- Fin Mientras
- Si actual.siguiente = NULL entonces
  - Retornar Falso
- Fin Si
- actual.siguiente <- actual.siguiente.siguiente
- Retornar Verdadero

Fin

¿Qué cambia en la lista? El nodo seleccionado deja de formar parte de la secuencia. Los demás nodos mantienen su orden y continúan enlazados.

¿Qué tan rápido es? La eliminación del primer nodo tiene una complejidad de O(1), porque solo se actualiza `cabeza`. La eliminación por código tiene una complejidad de O(n) en el peor caso, porque es necesario recorrer la lista para localizar el nodo que se eliminará.

## 4. Resultado al ejecutar la eliminación

Para comprobar el funcionamiento, se eliminó la solicitud S004, correspondiente a «Consulta de notas». El programa confirmó que la operación se realizó correctamente.

Antes de eliminar:

[S001 | Matricula] -> [S002 | Constancia] -> [S003 | Certificado de Estudios] -> [S004 | Consulta de notas] -> [S005 | Documentos] -> NULL

Después de eliminar:

[S001 | Matricula] -> [S002 | Constancia] -> [S003 | Certificado de Estudios] -> [S005 | Documentos] -> NULL

Como se observa, S003 queda enlazado directamente con S005, sin perder la conexión con el resto de la lista.
