/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jvanj
 */
public class AdaptadorProducto extends Producto {
    public AdaptadorProducto(ProductoExterno externo) {
        super(externo.getTitulo(), externo.getCantidad());
    }
}

