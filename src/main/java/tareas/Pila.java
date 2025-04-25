package tareas;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Pila<T> {
    private ArrayList<T> elementos;
    
    public Pila() {
        elementos = new ArrayList<>();
    }
    
    public void push(T elemento) {
        elementos.add(elemento);
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos.remove(elementos.size() - 1);
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos.get(elementos.size() - 1);
    }
    
    public boolean isEmpty() {
        return elementos.isEmpty();
    }
    
    public int size() {
        return elementos.size();
    }
    
    public ArrayList<T> getElementos() {
        return new ArrayList<>(elementos);
    }
} 