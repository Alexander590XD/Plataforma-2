/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * La clase AnalistaMarketing representa a un analista de marketing con información básica,
 * comentarios recopilados y campañas en las que ha colaborado. Incluye métodos para manejar
 * estos datos y realizar operaciones relacionadas con el análisis de marketing.
 */
public abstract class AnalistaMarketing implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String nombre; // Nombre del analista de marketing.
    private String especialidad; // Especialidad del analista.
    private int aniosExperiencia; // Años de experiencia del analista.
    private Tiempo tiempoRegistro; // Hora de registro del analista.
    private List<String> comentariosRecopilados; // Lista que almacena comentarios recopilados por el analista.
    private List<String> campanasColaboradas; // Lista que almacena campañas en las que el analista ha colaborado.

    /**
     * Constructor para crear una instancia de AnalistaMarketing con la información proporcionada.
     */
    public AnalistaMarketing(String nombre, String especialidad, int aniosExperiencia, Tiempo tiempoRegistro) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
        this.tiempoRegistro = tiempoRegistro;
        this.comentariosRecopilados = new ArrayList<>(); // Inicializa la lista de comentarios recopilados.
        this.campanasColaboradas = new ArrayList<>(); // Inicializa la lista de campañas colaboradas.
    }

    // Métodos Getter y Setter para acceder y modificar los atributos privados.

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

    // Métodos abstractos que deben ser implementados por las subclases.

    public abstract void mostrarInformacion();
    public abstract void realizarEncuesta(Scanner scanner);
    public abstract void colaborarEnCampania(Scanner scanner);
    public abstract void mostrarComentariosRecopilados();
    public abstract void mostrarCampañasColaboradas();

    /**
     * Agrega un comentario a la lista de comentarios recopilados.
     */
    public void agregarComentario(String comentario) {
        if (comentario != null && !comentario.trim().isEmpty()) {
            comentariosRecopilados.add(comentario); // Añade el comentario a la lista.
            System.out.println("Comentario agregado.");
        } else {
            System.out.println("Comentario no válido.");
        }
    }

    /**
     * Agrega una campaña a la lista de campañas colaboradas.
     */
    public void agregarCampana(String campana) {
        if (campana != null && !campana.trim().isEmpty()) {
            campanasColaboradas.add(campana); // Añade la campaña a la lista.
            System.out.println("Campaña agregada.");
        } else {
            System.out.println("Campaña no válida.");
        }
    }

    /**
     * Imprime todos los comentarios recopilados.
     */
    public void imprimirComentariosRecopilados() {
        System.out.println("Comentarios recopilados:");
        for (String comentario : comentariosRecopilados) {
            System.out.println("- " + comentario); // Imprime cada comentario de la lista.
        }
    }

    /**
     * Imprime todas las campañas colaboradas.
     */
    public void imprimirCampanasColaboradas() {
        System.out.println("Campañas colaboradas:");
        for (String campana : campanasColaboradas) {
            System.out.println("- " + campana); // Imprime cada campaña de la lista.
        }
    }

    /**
     * Método estático para crear una instancia de AnalistaMarketing con valores por defecto.
     * @return Una nueva instancia de AnalistaMarketing.
     */
    public static AnalistaMarketing crearAnalistaPorDefecto() {
        Tiempo tiempo = new Tiempo(); // Suponiendo que Tiempo tiene un constructor por defecto.
        tiempo.capturarHora(); // Captura la hora actual para el tiempo de registro.
        return new AnalistaMarketing("Nombre Por Defecto", "Especialidad Por Defecto", 0, tiempo) {
            @Override
            public void mostrarInformacion() {
                // Implementar una versión básica aquí si es necesario.
            }

            @Override
            public void realizarEncuesta(Scanner scanner) {
                // Implementar una versión básica aquí si es necesario.
            }

            @Override
            public void colaborarEnCampania(Scanner scanner) {
                // Implementar una versión básica aquí si es necesario.
            }

            @Override
            public void mostrarComentariosRecopilados() {
                // Implementar una versión básica aquí si es necesario.
            }

            @Override
            public void mostrarCampañasColaboradas() {
                // Implementar una versión básica aquí si es necesario.
            }
        };
    }

    /**
     * Método predeterminado para mostrar la información básica del analista.
     * @return Información básica del analista.
     */
    public String obtenerInformacionBasica() {
        return "Nombre: " + nombre + ", Especialidad: " + especialidad;
    }
}
