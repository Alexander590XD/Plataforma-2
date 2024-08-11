/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pato4
 */
public class Recomendacion {
    private Map<String, Integer> historialVisualizacion; // Contenidos y frecuencia de visualización

    public Recomendacion() {
        this.historialVisualizacion = new HashMap<>();
    }

    public void agregarVisualizacion(String contenido) {
        historialVisualizacion.put(contenido, historialVisualizacion.getOrDefault(contenido, 0) + 1);
    }

    public void mostrarRecomendaciones() {
        System.out.println("Recomendaciones Personalizadas:");
        // Simple recomendación basada en frecuencia de visualización
        historialVisualizacion.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // Ordenar por frecuencia
            .forEach(entry -> System.out.println(" - " + entry.getKey() + " (Visto " + entry.getValue() + " veces)"));
    }
}
