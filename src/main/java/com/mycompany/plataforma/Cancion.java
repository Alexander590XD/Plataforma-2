/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.time.LocalDate;
import java.util.Scanner;
/**
 * Clase que representa una canción.
 * Hereda de Audio y añade atributos específicos para una canción.
 */
public class Cancion extends Audio {

    // Atributos específicos de la canción
    private int numeroTrack;    // Número de la pista en el álbum
    private boolean esExplicita; // Indica si la canción tiene contenido explícito

    // Constructor por defecto
    public Cancion() {
        super();  // Llama al constructor de la clase base Audio
        Scanner scanner = new Scanner(System.in);

        // Solicita información adicional al usuario
        System.out.print("Número de Track: ");
        this.numeroTrack = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("¿Es explícita? (true/false): ");
        this.esExplicita = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar el buffer
    }

    // Constructor con parámetros para inicializar todos los atributos
    public Cancion(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechalanzamiento,
                   String artista, String album, String genero, String compositor, String discografica, String letra,
                   int numeroTrack, boolean esExplicita) {
        super(nombre, idElemento, titulo, duracion, calidad, fechalanzamiento, artista, album, genero, compositor, discografica, letra);
        this.numeroTrack = numeroTrack;
        this.esExplicita = esExplicita;
    }

    // Getters y Setters para los atributos
    public int getNumeroTrack() {
        return numeroTrack;
    }

    public void setNumeroTrack(int numeroTrack) {
        this.numeroTrack = numeroTrack;
    }

    public boolean isEsExplicita() {
        return esExplicita;
    }

    public void setEsExplicita(boolean esExplicita) {
        this.esExplicita = esExplicita;
    }

    // Método para mostrar información de la canción
    public void mostrarInfoCancion() {
        super.mostrarInfo(); // Llama al método mostrarInfo() de la clase Audio
        System.out.println("Número de Track: " + numeroTrack);
        System.out.println("Es explícita: " + (esExplicita ? "Sí" : "No"));
    }

    // Método para modificar información de la canción
    public void modificarInformacion() {
       Scanner scanner = new Scanner(System.in);

        // Solicita al usuario el nuevo número de track
        System.out.print("Por favor, proporcione el nuevo número de track (actual: " + numeroTrack + "): ");
        this.numeroTrack = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Solicita al usuario si el contenido es explícito
        System.out.print("Indique si el contenido es explícito (true/false, actual: " + (esExplicita ? "Sí" : "No") + "): ");
        this.esExplicita = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar el buffer
    }
}
