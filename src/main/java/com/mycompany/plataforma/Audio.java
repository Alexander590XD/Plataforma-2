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
public class Audio extends ElementoMultimedia{
    
    protected String artista;
    protected String album;
    protected String genero;
    protected String compositor;
    protected String discografica;
    private String letra;

    public Audio() {
        super();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Artista: ");
        this.artista = scanner.nextLine();

        System.out.print("Nombre del álbum: ");
        this.album = scanner.nextLine();

        System.out.print("Género: ");
        this.genero = scanner.nextLine();

        System.out.print("Compositor: ");
        this.compositor = scanner.nextLine();

        System.out.print("Discográfica: ");
        this.discografica = scanner.nextLine();

        System.out.print("Letra: ");
        this.letra = scanner.nextLine();
    }

    public Audio(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechalanzamiento,
                 String artista, String album, String genero, String compositor, String discografica, String letra) {
        super(nombre, idElemento, titulo, duracion, calidad, fechalanzamiento);
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.compositor = compositor;
        this.discografica = discografica;
        this.letra = letra;
    }

    // Getters and Setters
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo(); // Muestra la información básica del elemento multimedia
        System.out.println("Artista: " + artista);
        System.out.println("Álbum: " + album);
        System.out.println("Género: " + genero);
        System.out.println("Compositor: " + compositor);
        System.out.println("Discográfica: " + discografica);
    }
}
