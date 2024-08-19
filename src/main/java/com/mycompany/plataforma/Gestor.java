/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Gestor administra comentarios, analistas de marketing y tiempo de registro.
 * Utiliza listas para almacenar comentarios y analistas, y proporciona métodos para manejar estos datos.
 */
public class Gestor {
    // Lista estática para almacenar comentarios. Se utiliza para agregar, consultar y gestionar comentarios.
    private static List<String> comentarios = new ArrayList<>();

    // Lista estática para almacenar analistas de marketing. Permite añadir y gestionar analistas.
    private static List<AnalistaMarketing> analistas = new ArrayList<>();

    // Instancia estática de Tiempo para gestionar el tiempo de registro.
    private static Tiempo tiempoRegistro = new Tiempo();

    /**
     * Agrega un comentario a la lista de comentarios.
     * Este método verifica si el comentario no es nulo y no está vacío antes de agregarlo a la lista.
     * @param respuesta El comentario a agregar.
     */
    public static void addComentario(String respuesta) {
        if (respuesta != null && !respuesta.trim().isEmpty()) {
            comentarios.add(respuesta); // Agrega el comentario a la lista.
            System.out.println("Comentario agregado.");
        } else {
            System.out.println("Comentario no válido.");
        }
    }

    /**
     * Verifica si la lista de comentarios está vacía.
     * Este método devuelve true si la lista no contiene elementos, de lo contrario, devuelve false.
     * @return True si la lista está vacía, false en caso contrario.
     */
    public static boolean comentariosVacios() {
        return comentarios.isEmpty(); // Usa el método isEmpty() de la lista para verificar su estado.
    }

    /**
     * Agrega un analista a la lista de analistas.
     * Verifica que el analista no sea nulo antes de añadirlo a la lista.
     * @param analista El analista a agregar.
     */
    public static void addAnalista(AnalistaMarketing analista) {
        if (analista != null) {
            analistas.add(analista); // Añade el analista a la lista.
            System.out.println("Analista agregado.");
        } else {
            System.out.println("Analista no válido.");
        }
    }

    /**
     * Imprime la hora en formato universal usando la instancia de Tiempo.
     * Este método llama al método imprimeUniversal() de la clase Tiempo.
     */
    public static void imprimirTiempoRegistro() {
        tiempoRegistro.imprimeUniversal(); // Llama al método de la instancia para imprimir la hora.
    }

    // Métodos adicionales

    /**
     * Método estático para obtener el número total de comentarios en la lista.
     * @return El número de comentarios en la lista.
     */
    public static int getNumeroComentarios() {
        return comentarios.size(); // Devuelve el tamaño de la lista de comentarios.
    }

    /**
     * Método sobrecargado para agregar comentarios con una marca de tiempo.
     * Este método permite agregar un comentario con una marca de tiempo asociada.
     */
    public static void addComentario(String respuesta, String marcaTiempo) {
        if (respuesta != null && !respuesta.trim().isEmpty()) {
            comentarios.add(respuesta + " [" + marcaTiempo + "]"); // Agrega el comentario con la marca de tiempo.
            System.out.println("Comentario con marca de tiempo agregado.");
        } else {
            System.out.println("Comentario no válido.");
        }
    }

    /**
     * Método predeterminado para mostrar información general sobre la clase Gestor.
     * @return Información general sobre la clase.
     */
    public static String getInformacionGeneral() {
        return "Gestor de Comentarios, Analistas y Tiempo de Registro"; // Proporciona información sobre la función de la clase.
    }
}
