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
public class Video extends ElementoMultimedia {
    
    protected String director;
    protected List<String> actores;
    protected String paisO;
    protected List<String> subtitulos;
    
    public Video(){
        super();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Director: ");
        this.director = scanner.nextLine();
        
        System.out.print("Actores: ");
        String actoresInput = scanner.nextLine();
        this.actores = List.of(actoresInput.split(","));
        
        System.out.print("Pais de origen: ");
        this.paisO = scanner.nextLine();
        
        System.out.print("Subtitulos: ");
        String subtitulosInput = scanner.nextLine();
        this.subtitulos = List.of(subtitulosInput.split(","));
        
        this.titulo = super.getTitulo();
        this.duracion = super.getDuracion();
    }
    public Video(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechalanzamiento,String director,List<String> actores,String paisO,List<String> subtitulos ){
        super(nombre,idElemento,titulo,duracion,calidad,fechalanzamiento);
        this.director=director;
        this.actores=actores;
        this.paisO=paisO;
        this.subtitulos=subtitulos;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the actores
     */
    public List<String> getActores() {
        return actores;
    }

    /**
     * @param actores the actores to set
     */
    public void setActores(List<String> actores) {
        this.actores = actores;
    }

    /**
     * @return the paisO
     */
    public String getPaisO() {
        return paisO;
    }

    /**
     * @param paisO the paisO to set
     */
    public void setPaisO(String paisO) {
        this.paisO = paisO;
    }

    /**
     * @return the subtitulos
     */
    public List<String> getSubtitulos() {
        return subtitulos;
    }

    /**
     * @param subtitulos the subtitulos to set
     */
    public void setSubtitulos(List<String> subtitulos) {
        this.subtitulos = subtitulos;
    }
    
    public void mostrarVideo(){
        super.mostrarInfo();
        System.out.println("Director: " + director);
        System.out.println("Actores: " + actores);
        System.out.println("País de Origen: " + paisO);
        System.out.println("Subtítulos: " + subtitulos);
        
        this.titulo = super.getTitulo();
        this.duracion = super.getDuracion();
    }
    public void reproducir() {
        System.out.println("Reproduciendo: " + titulo);
    }

    public void verTrailer() {
        System.out.println("Viendo trailer de: " + titulo);
    }

    public String obtenerDuracionFormateada() {
        int horas = duracion / 60;
        int minutos = duracion % 60;
        return horas + "h " + minutos + "min";
    }

    public boolean tieneSubtitulosEnIdioma(String idioma) {
        return subtitulos.contains(idioma);
    }
    
}
