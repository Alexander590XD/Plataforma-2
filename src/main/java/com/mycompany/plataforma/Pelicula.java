/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author pato4
 */
public class Pelicula extends Video{
    
    private String genero;
    private String sinopsis;
    private String estudio;
    private String clasificacio;
   
    public Pelicula(){
        super();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Genero: ");
        this.genero = scanner.nextLine();
        
        System.out.print("Sinopsis: ");
        this.sinopsis = scanner.nextLine();
        
        System.out.print("Estudio: ");
        this.estudio = scanner.nextLine();

        System.out.print("Clasificación de Edad: ");
        this.clasificacio =scanner.nextLine();
        
        this.titulo = super.getTitulo();
    }
    
    public Pelicula(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechalanzamiento,String director,
            List<String> actores,String paisO,List<String> subtitulos,String genero,String sinopsis,String estudio,String clasificacio){
        super(nombre,idElemento,titulo,duracion,calidad,fechalanzamiento,director,actores,paisO,subtitulos);
        this.genero=genero;
        this.sinopsis=sinopsis;
        this.estudio=estudio;
        this.clasificacio=clasificacio;
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
     * @return the sinopsis
     */
    public String getSinopsis() {
        return sinopsis;
    }

    /**
     * @param sinopsis the sinopsis to set
     */
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    /**
     * @return the estudio
     */
    public String getEstudio() {
        return estudio;
    }

    /**
     * @param estudio the estudio to set
     */
    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    /**
     * @return the clasificacio
     */
    public String getClasificacio() {
        return clasificacio;
    }

    /**
     * @param clasificacio the clasificacio to set
     */
    public void setClasificacio(String clasificacio) {
        this.clasificacio = clasificacio;
    }
    
    public void mostrarPelicula() {
        super.mostrarVideo(); 
        System.out.println("Género: " + genero);
        System.out.println("Sinopsis: " + sinopsis);
        System.out.println("Estudio: " + estudio);
        System.out.println("Clasificación de Edad: " + clasificacio);
    }

    public void recomendarPelicula(String amigo) {
        System.out.println("Recomendando la película " + super.getTitulo() + " a " + amigo);
    }
    
    public boolean esAptaParaNinos() {
        return clasificacio.equals("PG") || clasificacio.equals("G");
    }

    public String obtenerDescripcionBreve() {
        return(titulo + " - " + genero + " " + clasificacio + " ");
    }
    public void agregarComentario(String comentario) {
        System.out.println("Comentario agregado a " + titulo + ": " + comentario);
    }
}
