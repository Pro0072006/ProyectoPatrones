package proxy;

import java.util.ArrayList;

public class Cliente implements ICliente {
    private int cedula;
    private ArrayList<IProducto> productos;
    private String password;
    private boolean autenticado;

    public Cliente(int cedula, String password) {
        this.cedula = cedula;
        productos = new ArrayList<>();
        this.password = password;
        autenticado = false;
    }

    public int getCedula() {
        return cedula;
    }

    private void agregarProducto(IProducto producto) {
        productos.add(producto);
    }

    public IProducto getProducto(int index) {
        return productos.get(index);
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    private void autenticar(String password) {
        if (this.password.equals(password)) {
            autenticado = true;
        } else {
            autenticado = false;
        }
    }

    private void RecuperarPassword() {
        System.out.println("Enviando correo con la contraseña al cliente: " + cedula);
    }

    public void realizarOperacion(String operacion) {
        switch (operacion) {
            case "autenticar":
                autenticar("1234");
                System.out.println("Cliente autenticado con éxito");
                break;
            case "agregarProducto":
                agregarProducto(null);
                System.out.println("Producto agregado con éxito");
                break;
            case "getProducto":
                getProducto(0);
                System.out.println("Producto obtenido con éxito");
                break;
            case "recuperarPassword":
                RecuperarPassword();
                System.out.println("Contraseña recuperada con éxito");
                break;
            default:
                System.out.println("Operación no permitida");
        }
    }
}
