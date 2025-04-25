package tareas;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Pila<T> {
    private ArrayList<T> elementos;
    
    public Pila() {
        elementos = new ArrayList<>();
    }
    
    /**
     * Agregar un elemento a la pila
     * @param elemento elemento a agregar
     */
    public void push(T elemento) {
        elementos.add(elemento);
    }

    /**
     * Eliminar y devolver el elemento superior de la pila
     * @return elemento superior de la pila
     * @throws EmptyStackException si la pila está vacía
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos.remove(elementos.size() - 1);
    }

    /**
     * Devolver el elemento superior de la pila sin eliminarlo
     * @return elemento superior de la pila
     * @throws EmptyStackException si la pila está vacía
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos.get(elementos.size() - 1);
    }

    /**
     * Verificar si la pila está vacía
     * @return true si la pila está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    /**
     * Obtener el tamaño de la pila
     * @return tamaño de la pila
     */
    public int size() {
        return elementos.size();
    }

    /**
     * Obtener una copia de la pila
     * @return copia de la pila
     */
    public ArrayList<T> getElementos() {
        return new ArrayList<>(elementos);
    }
} 