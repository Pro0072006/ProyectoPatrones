package observador;

public class TarjetaDeCreditoLog extends ProductoDecorador {

    public TarjetaDeCreditoLog(IProducto producto) {
        super(producto);
    }

    @Override
    public void activar() {
        super.activar();
        registrarMovimiento("Producto activado.");
    }

    @Override
    public void desactivar() {
        super.desactivar();
        registrarMovimiento("Producto desactivado.");
    }

    private void registrarMovimiento(String mensaje) {
        // Aquí iría la lógica para registrar el movimiento, como agregarlo a una lista
        // o archivo.
        System.out.println("Log: " + mensaje);
    }
}
