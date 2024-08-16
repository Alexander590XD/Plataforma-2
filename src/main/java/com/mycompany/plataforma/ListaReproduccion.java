/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pato4
 */
public class ListaReproduccion {
    private String nombre;
    private List<Video> contenido; // Lista de objetos Video (incluye Series y Películas)

    public ListaReproduccion(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
    }

    public void agregarContenido(Video item) {
        contenido.add(item);
    }

    public void eliminarContenido(Video item) {
        contenido.remove(item);
    }

    public void mostrarContenido() {
        System.out.println("Lista de Reproducción: " + nombre);
        for (Video item : contenido) {
            item.mostrarInfo(); // Llama al método mostrarInfo() de la clase Video
        }
    }

    public String getNombre() {
        return nombre;
    }
}
