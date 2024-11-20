package santi.universidadpiloto;

import javax.swing.*;
import java.awt.*;

import Modelos.AdministradorInscripciones;
import Modelos.Materia;
import Modelos.MateriaConPrerequisito;
import interfaces.IMateria;

public class GestorMateriaVentana extends JDialog {
    private AdministradorInscripciones admin;

    public GestorMateriaVentana(JFrame owner) {
        super(owner, "Gestión de Materias", true);
        admin = AdministradorInscripciones.getInstance();
        setSize(500, 400);
        setLayout(new BorderLayout());

        // Panel para crear materias
        JPanel createPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        JTextField nombreField = new JTextField();
        JTextField codigoField = new JTextField();
        JTextField horarioField = new JTextField();
        JTextField cupoField = new JTextField();
        JTextField prerequisitoField = new JTextField();
        JButton agregarButton = new JButton("Agregar Materia");

        createPanel.add(new JLabel("Nombre del curso:"));
        createPanel.add(nombreField);
        createPanel.add(new JLabel("Código:"));
        createPanel.add(codigoField);
        createPanel.add(new JLabel("Horario:"));
        createPanel.add(horarioField);
        createPanel.add(new JLabel("Cupo:"));
        createPanel.add(cupoField);
        createPanel.add(new JLabel("Prerequisito:"));
        createPanel.add(prerequisitoField);
        createPanel.add(new JLabel(""));
        createPanel.add(agregarButton);

        // Panel para listar materias
        JTextArea materiasArea = new JTextArea();
        materiasArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(materiasArea);

        // Acción para agregar materias
        agregarButton.addActionListener(_ -> {
            String nombre = nombreField.getText();
            String codigo = codigoField.getText();
            String horario = horarioField.getText();
            int cupo;

            if (nombre.length() == 0 || codigo.length() == 0 || horario.length() == 0
                    || cupoField.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Todos los campos son requeridos.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                cupo = Integer.parseInt(cupoField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Cupo debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            IMateria materia;

            if (prerequisitoField.getText().length() > 0) {
                IMateria materiaBusqueda = admin.obtenerMateria(prerequisitoField.getText().toLowerCase());
                if (materiaBusqueda == null) {
                    JOptionPane.showMessageDialog(this,
                            "No se encontró la materia con código " + prerequisitoField.getText().toLowerCase(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                materia = new MateriaConPrerequisito(nombre, codigo, horario, cupo, materiaBusqueda);
            } else {
                materia = new Materia(nombre, codigo, horario, cupo);
            }

            admin.agregarMateria(materia);
            nombreField.setText("");
            codigoField.setText("");
            horarioField.setText("");
            cupoField.setText("");
            admin.obtenerTodosLosEstudiantes().forEach(estudiante -> materia.agregarObservador(estudiante));
            actualizarListado(materiasArea);
        });

        add(createPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        actualizarListado(materiasArea);
        setLocationRelativeTo(owner);
        setVisible(true);
    }

    private void actualizarListado(JTextArea materiasArea) {
        StringBuilder listado = new StringBuilder("Materias:\n");
        for (IMateria materia : admin.obtenerTodasLasMaterias()) {
            listado.append(materia.toString()).append("\n");
        }
        materiasArea.setText(listado.toString());
    }
}
