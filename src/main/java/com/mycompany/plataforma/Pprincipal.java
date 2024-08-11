/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pato4
 */
public class Pprincipal {
    
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenuPrincipal(scanner);
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mostrarMenuSecundario(scanner);
                    break;
                case 2:
                    gestionarUsuario(scanner);
                    break;
                case 3:
                    gestionarAnalista(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 4);
    }

    private static void mostrarMenuPrincipal(Scanner scanner) {
        System.out.println("\n----- Menú Principal -----");
        System.out.println("1. Administrador");
        System.out.println("2. Usuario");
        System.out.println("3. Analista de Marketing");
        System.out.println("4. Salir");
        System.out.print("Ingrese una opción: ");
    }
    
    private static void mostrarMenuSecundario(Scanner scanner){
        GestionPlataforma gestionPlataforma = new GestionPlataforma();
        GestionUsuarios gestionUsuarios = new GestionUsuarios();
        
        int ad = 0;
        do {
            System.out.println("Gestionar: ");
            System.out.println("1. Plataforma");
            System.out.println("2. Usuarios");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");
            ad = scanner.nextInt();
            scanner.nextLine();

            switch (ad) {
                case 1:
                    gestionarAdministrador(scanner, gestionPlataforma);
                    break;
                case 2:
                    gestionarAdministrador2(scanner, gestionUsuarios);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (ad != 3);
    }

    private static void gestionarAdministrador(Scanner scanner, GestionPlataforma gestionPlataforma) {
        System.out.print("Ingrese la contraseña de administrador: ");
        String contrasena = scanner.nextLine();

        if ("admin123".equals(contrasena)) {
            gestionPlataforma.mostrarMenuPrincipal(scanner);
        } else {
            System.out.println("Contraseña incorrecta. No tiene acceso a esta funcionalidad.");
        }
    }

    private static void gestionarAdministrador2(Scanner scanner, GestionUsuarios gestionUsuarios) {
        System.out.print("Ingrese la contraseña de administrador: ");
        String contrasena = scanner.nextLine();

        if ("admin123".equals(contrasena)) {
            gestionUsuarios.mostrarMenuPrincipal(scanner);
        } else {
            System.out.println("Contraseña incorrecta. No tiene acceso a esta funcionalidad.");
        }
    }

    private static void gestionarUsuario(Scanner scanner) {
        Usuario usuario = Usuario.registrarUsuario();
        boolean sesionIniciada = false;

        while (!sesionIniciada) {
            System.out.print("Ingrese la contraseña para iniciar sesión: ");
            String contrasena = scanner.nextLine();
            if (usuario.iniciarSesion(contrasena)) {
                System.out.println("Inicio de sesión exitoso.");
                manejarMenuUsuario(scanner, usuario);
                sesionIniciada = true;
            } else {
                System.out.println("Contraseña incorrecta. Intente nuevamente.");
            }
        }
    }

    private static void manejarMenuUsuario(Scanner scanner, Usuario usuario) {
        int opcion;
        do {
            System.out.println("\n----- Menú del Usuario -----");
            System.out.println("1. Ver información del usuario");
            System.out.println("2. Crear lista de reproducción");
            System.out.println("3. Agregar contenido a lista de reproducción");
            System.out.println("4. Marcar contenido como favorito");
            System.out.println("5. Eliminar contenido de favoritos");
            System.out.println("6. Ver recomendaciones");
            System.out.println("7. Cerrar sesión");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    usuario.mostrarInformacion();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la nueva lista de reproducción: ");
                    String nombreLista = scanner.nextLine();
                    usuario.crearListaReproduccion(nombreLista);
                    System.out.println("Lista de reproducción creada.");
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la lista de reproducción: ");
                    String nombreListaAgregar = scanner.nextLine();
                    System.out.print("Ingrese el contenido a agregar: ");
                    String contenidoAgregar = scanner.nextLine();
                    usuario.agregarContenidoALista(nombreListaAgregar, contenidoAgregar);
                    System.out.println("Contenido agregado a la lista.");
                    break;
                case 4:
                    System.out.print("Ingrese el contenido para marcar como favorito: ");
                    String contenidoFavorito = scanner.nextLine();
                    usuario.agregarFavorito(contenidoFavorito);
                    System.out.println("Contenido marcado como favorito.");
                    break;
                case 5:
                    System.out.print("Ingrese el contenido para eliminar de favoritos: ");
                    String contenidoEliminar = scanner.nextLine();
                    usuario.eliminarFavorito(contenidoEliminar);
                    System.out.println("Contenido eliminado de favoritos.");
                    break;
                case 6:
                    usuario.mostrarRecomendaciones();
                    break;
                case 7:
                    System.out.println("Cerrando sesión...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 7);
    }

    private static void gestionarAnalista(Scanner scanner) {
        System.out.print("Ingrese la contraseña del analista de marketing: ");
        String contrasena = scanner.nextLine();

        if ("analista123".equals(contrasena)) {
            // Por ahora, no hay implementación específica para el analista.
            System.out.println("Acceso de analista de marketing aún no implementado.");
        } else {
            System.out.println("Contraseña incorrecta. No tiene acceso a esta funcionalidad.");
        }
    }
}
