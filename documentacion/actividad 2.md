# ACTIVIDAD 2: RECORRIDO E INSERCIÓN

## Introducción
En esta actividad seguimos trabajando con la lista de solicitudes de la Actividad 1. Cada nodo es como una ficha que guarda el **código** de la solicitud (por ejemplo S001), el **tipo de solicitud** (por ejemplo Matricula) y una flecha llamada **siguiente**, que indica cuál es la ficha que viene después.

La lista funciona como una fila: la **cabeza** es la primera solicitud y la última no tiene a nadie detrás, por eso apunta a `NULL`.

Como en el caso las solicitudes cambian todo el tiempo (llegan casos nuevos, algunos urgentes y otros que hay que poner junto a uno parecido), hicimos cuatro operaciones: recorrer la lista, agregar al inicio, agregar al final y agregar después de una solicitud.

## 1. Recorrido completo
Recorrer es pasar por todas las solicitudes, una por una, desde la primera hasta la última. Para eso usamos una ayuda llamada **actual**: empieza en la cabeza y va saltando a la siguiente hasta que ya no hay más.

No movemos la cabeza, porque si lo hacemos perdemos el inicio de la lista.

```
Algoritmo Recorrer()
Inicio
    actual <- cabeza
    Mientras actual <> NULL hacer
        Mostrar actual.codigo, actual.solicitud
        actual <- actual.siguiente
    Fin Mientras
Fin
```

**¿Qué cambia en la lista?** Nada, solo se leen las solicitudes.
**¿Qué tan rápido es?** O(n): mientras más solicitudes haya, más se demora, porque hay que pasar por todas.

## 2. Insertar al inicio
Lo usamos cuando llega una solicitud **urgente** que debe atenderse primero.

Se hace en dos pasos y el orden importa:
1. La nueva solicitud apunta a la que antes era la primera.
2. La cabeza pasa a ser la nueva solicitud.

Si lo hacemos al revés, se pierde el resto de la lista.

```
Algoritmo InsertarInicio(codigo, solicitud)
Inicio
    nuevo <- crear Nodo(codigo, solicitud)
    nuevo.siguiente <- cabeza     // paso 1
    cabeza <- nuevo               // paso 2
Fin
```

**¿Qué cambia en la lista?** S006 (Reclamo urgente) queda primero y apunta a S001. El resto queda igual.
**¿Qué tan rápido es?** O(1): siempre son los mismos dos pasos, no importa si hay 5 o 500 solicitudes.

## 3. Insertar al final
Es el caso normal: la solicitud nueva va al final de la fila.

Como solo sabemos dónde está la primera, hay que avanzar hasta la última (la que apunta a `NULL`) y hacer que apunte a la nueva. Si la lista está vacía, la nueva pasa a ser la primera.

```
Algoritmo InsertarFinal(codigo, solicitud)
Inicio
    nuevo <- crear Nodo(codigo, solicitud)
    Si cabeza = NULL entonces
        cabeza <- nuevo
        Terminar
    Fin Si
    actual <- cabeza
    Mientras actual.siguiente <> NULL hacer
        actual <- actual.siguiente
    Fin Mientras
    actual.siguiente <- nuevo
Fin
```

**¿Qué cambia en la lista?** S005 ya no es la última: ahora apunta a S007 (Traslado), que queda al final.
**¿Qué tan rápido es?** O(n): hay que caminar hasta el final, así que demora más si la lista es larga.

## 4. Insertar después de una solicitud
Sirve para poner una solicitud junto a otra con la que está relacionada. Por ejemplo, un **duplicado de constancia (S008)** se coloca justo después de la **constancia (S002)** para que se atiendan juntas.

Primero buscamos la solicitud S002 y luego metemos la nueva en medio, también en dos pasos:
1. La nueva apunta a la que venía después de S002.
2. S002 apunta a la nueva.

Si la solicitud buscada no existe, no se agrega nada.

```
Algoritmo InsertarDespues(codigoDado, codigo, solicitud)
Inicio
    actual <- cabeza
    Mientras actual <> NULL Y actual.codigo <> codigoDado hacer
        actual <- actual.siguiente
    Fin Mientras
    Si actual = NULL entonces
        Terminar
    Fin Si
    nuevo <- crear Nodo(codigo, solicitud)
    nuevo.siguiente <- actual.siguiente   // paso 1
    actual.siguiente <- nuevo             // paso 2
Fin
```

**¿Qué cambia en la lista?** Antes era S002 → S003. Ahora queda S002 → S008 → S003.
**¿Qué tan rápido es?** O(n): primero hay que buscar la solicitud; ya encontrada, meter la nueva es inmediato.

## Resultado al ejecutar el programa
```
ACTIVIDAD 2: RECORRIDO E INSERCION

Lista inicial:
[S001 | Matricula] -> [S002 | Constancia] -> [S003 | Certificados] -> [S004 | Consulta de notas] -> [S005 | Documentos] -> NULL

Insertar S006 al inicio (caso urgente):
[S006 | Reclamo urgente] -> [S001 | Matricula] -> [S002 | Constancia] -> [S003 | Certificados] -> [S004 | Consulta de notas] -> [S005 | Documentos] -> NULL

Insertar S007 al final (nueva solicitud):
[S006 | Reclamo urgente] -> [S001 | Matricula] -> [S002 | Constancia] -> [S003 | Certificados] -> [S004 | Consulta de notas] -> [S005 | Documentos] -> [S007 | Traslado] -> NULL

Insertar S008 despues de S002 (caso relacionado):
[S006 | Reclamo urgente] -> [S001 | Matricula] -> [S002 | Constancia] -> [S008 | Duplicado de constancia] -> [S003 | Certificados] -> [S004 | Consulta de notas] -> [S005 | Documentos] -> [S007 | Traslado] -> NULL
```

## Conclusión
En una lista enlazada no hace falta mover todas las solicitudes para agregar una nueva: solo se cambian una o dos flechas. Agregar al inicio es lo más rápido; agregar al final o después de una solicitud toma más tiempo, porque siempre hay que empezar a buscar desde la primera.
