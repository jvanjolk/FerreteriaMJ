/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jvanj
 */
public class ProductoExterno {
    private String titulo;
    private int cantidad;

    public ProductoExterno(String titulo, int cantidad) {
        this.titulo = titulo;
        this.cantidad = cantidad;
    }

    public String getTitulo() { return titulo; }
    public int getCantidad() { return cantidad; }
}
