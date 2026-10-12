ACTIVIDAD 4: APLICACIONES DE LAS LISTAS DOBLEMENTE ENLAZADAS Y CIRCULARES

4.1. Introducción

Las listas enlazadas son estructuras de datos que permiten almacenar elementos mediante nodos conectados entre sí. Dependiendo de la forma en que se establecen sus enlaces, se pueden utilizar para resolver diferentes problemas. En esta actividad se presentan dos casos prácticos: el uso de una lista doblemente enlazada para consultar solicitudes de servicio y el uso de una lista circular para organizar la asignación rotativa de solicitudes a técnicos.

4.2. Caso práctico de una lista doblemente enlazada

Situación planteada

En un sistema de gestión de solicitudes de servicio, los usuarios necesitan consultar sus solicitudes anteriores y posteriores. Para resolver esta necesidad, se propone utilizar una lista doblemente enlazada.

Funcionamiento

Cada nodo representa una solicitud y contiene sus datos, una referencia al nodo anterior y otra al nodo siguiente.

Representación básica:

NULL ← Solicitud 101 ⇄ Solicitud 102 ⇄ Solicitud 103 → NULL

Justificación

Esta estructura es adecuada porque permite avanzar y retroceder entre las solicitudes. Si el usuario desea regresar desde la solicitud 103 hasta la 102, puede hacerlo mediante la referencia al nodo anterior. En una lista simplemente enlazada, sería necesario recorrer la lista desde el inicio para localizar el nodo anterior.

4.3. Caso práctico de una lista circular

Situación planteada

En una empresa que administra solicitudes de servicio, existen varios técnicos que reciben solicitudes por turnos. Para mantener una asignación rotativa, se propone utilizar una lista circular.

Funcionamiento

Cada nodo representa a un técnico. El último nodo apunta nuevamente al primero, permitiendo repetir el recorrido.

Representación básica:

Técnico 1 → Técnico 2 → Técnico 3 → Técnico 4
     ↑________________________________↓

Justificación

Esta estructura permite recorrer continuamente los técnicos sin que el recorrido termine en un nodo nulo. Después de llegar al último técnico, el sistema puede regresar al primero y continuar con la rotación. Para garantizar una distribución justa, el sistema también debe considerar la disponibilidad y la carga de trabajo de cada técnico.

4.4. Comparación de las estructuras

La lista simplemente enlazada permite avanzar de un nodo al siguiente. La lista doblemente enlazada permite avanzar y retroceder porque cada nodo mantiene dos referencias. Por su parte, la lista circular conecta el último nodo con el primero, lo que permite repetir el recorrido.

Por lo tanto, la elección de una estructura depende de las necesidades del sistema: navegación en ambos sentidos para las listas dobles y recorridos repetitivos para las listas circulares.

4.5. Conclusiones

Las listas doblemente enlazadas y circulares ofrecen alternativas útiles para organizar la información en un sistema de gestión de solicitudes. La lista doble facilita la navegación entre solicitudes anteriores y posteriores, mientras que la lista circular permite organizar procesos rotativos. La estructura debe elegirse de acuerdo con el problema que se desea resolver y con las operaciones que el sistema necesita realizar.
