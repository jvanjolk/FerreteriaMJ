/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import java.util.ArrayList;
import java.util.List;
import model.Producto;

/**
 *
 * @author jvanj
 */
public class GestorInventario {
    private static GestorInventario instancia;
    private List<Producto> productos = new ArrayList<>();

    private GestorInventario() {}

    public static GestorInventario obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorInventario();
        }
        return instancia;
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
        System.out.println("Producto agregado: " + p.getNombre());
    }
}