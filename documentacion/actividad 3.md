# ACTIVIDAD 3: BÚSQUEDA, MODIFICACIÓN Y ELIMINACIÓN

## Introducción

En esta actividad seguimos trabajando con la lista enlazada de solicitudes. A diferencia de las actividades anteriores, ahora necesitamos localizar una solicitud por su código, cambiar su información o eliminarla cuando sea necesario.

Para realizar estas operaciones, recorremos la lista desde la `cabeza` y avanzamos por medio del apuntador `siguiente`. De esta manera, podemos trabajar con una solicitud específica sin alterar las demás.

## 1. Búsqueda de una solicitud

La búsqueda permite encontrar una solicitud utilizando su código. Por ejemplo, podemos buscar S003 para revisar qué tipo de trámite tiene registrado.

El recorrido comienza en la `cabeza`. Se compara el código de cada nodo con el código buscado y se avanza al siguiente hasta encontrar una coincidencia o llegar a `NULL`.

```text
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
```

¿Qué cambia en la lista? Nada, porque solamente consultamos la información de los nodos.

¿Qué tan rápido es? O(n): en el peor caso, hay que recorrer toda la lista para encontrar el código o comprobar que no existe.

## 2. Modificación de una solicitud

La modificación permite actualizar la información de una solicitud que ya existe. En nuestro caso, buscamos S003, que inicialmente tiene el nombre «Certificados», y cambiamos su descripción a «Certificado de Estudios».

Primero utilizamos el algoritmo de búsqueda. Si encontramos el nodo, reemplazamos el contenido de su campo `solicitud`. No es necesario crear otro nodo ni cambiar sus enlaces.

```text
Algoritmo ModificarSolicitud(codigoBuscado, nuevaSolicitud)
Inicio
    encontrado <- Buscar(codigoBuscado)
    Si encontrado = NULL entonces
        Retornar Falso
    Fin Si
    encontrado.solicitud <- nuevaSolicitud
    Retornar Verdadero
Fin
```

¿Qué cambia en la lista? La solicitud S003 pasa de «Certificados» a «Certificado de Estudios». Su posición y sus enlaces se mantienen iguales.

¿Qué tan rápido es? O(n): primero hay que localizar el nodo que se desea modificar.

## 3. Eliminación de una solicitud

La eliminación permite retirar una solicitud de la lista utilizando su código. Para hacerlo, primero comprobamos si la lista está vacía. Si el nodo que se eliminará es el primero, actualizamos la `cabeza`. Si está en otra posición, buscamos el nodo anterior para reajustar su enlace.

```text
Algoritmo Eliminar(codigoBuscado)
Inicio
    Si cabeza = NULL entonces
        Retornar Falso
    Fin Si

    Si cabeza.codigo = codigoBuscado entonces
        cabeza <- cabeza.siguiente
        Retornar Verdadero
    Fin Si

    actual <- cabeza
    Mientras actual.siguiente <> NULL Y actual.siguiente.codigo <> codigoBuscado hacer
        actual <- actual.siguiente
    Fin Mientras

    Si actual.siguiente = NULL entonces
        Retornar Falso
    Fin Si

    actual.siguiente <- actual.siguiente.siguiente
    Retornar Verdadero
Fin
```

¿Qué cambia en la lista? El nodo eliminado deja de formar parte de la secuencia. Los demás nodos conservan su orden y continúan conectados.

¿Qué tan rápido es? O(1) si se elimina el primer nodo, porque solo se actualiza la `cabeza`. Si se elimina por código en otra posición, la complejidad es O(n) en el peor caso, porque primero hay que localizar el nodo.

## 4. Reajuste de los enlaces

Para eliminar una solicitud que se encuentra en medio de la lista, debemos cambiar el enlace del nodo anterior para que apunte al siguiente del nodo eliminado.

En nuestra prueba, eliminamos S004, correspondiente a «Consulta de notas». Antes de eliminarlo, S003 apuntaba a S004 y S004 apuntaba a S005. Después, S003 apunta directamente a S005.

Antes de eliminar:

```text
S001 -> S002 -> S003 -> S004 -> S005 -> NULL
```

Después de eliminar:

```text
S001 -> S002 -> S003 -> S005 -> NULL
```

De esta manera, la lista mantiene la conexión entre sus nodos sin necesidad de modificar los demás datos.

## Resultado al ejecutar el programa

Al ejecutar las pruebas de búsqueda, modificación y eliminación en NetBeans, se obtiene el siguiente resultado:

```text
ACTIVIDAD 3: BUSQUEDA Y MODIFICACION

Lista original:
[S001 | Matricula] -> [S002 | Constancia] -> [S003 | Certificados] -> [S004 | Consulta de notas] -> [S005 | Documentos] -> NULL

--- Probando Busqueda (Buscando S003) ---
Encontrado con exito -> Codigo: S003 | Solicitud: Certificados

--- Probando Modificacion (Modificando S003 a 'Certificado de Estudios') ---
Estado: Modificacion realizada correctamente.

Lista despues de la modificacion:
[S001 | Matricula] -> [S002 | Constancia] -> [S003 | Certificado de Estudios] -> [S004 | Consulta de notas] -> [S005 | Documentos] -> NULL

--- Probando Eliminacion (Eliminando S004) ---
Estado: Eliminacion realizada correctamente.

Lista despues de la eliminacion:
[S001 | Matricula] -> [S002 | Constancia] -> [S003 | Certificado de Estudios] -> [S005 | Documentos] -> NULL
```

## 5. Comparación de la eficiencia

La búsqueda y la modificación por código tienen una complejidad de O(n), porque necesitan localizar el nodo. La eliminación del primer nodo es O(1), ya que solo requiere actualizar la `cabeza`; en cambio, eliminar un nodo por código tiene una complejidad de O(n) en el peor caso.

En comparación con la inserción, agregar al inicio también es O(1), mientras que agregar al final o después de un código específico requiere recorrer la lista en nuestra implementación y tiene una complejidad de O(n).

## Conclusión

La búsqueda, modificación y eliminación permiten gestionar las solicitudes de una lista enlazada simple. Con la búsqueda podemos localizar un código, con la modificación podemos actualizar la información y con la eliminación podemos retirar una solicitud sin perder la conexión entre los demás nodos. Cada operación tiene una eficiencia distinta según si necesita recorrer la lista o solamente actualizar un enlace.
