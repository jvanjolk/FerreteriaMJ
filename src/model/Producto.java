/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import observerstock.Observador;

/**
 *
 * @author jvanj
 */
public class Producto implements Cloneable {
    protected String nombre;
    protected int stock;
    private List<Observador> observadores = new ArrayList<>();

    public Producto(String nombre, int stock) {
        this.nombre = nombre;
        this.stock = stock;
    }

    public String getNombre() { return nombre; }
    public int getStock() { return stock; }

    public void setStock(int stock) {
        this.stock = stock;
        if (stock < 2) {
            notificarObservadores();
        }
    }

    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void eliminarObservador(Observador o) {
        observadores.remove(o);
    }

    private void notificarObservadores() {
        for (Observador o : observadores) {
            o.actualizar(this);
        }
    }

    public Producto clonar() {
        try {
            Producto clon = (Producto) super.clone();
            clon.observadores = new ArrayList<>(); 
            clon.nombre = this.nombre + " (Clon xd)";
            return clon;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
