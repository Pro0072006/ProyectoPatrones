/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package decorator;

/**
 *
 * @author santi
 */
public class Decorator {

    public static void main(String[] args) {
        // Crear un producto concreto
        IProducto producto = new TarjetaDeCredito("1234-5678-9012-3456", "061", "12/2025");

        // Mostrar el estado inicial del producto
        System.out.println("Producto tipo: " + producto.getTipoDeProducto());
        System.out.println("¿Está activa?: " + producto.estaActivo());

        // Decorar el producto con la funcionalidad de log
        IProducto productoConLog = new TarjetaDeCreditoLog(producto);

        // Activar y desactivar el producto decorado
        System.out.println("\n--- Activando el producto ---");
        productoConLog.activar();
        System.out.println("¿Está activa?: " + productoConLog.estaActivo());

        System.out.println("\n--- Desactivando el producto ---");
        productoConLog.desactivar();
        System.out.println("¿Está activa?: " + productoConLog.estaActivo());
    }

}
