package tareas;

public class Tarea {
    private String descripcion;
    private int prioridad;

    /**
     * Constructor de la clase Tarea
     * @param descripcion descripción de la tarea
     * @param prioridad prioridad de la tarea
     */
    public Tarea(String descripcion, int prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    /**
     * Obtener la descripción de la tarea
     * @return descripción de la tarea
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtener la prioridad de la tarea
     * @return prioridad de la tarea
     */ 
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * Obtener la representación en cadena de la tarea
     * @return descripción de la tarea
     */
    @Override
    public String toString() {
        return descripcion;
    }
} 