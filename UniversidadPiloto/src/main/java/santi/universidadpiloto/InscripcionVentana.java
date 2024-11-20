package santi.universidadpiloto;

import java.util.List;

import javax.swing.*;
import java.awt.*;

import Modelos.AdministradorInscripciones;
import Modelos.Estudiante;
import interfaces.IMateria;

public class InscripcionVentana extends JDialog {
    private AdministradorInscripciones admin;

    public InscripcionVentana(JFrame owner) {
        super(owner, "Inscripción de Estudiantes", true);
        admin = AdministradorInscripciones.getInstance();
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Panel para seleccionar estudiante y materia
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));

        JComboBox<String> estudianteComboBox = new JComboBox<>();
        JComboBox<String> materiaComboBox = new JComboBox<>();
        JButton inscribirButton = new JButton("Inscribir");

        // Llenar los comboBox con estudiantes y materias
        actualizarComboBoxes(estudianteComboBox, materiaComboBox);

        inputPanel.add(new JLabel("Seleccionar Estudiante:"));
        inputPanel.add(estudianteComboBox);
        inputPanel.add(new JLabel("Seleccionar Materia:"));
        inputPanel.add(materiaComboBox);
        inputPanel.add(new JLabel(""));
        inputPanel.add(inscribirButton);

        // Área de notificaciones
        JTextArea resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane resultadoScrollPane = new JScrollPane(resultadoArea);

        // Acción para inscribir un estudiante
        inscribirButton.addActionListener(_ -> {
            String estudianteNombre = (String) estudianteComboBox.getSelectedItem();
            String materiaNombre = (String) materiaComboBox.getSelectedItem();

            Estudiante estudiante = admin.obtenerEstudiante(estudianteNombre);
            IMateria materia = admin.obtenerMateria(materiaNombre);

            if (estudiante == null || materia == null) {
                resultadoArea.setText("Error: Estudiante o materia no seleccionados.");
                return;
            }

            // Inscribir al estudiante y notificar
            materia.inscribir(estudiante);
            actualizarComboBoxes(estudianteComboBox, materiaComboBox);
        });

        add(inputPanel, BorderLayout.NORTH);
        add(resultadoScrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(owner); // Centrar respecto a la ventana principal
        setVisible(true);
    }

    // Actualizar los comboBoxes con la lista de estudiantes y materias
    private void actualizarComboBoxes(JComboBox<String> estudianteComboBox, JComboBox<String> materiaComboBox) {
        List<Estudiante> estudiantes = admin.obtenerTodosLosEstudiantes();
        List<IMateria> materias = admin.obtenerTodasLasMaterias();

        estudianteComboBox.removeAllItems();
        for (Estudiante estudiante : estudiantes) {
            estudianteComboBox.addItem(estudiante.getNombre());
        }

        materiaComboBox.removeAllItems();
        for (IMateria materia : materias) {
            materiaComboBox.addItem(materia.getNombre());
        }
    }
}
