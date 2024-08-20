/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
/**
 * Clase que representa una serie.
 * Hereda de Video y añade atributos específicos para una serie.
 */
public class Serie extends Video {
    
    private int temporadas;
    private int capitulos;
    private String dCap;
    private String emision;
    private String pOrigen;
    private String iAudio;

    public Serie() {
        super();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Temporadas: ");
        this.temporadas = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Número de capítulos: ");
        this.capitulos = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Duración del capítulo: ");
        this.dCap = scanner.nextLine();
        
        System.out.print("Estado de emisión: ");
        this.emision = scanner.nextLine();
        
        System.out.print("Plataforma de origen: ");
        this.pOrigen = scanner.nextLine();
        
        System.out.print("Idioma original: ");
        this.iAudio = scanner.nextLine();
    }
    
    public Serie(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechalanzamiento,
                 String director, List<String> actores, String paisO, List<String> subtitulos,
                 int temporadas, int capitulos, String dCap, String emision, String pOrigen, String iAudio) {
        super(nombre, idElemento, titulo, duracion, calidad, fechalanzamiento, director, actores, paisO, subtitulos);
        this.temporadas = temporadas;
        this.capitulos = capitulos;
        this.dCap = dCap;
        this.emision = emision;
        this.pOrigen = pOrigen;
        this.iAudio = iAudio;
    }

    // Getters and Setters
    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }

    public String getdCap() {
        return dCap;
    }

    public void setdCap(String dCap) {
        this.dCap = dCap;
    }

    public String getEmision() {
        return emision;
    }

    public void setEmision(String emision) {
        this.emision = emision;
    }

    public String getpOrigen() {
        return pOrigen;
    }

    public void setpOrigen(String pOrigen) {
        this.pOrigen = pOrigen;
    }

    public String getiAudio() {
        return iAudio;
    }

    public void setiAudio(String iAudio) {
        this.iAudio = iAudio;
    }

    public void mostrarSerie() {
        super.mostrarInfo(); // Usa el método de Video para mostrar la información básica
        System.out.println("Temporadas: " + temporadas);
        System.out.println("Número de capítulos: " + capitulos);
        System.out.println("Duración del capítulo: " + dCap);
        System.out.println("Estado de emisión: " + emision);
        System.out.println("Plataforma de origen: " + pOrigen);
        System.out.println("Idioma original: " + iAudio);
    }
    
    public void agregarTemporada() {
        temporadas++;
    }

    public void agregarCapitulo() {
        capitulos++;
    }
    
    public void modificarInformacion() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese nuevo número de temporadas (actual: " + temporadas + "): ");
        this.temporadas = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Ingrese nuevo número de capítulos (actual: " + capitulos + "): ");
        this.capitulos = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Ingrese nueva duración del capítulo (actual: " + dCap + "): ");
        this.dCap = scanner.nextLine();
        
        System.out.print("Ingrese nuevo estado de emisión (actual: " + emision + "): ");
        this.emision = scanner.nextLine();
        
        System.out.print("Ingrese nueva plataforma de origen (actual: " + pOrigen + "): ");
        this.pOrigen = scanner.nextLine();
        
        System.out.print("Ingrese nuevo idioma original (actual: " + iAudio + "): ");
        this.iAudio = scanner.nextLine();
    }
}
