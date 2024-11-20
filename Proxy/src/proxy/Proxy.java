package proxy;

/**
 *
 * @author santi
 */
public class Proxy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente clienteAdmin = new Cliente(120563214, "1234");
        ClienteProxy proxyAdmin = new ClienteProxy(clienteAdmin, "admin");

        System.out.println("Proxy con permisos de administrador");
        proxyAdmin.realizarOperacion("autenticar"); // Permitir acceso
        proxyAdmin.realizarOperacion("agregarProducto"); // Permitir acceso

        System.out.println("\n-------------------------------------------------");

        Cliente clienteUsuario = new Cliente(1023245859, "1234");
        ClienteProxy proxyUsuario = new ClienteProxy(clienteUsuario, "usuario");

        System.out.println("\nProxy con permisos de usuario");
        proxyUsuario.realizarOperacion("agregarProducto"); // Acceso denegado
        proxyUsuario.realizarOperacion("recuperarPassword"); // Permitir acceso

        System.out.println("\n-------------------------------------------------");

        Cliente clienteFuncionario = new Cliente(259654152, "1234");
        ClienteProxy proxyFuncionario = new ClienteProxy(clienteFuncionario, "funcionario");

        System.out.println("\nProxy con permisos de funcionario");
        proxyFuncionario.realizarOperacion("autenticar");// Acceso denegado;
        proxyFuncionario.realizarOperacion("recuperarPassword"); // Permitir acceso
    }

}
