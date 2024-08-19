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
 * La clase Usuario representa a un usuario del sistema con capacidad para gestionar
 * listas de reproducción, favoritos y otra información personal. Implementa la interfaz
 * IUsuario y es serializable.
 */
public class Usuario implements IUsuario, Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String contrasena;
    private Tiempo tiempoRegistro;
    private Pago pago;
    private List<ListaReproduccion> listasReproduccion;
    private List<String> favoritos;

    /**
     * Constructor para crear una instancia de Usuario con la información proporcionada.
     */
    public Usuario(String nombre, String contrasena, Tiempo tiempoRegistro, Pago pago) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.tiempoRegistro = tiempoRegistro;
        this.pago = pago;
        this.listasReproduccion = new ArrayList<>();
        this.favoritos = new ArrayList<>();
    }

    // Métodos implementados de la interfaz IUsuario

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getContrasena() {
        return contrasena;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.print("Hora de registro: ");
        tiempoRegistro.imprimeUniversal();
        if (pago != null) {
            pago.mostrarInformacion();
        } else {
            System.out.println("No se ha registrado ninguna información de pago.");
        }
    }

    // Método de instancia para iniciar sesión
    public boolean iniciarSesion(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    // Método estático para registrar un usuario
    public static Usuario registrarUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese nombre de usuario: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese contraseña: ");
        String contrasena = scanner.nextLine();

        Tiempo tiempo = new Tiempo();
        tiempo.capturarHora();

        System.out.println("Ingrese la información de pago:");
        Pago pago = Pago.capturarPago();

        return new Usuario(nombre, contrasena, tiempo, pago);
    }

    // Métodos para gestionar listas de reproducción

    /**
     * Agrega un contenido a una lista de reproducción.
     */
    public void agregarContenidoALista(String nombreListaAgregar, Video contenidoAgregar) {
        for (ListaReproduccion lista : listasReproduccion) {
            if (lista.getNombre().equals(nombreListaAgregar)) {
                if (contenidoAgregar != null) {
                    lista.agregarContenido(contenidoAgregar);
                    System.out.println("Contenido agregado a la lista.");
                } else {
                    System.out.println("El contenido no está registrado.");
                }
                return;
            }
        }
        System.out.println("Lista no encontrada.");
    }

    /**
     * Crea una nueva lista de reproducción.
     */
    public void crearListaReproduccion(String nombreLista) {
        ListaReproduccion nuevaLista = new ListaReproduccion(nombreLista);
        listasReproduccion.add(nuevaLista);
        System.out.println("Lista de reproducción creada.");
    }

    // Métodos para gestionar favoritos

    /**
     * Agrega un contenido a la lista de favoritos.
     */
    public void agregarFavorito(String contenidoFavorito) {
        if (!favoritos.contains(contenidoFavorito)) {
            favoritos.add(contenidoFavorito);
            System.out.println("Favorito agregado.");
        } else {
            System.out.println("El contenido ya está en favoritos.");
        }
    }

    /**
     * Elimina un contenido de la lista de favoritos.
     * @param contenidoEliminar Contenido a eliminar de favoritos.
     */
    public void eliminarFavorito(String contenidoEliminar) {
        if (favoritos.remove(contenidoEliminar)) {
            System.out.println("Favorito eliminado.");
        } else {
            System.out.println("El contenido no estaba en favoritos.");
        }
    }

    /**
     * Muestra recomendaciones personalizadas basadas en favoritos.
     */
    public void recomendaciones() {
        System.out.println("Recomendaciones personalizadas: ");
        // Aquí puedes agregar lógica para recomendaciones personalizadas basadas en favoritos
    }

    /**
     * Muestra todas las listas de reproducción del usuario.
     */
    public void mostrarListasReproduccion() {
        System.out.println("Listas de reproducción del usuario " + nombre + ":");
        for (ListaReproduccion lista : listasReproduccion) {
            lista.mostrarContenido();
            System.out.println();
        }
    }

    // Métodos de instancia para modificar y eliminar la cuenta

    /**
     * Permite al usuario modificar su información personal.
     */
    public void modificarCuenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué información desea modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Contraseña");
        System.out.println("3. Información de pago");
        System.out.print("Ingrese el número de la opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consume el newline

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nuevo nombre: ");
                this.nombre = scanner.nextLine();
                System.out.println("Nombre modificado con éxito.");
                break;
            case 2:
                System.out.print("Ingrese la nueva contraseña: ");
                this.contrasena = scanner.nextLine();
                System.out.println("Contraseña modificada con éxito.");
                break;
            case 3:
                this.pago = Pago.capturarPago();
                System.out.println("Información de pago modificada con éxito.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    /**
     * Elimina la cuenta del usuario.
     */
    public void eliminarCuenta() {
        System.out.println("Cuenta eliminada con éxito.");
    }

    /**
     * La clase ListaReproduccion representa una lista de reproducción que contiene
     * una colección de videos.
     */
    private static class ListaReproduccion implements Serializable {
        private static final long serialVersionUID = 1L;
        private String nombre;
        private List<Video> contenido; // Lista de objetos Video (incluye Series y Películas)

        /**
         * Constructor para crear una instancia de ListaReproduccion con el nombre proporcionado.
         */
        public ListaReproduccion(String nombre) {
            this.nombre = nombre;
            this.contenido = new ArrayList<>();
        }

        /**
         * Agrega un contenido a la lista de reproducción.
         */
        public void agregarContenido(Video item) {
            contenido.add(item);
        }

        /**
         * Elimina un contenido de la lista de reproducción.
         */
        public void eliminarContenido(Video item) {
            contenido.remove(item);
        }

        /**
         * Muestra el contenido de la lista de reproducción.
         */
        public void mostrarContenido() {
            System.out.println("Lista de Reproducción: " + nombre);
            for (Video item : contenido) {
                item.mostrarInfo(); // Llama al método mostrarInfo() de la clase Video
            }
        }

        /**
         * Obtiene el nombre de la lista de reproducción.
         * @return Nombre de la lista de reproducción.
         */
        public String getNombre() {
            return nombre;
        }
    }
}


