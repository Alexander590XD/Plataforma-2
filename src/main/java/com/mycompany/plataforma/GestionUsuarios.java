/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pato4
 */
public class GestionUsuarios {
   private List<Usuario> usuarios;

    // Constructor
    public GestionUsuarios() {
        usuarios = new ArrayList<>();
        cargarUsuarios(); // Cargar usuarios al iniciar la aplicación
    }

    // Registrar un nuevo usuario
    public void registrarNuevoUsuario() {
        Usuario nuevoUsuario = Usuario.registrarUsuario();
        if (nuevoUsuario != null) {
            usuarios.add(nuevoUsuario);
            guardarUsuarios(); // Guardar los usuarios cada vez que se registra uno nuevo
            System.out.println("Usuario registrado exitosamente: " + nuevoUsuario.getNombre());
        } else {
            System.out.println("Error al registrar el usuario.");
        }
    }

    // Buscar un usuario por nombre
    public Usuario buscarUsuarioPorNombre(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    // Iniciar sesión
    public Usuario iniciarSesion(String nombre, String contrasena) {
        Usuario usuario = buscarUsuarioPorNombre(nombre);
        if (usuario != null && usuario.iniciarSesion(contrasena)) {
            return usuario;
        }
        return null;
    }

    // Modificar la información de un usuario
    public void modificarUsuario(String nombre) {
        Usuario usuario = buscarUsuarioPorNombre(nombre);
        if (usuario != null) {
            System.out.println("Modificando información para el usuario: " + nombre);
            usuario.modificarCuenta(); // Permite al usuario modificar su cuenta
            guardarUsuarios(); // Guardar los cambios
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // Eliminar un usuario
    public void eliminarUsuario(String nombre) {
        Usuario usuario = buscarUsuarioPorNombre(nombre);
        if (usuario != null) {
            usuarios.remove(usuario);
            guardarUsuarios(); // Guardar los cambios después de eliminar
            System.out.println("Usuario eliminado exitosamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // Mostrar todos los usuarios
    public void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Usuarios registrados:");
            for (Usuario usuario : usuarios) {
                System.out.println("Usuario: " + usuario.getNombre());
            }
        }
    }

    // Guardar usuarios en un archivo
    private void guardarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuarios.dat"))) {
            oos.writeObject(usuarios);
            System.out.println("Usuarios guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    // Cargar usuarios desde un archivo
    private void cargarUsuarios() {
        File file = new File("usuarios.dat");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                usuarios = (List<Usuario>) ois.readObject();
                System.out.println("Usuarios cargados exitosamente.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar usuarios: " + e.getMessage());
            }
        } else {
            System.out.println("No se encontró el archivo de usuarios.");
        }
    }

    // Mostrar el menú para gestionar usuarios
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n----- Menú de Gestión de Usuarios -----");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Modificar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Mostrar todos los usuarios");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarNuevoUsuario();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del usuario a modificar: ");
                    String nombreModificar = scanner.nextLine();
                    modificarUsuario(nombreModificar);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del usuario a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    eliminarUsuario(nombreEliminar);
                    break;
                case 4:
                    mostrarUsuarios();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 5);
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        GestionUsuarios gestion = new GestionUsuarios();
        gestion.mostrarMenu(); // Inicia el menú para gestionar usuarios
    }
}
