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
public class Serie extends Video {
    
    private int temporadas;
    private int capitulos;
    private String dCap;
    private String emision;
    private String pOrigen;
    private String iAudio;
    
    public Serie(){
        super();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Temporadas: ");
        this.temporadas = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Numero de capitulo: ");
        this.capitulos = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Duracion del capitulo");
        this.dCap = scanner.nextLine();
        
        System.out.print("Estado de Emision: ");
        this.emision = scanner.nextLine();
        
        System.out.print("Plateforma de Origen: ");
        this.pOrigen = scanner.nextLine();
        
        System.out.print("Idioma Original: ");
        this.iAudio =scanner.nextLine();
    }
    
    public Serie(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechalanzamiento,String director,
            List<String> actores,String paisO,List<String> subtitulos,int temporadas,int capitulos,String dCap,String emision,String pOrigen,String iAudio){
        super(nombre,idElemento,titulo,duracion,calidad,fechalanzamiento,director,actores,paisO,subtitulos);
        this.temporadas=temporadas;
        this.capitulos=capitulos;
        this.dCap=dCap;
        this.emision=emision;
        this.pOrigen=pOrigen;
        this.iAudio=iAudio;
    }

    /**
     * @return the temporadas
     */
    public int getTemporadas() {
        return temporadas;
    }

    /**
     * @param temporadas the temporadas to set
     */
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    /**
     * @return the emision
     */
    public String getEmision() {
        return emision;
    }

    /**
     * @param emision the emision to set
     */
    public void setEmision(String emision) {
        this.emision = emision;
    }

    /**
     * @return the pOrigen
     */
    public String getpOrigen() {
        return pOrigen;
    }

    /**
     * @param pOrigen the pOrigen to set
     */
    public void setpOrigen(String pOrigen) {
        this.pOrigen = pOrigen;
    }

    /**
     * @return the iAudio
     */
    public String getiAudio() {
        return iAudio;
    }

    /**
     * @param iAudio the iAudio to set
     */
    public void setiAudio(String iAudio) {
        this.iAudio = iAudio;
    }
    
     /**
     * @return the capitulos
     */
    public int getCapitulos() {
        return capitulos;
    }

    /**
     * @param capitulos the capitulos to set
     */
    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }
    
      /**
     * @return the dCap
     */
    public String getdCap() {
        return dCap;
    }

    /**
     * @param dCap the dCap to set
     */
    public void setdCap(String dCap) {
        this.dCap = dCap;
    }
    public void mostrarSerie() {
        super.mostrarVideo();
        System.out.println("Temporadas: " + temporadas);
        System.out.println("Capitulo: " + capitulos);
        System.out.println("Estado de Emisión: " + emision);
        System.out.println("Plataforma de Origen: " + pOrigen);
        System.out.println("Idioma Original: " + iAudio);
    }
    
    public void agregarTemporada() {
        temporadas++;
    }
    public void agregarCapitulo() {
        setCapitulos(getCapitulos() + 1);
    }
    
    public void cambiarEstadoEmision(String nuevoEstado) {
        this.emision = nuevoEstado;
    }
   
    public void cambiarDuracion(int nuevaDuracion){
        super.setDuracion(nuevaDuracion);
    }
    
    public void cambiarDuracionCap(int nuevaDuracionCp){
        super.setDuracion(nuevaDuracionCp);
    }
}
