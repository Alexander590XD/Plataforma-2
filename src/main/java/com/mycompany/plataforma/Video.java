/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 *
 * @author pato4
 */
public class Video extends ElementoMultimedia implements Serializable {
    private static final long serialVersionUID = 1L;
    
    protected String director;
    protected List<String> actores;
    protected String paisO;
    protected List<String> subtitulos;

    public Video() {
        super();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Director: ");
        this.director = scanner.nextLine();

        System.out.print("Actores (separados por comas): ");
        String actoresInput = scanner.nextLine();
        this.actores = Stream.of(actoresInput.split(","))
                             .map(String::trim)
                             .collect(Collectors.toList());

        System.out.print("País de origen: ");
        this.paisO = scanner.nextLine();

        System.out.print("Subtítulos (separados por comas): ");
        String subtitulosInput = scanner.nextLine();
        this.subtitulos = Stream.of(subtitulosInput.split(","))
                                .map(String::trim)
                                .collect(Collectors.toList());
    }

    public Video(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechalanzamiento,
                 String director, List<String> actores, String paisO, List<String> subtitulos) {
        super(nombre, idElemento, titulo, duracion, calidad, fechalanzamiento);
        this.director = director;
        this.actores = actores;
        this.paisO = paisO;
        this.subtitulos = subtitulos;
    }

    // Getters and Setters
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

    public String getPaisO() {
        return paisO;
    }

    public void setPaisO(String paisO) {
        this.paisO = paisO;
    }

    public List<String> getSubtitulos() {
        return subtitulos;
    }

    public void setSubtitulos(List<String> subtitulos) {
        this.subtitulos = subtitulos;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo(); // Muestra la información básica del elemento multimedia
        System.out.println("Director: " + director);
        System.out.println("Actores: " + String.join(", ", actores));
        System.out.println("País de Origen: " + paisO);
        System.out.println("Subtítulos: " + String.join(", ", subtitulos));
    }

    public void reproducir() {
        System.out.println("Reproduciendo: " + getTitulo());
    }

    public void verTrailer() {
        System.out.println("Viendo tráiler de: " + getTitulo());
    }

    public String obtenerDuracionFormateada() {
        int horas = getDuracion() / 60;
        int minutos = getDuracion() % 60;
        return horas + "h " + minutos + "min";
    }

    public boolean tieneSubtitulosEnIdioma(String idioma) {
        return subtitulos.contains(idioma);
    }
    
}