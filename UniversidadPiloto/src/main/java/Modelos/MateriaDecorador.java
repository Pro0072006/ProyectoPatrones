package Modelos;

import java.util.List;

import interfaces.IMateria;
import interfaces.IObservador;

public class MateriaDecorador implements IMateria {
    private IMateria materia;

    public MateriaDecorador(IMateria materia) {
        this.materia = materia;
    }

    @Override
    public String getNombre() {
        return materia.getNombre();
    }

    @Override
    public String getCodigo() {
        return materia.getCodigo();
    }

    @Override
    public String getHorario() {
        return materia.getHorario();
    }

    @Override
    public void inscribir(Estudiante estudiante) {
        materia.inscribir(estudiante);
    }

    @Override
    public int getCupo() {
        return materia.getCupo();
    }

    @Override
    public void agregarObservador(IObservador observador) {
        materia.agregarObservador(observador);
    }

    @Override
    public void notificarObservadores(String mensaje) {
        materia.notificarObservadores(mensaje);
    }

    @Override
    public void removerObservador(IObservador observador) {
        materia.removerObservador(observador);
    }

    @Override
    public List<Estudiante> getEstudiantesInscritos() {
        return materia.getEstudiantesInscritos();
    }

    @Override
    public String toString() {
        return materia.toString();
    }
}
