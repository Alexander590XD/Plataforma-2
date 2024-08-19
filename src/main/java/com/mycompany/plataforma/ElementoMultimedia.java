/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Clase que representa un elemento multimedia en una plataforma.
 * Hereda de la clase Plataforma.
 */
public class ElementoMultimedia extends Plataforma{
    protected int idElemento;  // Identificador del elemento
    protected String titulo;  // Título del elemento
    protected int duracion;  // Duración en minutos
    protected String calidad;  // Calidad de reproducción
    protected LocalDate fechaLanzamiento;  // Fecha de lanzamiento

    /**
     * Constructor vacío que solicita datos al usuario.
     */
    public ElementoMultimedia() {
        super();
        Scanner scanner = new Scanner(System.in);
        this.idElemento = promptInt(scanner, "ID de Elemento: ");
        this.titulo = promptString(scanner, "Título del elemento: ");
        this.duracion = promptInt(scanner, "Duración (en minutos): ");
        this.calidad = promptString(scanner, "Calidad de reproducción: ");
        this.fechaLanzamiento = promptDate(scanner, "Fecha de Lanzamiento (aaaa-mm-dd): ");
    }

    /**
     * Constructor con parámetros para inicializar un elemento multimedia.
     */
    public ElementoMultimedia(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechaLanzamiento) {
        super(nombre);
        this.idElemento = idElemento;
        this.titulo = titulo;
        this.duracion = duracion;
        this.calidad = calidad;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    // Getters y setters para los atributos

    public int getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(int idElemento) {
        this.idElemento = idElemento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    /**
     * Implementación del método abstracto para mostrar la información del elemento multimedia.
     */
    public void mostrarInfo() {
        mostrarPlataforma();  // Muestra la información básica de la plataforma
        System.out.println("ID de elemento: " + idElemento);
        System.out.println("Título del elemento: " + titulo);
        System.out.println("Duración: " + duracion + " minutos");
        System.out.println("Calidad: " + calidad);
        System.out.println("Fecha de lanzamiento: " + fechaLanzamiento.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    private int promptInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }
    
    private String promptString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        scanner.nextLine();  // Consume el salto de línea pendiente
        return scanner.nextLine();
    }

    private LocalDate promptDate(Scanner scanner, String prompt) {
        String fechaStr = promptString(scanner, prompt);
        return LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private List<String> promptList(Scanner scanner, String prompt) {
        String input = promptString(scanner, prompt);
        return Stream.of(input.split(","))
                     .map(String::trim)
                     .collect(Collectors.toList());
    }
}
