package decorator;

/**
 *
 * @author santi
 */
public class Banco {
    private int operacionesHechas;
    private String nombreBanco;
    private int codigoACH;

    private static Banco instance;

    private Banco() {
        operacionesHechas = 0;
        nombreBanco = "NU";
        codigoACH = 1102;
    }

    public static Banco getInstance() {
        if (instance == null) {
            instance = new Banco();
        }

        return instance;
    }

    public boolean cancelarTarjetaDeCredito(Cliente cliente) {
        System.out.println("Tarjeta de crédito cancelada del cliente: " + cliente.getCedula());
        operacionesHechas++;
        return true;
    }

    public boolean hacerCorteTarjetaDeCredito(Cliente cliente) {
        TarjetaDeCredito tarjeta = (TarjetaDeCredito) cliente.getProducto(0);
        System.out.println("Corte de tarjeta de crédito del cliente: " + cliente.getCedula());
        System.out.println("Intereses generados: $" + tarjeta.CalcularInteresesDeLasCompras());
        operacionesHechas++;
        return true;
    }

    public int getCodigoACH() {
        return codigoACH;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public int getOperacionesHechas() {
        return operacionesHechas;
    }
}
