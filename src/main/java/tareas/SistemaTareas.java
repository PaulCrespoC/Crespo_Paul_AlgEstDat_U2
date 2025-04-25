package tareas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SistemaTareas extends JFrame {
    private GestorTareas gestor;
    private JTextField campoDescripcion;
    private DefaultListModel<Tarea> modeloTareasPendientes;
    private DefaultListModel<Tarea> modeloTareasCompletadas;
    private JList<Tarea> listaTareasPendientes;
    private JList<Tarea> listaTareasCompletadas;
    private JLabel etiquetaProximaTarea;
    private Font fuenteNormal;
    private Font fuenteGrande;

    public SistemaTareas() {
        gestor = new GestorTareas();
        configurarVentana();
        inicializarComponentes();
        agregarComponentes();
        agregarListeners();
        actualizarVistas();
    }

    private void configurarVentana() {
        setTitle("Sistema de Gestión de Tareas");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));
        
        fuenteNormal = new Font("Arial", Font.PLAIN, 16);
        fuenteGrande = new Font("Arial", Font.BOLD, 18);
    }

    private void inicializarComponentes() {
        // Panel para agregar tareas
        campoDescripcion = new JTextField(25);
        campoDescripcion.setFont(fuenteNormal);
        campoDescripcion.setPreferredSize(new Dimension(300, 35));

        // Modelos y listas para tareas
        modeloTareasPendientes = new DefaultListModel<>();
        modeloTareasCompletadas = new DefaultListModel<>();
        
        listaTareasPendientes = new JList<>(modeloTareasPendientes);
        listaTareasPendientes.setFont(fuenteNormal);
        
        listaTareasCompletadas = new JList<>(modeloTareasCompletadas);
        listaTareasCompletadas.setFont(fuenteNormal);

        // Etiqueta para próxima tarea
        etiquetaProximaTarea = new JLabel("No hay tareas pendientes");
        etiquetaProximaTarea.setFont(fuenteNormal);
    }

    private void agregarComponentes() {
        // Panel para agregar tareas
        JPanel panelAgregar = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelAgregar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel labelDescripcion = new JLabel("Descripción:");
        labelDescripcion.setFont(fuenteNormal);
        panelAgregar.add(labelDescripcion);
        panelAgregar.add(campoDescripcion);
        
        JButton botonAgregar = new JButton("Agregar Tarea");
        botonAgregar.setFont(fuenteNormal);
        botonAgregar.setPreferredSize(new Dimension(150, 35));
        panelAgregar.add(botonAgregar);
        
        // Panel para la próxima tarea
        JPanel panelProxima = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JLabel labelProxima = new JLabel("Próxima Tarea: ");
        labelProxima.setFont(fuenteNormal);
        panelProxima.add(labelProxima);
        panelProxima.add(etiquetaProximaTarea);
        
        // Panel superior combinado
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(panelAgregar, BorderLayout.CENTER);
        panelSuperior.add(panelProxima, BorderLayout.SOUTH);
        
        // Panel para listas de tareas
        JPanel panelListas = new JPanel(new GridLayout(1, 2, 15, 0));
        
        // Panel de tareas pendientes
        JPanel panelPendientes = new JPanel(new BorderLayout(0, 10));
        panelPendientes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel labelPendientes = new JLabel("Tareas Pendientes (Pila):");
        labelPendientes.setFont(fuenteGrande);
        panelPendientes.add(labelPendientes, BorderLayout.NORTH);
        
        JScrollPane scrollPendientes = new JScrollPane(listaTareasPendientes);
        scrollPendientes.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelPendientes.add(scrollPendientes, BorderLayout.CENTER);
        
        JPanel panelBotonesPendientes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JButton botonCompletar = new JButton("Marcar como Completada");
        botonCompletar.setFont(fuenteNormal);
        botonCompletar.setPreferredSize(new Dimension(220, 40));
        
        JButton botonEliminar = new JButton("Eliminar Tarea");
        botonEliminar.setFont(fuenteNormal);
        botonEliminar.setPreferredSize(new Dimension(150, 40));
        
        panelBotonesPendientes.add(botonCompletar);
        panelBotonesPendientes.add(botonEliminar);
        panelPendientes.add(panelBotonesPendientes, BorderLayout.SOUTH);
        
        // Panel de tareas completadas
        JPanel panelCompletadas = new JPanel(new BorderLayout(0, 10));
        panelCompletadas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel labelCompletadas = new JLabel("Tareas Completadas (Cola):");
        labelCompletadas.setFont(fuenteGrande);
        panelCompletadas.add(labelCompletadas, BorderLayout.NORTH);
        
        JScrollPane scrollCompletadas = new JScrollPane(listaTareasCompletadas);
        scrollCompletadas.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelCompletadas.add(scrollCompletadas, BorderLayout.CENTER);
        
        panelListas.add(panelPendientes);
        panelListas.add(panelCompletadas);
        
        // Agregar todo a la ventana principal
        add(panelSuperior, BorderLayout.NORTH);
        add(panelListas, BorderLayout.CENTER);
        
        // Configurar listeners para botones
        botonAgregar.addActionListener(e -> agregarTarea());
        botonCompletar.addActionListener(e -> marcarComoCompletada());
        botonEliminar.addActionListener(e -> eliminarTarea());
    }

    private void agregarListeners() {
        listaTareasPendientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    marcarComoCompletada();
                }
            }
        });
    }

    private void agregarTarea() {
        String descripcion = campoDescripcion.getText().trim();
        if (!descripcion.isEmpty()) {
            Tarea tarea = new Tarea(descripcion, 1); // Prioridad por defecto 1
            gestor.agregarTarea(tarea);
            campoDescripcion.setText("");
            actualizarVistas();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese una descripción para la tarea", 
                                         "Campo vacío", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void marcarComoCompletada() {
        if (!modeloTareasPendientes.isEmpty()) {
            gestor.marcarComoCompletada();
            actualizarVistas();
        }
    }

    private void eliminarTarea() {
        if (!modeloTareasPendientes.isEmpty()) {
            gestor.eliminarTarea();
            actualizarVistas();
        }
    }

    private void actualizarVistas() {
        // Actualizar lista de tareas pendientes
        modeloTareasPendientes.clear();
        Pila<Tarea> tareasPendientes = gestor.getTareasPendientes();
        Pila<Tarea> copiaTemp = new Pila<>();
        
        while (!tareasPendientes.isEmpty()) {
            copiaTemp.push(tareasPendientes.pop());
        }
        
        while (!copiaTemp.isEmpty()) {
            Tarea tarea = copiaTemp.pop();
            modeloTareasPendientes.addElement(tarea);
            tareasPendientes.push(tarea);
        }
        
        // Actualizar lista de tareas completadas
        modeloTareasCompletadas.clear();
        ArrayList<Tarea> tareasCompletadas = gestor.getTareasCompletadas().getElementos();
        for (Tarea tarea : tareasCompletadas) {
            modeloTareasCompletadas.addElement(tarea);
        }
        
        // Actualizar próxima tarea
        Tarea proximaTarea = gestor.getProximaTarea();
        if (proximaTarea != null) {
            etiquetaProximaTarea.setText(proximaTarea.toString());
        } else {
            etiquetaProximaTarea.setText("No hay tareas pendientes");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaTareas sistema = new SistemaTareas();
            sistema.setVisible(true);
        });
    }
} 