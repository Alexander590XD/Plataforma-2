/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author pato4
 */
public class GestionPlataforma {
    
    private Map<Integer, Plataforma> plataformas;
    private int nextId;
    private final String ADMIN_PASSWORD = "admin123"; 

    public GestionPlataforma() {
        plataformas = new HashMap<>();
        nextId = 1;
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
            System.out.println("1. Registrar Película");
            System.out.println("2. Registrar Serie");
            System.out.println("3. Registrar Canción");
            System.out.println("4. Registrar Efecto de Sonido");
            System.out.println("5. Modificar Información");
            System.out.println("6. Mostrar Información");
            System.out.println("7. Eliminar Información");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    if (validarContraseña(scanner)) {
                        registrarPelicula(scanner);
                    }
                    break;
                case 2:
                    if (validarContraseña(scanner)) {
                        registrarSerie(scanner);
                    }
                    break;
                case 3:
                    if (validarContraseña(scanner)) {
                        registrarCancion(scanner);
                    }
                    break;
                case 4:
                    if (validarContraseña(scanner)) {
                        registrarEfectoDeSonido(scanner);
                    }
                    break;
                case 5:
                    if (validarContraseña(scanner)) {
                        modificarInformacion(scanner);
                    }
                    break;
                case 6:
                    mostrarInformacion(scanner);
                    break;
                case 7:
                    if (validarContraseña(scanner)) {
                        eliminarInformacion(scanner);
                    }
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    return; 
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 8);
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

    private void registrarPelicula(Scanner scanner) {
        System.out.println("\n----- Registro de Nueva Película -----");
        Pelicula pelicula = new Pelicula();
        pelicula.setIdElemento(nextId++);
        plataformas.put(pelicula.getIdElemento(), pelicula);
    }

    private void registrarSerie(Scanner scanner) {
        System.out.println("\n----- Registro de Nueva Serie -----");
        Serie serie = new Serie();
        serie.setIdElemento(nextId++);
        plataformas.put(serie.getIdElemento(), serie);
    }

    private void registrarCancion(Scanner scanner) {
        System.out.println("\n----- Registro de Nueva Canción -----");
        Cancion cancion = new Cancion();
        cancion.setIdElemento(nextId++);
        plataformas.put(cancion.getIdElemento(), cancion);
    }

    private void registrarEfectoDeSonido(Scanner scanner) {
        System.out.println("\n----- Registro de Nuevo Efecto de Sonido -----");
        EfectoDeSonido efecto = new EfectoDeSonido();
        efecto.setIdElemento(nextId++);
        plataformas.put(efecto.getIdElemento(), efecto);
    }

    private void modificarInformacion(Scanner scanner) {
        System.out.println("\n----- Menú de Modificación -----");
        System.out.println("1. Modificar Película");
        System.out.println("2. Modificar Serie");
        System.out.println("3. Modificar Canción");
        System.out.println("4. Modificar Efecto de Sonido");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
            case 1:
                modificarElemento(Pelicula.class, scanner);
                break;
            case 2:
                modificarElemento(Serie.class, scanner);
                break;
            case 3:
                modificarElemento(Cancion.class, scanner);
                break;
            case 4:
                modificarElemento(EfectoDeSonido.class, scanner);
                break;
            case 5:
                System.out.println("Regresando al menú principal...");
                break;
            default:
                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
        }
    }

    private void modificarElemento(Class<?> tipo, Scanner scanner) {
        System.out.print("Ingrese el ID del elemento a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Plataforma plataforma = plataformas.get(id);
        if (plataforma != null) {
            if (tipo.isInstance(plataforma)) {
                if (plataforma instanceof Pelicula) {
                    ((Pelicula) plataforma).modificarInformacion();
                } else if (plataforma instanceof Serie) {
                    ((Serie) plataforma).modificarInformacion();
                } else if (plataforma instanceof Cancion) {
                    ((Cancion) plataforma).modificarInformacion();
                } else if (plataforma instanceof EfectoDeSonido) {
                    ((EfectoDeSonido) plataforma).modificarInformacion();
                }
            } else {
                System.out.println("El ID proporcionado no corresponde al tipo esperado.");
            }
        } else {
            System.out.println("No se encontró un elemento con ID " + id + ".");
        }
    }

    private void mostrarInformacion(Scanner scanner) {
        int opcionMostrar;
        do {
            System.out.println("\n----- Menú de Mostrar Información -----");
            System.out.println("1. Mostrar Películas");
            System.out.println("2. Mostrar Series");
            System.out.println("3. Mostrar Canciones");
            System.out.println("4. Mostrar Efectos de Sonido");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcionMostrar = scanner.nextInt();
            scanner.nextLine();
            switch (opcionMostrar) {
                case 1:
                    mostrarPeliculas();
                    break;
                case 2:
                    mostrarSeries();
                    break;
                case 3:
                    mostrarCanciones();
                    break;
                case 4:
                    mostrarEfectosDeSonido();
                    break;
                case 5:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcionMostrar != 5);
    }

    private void eliminarInformacion(Scanner scanner) {
        System.out.println("\n----- Menú de Eliminación -----");
        System.out.println("1. Eliminar Películas");
        System.out.println("2. Eliminar Series");
        System.out.println("3. Eliminar Canciones");
        System.out.println("4. Eliminar Efectos de Sonido");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opción: ");
        int opcionEliminar = scanner.nextInt();
        scanner.nextLine();
        switch (opcionEliminar) {
            case 1:
                eliminarElementos(Pelicula.class, scanner);
                break;
            case 2:
                eliminarElementos(Serie.class, scanner);
                break;
            case 3:
                eliminarElementos(Cancion.class, scanner);
                break;
            case 4:
                eliminarElementos(EfectoDeSonido.class, scanner);
                break;
            case 5:
                System.out.println("Regresando al menú principal...");
                break;
            default:
                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
        }
    }

    private void eliminarElementos(Class<?> tipo, Scanner scanner) {
        System.out.print("Ingrese el ID del elemento a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (plataformas.remove(id) != null) {
            System.out.println("Elemento eliminado.");
        } else {
            System.out.println("No se encontró un elemento con ID " + id + ".");
        }
    }

    private void mostrarPeliculas() {
        System.out.println("\n--- Información de Películas ---");
        for (Plataforma plataforma : plataformas.values()) {
            if (plataforma instanceof Pelicula) {
                ((Pelicula) plataforma).mostrarPelicula();
                System.out.println("---------------------------------------");
            }
        }
    }

    private void mostrarSeries() {
        System.out.println("\n--- Información de Series ---");
        for (Plataforma plataforma : plataformas.values()) {
            if (plataforma instanceof Serie) {
                ((Serie) plataforma).mostrarSerie();
                System.out.println("---------------------------------------");
            }
        }
    }

    private void mostrarCanciones() {
        System.out.println("\n--- Información de Canciones ---");
        for (Plataforma plataforma : plataformas.values()) {
            if (plataforma instanceof Cancion) {
                ((Cancion) plataforma).mostrarInfoCancion();
                System.out.println("---------------------------------------");
            }
        }
    }

    private void mostrarEfectosDeSonido() {
        System.out.println("\n--- Información de Efectos de Sonido ---");
        for (Plataforma plataforma : plataformas.values()) {
            if (plataforma instanceof EfectoDeSonido) {
                ((EfectoDeSonido) plataforma).mostrarInfoEfecto();
                System.out.println("---------------------------------------");
            }
        }
    }
}