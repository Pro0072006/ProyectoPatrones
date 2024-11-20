package santi.universidadpiloto;

import javax.swing.*;
import java.awt.*;

import Modelos.AdministradorInscripciones;
import Modelos.Estudiante;

public class GestorEstudianteVentana extends JDialog {
    private AdministradorInscripciones admin;

    public GestorEstudianteVentana(JFrame owner) {
        super(owner, "Gestión de Estudiantes", true);
        admin = AdministradorInscripciones.getInstance();
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Panel para crear estudiantes
        JPanel createPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        JTextField nombreField = new JTextField();
        JTextField idField = new JTextField();
        JTextField emailField = new JTextField();
        JButton agregarButton = new JButton("Registrar Estudiante");

        createPanel.add(new JLabel("Nombre:"));
        createPanel.add(nombreField);
        createPanel.add(new JLabel("ID:"));
        createPanel.add(idField);
        createPanel.add(new JLabel("Email:"));
        createPanel.add(emailField);
        createPanel.add(new JLabel(""));
        createPanel.add(agregarButton);

        // Panel para listar estudiantes
        JTextArea estudiantesArea = new JTextArea();
        estudiantesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(estudiantesArea);

        // Acción para agregar estudiantes
        agregarButton.addActionListener(_ -> {
            String nombre = nombreField.getText();
            String id = idField.getText();
            String email = emailField.getText();

            Estudiante nuevoEstudiante = new Estudiante(nombre, id, email);
            admin.registrarEstudiante(nuevoEstudiante);
            nombreField.setText("");
            idField.setText("");
            emailField.setText("");
            actualizarListado(estudiantesArea);
            admin.obtenerTodasLasMaterias().forEach(materia -> materia.agregarObservador(nuevoEstudiante));
        });

        add(createPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        actualizarListado(estudiantesArea);
        setLocationRelativeTo(owner); // Centrar respecto a la ventana principal
        setVisible(true);
    }

    private void actualizarListado(JTextArea estudiantesArea) {
        StringBuilder listado = new StringBuilder("Estudiantes:\n");
        for (Estudiante estudiante : admin.obtenerTodosLosEstudiantes()) {
            listado.append(estudiante.getNombre()).append(" (").append(estudiante.getId()).append(")\n");
        }
        estudiantesArea.setText(listado.toString());
    }
}
