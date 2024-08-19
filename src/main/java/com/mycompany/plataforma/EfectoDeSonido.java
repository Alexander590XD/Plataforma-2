/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.time.LocalDate;
import java.util.Scanner;
/**
 * Clase que representa un efecto de sonido.
 * Hereda de Audio y añade atributos específicos para un efecto de sonido.
 */
public class EfectoDeSonido extends Audio {

    private String tipo;            // Tipo de efecto de sonido
    private String descripcion;     // Descripción del efecto de sonido

    /**
     * Constructor vacío que solicita datos al usuario.
     */
    public EfectoDeSonido() {
        super();  // Llama al constructor de Audio
        Scanner scanner = new Scanner(System.in);

        // Solicita información específica para el efecto de sonido
        System.out.print("Tipo de efecto: ");
        this.tipo = scanner.nextLine();

        System.out.print("Descripción: ");
        this.descripcion = scanner.nextLine();
    }

    /**
     * Constructor con parámetros para inicializar un efecto de sonido.
     */
    public EfectoDeSonido(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechaLanzamiento,
                          String artista, String album, String genero, String compositor, String discografica, String letra,
                          String tipo, String descripcion) {
        super(nombre, idElemento, titulo, duracion, calidad, fechaLanzamiento, artista, album, genero, compositor, discografica, letra);
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    // Getters y setters para los atributos

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Muestra la información del efecto de sonido.
     * Llama al método mostrarInfo() de la clase Audio.
     */
    public void mostrarInfoEfecto() {
        super.mostrarInfo(); // Muestra la información básica del audio
        System.out.println("Tipo de efecto: " + tipo);
        System.out.println("Descripción: " + descripcion);
    }
    
    /**
     * Permite modificar la información del efecto de sonido.
     */
    public void modificarInformacion() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nuevo tipo de efecto (actual: " + tipo + "): ");
        this.tipo = scanner.nextLine();

        System.out.print("Ingrese la nueva descripción (actual: " + descripcion + "): ");
        this.descripcion = scanner.nextLine();
    }
}