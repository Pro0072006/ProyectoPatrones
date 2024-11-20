package Modelos;

import java.util.ArrayList;
import java.util.List;

import interfaces.IMateria;

public class AdministradorInscripciones {
    private static AdministradorInscripciones instancia;

    private List<IMateria> materias;
    private List<Estudiante> estudiantes;

    // Constructor privado para Singleton
    private AdministradorInscripciones() {
        materias = new ArrayList<>();
        estudiantes = new ArrayList<>();
    }

    // Método estático para obtener la única instancia
    public static AdministradorInscripciones getInstance() {
        if (instancia == null) {
            instancia = new AdministradorInscripciones();
        }
        return instancia;
    }

    // Métodos de gestión de materias
    public void agregarMateria(IMateria materia) {
        materias.add(materia);
    }

    public IMateria obtenerMateria(String nombre) {
        for (IMateria materia : materias) {
            if (materia.getNombre().equalsIgnoreCase(nombre)) {
                return materia;
            }
        }
        return null; // No encontrada
    }

    public List<IMateria> obtenerTodasLasMaterias() {
        return materias;
    }

    // Métodos de gestión de estudiantes
    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public Estudiante obtenerEstudiante(String nombre) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombre)) {
                return estudiante;
            }
        }
        return null; // No encontrado
    }

    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudiantes;
    }

    // Método para limpiar las listas (para pruebas)
    public void limpiarDatos() {
        materias.clear();
        estudiantes.clear();
    }
}
