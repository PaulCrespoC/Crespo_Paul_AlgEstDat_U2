package tareas;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            SistemaTareas sistema = new SistemaTareas();
            sistema.setVisible(true);
        });
    }
} 