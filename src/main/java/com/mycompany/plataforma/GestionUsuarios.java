/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author pato4
 */
public class GestionUsuarios {
    private Map<Integer, Usuario> usuarios;
    private List<Usuario> listaUsuarios;
    private Stack<Usuario> pilaUsuarios;
    private Queue<Usuario> colaUsuarios;
    private int nextId;

    public GestionUsuarios() {
        usuarios = new HashMap<>();
        /*listaUsuarios = new LinkedList<>();*/
        pilaUsuarios = new Stack<>();
        colaUsuarios = new LinkedList<>();
        nextId = 1;
    }

    public void mostrarMenuPrincipal(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n----- Menú Principal -----");
            System.out.println("1. Modificar Usuario");
            System.out.println("2. Eliminar Usuario");
            System.out.println("3. Mostrar Usuarios");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    modificarUsuario(scanner);
                    break;
                case 2:
                    eliminarUsuario(scanner);
                    break;
                case 3:
                    mostrarUsuarios();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 4);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(nextId, usuario);
        listaUsuarios.add(usuario);
        pilaUsuarios.push(usuario);
        colaUsuarios.offer(usuario);
        System.out.println("Usuario registrado con éxito. ID: " + nextId);
        nextId++;
    }

    private void modificarUsuario(Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario a modificar: ");
        String nombre = scanner.nextLine();
        Usuario usuario = buscarUsuarioPorNombre(nombre);
        if (usuario == null) {
            System.out.println("No se encontró un usuario con el nombre " + nombre + ".");
            return;
        }
        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Ingrese la nueva contraseña: ");
        String nuevaContrasena = scanner.nextLine();
        Usuario usuarioModificado = new Usuario(nuevoNombre, nuevaContrasena, usuario.tiempoRegistro, usuario.pago);
        usuarios.replace(getIdPorUsuario(usuario), usuarioModificado);
        listaUsuarios.remove(usuario);
        listaUsuarios.add(usuarioModificado);
        pilaUsuarios.remove(usuario);
        pilaUsuarios.push(usuarioModificado);
        colaUsuarios.remove(usuario);
        colaUsuarios.offer(usuarioModificado);
        System.out.println("Usuario modificado con éxito.");
    }

    private void eliminarUsuario(Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario a eliminar: ");
        String nombre = scanner.nextLine();
        Usuario usuario = buscarUsuarioPorNombre(nombre);
        if (usuario == null) {
            System.out.println("No se encontró un usuario con el nombre " + nombre + ".");
            return;
        }
        usuarios.remove(getIdPorUsuario(usuario));
        listaUsuarios.remove(usuario);
        pilaUsuarios.remove(usuario);
        colaUsuarios.remove(usuario);
        System.out.println("Usuario eliminado con éxito.");
    }

    private Usuario buscarUsuarioPorNombre(String nombre) {
        for (Usuario usuario : usuarios.values()) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    private int getIdPorUsuario(Usuario usuario) {
        for (Map.Entry<Integer, Usuario> entry : usuarios.entrySet()) {
            if (entry.getValue().equals(usuario)) {
                return entry.getKey();
            }
        }
        return -1; // ID no encontrado
    }

    private void mostrarUsuarios() {
        System.out.println("\n--- Lista de Usuarios ---");
        for (Map.Entry<Integer, Usuario> entry : usuarios.entrySet()) {
            System.out.println("ID: " + entry.getKey());
            entry.getValue().mostrarInformacion();
            System.out.println("---------------------------------------");
        }
    }
}
