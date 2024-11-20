/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.ArrayList;
import java.util.List;

import interfaces.IMateria;
import interfaces.IObservador;

/**
 *
 * @author santi
 */
public class Materia implements IMateria {
    private String nombre;
    private String codigo;
    private String horario;
    private int cupo;
    private List<IObservador> observadores = new ArrayList<>();
    private List<Estudiante> estudiantesInscritos = new ArrayList<>();

    public Materia(String nombre, String codigo, String horario, int cupo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.horario = horario;
        this.cupo = cupo;
    }

    @Override
    public void inscribir(Estudiante estudiante) {
        if (estudiantesInscritos.contains(estudiante)) {
            System.out.println(
                    "El estudiante " + estudiante.getNombre() + " ya está inscrito en la materia " + nombre + ".");
            return;
        }
        if (cupo > 0) {
            estudiantesInscritos.add(estudiante);
            estudiante.inscribirMateria(this);
            System.out.println("Te has inscrito en la materia " + nombre + ".");
            cupo--;
            observadores.remove(estudiante);
            notificarObservadores("La cantidad de cupos en la materia " + nombre + " disminuyó a " + cupo + ".");
            if (cupo == 0) {
                notificarObservadores("La materia " + nombre + " está llena.");
            }
        } else {
            estudiante.actualizar("No hay cupos disponibles para " + nombre + ".");
        }
    }

    public void liberarCupo() {
        if (!estudiantesInscritos.isEmpty()) {
            Estudiante estudianteRemovido = estudiantesInscritos.remove(0);
            cupo++;
            notificarObservadores("Un cupo se liberó en la materia " + nombre +
                    " tras la salida de " + estudianteRemovido.getNombre() + ".");
        } else {
            System.out.println("No hay estudiantes inscritos para liberar un cupo.");
        }
    }

    public void agregarObservador(IObservador observador) {
        if (observadores.contains(observador)) {
            return;
        }
        observadores.add(observador);
    }

    public void notificarObservadores(String mensaje) {
        for (IObservador observador : observadores) {
            observador.actualizar(mensaje);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getCupo() {
        return cupo;
    }

    public List<Estudiante> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    @Override
    public void removerObservador(IObservador observador) {
        observadores.remove(observador);
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public String getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return nombre + " (" + codigo + ") (" + horario + ") - " + cupo + " cupos";
    }
}
