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

 // Atributos específicos del efecto de sonido
    private String tipo;         // Tipo de efecto de sonido
    private String descripcion;  // Descripción del efecto

    // Constructor por defecto
    public EfectoDeSonido() {
        super();  // Llama al constructor de la clase base Audio
        Scanner scanner = new Scanner(System.in);

        // Solicita información adicional al usuario
        System.out.print("Tipo de efecto: ");
        this.tipo = scanner.nextLine();

        System.out.print("Descripción: ");
        this.descripcion = scanner.nextLine();
    }

    // Constructor con parámetros para inicializar todos los atributos
    public EfectoDeSonido(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechalanzamiento,
                          String artista, String album, String genero, String compositor, String discografica, String letra,
                          String tipo, String descripcion) {
        super(nombre, idElemento, titulo, duracion, calidad, fechalanzamiento, artista, album, genero, compositor, discografica, letra);
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    // Getters y Setters para los atributos
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

    // Método para mostrar información del efecto de sonido
    public void mostrarInfoEfecto() {
        super.mostrarInfo(); // Llama al método mostrarInfo() de la clase Audio
        System.out.println("Tipo de efecto: " + tipo);
        System.out.println("Descripción: " + descripcion);
    }

    // Método para modificar información del efecto de sonido
    public void modificarInformacion() {
        Scanner scanner = new Scanner(System.in);

        // Solicita al usuario el nuevo tipo de efecto
        System.out.print("Por favor, proporcione el nuevo tipo de efecto (actualmente: " + tipo + "): ");
        this.tipo = scanner.nextLine();

        // Solicita al usuario la nueva descripción
        System.out.print("Por favor, proporcione la nueva descripción (actualmente: " + descripcion + "): ");
        this.descripcion = scanner.nextLine();
    }
}