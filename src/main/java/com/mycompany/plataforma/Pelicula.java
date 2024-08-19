/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
/**
 * Clase que representa una película.
 * Hereda de Video y añade atributos específicos para una película.
 */
public class Pelicula extends Video{
    private String genero;           // Género de la película
    private String sinopsis;         // Sinopsis de la película
    private String estudio;          // Estudio que produjo la película
    private String clasificacion;    // Clasificación de edad

    /**
     * Constructor vacío que solicita datos al usuario.
     */
    public Pelicula() {
        super();  // Llama al constructor de Video
        Scanner scanner = new Scanner(System.in);
        
        // Solicita información específica para la película
        System.out.print("Género: ");
        this.genero = scanner.nextLine();
        
        System.out.print("Sinopsis: ");
        this.sinopsis = scanner.nextLine();
        
        System.out.print("Estudio: ");
        this.estudio = scanner.nextLine();
        
        System.out.print("Clasificación de Edad: ");
        this.clasificacion = scanner.nextLine();
    }
    
    /**
     * Constructor con parámetros para inicializar una película.
     */
    public Pelicula(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechaLanzamiento,
                    String director, List<String> actores, String paisOrigen, List<String> subtitulos,
                    String genero, String sinopsis, String estudio, String clasificacion) {
        super(nombre, idElemento, titulo, duracion, calidad, fechaLanzamiento, director, actores, paisOrigen, subtitulos);
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.estudio = estudio;
        this.clasificacion = clasificacion;
    }

    // Getters y setters para los atributos

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * Muestra la información de la película.
     * Llama al método mostrarInfo() de la clase Video.
     */
    public void mostrarPelicula() {
        super.mostrarInfo(); // Muestra la información básica del video
        System.out.println("Género: " + genero);
        System.out.println("Sinopsis: " + sinopsis);
        System.out.println("Estudio: " + estudio);
        System.out.println("Clasificación de Edad: " + clasificacion);
    }

    /**
     * Permite modificar la información de la película.
     */
    public void modificarInformacion() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese nuevo género (actual: " + genero + "): ");
        this.genero = scanner.nextLine();
        
        System.out.print("Ingrese nueva sinopsis (actual: " + sinopsis + "): ");
        this.sinopsis = scanner.nextLine();
        
        System.out.print("Ingrese nuevo estudio (actual: " + estudio + "): ");
        this.estudio = scanner.nextLine();
        
        System.out.print("Ingrese nueva clasificación de edad (actual: " + clasificacion + "): ");
        this.clasificacion = scanner.nextLine();
    }
}