package Modelos;

import java.util.List;

import interfaces.IMateria;
import interfaces.IObservador;

public class MateriaDecorador implements IMateria {
    private Materia materia;

    public MateriaDecorador(Materia materia) {
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inscribir'");
    }

    @Override
    public int getCupo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCupo'");
    }

    @Override
    public void agregarObservador(IObservador observador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarObservador'");
    }

    @Override
    public void notificarObservadores(String mensaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notificarObservadores'");
    }

    @Override
    public void removerObservador(IObservador observador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerObservador'");
    }

    @Override
    public List<Estudiante> getEstudiantesInscritos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEstudiantesInscritos'");
    }
}
