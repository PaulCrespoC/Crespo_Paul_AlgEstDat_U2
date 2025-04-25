package tareas;

public class GestorTareas {


    private Pila<Tarea> tareasPendientes;
    private Cola<Tarea> tareasCompletadas;

    public GestorTareas() {
        tareasPendientes = new Pila<>();
        tareasCompletadas = new Cola<>();
    }

    /**
     * Agregar una tarea a la pila de pendientes
     * @param tarea
     */
    public void agregarTarea(Tarea tarea) {
        tareasPendientes.push(tarea);
    }

    /**
     * Marcar una tarea como completada
     */
    public void marcarComoCompletada() {
        if (!tareasPendientes.isEmpty()) {
            Tarea tarea = tareasPendientes.pop();
            tareasCompletadas.add(tarea);
        }
    }

    /**
     * Eliminar una tarea de la pila de pendientes
     */
    public void eliminarTarea() {
        if (!tareasPendientes.isEmpty()) {
            tareasPendientes.pop();
        }
    }

    /**
     * Obtener la pila de tareas pendientes
     * @return pila de tareas pendientes
     */
    public Pila<Tarea> getTareasPendientes() {
        return tareasPendientes;
    }

    /**
     * Obtener la cola de tareas completadas
     * @return cola de tareas completadas
     */
    public Cola<Tarea> getTareasCompletadas() {
        return tareasCompletadas;
    }

    /**
     * Obtener la próxima tarea de la pila de pendientes
     * @return próxima tarea
     */
    public Tarea getProximaTarea() {
        if (!tareasPendientes.isEmpty()) {
            return tareasPendientes.peek();
        }
        return null;
    }
}