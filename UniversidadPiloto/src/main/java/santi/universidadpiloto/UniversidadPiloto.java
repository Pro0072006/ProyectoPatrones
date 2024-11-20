/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package santi.universidadpiloto;

import javax.swing.*;
import java.awt.*;

import Modelos.AdministradorInscripciones;
import Modelos.Estudiante;
import Modelos.Materia;

/**
 *
 * @author santi
 */
public class UniversidadPiloto extends JFrame {

    public UniversidadPiloto() {
        setTitle("Sistema de Inscripción Universitaria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton materiasButton = new JButton("Gestión de Materias");
        JButton estudiantesButton = new JButton("Gestión de Estudiantes");
        JButton inscripcionesButton = new JButton("Inscripción de Estudiantes");
        JButton resumenButton = new JButton("Resumen de Inscripciones");

        // Listeners para abrir las ventanas
        materiasButton.addActionListener(_ -> new GestorMateriaVentana(this));
        estudiantesButton.addActionListener(_ -> new GestorEstudianteVentana(this));
        inscripcionesButton.addActionListener(_ -> new InscripcionVentana(this));
        resumenButton.addActionListener(_ -> new ResumenVentana(this));

        add(materiasButton);
        add(estudiantesButton);
        add(inscripcionesButton);
        add(resumenButton);

        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        var admin = AdministradorInscripciones.getInstance();

        // Crear materias de ejemplo
        admin.agregarMateria(new Materia("Matematicas", "MAT101", "Lunes 8:00 - 10:00", 30));
        admin.agregarMateria(new Materia("Fisica", "FIS101", "Martes 10:00 - 12:00", 25));
        admin.agregarMateria(new Materia("Programacion", "PROG101", "Miércoles 14:00 - 16:00", 20));

        // Crear estudiantes de ejemplo
        admin.registrarEstudiante(new Estudiante("Juan Pérez", "123456", ""));
        admin.registrarEstudiante(new Estudiante("María López", "654321", ""));
        admin.registrarEstudiante(new Estudiante("Carlos Ramírez", "456789", ""));

        admin.obtenerTodasLasMaterias().forEach(materia -> {
            materia.agregarObservador(admin.obtenerEstudiante("Juan Pérez"));
            materia.agregarObservador(admin.obtenerEstudiante("María López"));
            materia.agregarObservador(admin.obtenerEstudiante("Carlos Ramírez"));
        });
        SwingUtilities.invokeLater(UniversidadPiloto::new);
    }
}
