package observador;

public abstract class ProductoDecorador implements IProducto {
    protected IProducto productoDecorado;

    public ProductoDecorador(IProducto producto) {
        this.productoDecorado = producto;
    }

    @Override
    public boolean estaActivo() {
        return productoDecorado.estaActivo();
    }

    @Override
    public String getTipoDeProducto() {
        return productoDecorado.getTipoDeProducto();
    }

    @Override
    public void activar() {
        productoDecorado.activar();
    }

    @Override
    public void desactivar() {
        productoDecorado.desactivar();
    }
}
