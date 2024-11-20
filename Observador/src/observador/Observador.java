/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package observador;

/**
 *
 * @author santi
 */
public class Observador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear una tarjeta de crédito (sujeto)
        TarjetaDeCredito tarjeta = new TarjetaDeCredito("123456789", "123", "12/26");

        // Crear observadores (clientes)
        IObservador cliente1 = new NotificacionCliente("Gilberto");
        IObservador cliente2 = new NotificacionCliente("Sofia");

        // Registrar observadores
        tarjeta.agregarObservador(cliente1);
        tarjeta.agregarObservador(cliente2);

        // Añadir movimientos a la tarjeta
        tarjeta.agregarCompra("Compra en Supermercado $50");
        tarjeta.agregarCompra("Pago de Servicios $30");

        System.out.println("Estos mensaje anteriores, fueron notificaciones que genero la tarjeta de credito");
    }

}
