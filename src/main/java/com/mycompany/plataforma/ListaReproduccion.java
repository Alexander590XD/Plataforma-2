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
    private List<String> contenido; // Lista de IDs o nombres de contenido

    public ListaReproduccion(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
    }

    public void agregarContenido(String item) {
        contenido.add(item);
    }

    public void eliminarContenido(String item) {
        contenido.remove(item);
    }

    public void mostrarContenido() {
        System.out.println("Lista de Reproducción: " + nombre);
        for (String item : contenido) {
            System.out.println(" - " + item);
        }
    }
}
