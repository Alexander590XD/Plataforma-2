/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class AnalistaMarketing implements Serializable {
    
    private String nombre;
    private String especialidad;
    private int aniosExperiencia;
    private Tiempo tiempoRegistro;
    private List<String> comentariosRecopilados;
    private List<String> campanasColaboradas;

    public AnalistaMarketing(String nombre, String especialidad, int aniosExperiencia, Tiempo tiempoRegistro) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
        this.tiempoRegistro = tiempoRegistro;
        this.comentariosRecopilados = new ArrayList<>();
        this.campanasColaboradas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public Tiempo getTiempoRegistro() {
        return tiempoRegistro;
    }

    public void setTiempoRegistro(Tiempo tiempoRegistro) {
        this.tiempoRegistro = tiempoRegistro;
    }

    public abstract void mostrarInformacion();
    public abstract void realizarEncuesta(Scanner scanner);
    public abstract void colaborarEnCampania(Scanner scanner);
    public abstract void mostrarComentariosRecopilados();
    public abstract void mostrarCampañasColaboradas();
}
