/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author pato4
 */
public class Cancion extends Audio {

    private int numeroTrack;
    private boolean esExplicita;
    
    public Cancion() {
        super();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Número de Track: ");
        this.numeroTrack = scanner.nextInt();
        scanner.nextLine();

        System.out.print("¿Es explícita? (true/false): ");
        this.esExplicita = scanner.nextBoolean();
        scanner.nextLine();
    }
    public Cancion(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechalanzamiento,
            String artista, String album, String genero, String compositor, String discografica, String letra,
            int numeroTrack, boolean esExplicita) {
        super(nombre, idElemento, titulo, duracion, calidad, fechalanzamiento, artista, album, genero, compositor,
                discografica, letra);
        this.numeroTrack = numeroTrack;
        this.esExplicita = esExplicita;
    }
    
    /**
     * @return the numeroTrack
     */
    public int getNumeroTrack() {
        return numeroTrack;
    }

    /**
     * @param numeroTrack the numeroTrack to set
     */
    public void setNumeroTrack(int numeroTrack) {
        this.numeroTrack = numeroTrack;
    }

    /**
     * @return the esExplicita
     */
    public boolean isEsExplicita() {
        return esExplicita;
    }

    /**
     * @param esExplicita the esExplicita to set
     */
    public void setEsExplicita(boolean esExplicita) {
        this.esExplicita = esExplicita;
    }
    
    public void reproducir() {
        System.out.println("Reproduciendo " + super.getTitulo());
    }

    public void agregarAPlaylist(String playlist) {
        System.out.println(super.getTitulo() + " agregada a la playlist: " + playlist);
    }
    public void mostrarInfoCancion() {
        super.mostrarInfo(); // Llama al método mostrarInfo() de la clase padre (Audio)
        System.out.println("Número de Track: " + numeroTrack);
        System.out.println("Es explícita: " + (esExplicita ? "Sí" : "No"));
    }
}
