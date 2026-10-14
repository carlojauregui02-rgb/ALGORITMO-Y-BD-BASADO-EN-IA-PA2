#ACTIVIDAD 4: APLICACIONES DE LAS LISTAS DOBLEMENTE ENLAZADAS Y CIRCULARES

##Introducción

Las listas enlazadas son estructuras de datos que permiten almacenar elementos mediante nodos conectados entre sí. Dependiendo de la forma en que se establecen sus enlaces, se pueden utilizar para resolver diferentes problemas.

En esta actividad se presentan dos casos prácticos:

El uso de una lista doblemente enlazada para consultar solicitudes de servicio.

El uso de una lista circular para organizar la asignación rotativa de solicitudes a técnicos.

4.2. Caso práctico de una lista doblemente enlazada

Situación planteada

En un sistema de gestión de solicitudes de servicio, los usuarios necesitan consultar sus solicitudes anteriores y posteriores. Para resolver esta necesidad, se propone utilizar una lista doblemente enlazada.

Funcionamiento

Cada nodo representa una solicitud y contiene sus datos, una referencia al nodo anterior y otra al nodo siguiente.

Representación básica:

NULL ← [Solicitud 101] ⇄ [Solicitud 102] ⇄ [Solicitud 103] → NULL


Justificación

Esta estructura es adecuada porque permite avanzar y retroceder entre las solicitudes. Si el usuario desea regresar desde la Solicitud 103 hasta la 102, puede hacerlo de forma directa mediante la referencia al nodo anterior. En una lista simplemente enlazada, habría sido necesario recorrer la estructura desde el inicio para localizar el nodo previo.

##Caso práctico de una lista circular

Situación planteada

En una empresa que administra solicitudes de servicio, existen varios técnicos que reciben solicitudes por turnos. Para mantener una asignación rotativa, se propone utilizar una lista circular.

Funcionamiento

Cada nodo representa a un técnico. El último nodo apunta nuevamente al primero, permitiendo repetir el recorrido de forma indefinida.

Representación básica:

[Técnico 1] → [Técnico 2] → [Técnico 3] → [Técnico 4]
     ↑________________________________________________|


Justificación

Esta estructura permite recorrer continuamente a los técnicos sin que el proceso termine en un nodo nulo. Después de llegar al último técnico, el sistema puede regresar al primero y continuar con la rotación. Para garantizar una distribución justa, el sistema también debe considerar la disponibilidad y la carga de trabajo de cada técnico.

##Comparación de las estructuras

Lista simplemente enlazada: Permite avanzar en una sola dirección, de un nodo al siguiente.

Lista doblemente enlazada: Permite avanzar y retroceder gracias a que cada nodo mantiene dos referencias.

Lista circular: Conecta el último nodo con el primero, permitiendo repetir el recorrido de manera cíclica.

Conclusión técnica: La elección de una estructura depende estrictamente de las necesidades del sistema: navegación en ambos sentidos para las listas dobles y recorridos repetitivos para las circulares.

##Conclusiones

Las listas doblemente enlazadas y circulares ofrecen alternativas eficientes y útiles para organizar la información en un sistema de gestión de solicitudes. La lista doble facilita la navegación bidireccional entre solicitudes, mientras que la lista circular optimiza la organización de procesos rotativos. En consecuencia, la estructura idónea siempre debe elegirse de acuerdo con el problema que se desea resolver y las operaciones clave que el sistema necesite ejecutar.
