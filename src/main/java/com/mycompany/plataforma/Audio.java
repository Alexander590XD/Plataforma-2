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
    
     protected String artista;  // Artista del audio
    protected String album;  // Nombre del álbum
    protected String genero;  // Género del audio
    protected String compositor;  // Compositor del audio
    protected String discografica;  // Discográfica del audio
    private String letra;  // Letra de la canción

    /**
     * Constructor vacío que solicita datos al usuario.
     */
    public Audio() {
        super();
        Scanner scanner = new Scanner(System.in);
        this.artista = promptString(scanner, "Artista: ");
        this.album = promptString(scanner, "Nombre del álbum: ");
        this.genero = promptString(scanner, "Género: ");
        this.compositor = promptString(scanner, "Compositor: ");
        this.discografica = promptString(scanner, "Discográfica: ");
        this.letra = promptString(scanner, "Letra: ");
    }

    /**
     * Constructor con parámetros para inicializar un audio.
    */
    public Audio(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechaLanzamiento,
                 String artista, String album, String genero, String compositor, String discografica, String letra) {
        super(nombre, idElemento, titulo, duracion, calidad, fechaLanzamiento);
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.compositor = compositor;
        this.discografica = discografica;
        this.letra = letra;
    }

    // Getters y setters para los atributos

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

    /**
     * Implementación del método abstracto para mostrar la información del audio.
     */
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();  // Muestra la información básica del elemento multimedia
        System.out.println("Artista: " + artista);
        System.out.println("Álbum: " + album);
        System.out.println("Género: " + genero);
        System.out.println("Compositor: " + compositor);
        System.out.println("Discográfica: " + discografica);
    }

    private String promptString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        scanner.nextLine();  // Consume el salto de línea pendiente
        return scanner.nextLine();
    }
}
