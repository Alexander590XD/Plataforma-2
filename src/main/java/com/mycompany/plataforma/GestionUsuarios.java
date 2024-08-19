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
 * La clase GestionUsuarios administra una lista de usuarios, permitiendo
 * registrar, modificar, eliminar y mostrar usuarios. Implementa la persistencia
 * de usuarios en un archivo.
 */
public class GestionUsuarios {
   // Lista de usuarios gestionados por esta clase.
    private List<Usuario> usuarios;

    /**
     * Constructor que inicializa la lista de usuarios y carga los usuarios desde el archivo.
     */
    public GestionUsuarios() {
        usuarios = new ArrayList<>();
        cargarUsuarios(); // Carga usuarios al iniciar la aplicación
    }

    /**
     * Registra un nuevo usuario mediante la captura de datos.
     */
    public void registrarNuevoUsuario() {
        Usuario nuevoUsuario = Usuario.registrarUsuario();
        if (nuevoUsuario != null) {
            usuarios.add(nuevoUsuario);
            guardarUsuarios(); // Guarda los usuarios cada vez que se registra uno nuevo
            System.out.println("Usuario registrado exitosamente: " + nuevoUsuario.getNombre());
        } else {
            System.out.println("Error al registrar el usuario.");
        }
    }

    /**
     * Busca un usuario por nombre.
     * @return El usuario encontrado o null si no existe.
     */
    public Usuario buscarUsuarioPorNombre(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Inicia sesión para un usuario dado su nombre y contraseña.
     * @return El usuario si las credenciales son correctas, null en caso contrario.
     */
    public Usuario iniciarSesion(String nombre, String contrasena) {
        Usuario usuario = buscarUsuarioPorNombre(nombre);
        if (usuario != null && usuario.iniciarSesion(contrasena)) {
            return usuario;
        }
        return null;
    }

    /**
     * Modifica la información de un usuario dado su nombre.
     */
    public void modificarUsuario(String nombre) {
        Usuario usuario = buscarUsuarioPorNombre(nombre);
        if (usuario != null) {
            System.out.println("Modificando información para el usuario: " + nombre);
            usuario.modificarCuenta(); // Permite al usuario modificar su cuenta
            guardarUsuarios(); // Guarda los cambios
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    /**
     * Elimina un usuario dado su nombre.
     */
    public void eliminarUsuario(String nombre) {
        Usuario usuario = buscarUsuarioPorNombre(nombre);
        if (usuario != null) {
            usuarios.remove(usuario);
            guardarUsuarios(); // Guarda los cambios después de eliminar
            System.out.println("Usuario eliminado exitosamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    /**
     * Muestra todos los usuarios registrados.
     */
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

    /**
     * Guarda la lista de usuarios en un archivo.
     */
    private void guardarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuarios.dat"))) {
            oos.writeObject(usuarios);
            System.out.println("Usuarios guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    /**
     * Carga la lista de usuarios desde un archivo.
     */
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

    /**
     * Muestra el menú para gestionar usuarios.
     */
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

    /**
     * Método principal para ejecutar la aplicación.
     */
    public static void main(String[] args) {
        GestionUsuarios gestion = new GestionUsuarios();
        gestion.mostrarMenu(); // Inicia el menú para gestionar usuarios
    }
}
