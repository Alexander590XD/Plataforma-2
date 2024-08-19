/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 *
 * @author pato4
 */
public class Video extends ElementoMultimedia{
    
   protected String director;  // Director del video
    protected List<String> actores;  // Lista de actores
    protected String paisOrigen;  // País de origen
    protected List<String> subtitulos;  // Lista de subtítulos

    /**
     * Constructor vacío que solicita datos al usuario.
     */
    public Video() {
        super();
        Scanner scanner = new Scanner(System.in);
        this.director = promptString(scanner, "Director: ");
        this.actores = promptList(scanner, "Actores (separados por comas): ");
        this.paisOrigen = promptString(scanner, "País de origen: ");
        this.subtitulos = promptList(scanner, "Subtítulos (separados por comas): ");
    }

    /**
     * Constructor con parámetros para inicializar un video.
     */
    public Video(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechaLanzamiento,
                 String director, List<String> actores, String paisOrigen, List<String> subtitulos) {
        super(nombre, idElemento, titulo, duracion, calidad, fechaLanzamiento);
        this.director = director;
        this.actores = actores;
        this.paisOrigen = paisOrigen;
        this.subtitulos = subtitulos;
    }

    // Getters y setters para los atributos

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getActores() {
        return actores;
    }

    public void setActores(List<String> actores) {
        this.actores = actores;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public List<String> getSubtitulos() {
        return subtitulos;
    }

    public void setSubtitulos(List<String> subtitulos) {
        this.subtitulos = subtitulos;
    }

    /**
     * Implementación del método abstracto para mostrar la información del video.
     */
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();  // Muestra la información básica del elemento multimedia
        System.out.println("Director: " + director);
        System.out.println("Actores: " + String.join(", ", actores));
        System.out.println("País de Origen: " + paisOrigen);
        System.out.println("Subtítulos: " + String.join(", ", subtitulos));
    }

    private String promptString(Scanner scanner, String director_) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private List<String> promptList(Scanner scanner, String actores_separados_por_comas_) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}