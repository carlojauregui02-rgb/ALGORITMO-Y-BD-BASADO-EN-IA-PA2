# ACTIVIDAD 4: LISTAS DOBLES Y CIRCULARES

## 1. Caso de uso de una lista doblemente enlazada

### Situación: Gestión de solicitudes administrativas

En una institución educativa se necesita gestionar solicitudes de los estudiantes, como matrículas, constancias, certificados, consultas de notas y documentos. El personal administrativo necesita revisar las solicitudes tanto hacia adelante como hacia atrás.

La lista doblemente enlazada es adecuada para este caso porque cada nodo contiene una referencia al nodo anterior y otra al siguiente, lo que permite recorrer la información en ambas direcciones.

## 2. Diagrama de la lista doblemente enlazada

Cada nodo tiene una conexión hacia adelante y otra hacia atrás.

```text
             Lista doblemente enlazada

       Anterior                 Siguiente
          ←                         →
      ┌─────────┐    ┌─────────┐    ┌──────────┐
NULL  │  S001   │ ⇄  │  S002   │ ⇄  │  S003    │ NULL
      │ Matrícula│    │Constancia│   │Certificados│
      └─────────┘    └─────────┘    └──────────┘
```

### Funcionamiento

- Cada nodo almacena el código y el nombre de la solicitud.
- El enlace siguiente permite avanzar al próximo nodo.
- El enlace anterior permite regresar al nodo previo.
- La lista puede recorrerse desde el inicio hasta el final y desde el final hasta el inicio.

**Ventaja:** facilita la navegación en ambas direcciones sin tener que comenzar nuevamente desde el primer nodo.

## 3. Caso de uso de una lista circular

### Situación: Atención de solicitudes por turnos

Una institución educativa tiene varias solicitudes pendientes de revisión. El personal administrativo desea revisarlas continuamente por turnos, de modo que, después de revisar la última solicitud, pueda volver a la primera.

La lista circular es adecuada porque el último nodo apunta al primero, formando un ciclo.

## 4. Diagrama de la lista circular

```text
             Lista circular

          ┌─────────────────────┐
          ↓                     │
      ┌─────────┐    ┌─────────┐ │
      │  S001   │ →  │  S002   │ │
      │ Matrícula│    │Constancia│ │
      └─────────┘    └─────────┘ │
          ↑                      ↓
      ┌─────────┐    ┌──────────┐
      │  S004   │ ←  │  S003    │
      │ Consulta│    │Certificados│
      │ de notas│    └──────────┘
      └─────────┘
```

El recorrido continúa y regresa al nodo S001.

### Funcionamiento

- Cada nodo almacena una solicitud y una referencia al siguiente nodo.
- El último nodo enlaza nuevamente con el primero.
- El recorrido puede continuar repetidamente.
- Para mostrar cada solicitud una sola vez, el programa debe detectar cuándo regresa al nodo inicial.

**Ventaja:** permite organizar turnos de revisión continua sin que el recorrido termine necesariamente en el último nodo.

## 5. Comparación con una lista simplemente enlazada

| Característica | Lista simple | Lista doble | Lista circular |
|---|---|---|---|
| Enlaces por nodo | Uno al siguiente | Al anterior y al siguiente | Al siguiente |
| Recorrido hacia adelante | Sí | Sí | Sí |
| Recorrido hacia atrás | No directamente | Sí | No directamente |
| Regresa automáticamente al inicio | No | No | Sí |
| Uso apropiado | Recorrido secuencial | Navegación en ambas direcciones | Turnos continuos |

## 6. Justificación de las estructuras elegidas

La lista doblemente enlazada se seleccionó para la gestión de solicitudes administrativas porque permite consultar los registros en ambas direcciones. Esto facilita revisar solicitudes anteriores y posteriores.

La lista circular se eligió para la atención por turnos porque permite pasar de la última solicitud a la primera y repetir el proceso. Es útil cuando se necesita un recorrido continuo.

Ambas estructuras ofrecen ventajas frente a la lista simplemente enlazada según las necesidades del sistema. Sin embargo, la lista doble utiliza referencias adicionales y la lista circular requiere controlar cuidadosamente el recorrido para evitar ciclos infinitos.

## 7. Conclusión

Las listas doblemente enlazadas y circulares son estructuras útiles para organizar información dinámica.

La lista doble permite desplazarse hacia adelante y hacia atrás, mientras que la lista circular facilita los procesos repetitivos y la atención por turnos.

La elección de cada estructura depende del funcionamiento que se necesita implementar y de la forma en que se desea recorrer los datos.
