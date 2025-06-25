
import gestor.GestorInventario;
import model.AdaptadorProducto;
import model.Producto;
import model.ProductoExterno;
import observerstock.ObservadorStock;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author jvanj
 */
public class NewMain {
    public static void main(String[] args) {
        GestorInventario inventario = GestorInventario.obtenerInstancia();

        Producto martillo = new Producto("Martillo", 10);
        Producto clavos = new Producto("Clavos", 3);

        ObservadorStock observadorAdmin = new ObservadorStock("Admin Juan");
        clavos.agregarObservador(observadorAdmin);

        inventario.agregarProducto(martillo);
        inventario.agregarProducto(clavos);

        clavos.setStock(3); // sin alerta
        clavos.setStock(1); // alerta

        // Adapter
        ProductoExterno prodExt = new ProductoExterno("Taladro XYZ", 15);
        AdaptadorProducto adaptador = new AdaptadorProducto(prodExt);
        inventario.agregarProducto(adaptador);

        // Prototype aplicado a productos
        Producto copiaMartillo = martillo.clonar();
        copiaMartillo.setStock(5); // nueva copia con stock diferente
        inventario.agregarProducto(copiaMartillo);

        System.out.println("Sistema de ferretería cargado exitosamente.");
    }
}
