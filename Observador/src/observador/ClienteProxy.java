package observador;

public class ClienteProxy implements ICliente {
    private Cliente cliente;
    private String rol;

    public ClienteProxy(Cliente cliente, String rol) {
        this.cliente = cliente;
        this.rol = rol;
    }

    public void realizarOperacion(String operacion) {
        if (tienePermisos(rol, operacion)) {
            cliente.realizarOperacion(operacion);
        } else {
            System.out.println("No tiene permisos para realizar esta operación: " + operacion);
        }
    }

    public boolean tienePermisos(String permiso, String operacion) {
        switch (permiso) {
            case "admin":
                return true;
            case "usuario":
                if (operacion.equals("autenticar") || operacion.equals("recuperarPassword")
                        || operacion.equals("getProducto")) {
                    return true;
                }
                break;
            case "funcionario":
                if (operacion.equals("agregarProducto") || operacion.equals("recuperarPassword")) {
                    return true;
                }
                break;
            default:
                return false;
        }

        return false;
    }

}
