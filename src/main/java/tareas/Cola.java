package tareas;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Cola<T> {
    private ArrayList<T> elementos;
    
    public Cola() {
        elementos = new ArrayList<>();
    }
    
    /**
     * Agregar un elemento a la cola
     * @param elemento elemento a agregar
     */
    public void add(T elemento) {
        elementos.add(elemento);
    }

    /**
     * Eliminar y devolver el elemento frontal de la cola
     * @return elemento frontal de la cola
     * @throws NoSuchElementException si la cola está vacía
     */
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elementos.remove(0);
    }

    /**
     * Devolver el elemento frontal de la cola sin eliminarlo
     * @return elemento frontal de la cola
     * @throws NoSuchElementException si la cola está vacía
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elementos.get(0);
    }

    /**
     * Verificar si la cola está vacía
     * @return true si la cola está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    /**
     * Obtener el tamaño de la cola
     * @return tamaño de la cola
     */
    public int size() {
        return elementos.size();
    }

    /**
     * Obtener una copia de la cola
     * @return copia de la cola
     */
    public ArrayList<T> getElementos() {
        return new ArrayList<>(elementos);
    }
} 