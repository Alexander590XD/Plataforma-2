/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.util.Scanner;

/**
 *
 * @author pato4
 */
public class GestionUsuarios {
    /*private Map<Integer, Usuario> usuarios;
    private final String ADMIN_PASSWORD = "admin123"; 

    public GestionUsuarios() {
        usuarios = new HashMap<>();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            mostrarMenuPrincipal(scanner);
        } while (true); 
    }

    public void mostrarMenuPrincipal(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n----- Menú Principal -----");
            System.out.println("1. Mostrar Información en Lista");
            System.out.println("2. Mostrar Información en Cola");
            System.out.println("3. Mostrar Información en Pila");
            System.out.println("4. Eliminar Información");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    mostrarInformacionLista();
                    break;
                case 2:
                    mostrarInformacionCola();
                    break;
                case 3:
                    mostrarInformacionPila();
                    break;
                case 4:
                    if (validarContraseña(scanner)) {
                        eliminarInformacion(scanner);
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    return; 
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 5);
    }

    private boolean validarContraseña(Scanner scanner) {
        System.out.print("Ingrese la contraseña: ");
        String contrasena = scanner.nextLine();
        if (ADMIN_PASSWORD.equals(contrasena)) {
            return true;
        } else {
            System.out.println("Contraseña incorrecta. No tiene acceso a esta funcionalidad.");
            return false;
        }
    }

    private void mostrarInformacionLista() {
        System.out.println("\n----- Información de Usuarios en Lista -----");
        List<Usuario> listaUsuarios = new ArrayList<>(usuarios.values());
        for (Usuario usuario : listaUsuarios) {
            mostrarUsuario(usuario);
        }
    }

    private void mostrarInformacionCola() {
        System.out.println("\n----- Información de Usuarios en Cola -----");
        Queue<Usuario> colaUsuarios = new LinkedList<>(usuarios.values());
        while (!colaUsuarios.isEmpty()) {
            Usuario usuario = colaUsuarios.poll();
            mostrarUsuario(usuario);
        }
    }

    private void mostrarInformacionPila() {
        System.out.println("\n----- Información de Usuarios en Pila -----");
        Stack<Usuario> pilaUsuarios = new Stack<>();
        pilaUsuarios.addAll(usuarios.values());
        while (!pilaUsuarios.isEmpty()) {
            Usuario usuario = pilaUsuarios.pop();
            mostrarUsuario(usuario);
        }
    }

    private void mostrarUsuario(Usuario usuario) {
        System.out.println("ID: " + usuario.getId());
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Correo: " + usuario.getCorreo());
        System.out.println("---------------------------------------");
    }

    private void eliminarInformacion(Scanner scanner) {
        System.out.println("\n----- Menú de Eliminación -----");
        System.out.println("1. Eliminar Usuario");
        System.out.println("2. Salir");
        System.out.print("Ingrese una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
            case 1:
                eliminarUsuario(scanner);
                break;
            case 2:
                System.out.println("Regresando al menú principal...");
                break;
            default:
                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
        }
    }

    private void eliminarUsuario(Scanner scanner) {
        System.out.print("Ingrese el ID del usuario a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (usuarios.remove(id) != null) {
            System.out.println("Usuario eliminado.");
        } else {
            System.out.println("No se encontró un usuario con ID " + id + ".");
        }
    }

    // Clase interna para representar un Usuario
    private static class Usuario {
        private int id;
        private String nombre;
        private String correo;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }
    }*/
}
