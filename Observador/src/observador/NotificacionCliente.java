package observador;

public class NotificacionCliente implements IObservador {

    private String nombre;

    public NotificacionCliente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String movimiento) {
        System.out.println("Hola " + nombre + ", se ha realizado un nuevo movimiento en tu tarjeta.");
        System.out.println("Movimientos reciente: " + movimiento + "\n");
    }
}
