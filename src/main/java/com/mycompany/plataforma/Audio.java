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
    
    
     public Audio(){
        super();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Arista: ");
        this.artista = scanner.nextLine();
        
        System.out.print("Nombre del album: ");
        this.album = scanner.nextLine();
        
        System.out.print("Genero: ");
        this.artista = scanner.nextLine();
         
        System.out.println("Compositor: ");
        this.compositor = scanner.nextLine();
        
        System.out.print("Discografia: ");
        this.discografica = scanner.nextLine();
        
        System.out.print("Letra: ");
        this.letra = scanner.nextLine();
    }
    
    public Audio(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechalanzamiento,String artista,String album,String genero,String compositor, String discografica,String letra ){
        super(nombre,idElemento,titulo,duracion,calidad,fechalanzamiento);
        this.artista=artista;
        this.album=album;
        this.genero=genero;
        this.compositor=compositor;
        this.discografica=discografica;
        this.letra=letra;
    }

    /**
     * @return the artista
     */
    public String getArtista() {
        return artista;
    }

    /**
     * @param artista the artista to set
     */
    public void setArtista(String artista) {
        this.artista = artista;
    }

    /**
     * @return the album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * @param album the album to set
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the compositor
     */
    public String getCompositor() {
        return compositor;
    }

    /**
     * @param compositor the compositor to set
     */
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    /**
     * @return the discografica
     */
    public String getDiscografica() {
        return discografica;
    }

    /**
     * @param discografica the discografica to set
     */
    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }
   
     public String getLetra() {
        return letra;
    }

    /**
     * @param letra the letra to set
     */
    public void setLetra(String letra) {
        this.letra = letra;
    }

    
    public void mostrarInformacion() {
        super.mostrarInfo();
        System.out.println("Artista: " + artista);
        System.out.println("Álbum: " + album);
        System.out.println("Género: " + genero);
        System.out.println("Compositor: " + compositor);
        System.out.println("Discográfica: " + discografica);
    }
    
    public void imprimirInfoProduccion() {
        System.out.println("Compositor: " + compositor);
        System.out.println("Discográfica: " + discografica);
    }
    
    public void cambiarGenero(String nuevoGenero) {
        this.genero = nuevoGenero;
    }
    
    public void descargar(){
        System.out.println("Descargando: " + super.getTitulo());
    }
    
    public void imprimirLetra() {
        if (this.getLetra() !=null && !letra.isEmpty()) {
            System.out.println("Letra:\n" + getLetra());
        } else {
            System.out.println("Letra no disponible.");
        }
    }

}
