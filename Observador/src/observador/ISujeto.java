package observador;

public interface ISujeto {
    void agregarObservador(IObservador observador);

    void eliminarObservador(IObservador observador);

    void notificarObservadores();
}
