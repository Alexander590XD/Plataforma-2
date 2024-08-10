/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
/**
 *
 * @author pato4
 */
public class ElementoMultimedia extends Plataforma {
    
    protected int idElemento;
    protected String titulo;
    protected int duracion;
    protected String calidad;
    protected LocalDate fechalanzamiento;

    public ElementoMultimedia() {
        super();
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID de Elemento: ");
        this.idElemento = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Título del elemento: ");
        this.titulo = scanner.nextLine();

        System.out.print("Duración (en minutos): ");
        this.duracion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Calidad de reproducción: ");
        this.calidad = scanner.nextLine();

        System.out.print("Fecha de Lanzamiento (aaaa-mm-dd): ");
        String fechaStr = scanner.nextLine();
        this.fechalanzamiento = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public ElementoMultimedia(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechalanzamiento) {
        super(nombre);
        this.idElemento = idElemento;
        this.titulo = titulo;
        this.duracion = duracion;
        this.calidad = calidad;
        this.fechalanzamiento = fechalanzamiento;
    }

    // Getters and Setters
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

    public LocalDate getFechalanzamiento() {
        return fechalanzamiento;
    }

    public void setFechalanzamiento(LocalDate fechalanzamiento) {
        this.fechalanzamiento = fechalanzamiento;
    }

    @Override
    public void mostrarInfo() {
        mostrarPlataforma(); // Muestra la información básica de la plataforma
        System.out.println("ID de elemento: " + idElemento);
        System.out.println("Título del elemento: " + titulo);
        System.out.println("Duración: " + duracion + " minutos");
        System.out.println("Calidad: " + calidad);
        System.out.println("Fecha de lanzamiento: " + fechalanzamiento.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    public void modificarFechaLanzamiento(String nuevaFechaStr) {
        this.fechalanzamiento = LocalDate.parse(nuevaFechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
