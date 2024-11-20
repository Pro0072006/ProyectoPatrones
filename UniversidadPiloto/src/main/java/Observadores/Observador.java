package Observadores;

import interfaces.IObservador;

public class Observador implements IObservador {
    @Override
    public void actualizar(String mensaje) {
        System.out.println(mensaje);
    }
}
