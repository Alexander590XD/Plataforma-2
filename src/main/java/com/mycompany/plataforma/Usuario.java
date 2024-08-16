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
 *
 * @author pato4
 */

public class Usuario implements IUsuario, Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String contrasena;
    private Tiempo tiempoRegistro;
    private Pago pago;
    private List<ListaReproduccion> listasReproduccion;
    private List<String> favoritos;

    // Constructor
    public Usuario(String nombre, String contrasena, Tiempo tiempoRegistro, Pago pago) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.tiempoRegistro = tiempoRegistro;
        this.pago = pago;
        this.listasReproduccion = new ArrayList<>();
        this.favoritos = new ArrayList<>();
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
    
    public boolean iniciarSesion(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

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

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getContrasena() {
        return contrasena;
    }

   public void agregarContenidoALista(String nombreListaAgregar, Video contenidoAgregar) {
        for (ListaReproduccion lista : listasReproduccion) {
            if (lista.getNombre().equals(nombreListaAgregar)) {
                // Verificar si el contenido a agregar es un registro predeterminado
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

    public void crearListaReproduccion(String nombreLista) {
        ListaReproduccion nuevaLista = new ListaReproduccion(nombreLista);
        listasReproduccion.add(nuevaLista);
        System.out.println("Lista de reproducción creada.");
    }

    public void agregarFavorito(String contenidoFavorito) {
        if (!favoritos.contains(contenidoFavorito)) {
            favoritos.add(contenidoFavorito);
            System.out.println("Favorito agregado.");
        } else {
            System.out.println("El contenido ya está en favoritos.");
        }
    }

    public void eliminarFavorito(String contenidoEliminar) {
        if (favoritos.remove(contenidoEliminar)) {
            System.out.println("Favorito eliminado.");
        } else {
            System.out.println("El contenido no estaba en favoritos.");
        }
    }

    public void recomendaciones() {
        System.out.println("Recomendaciones personalizadas: ");
        // Aquí puedes agregar lógica para recomendaciones personalizadas basadas en favoritos
    }

    public void mostrarListasReproduccion() {
        System.out.println("Listas de reproducción del usuario " + nombre + ":");
        for (ListaReproduccion lista : listasReproduccion) {
            lista.mostrarContenido();
            System.out.println();
        }
    }
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
                this.pago = Pago.capturarPago(); // Suponiendo que se puede capturar nueva información de pago
                System.out.println("Información de pago modificada con éxito.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public void eliminarCuenta() {
        System.out.println("Cuenta eliminada con éxito.");
    }
}

