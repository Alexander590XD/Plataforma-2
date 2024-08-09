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
       ArrayList<Plataforma> plata = new ArrayList<>();
       
       int opcion;
       
       do{
           
            System.out.println("\n----- Menú Principal -----");
            System.out.println("1. Registrar Pelicula");
            System.out.println("2. Registrar Serie ");
            System.out.println("3. Registrar Cancion");
            System.out.println("4. Registrar Efecto de Sonido");
            System.out.println("5. Mostrar información");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    registarPelicula(plata, scanner);
                    break;
                case 2:
                    registarSerie(plata, scanner);
                    break;
                case 3:
                    registrarCancion(plata, scanner);
                    break;
                case 4:
                    registrarEfectoDeSonido(plata, scanner);
                    break;
                case 5:
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
                            scanner.nextLine(); // Consumir la nueva línea después de nextInt()

                            switch (opcionMostrar) {
                                case 1:
                                    mostrarPeliculas(plata);
                                    break;
                                case 2:
                                    mostrarSeries(plata);
                                    break;
                                case 3:
                                    mostrarCanciones(plata);
                                    break;
                                case 4:
                                    mostrarEfectosDeSonido(plata);
                                    break;
                                case 5:
                                    System.out.println("Regresando al menú principal...");
                                    break;
                                default:
                                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                            }

                        } while (opcionMostrar != 5);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }

        }while(opcion != 5);
       
        scanner.close();
    }
     
    private static void registarPelicula(ArrayList<Plataforma> plata, Scanner scanner) {
       System.out.println("\n----- Registro de Nueva Película -----");
    Pelicula pelicula = new Pelicula();
    plata.add(pelicula);
    
    int op = 0;
        do {
            System.out.println("\n----- Menú -----");
            System.out.println("1. Ver trailer");
            System.out.println("2. Recomendar película");
            System.out.println("3. Apta para público");
            System.out.println("4. Descripción breve");
            System.out.println("5. Agregar comentario");
            System.out.println("6. Reproducir pelicula");
            System.out.println("7. Obtener duración formateada");
            System.out.println("8. Verificar subtitulos en idioma");
            System.out.println("9. Mofificar fecha de lanzamiento");
            System.out.println("10. Salir");
            System.out.print("Ingrese una opción: ");
            op = scanner.nextInt();

            scanner.nextLine();

            switch(op) {
                case 1:
                    pelicula.verTrailer();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de su amigo/a para recomendar la película: ");
                    String amigo = scanner.nextLine();
                    pelicula.recomendarPelicula(amigo);
                    break;
                case 3:
                    pelicula.esAptaParaNinos();
                    break;
                case 4:
                    pelicula.obtenerDescripcionBreve();
                    break;
                case 5:
                    System.out.print("Ingrese su comentario sobre la película: ");
                    String comentario = scanner.nextLine();
                    pelicula.agregarComentario(comentario);
                    break;
                case 6:
                    pelicula.reproducir();
                    break;
                case 7:
                    System.out.println("Duración formateada: " + pelicula.obtenerDuracionFormateada());
                    break;
                case 8:
                    System.out.print("Ingrese el idioma para verificar subtitulos: ");
                    String idioma = scanner.nextLine();
                    if (pelicula.tieneSubtitulosEnIdioma(idioma)) {
                        System.out.println("La película tiene subtitulos en " + idioma);
                    } else {
                        System.out.println("La película no tiene subtitulos en " + idioma);
                    }
                    break;
                case 9: 
                    System.out.print("Nuevo fecha: ");
                    String nuevaFechaStr = scanner.nextLine();
                    pelicula.modificarFechaLanzamiento(nuevaFechaStr);
                    break;
                case 10:
                    System.out.println("Saliendo del menú de video...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while(op != 10);
    }
    private static void registarSerie(ArrayList<Plataforma> plata, Scanner scanner) {
         System.out.println("\n----- Registro de Nueva Serie -----");
    Serie serie = new Serie();
    plata.add(serie);
    
    int op = 0;
        do {
            System.out.println("\n----- Menú -----");
            System.out.println("1. Agregar temporada");
            System.out.println("2. Agregar capitulo");
            System.out.println("3. Estado de Emisión");
            System.out.println("4. Actualizar duración general");
            System.out.println("5. Actualizar duración capítulo");
            System.out.println("6. Reproducir video");
            System.out.println("7. Ver trailer");
            System.out.println("8. Obtener duración formateada");
            System.out.println("9. Verificar subtitulos en idioma");
            System.out.println("10. Mofificar fecha de lanzamiento");
            System.out.println("11. Salir");
            System.out.print("Ingrese una opción: ");
            op = scanner.nextInt();

            scanner.nextLine();

            switch(op) {
                case 1: 
                    serie.agregarTemporada();
                    break;
                case 2:
                    serie.agregarCapitulo();
                    break;
                case 3: 
                    System.out.print("Nuevo estado de emisión: ");
                    String nuevoEstado = scanner.nextLine();
                    serie.cambiarEstadoEmision(nuevoEstado);
                    break;
                case 4:
                    System.out.print("Duración General (minutos): ");
                    int nuevaDuracion = scanner.nextInt();
                    serie.cambiarDuracion(nuevaDuracion);
                    break;
                case 5:
                    System.out.print("Duración del Capítulo: ");
                    int nuevaDuracionCp = scanner.nextInt();
                    serie.cambiarDuracionCap(nuevaDuracionCp);
                    break;
                case 6:
                    serie.reproducir();
                    break;
                case 7:
                    serie.verTrailer();
                    break;
                case 8:
                    System.out.println("Duración formateada: " + serie.obtenerDuracionFormateada());
                    break;
                case 9:
                    System.out.print("Ingrese el idioma para verificar subtitulos: ");
                    String idioma = scanner.nextLine();
                    if (serie.tieneSubtitulosEnIdioma(idioma)) {
                        System.out.println("La serie tiene subtitulos en " + idioma);
                    } else {
                        System.out.println("La serie no tiene subtitulos en " + idioma);
                    }
                    break;
                case 10:
                    System.out.print("Nuevo fecha: ");
                    String nuevaFechaStr = scanner.nextLine();
                    serie.modificarFechaLanzamiento(nuevaFechaStr);
                    break;
                case 11:
                    System.out.println("Saliendo del menú de serie...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while(op != 11);
    }
    
    private static void registrarCancion(ArrayList<Plataforma> plata, Scanner scanner) {
        System.out.println("\n----- Registro de Nueva Canción -----");
        Cancion cancion = new Cancion();
        plata.add(cancion);

        int opcion;
        do {
            System.out.println("\n----- Menú de Canción -----");
            System.out.println("1. Reproducir canción");
            System.out.println("2. Cambiar género");
            System.out.println("3. Descargar canción");
            System.out.println("4. Imprimir produccion");
            System.out.println("5. Imprimir letra");
            System.out.println("6. Agregar a Playlist");
            System.out.println("7. Mofificar fecha de lanzamiento");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            switch (opcion) {
                case 1:
                    cancion.reproducir();
                    break;
                case 2:
                    System.out.print("Nuevo género: ");
                    String nuevoGenero = scanner.nextLine();
                    cancion.cambiarGenero(nuevoGenero);
                    break;
                case 3:
                    cancion.descargar();
                    break;
                case 4:
                    cancion.imprimirInfoProduccion();
                    break;
                case 5:
                    cancion.imprimirLetra();
                    break;
                case 6:
                    System.out.print("Nombre de la Playlist: ");
                    String playlist = scanner.nextLine();
                    cancion.agregarAPlaylist(playlist);
                    break;
                case 7:
                    System.out.print("Nuevo fecha: ");
                    String nuevaFechaStr = scanner.nextLine();
                    cancion.modificarFechaLanzamiento(nuevaFechaStr);
                    break;
                case 8:
                    System.out.println("Saliendo del menú de canción...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 8);
    }
    private static void registrarEfectoDeSonido(ArrayList<Plataforma> plata, Scanner scanner) {
        System.out.println("\n----- Registro de Nuevo Efecto de Sonido -----");
        EfectoDeSonido efecto = new EfectoDeSonido();
        plata.add(efecto);

        // Menú de opciones para efectos de sonido
        int opcion;
        do {
            System.out.println("\n----- Menú de Efecto de Sonido -----");
            System.out.println("1. Reproducir efecto de sonido");
            System.out.println("2. Descargar efecto de sonido");
            System.out.println("3. Mofificar fecha de lanzamiento");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    efecto.reproducirEfecto();
                    break;
                case 2:
                    efecto.descargar();
                    break;
                case 3:
                    System.out.print("Nuevo fecha: ");
                    String nuevaFechaStr = scanner.nextLine();
                    efecto.modificarFechaLanzamiento(nuevaFechaStr);
                    break;
                case 4:
                    System.out.println("Saliendo del menú de efecto de sonido...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 4);
    }
    
    private static void mostrarPeliculas(ArrayList<Plataforma> plata) {
        System.out.println("\n--- Información de Películas ---");
        for (Plataforma plataforma : plata) {
            if (plataforma instanceof Pelicula) {
                ((Pelicula) plataforma).mostrarPelicula();
                System.out.println("---------------------------------------");
            }
        }
    }
    private static void mostrarSeries(ArrayList<Plataforma> plata) {
        System.out.println("\n--- Información de Series ---");
        for (Plataforma plataforma : plata) {
            if (plataforma instanceof Serie) {
                ((Serie) plataforma).mostrarSerie();
                System.out.println("---------------------------------------");
            }
        }
    }
    private static void mostrarCanciones(ArrayList<Plataforma> plata) {
        System.out.println("\n--- Información de Canciones ---");
        for (Plataforma plataforma : plata) {
            if (plataforma instanceof Cancion) {
                ((Cancion) plataforma).mostrarInfoCancion();
                System.out.println("---------------------------------------");
            }
        }
    }
    private static void mostrarEfectosDeSonido(ArrayList<Plataforma> plata) {
        System.out.println("\n--- Información de Efectos de Sonido ---");
        for (Plataforma plataforma : plata) {
            if (plataforma instanceof EfectoDeSonido) {
                ((EfectoDeSonido) plataforma).mostrarInfoEfecto();
                System.out.println("---------------------------------------");
            }
        }
    }
}
