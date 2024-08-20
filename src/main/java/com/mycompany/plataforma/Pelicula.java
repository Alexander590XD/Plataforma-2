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
    private String genero;
    private String sinopsis;
    private String estudio;
    private String clasificacio;

    public Pelicula() {
        super();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Género: ");
        this.genero = scanner.nextLine();
        
        System.out.print("Sinopsis: ");
        this.sinopsis = scanner.nextLine();
        
        System.out.print("Estudio: ");
        this.estudio = scanner.nextLine();
        
        System.out.print("Clasificación de Edad: ");
        this.clasificacio = scanner.nextLine();
    }
    
    public Pelicula(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechalanzamiento,
                    String director, List<String> actores, String paisO, List<String> subtitulos,
                    String genero, String sinopsis, String estudio, String clasificacio) {
        super(nombre, idElemento, titulo, duracion, calidad, fechalanzamiento, director, actores, paisO, subtitulos);
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.estudio = estudio;
        this.clasificacio = clasificacio;
    }

    // Getters and Setters
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

    public String getClasificacio() {
        return clasificacio;
    }

    public void setClasificacio(String clasificacio) {
        this.clasificacio = clasificacio;
    }

    public void mostrarPelicula() {
        super.mostrarInfo(); // Usa el método de Video para mostrar la información básica
        System.out.println("Género: " + genero);
        System.out.println("Sinopsis: " + sinopsis);
        System.out.println("Estudio: " + estudio);
        System.out.println("Clasificación de Edad: " + clasificacio);
    }
     public void modificarInformacion() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese nuevo género (actual: " + genero + "): ");
        this.genero = scanner.nextLine();
        
        System.out.print("Ingrese nueva sinopsis (actual: " + sinopsis + "): ");
        this.sinopsis = scanner.nextLine();
        
        System.out.print("Ingrese nuevo estudio (actual: " + estudio + "): ");
        this.estudio = scanner.nextLine();
        
        System.out.print("Ingrese nueva clasificación de edad (actual: " + clasificacio + "): ");
        this.clasificacio = scanner.nextLine();
    }
}