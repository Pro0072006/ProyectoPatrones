package proxy;

public interface IProducto {
    public boolean estaActivo();

    public void activar();

    public void desactivar();

    public String getTipoDeProducto();
}
