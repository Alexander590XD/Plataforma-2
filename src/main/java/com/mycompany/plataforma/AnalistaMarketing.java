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
    public abstract void mostrarInformacion();
    public abstract void realizarEncuesta(Scanner scanner);
    public abstract void colaborarEnCampania(Scanner scanner);
    public abstract void mostrarComentariosRecopilados();
    public abstract void mostrarCampañasColaboradas();

    // Métodos concretos para gestionar comentarios y campañas
    public void agregarComentario(String comentario) {
        if (comentario != null && !comentario.trim().isEmpty()) {
            comentariosRecopilados.add(comentario);
            System.out.println("Comentario agregado.");
        } else {
            System.out.println("Comentario no válido.");
        }
    }

    public void agregarCampana(String campana) {
        if (campana != null && !campana.trim().isEmpty()) {
            campanasColaboradas.add(campana);
            System.out.println("Campaña agregada.");
        } else {
            System.out.println("Campaña no válida.");
        }
    }

    public void imprimirComentariosRecopilados() {
        System.out.println("Comentarios recopilados:");
        for (String comentario : comentariosRecopilados) {
            System.out.println("- " + comentario);
        }
    }

    public void imprimirCampanasColaboradas() {
        System.out.println("Campañas colaboradas:");
        for (String campana : campanasColaboradas) {
            System.out.println("- " + campana);
        }
    }

    // Método estático para crear una instancia de AnalistaMarketing con valores por defecto
    public static AnalistaMarketing crearAnalistaPorDefecto() {
        Tiempo tiempo = new Tiempo();
        tiempo.capturarHora(); // Actualiza la hora de registro

        return new AnalistaMarketing("Nombre Por Defecto", "Especialidad Por Defecto", 0, tiempo) {
            @Override
            public void mostrarInformacion() {
                System.out.println("Nombre: " + getNombre());
                System.out.println("Especialidad: " + getEspecialidad());
                System.out.println("Experiencia: " + getAniosExperiencia() + " años");
                System.out.println("Tiempo de Registro: " + getTiempoRegistro().toString());
            }

            @Override
            public void realizarEncuesta(Scanner scanner) {
                System.out.println("Realizando encuesta...");
                System.out.println("Ingrese la respuesta a la encuesta:");
                String respuesta = scanner.nextLine();
                System.out.println("Respuesta recibida: " + respuesta);
            }

            @Override
            public void colaborarEnCampania(Scanner scanner) {
                System.out.println("Colaborando en una campaña...");
                System.out.println("Ingrese el nombre de la campaña:");
                String campania = scanner.nextLine();
                agregarCampana(campania); // Usa el método concreto para agregar una campaña
                System.out.println("Colaboración en la campaña '" + campania + "' registrada.");
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
}
