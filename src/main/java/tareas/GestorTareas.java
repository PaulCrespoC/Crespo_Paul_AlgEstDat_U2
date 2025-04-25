package tareas;

public class GestorTareas {
    private Pila<Tarea> tareasPendientes;
    private Cola<Tarea> tareasCompletadas;

    public GestorTareas() {
        tareasPendientes = new Pila<>();
        tareasCompletadas = new Cola<>();
    }

    public void agregarTarea(Tarea tarea) {
        tareasPendientes.push(tarea);
    }

    public void marcarComoCompletada() {
        if (!tareasPendientes.isEmpty()) {
            Tarea tarea = tareasPendientes.pop();
            tareasCompletadas.add(tarea);
        }
    }

    public void eliminarTarea() {
        if (!tareasPendientes.isEmpty()) {
            tareasPendientes.pop();
        }
    }

    public Pila<Tarea> getTareasPendientes() {
        return tareasPendientes;
    }

    public Cola<Tarea> getTareasCompletadas() {
        return tareasCompletadas;
    }

    public Tarea getProximaTarea() {
        if (!tareasPendientes.isEmpty()) {
            return tareasPendientes.peek();
        }
        return null;
    }
}