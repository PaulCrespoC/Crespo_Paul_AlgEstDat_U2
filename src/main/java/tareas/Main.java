package tareas;

public class Main {
    
    /**
     * Setup inicial de la aplicación
     * @param args
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            SistemaTareas sistema = new SistemaTareas();
            sistema.setVisible(true);
        });
    }
} 