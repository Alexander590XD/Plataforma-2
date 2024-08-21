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

    private String nombre;
    private String especialidad;
    private int aniosExperiencia;
    private Tiempo tiempoRegistro;
    private List<String> comentariosRecopilados;
    private List<String> campanasColaboradas;

    /**
     * Constructor de la clase AnalistaMarketing.
     */
    public AnalistaMarketing(String nombre, String especialidad, int aniosExperiencia, Tiempo tiempoRegistro) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
        this.tiempoRegistro = tiempoRegistro;
        this.comentariosRecopilados = new ArrayList<>();
        this.campanasColaboradas = new ArrayList<>();
    }

    // Métodos Getter y Setter

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
    
    /**
     * Muestra la información del analista.
     */
    public abstract void mostrarInformacion();

    /**
     * Permite al analista realizar una encuesta.
     */
    public abstract void realizarEncuesta(Scanner scanner);

    /**
     * Permite al analista colaborar en una campaña.
     */
    public abstract void colaborarEnCampania(Scanner scanner);

    /**
     * Muestra los comentarios recopilados por el analista.
     */
    public abstract void mostrarComentariosRecopilados();

    /**
     * Muestra las campañas en las que ha colaborado el analista.
     */
    public abstract void mostrarCampañasColaboradas();

    // Métodos concretos para gestionar comentarios y campañas
    
    /**
     * Agrega un comentario a la lista de comentarios recopilados.
     */
    public void agregarComentario(String comentario) {
        if (comentario != null && !comentario.trim().isEmpty()) {
            comentariosRecopilados.add(comentario);
            System.out.println("Comentario agregado con éxito.");
        } else {
            System.out.println("El comentario proporcionado no es válido.");
        }
    }

    /**
     * Agrega una campaña a la lista de campañas colaboradas.
     */
    public void agregarCampana(String campana) {
        if (campana != null && !campana.trim().isEmpty()) {
            campanasColaboradas.add(campana);
            System.out.println("Campaña añadida con éxito.");
        } else {
            System.out.println("La campaña proporcionada no es válida.");
        }
    }

    /**
     * Imprime en consola todos los comentarios recopilados.
     */
    public void imprimirComentariosRecopilados() {
        System.out.println("Comentarios Recopilados:");
        for (String comentario : comentariosRecopilados) {
            System.out.println("- " + comentario);
        }
    }

    /**
     * Imprime en consola todas las campañas colaboradas.
     */
    public void imprimirCampanasColaboradas() {
        System.out.println("Campañas Colaboradas:");
        for (String campana : campanasColaboradas) {
            System.out.println("- " + campana);
        }
    }

    /**
     * Método estático para crear una instancia de AnalistaMarketing con valores por defecto.
     * 
     * @return Una instancia de AnalistaMarketing con valores por defecto.
     */
    public static AnalistaMarketing crearAnalistaPorDefecto() {
        Tiempo tiempo = new Tiempo();
        tiempo.capturarHora(); // Actualiza la hora de registro

        return new AnalistaMarketing("Nombre Por Defecto", "Especialidad Por Defecto", 0, tiempo) {
            @Override
            public void mostrarInformacion() {
                System.out.println("Nombre: " + getNombre());
                System.out.println("Especialidad: " + getEspecialidad());
                System.out.println("Años de Experiencia: " + getAniosExperiencia() + " años");
                System.out.println("Hora de Registro: " + getTiempoRegistro().toString());
            }

            @Override
            public void realizarEncuesta(Scanner scanner) {
                System.out.println("Procediendo con la encuesta...");
                System.out.print("Por favor, ingrese su respuesta a la encuesta: ");
                String respuesta = scanner.nextLine();
                System.out.println("Su respuesta ha sido registrada: " + respuesta);
            }

            @Override
            public void colaborarEnCampania(Scanner scanner) {
                System.out.println("Colaborando en campaña...");
                System.out.print("Por favor, ingrese el nombre de la campaña en la que colaboró: ");
                String campania = scanner.nextLine();
                agregarCampana(campania); // Usa el método concreto para agregar una campaña
                System.out.println("Su participación en la campaña '" + campania + "' ha sido registrada.");
            }

            @Override
            public void mostrarComentariosRecopilados() {
                imprimirComentariosRecopilados(); // Usa el método concreto para imprimir comentarios
            }

            @Override
            public void mostrarCampañasColaboradas() {
                imprimirCampanasColaboradas(); // Usa el método concreto para imprimir campañas
            }
        };
    }

    /**
     * Método final que muestra un mensaje de bienvenida para el analista.
     */
    public final void mostrarMensajeBienvenida() {
        System.out.println("Bienvenido, " + nombre + ". Es un honor contar con un analista con "
                           + aniosExperiencia + " años de experiencia en " + especialidad + ".");
    }
}
