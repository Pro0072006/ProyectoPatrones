package observador;

import java.util.ArrayList;

public class TarjetaDeCredito implements IProducto, ISujeto {
    private String numeroTarjeta;
    private String codigoSeguridad;
    private String fechaExpiracion;
    private ArrayList<String> compras;
    private boolean activo;
    private ArrayList<IObservador> observadores;

    public TarjetaDeCredito(String numeroTarjeta, String codigoSeguridad, String fechaExpiracion) {
        this.numeroTarjeta = numeroTarjeta;
        this.codigoSeguridad = codigoSeguridad;
        this.fechaExpiracion = fechaExpiracion;
        compras = new ArrayList<>();
        activo = true;
        observadores = new ArrayList<>();
    }

    public void agregarCompra(String compra) {
        compras.add(compra);
        notificarObservadores();
    }

    public int CalcularInteresesDeLasCompras() {
        int intereses = 0;
        for (String compra : compras) {
            intereses += 10;
        }
        return intereses;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    @Override
    public boolean estaActivo() {
        return activo;
    }

    @Override
    public void activar() {
        activo = true;
    }

    @Override
    public void desactivar() {
        activo = false;
    }

    @Override
    public String getTipoDeProducto() {
        return "Tarjeta de Crédito\nNúmero: " + numeroTarjeta + "\nFecha de Expiración: " + fechaExpiracion;
    }

    @Override
    public void agregarObservador(IObservador observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminarObservador(IObservador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for (IObservador observador : observadores) {
            observador.actualizar(compras.get(compras.size() - 1));
        }
    }
}
