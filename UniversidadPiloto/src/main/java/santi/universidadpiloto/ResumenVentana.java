package santi.universidadpiloto;

import java.util.List;

import javax.swing.*;
import java.awt.*;

import Modelos.AdministradorInscripciones;
import Modelos.Estudiante;
import Modelos.Materia;
import interfaces.IMateria;

public class ResumenVentana extends JDialog {
    private AdministradorInscripciones admin;

    public ResumenVentana(JFrame owner) {
        super(owner, "Resumen de Materias y Estudiantes", true);
        admin = AdministradorInscripciones.getInstance();
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Panel de selección para mostrar resumen de Materias o Estudiantes
        JPanel selectionPanel = new JPanel(new FlowLayout());
        JComboBox<String> resumenComboBox = new JComboBox<>();
        resumenComboBox.addItem("Resumen de Materias");
        resumenComboBox.addItem("Resumen de Estudiantes");
        JButton mostrarButton = new JButton("Mostrar Resumen");

        selectionPanel.add(resumenComboBox);
        selectionPanel.add(mostrarButton);

        JTextArea resumenArea = new JTextArea();
        resumenArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resumenArea);

        // Acción al presionar el botón
        mostrarButton.addActionListener(_ -> {
            if (resumenComboBox.getSelectedItem().equals("Resumen de Materias")) {
                mostrarResumenDeMaterias(resumenArea);
            } else {
                mostrarResumenDeEstudiantes(resumenArea);
            }
        });

        add(selectionPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(owner);
        setVisible(true);
    }

    // Mostrar el resumen de todas las materias con los estudiantes inscritos
    private void mostrarResumenDeMaterias(JTextArea resumenArea) {
        List<IMateria> materias = admin.obtenerTodasLasMaterias();
        StringBuilder resumen = new StringBuilder();

        for (IMateria materia : materias) {
            resumen.append(materia.toString()).append("\n");
            for (Estudiante estudiante : (materia).getEstudiantesInscritos()) {
                resumen.append("  - " + estudiante.getNombre()).append("\n");
            }
            resumen.append("\n");
        }

        resumenArea.setText(resumen.toString());
    }

    // Mostrar el resumen de todos los estudiantes con las materias en las que están
    // inscritos
    private void mostrarResumenDeEstudiantes(JTextArea resumenArea) {
        List<Estudiante> estudiantes = admin.obtenerTodosLosEstudiantes();
        StringBuilder resumen = new StringBuilder();

        for (Estudiante estudiante : estudiantes) {
            resumen.append(estudiante.getNombre()).append(" (" + estudiante.getId() + ")\n");
            for (IMateria materia : estudiante.getMateriasInscritas()) {
                resumen.append("  - " + materia.getNombre()).append("\n");
            }
            resumen.append("\n");
        }

        resumenArea.setText(resumen.toString());
    }
}
