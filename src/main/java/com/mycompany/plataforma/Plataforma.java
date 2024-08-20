/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.plataforma;
import java.util.Scanner;

/**
 *
 * @author pato4
 */

/**
 * Clase abstracta que representa una plataforma
 */

public abstract class Plataforma{
     protected String nombre;  // Nombre de la plataforma

    public Plataforma() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Plataforma: ");
        this.nombre = scanner.nextLine();
    }

    /**
     * Constructor con nombre para inicializar la plataforma.
     * @param nombre Nombre de la plataforma.
     */
    public Plataforma(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre de la plataforma.
     * @return Nombre de la plataforma.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la plataforma.
     * @param nombre Nombre de la plataforma.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Muestra la información básica de la plataforma.
     */
    protected void mostrarPlataforma() {
        System.out.println("Nombre de la Plataforma: " + nombre);
    }
}
