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
    
    public ElementoMultimedia(){
        super();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("ID de Elemento: ");
        this.idElemento = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Titulo del elemento: ");
        this.titulo = scanner.nextLine();
        
        System.out.print("Duración (en minutos) ");
        this.duracion = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Calidad de reproducción: ");
        this.calidad = scanner.nextLine();
        
        System.out.print("Fecha de Lanzamiento: (yyyy-mm-dd)");
        String fechaStr = scanner.nextLine();
        this.fechalanzamiento = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
    }
    
    public ElementoMultimedia(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechalanzamiento){
        super(nombre);
        this.idElemento = idElemento;
        this.titulo= titulo;
        this.duracion = duracion;
        this.calidad= calidad;
        this.fechalanzamiento = fechalanzamiento;
        
    }

    /**
     * @return the idElemento
     */
    public int getIdElemento() {
        return idElemento;
    }

    /**
     * @param idElemento the idElemento to set
     */
    public void setIdElemento(int idElemento) {
        this.idElemento = idElemento;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the calidad
     */
    public String getCalidad() {
        return calidad;
    }

    /**
     * @param calidad the calidad to set
     */
    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    /**
     * @return the fechalanzamiento
     */
    public LocalDate  getFechalanzamiento() {
        return fechalanzamiento;
    }

    /**
     * @param fechalanzamiento the fechalanzamiento to set
     */
    public void setFechalanzamiento(LocalDate fechalanzamiento) {
        this.fechalanzamiento = fechalanzamiento;
    }
    
    public void mostrarInfo() {
        super.mostrarPlata();
        System.out.println("ID de elemento: " + idElemento);
        System.out.println("Titulo del elemento: " + titulo);
        System.out.println("Duración: " + duracion);
        System.out.println("Calidad: " + calidad);
        System.out.println("Fecha de lanzamiento: " + fechalanzamiento.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }    
    
    public void modificarFechaLanzamiento(String nuevaFechaStr) {
        this.fechalanzamiento = LocalDate.parse(nuevaFechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
