# Sistema de Gestión de Tareas

Sistema simple para gestionar tareas usando pilas y colas como estructuras de datos.

## Funcionalidades

1. **Agregar tarea**: Añade una nueva tarea a la pila de pendientes
2. **Marcar como completada**: Mueve la tarea de la pila a la cola de completadas
3. **Eliminar tarea**: Elimina la tarea de la pila de pendientes
4. **Ver próxima tarea**: Muestra la tarea en la parte superior de la pila

## Ejecución
Para compilarlo en un JAR se ejecuto el siguiente comando para generar un ejecutable capaz de correr en diferentes plataformas
```
java -jar Crespo_Paul_AlgEstDat_U2-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Uso

1. Para agregar una tarea: escriba la descripción y haga clic en "Agregar Tarea"
2. Para completar una tarea: selecciónela y presione "Marcar como Completada" o haga doble clic
3. Para eliminar una tarea: selecciónela y presione "Eliminar Tarea"

## Estructura

- **Tarea.java**: Representa una tarea
- **Pila.java**: Implementación personalizada de una pila
- **Cola.java**: Implementación personalizada de una cola
- **GestorTareas.java**: Maneja las tareas usando pila y cola
- **SistemaTareas.java**: Interfaz gráfica
- **Main.java**: Punto de entrada de la aplicación 