package Modelos;

import java.util.HashSet;
import java.util.Set;

import interfaces.IObservador;

public class Estudiante implements IObservador {
    private String nombre;
    private String id;
    private String email;
    private Set<Materia> materiasInscritas;

    public Estudiante(String nombre, String id, String email) {
        this.nombre = nombre;
        this.id = id;
        this.email = email;
        this.materiasInscritas = new HashSet<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Materia> getMateriasInscritas() {
        return materiasInscritas;
    }

    public void setMateriasInscritas(Set<Materia> materiasInscritas) {
        this.materiasInscritas = materiasInscritas;
    }

    // Métodos de inscripción
    public void inscribirMateria(Materia materia) {
        if (materiasInscritas.contains(materia)) {
            System.out.println("El estudiante ya está inscrito en la materia " + materia.getNombre());
        } else {
            materiasInscritas.add(materia);
            System.out.println("Inscripción exitosa en " + materia.getNombre());
        }
    }

    public void desinscribirMateria(Materia materia) {
        if (materiasInscritas.contains(materia)) {
            materiasInscritas.remove(materia);
            System.out.println("Desinscripción exitosa de " + materia.getNombre());
        } else {
            System.out.println("El estudiante no está inscrito en la materia " + materia.getNombre());
        }
    }

    // Representación en texto del estudiante
    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Notificación para " + nombre + ": " + mensaje);
    }
}
