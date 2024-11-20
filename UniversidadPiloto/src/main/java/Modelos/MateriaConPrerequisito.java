package Modelos;

import interfaces.IMateria;

public class MateriaConPrerequisito extends Materia {
    private IMateria prerrequisito;

    public MateriaConPrerequisito(String nombre, String codigo, String horario, int cupo, IMateria prerrequisito) {
        super(nombre, codigo, horario, cupo);
        this.prerrequisito = prerrequisito;
    }

    @Override
    public void inscribir(Estudiante estudiante) {
        // Verificar si el estudiante ha aprobado el prerrequisito
        if (!prerrequisito.getEstudiantesInscritos().contains(estudiante)) {
            notificarObservadores("El estudiante " + estudiante.getNombre() +
                    " no cumple con el prerrequisito para inscribirse en " + getNombre() + ".");
            return;
        }

        // Si cumple el prerrequisito, intentar inscribirlo normalmente
        super.inscribir(estudiante);
    }

    public IMateria getPrerrequisito() {
        return prerrequisito;
    }

    public void setPrerrequisito(Materia prerrequisito) {
        this.prerrequisito = prerrequisito;
    }

    @Override
    public String toString() {
        return super.toString() + " Prerrequisito: " + prerrequisito.getNombre();
    }
}
