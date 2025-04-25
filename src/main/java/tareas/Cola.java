package tareas;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Cola<T> {
    private ArrayList<T> elementos;
    
    public Cola() {
        elementos = new ArrayList<>();
    }
    
    public void add(T elemento) {
        elementos.add(elemento);
    }
    
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elementos.remove(0);
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elementos.get(0);
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