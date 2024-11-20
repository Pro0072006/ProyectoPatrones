package proxy;

import java.util.ArrayList;

public class TarjetaDeCredito implements IProducto {
    private String numeroTarjeta;
    private String codigoSeguridad;
    private String fechaExpiracion;
    private ArrayList<String> compras;
    private boolean activo;

    public TarjetaDeCredito(String numeroTarjeta, String codigoSeguridad, String fechaExpiracion) {
        this.numeroTarjeta = numeroTarjeta;
        this.codigoSeguridad = codigoSeguridad;
        this.fechaExpiracion = fechaExpiracion;
        compras = new ArrayList<>();
        activo = true;
    }

    public void agregarCompra(String compra) {
        compras.add(compra);
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

    public boolean estaActivo() {
        return activo;
    }

    public void activar() {
        activo = true;
    }

    public void desactivar() {
        activo = false;
    }

    @Override
    public String getTipoDeProducto() {
        return "Tarjeta de Crédito\nNúmero: " + numeroTarjeta + "\nFecha de Expiración: " + fechaExpiracion;
    }
}
