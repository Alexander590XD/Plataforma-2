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

    private int numeroTrack;        // Número de track en el álbum
    private boolean esExplicita;    // Indica si la canción es explícita

    /**
     * Constructor vacío que solicita datos al usuario.
     */
    public Cancion() {
        super();  // Llama al constructor de Audio
        Scanner scanner = new Scanner(System.in);

        // Solicita información específica para la canción
        System.out.print("Número de Track: ");
        this.numeroTrack = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("¿Es explícita? (true/false): ");
        this.esExplicita = scanner.nextBoolean();
        scanner.nextLine();
    }

    /**
     * Constructor con parámetros para inicializar una canción.
     */
    public Cancion(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechaLanzamiento,
                   String artista, String album, String genero, String compositor, String discografica, String letra,
                   int numeroTrack, boolean esExplicita) {
        super(nombre, idElemento, titulo, duracion, calidad, fechaLanzamiento, artista, album, genero, compositor, discografica, letra);
        this.numeroTrack = numeroTrack;
        this.esExplicita = esExplicita;
    }
    
    // Getters y setters para los atributos

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

    /**
     * Muestra la información de la canción.
     * Llama al método mostrarInfo() de la clase Audio.
     */
    public void mostrarInfoCancion() {
        super.mostrarInfo(); // Muestra la información básica del audio
        System.out.println("Número de Track: " + numeroTrack);
        System.out.println("Es explícita: " + (esExplicita ? "Sí" : "No"));
    }
    
    /**
     * Permite modificar la información de la canción.
     */
    public void modificarInformacion() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese nuevo número de track (actual: " + numeroTrack + "): ");
        this.numeroTrack = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("¿Es explícita? (true/false, actual: " + (esExplicita ? "Sí" : "No") + "): ");
        this.esExplicita = scanner.nextBoolean();
        scanner.nextLine();
    }
}
