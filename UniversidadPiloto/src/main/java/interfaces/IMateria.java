/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;

import Modelos.Estudiante;

/**
 *
 * @author santi
 */
public interface IMateria {
    void inscribir(Estudiante estudiante);

    String getNombre();

    int getCupo();

    void agregarObservador(IObservador observador);

    void notificarObservadores(String mensaje);

    void removerObservador(IObservador observador);

    String getCodigo();

    String getHorario();

    public List<Estudiante> getEstudiantesInscritos();
}
