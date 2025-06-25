/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observerstock;

import model.Producto;

/**
 *
 * @author jvanj
 */
public class ObservadorStock implements Observador {
    private String nombre;

    public ObservadorStock(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(Producto p) {
        System.out.println("[ALERTA] " + nombre + ": El stock de " + p.getNombre() + " es bajo: " + p.getStock());
    }
}
