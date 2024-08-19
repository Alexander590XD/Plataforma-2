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
    
     private int temporadas;          // Número de temporadas
    private int capitulos;           // Número de capítulos
    private String duracionCapitulo; // Duración de cada capítulo
    private String estadoEmision;    // Estado de emisión
    private String plataformaOrigen; // Plataforma de origen
    private String idiomaOriginal;   // Idioma original

    /**
     * Constructor vacío que solicita datos al usuario.
     */
    public Serie() {
        super();  // Llama al constructor de Video
        Scanner scanner = new Scanner(System.in);

        // Solicita información específica para la serie
        System.out.print("Temporadas: ");
        this.temporadas = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Número de capítulos: ");
        this.capitulos = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Duración del capítulo: ");
        this.duracionCapitulo = scanner.nextLine();
        
        System.out.print("Estado de emisión: ");
        this.estadoEmision = scanner.nextLine();
        
        System.out.print("Plataforma de origen: ");
        this.plataformaOrigen = scanner.nextLine();
        
        System.out.print("Idioma original: ");
        this.idiomaOriginal = scanner.nextLine();
    }
    
    /**
     * Constructor con parámetros para inicializar una serie.
     */
    public Serie(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechaLanzamiento,
                 String director, List<String> actores, String paisOrigen, List<String> subtitulos,
                 int temporadas, int capitulos, String duracionCapitulo, String estadoEmision, String plataformaOrigen, String idiomaOriginal) {
        super(nombre, idElemento, titulo, duracion, calidad, fechaLanzamiento, director, actores, paisOrigen, subtitulos);
        this.temporadas = temporadas;
        this.capitulos = capitulos;
        this.duracionCapitulo = duracionCapitulo;
        this.estadoEmision = estadoEmision;
        this.plataformaOrigen = plataformaOrigen;
        this.idiomaOriginal = idiomaOriginal;
    }

    // Getters y setters para los atributos

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

    public String getDuracionCapitulo() {
        return duracionCapitulo;
    }

    public void setDuracionCapitulo(String duracionCapitulo) {
        this.duracionCapitulo = duracionCapitulo;
    }

    public String getEstadoEmision() {
        return estadoEmision;
    }

    public void setEstadoEmision(String estadoEmision) {
        this.estadoEmision = estadoEmision;
    }

    public String getPlataformaOrigen() {
        return plataformaOrigen;
    }

    public void setPlataformaOrigen(String plataformaOrigen) {
        this.plataformaOrigen = plataformaOrigen;
    }

    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }

    /**
     * Muestra la información de la serie.
     * Llama al método mostrarInfo() de la clase Video.
     */
    public void mostrarSerie() {
        super.mostrarInfo(); // Muestra la información básica del video
        System.out.println("Temporadas: " + temporadas);
        System.out.println("Número de capítulos: " + capitulos);
        System.out.println("Duración del capítulo: " + duracionCapitulo);
        System.out.println("Estado de emisión: " + estadoEmision);
        System.out.println("Plataforma de origen: " + plataformaOrigen);
        System.out.println("Idioma original: " + idiomaOriginal);
    }
    
    /**
     * Permite modificar la información de la serie.
     */
    public void modificarInformacion() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese nuevo número de temporadas (actual: " + temporadas + "): ");
        this.temporadas = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Ingrese nuevo número de capítulos (actual: " + capitulos + "): ");
        this.capitulos = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Ingrese nueva duración del capítulo (actual: " + duracionCapitulo + "): ");
        this.duracionCapitulo = scanner.nextLine();
        
        System.out.print("Ingrese nuevo estado de emisión (actual: " + estadoEmision + "): ");
        this.estadoEmision = scanner.nextLine();
        
        System.out.print("Ingrese nueva plataforma de origen (actual: " + plataformaOrigen + "): ");
        this.plataformaOrigen = scanner.nextLine();
        
        System.out.print("Ingrese nuevo idioma original (actual: " + idiomaOriginal + "): ");
        this.idiomaOriginal = scanner.nextLine();
    }
}
