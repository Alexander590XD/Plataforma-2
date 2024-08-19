/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * Clase que gestiona una plataforma que contiene diferentes tipos de contenidos multimedia.
 * Permite registrar, modificar, eliminar y mostrar información de películas, series, canciones y efectos de sonido.
 */
public class GestionPlataforma {
    
       // Mapa para almacenar los elementos de la plataforma. La clave es el ID del elemento y el valor es el objeto Plataforma.
    private Map<Integer, Plataforma> plataformas;
    private int nextId; // Contador para asignar el próximo ID disponible
    private final String ADMIN_PASSWORD = "admin123"; // Contraseña de administrador para acceder a funcionalidades restrictivas

    // Constructor que inicializa el mapa de plataformas y el contador de ID
    public GestionPlataforma() {
        plataformas = new HashMap<>(); // HashMap es una estructura de datos que permite un acceso rápido a los elementos usando una clave (ID)
        nextId = 1; // Inicializa el ID siguiente en 1
    }
    
    // Método principal que inicia el programa y muestra el menú
    public void iniciar() {
        Scanner scanner = new Scanner(System.in); // Utiliza un escáner para leer la entrada del usuario
        int opcion;
        do {
            opcion = mostrarMenuPrincipal(scanner); // Muestra el menú principal y obtiene la opción seleccionada
        } while (opcion != 8); // Continúa mostrando el menú hasta que el usuario elija salir (opción 8)
    }

    // Muestra el menú principal y maneja la selección del usuario
    public int mostrarMenuPrincipal(Scanner scanner) {
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
            scanner.nextLine(); // Limpia el buffer del escáner
            switch (opcion) {
                case 1:
                    if (validarContraseña(scanner)) registrarPelicula(scanner);
                    break;
                case 2:
                    if (validarContraseña(scanner)) registrarSerie(scanner);
                    break;
                case 3:
                    if (validarContraseña(scanner)) registrarCancion(scanner);
                    break;
                case 4:
                    if (validarContraseña(scanner)) registrarEfectoDeSonido(scanner);
                    break;
                case 5:
                    if (validarContraseña(scanner)) modificarInformacion(scanner);
                    break;
                case 6:
                    mostrarInformacion(scanner);
                    break;
                case 7:
                    if (validarContraseña(scanner)) eliminarInformacion(scanner);
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    break; 
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 8); // Continúa hasta que se elija la opción de salir (8)
        return opcion;
    }

    // Método que valida la contraseña del administrador para acceder a funcionalidades restrictivas
    private boolean validarContraseña(Scanner scanner) {
        System.out.print("Ingrese la contraseña: ");
        String contrasena = scanner.nextLine();
        if (ADMIN_PASSWORD.equals(contrasena)) {
            return true; // Contraseña correcta, permite el acceso
        } else {
            System.out.println("Contraseña incorrecta. No tiene acceso a esta funcionalidad.");
            return false; // Contraseña incorrecta, deniega el acceso
        }
    }

    // Registra una nueva película y la añade al mapa de plataformas
    private void registrarPelicula(Scanner scanner) {
        System.out.println("\n----- Registro de Nueva Película -----");
        Pelicula pelicula = new Pelicula(); // Crea una nueva instancia de Pelicula
        pelicula.setIdElemento(nextId++); // Asigna un nuevo ID a la película y incrementa el contador de IDs
        plataformas.put(pelicula.getIdElemento(), pelicula); // Añade la película al mapa de plataformas con el ID como clave
    }

    // Registra una nueva serie y la añade al mapa de plataformas
    private void registrarSerie(Scanner scanner) {
        System.out.println("\n----- Registro de Nueva Serie -----");
        Serie serie = new Serie(); // Crea una nueva instancia de Serie
        serie.setIdElemento(nextId++); // Asigna un nuevo ID a la serie y incrementa el contador de IDs
        plataformas.put(serie.getIdElemento(), serie); // Añade la serie al mapa de plataformas con el ID como clave
    }

    // Registra una nueva canción y la añade al mapa de plataformas
    private void registrarCancion(Scanner scanner) {
        System.out.println("\n----- Registro de Nueva Canción -----");
        Cancion cancion = new Cancion(); // Crea una nueva instancia de Cancion
        cancion.setIdElemento(nextId++); // Asigna un nuevo ID a la canción y incrementa el contador de IDs
        plataformas.put(cancion.getIdElemento(), cancion); // Añade la canción al mapa de plataformas con el ID como clave
    }

    // Registra un nuevo efecto de sonido y lo añade al mapa de plataformas
    private void registrarEfectoDeSonido(Scanner scanner) {
        System.out.println("\n----- Registro de Nuevo Efecto de Sonido -----");
        EfectoDeSonido efecto = new EfectoDeSonido(); // Crea una nueva instancia de EfectoDeSonido
        efecto.setIdElemento(nextId++); // Asigna un nuevo ID al efecto de sonido y incrementa el contador de IDs
        plataformas.put(efecto.getIdElemento(), efecto); // Añade el efecto de sonido al mapa de plataformas con el ID como clave
    }

    // Muestra el menú de modificación y permite modificar los elementos existentes
    private void modificarInformacion(Scanner scanner) {
        System.out.println("\n----- Menú de Modificación -----");
        System.out.println("1. Modificar Película");
        System.out.println("2. Modificar Serie");
        System.out.println("3. Modificar Canción");
        System.out.println("4. Modificar Efecto de Sonido");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer del escáner
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

    // Modifica un elemento específico (película, serie, canción o efecto de sonido) dado su tipo
    private void modificarElemento(Class<?> tipo, Scanner scanner) {
        System.out.print("Ingrese el ID del elemento a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer del escáner
        Plataforma plataforma = plataformas.get(id); // Obtiene el elemento del mapa usando el ID
        if (plataforma != null) {
            if (tipo.isInstance(plataforma)) { // Verifica si el elemento es del tipo esperado
                if (plataforma instanceof Pelicula) {
                    ((Pelicula) plataforma).modificarInformacion(); // Modifica la información de la película
                } else if (plataforma instanceof Serie) {
                    ((Serie) plataforma).modificarInformacion(); // Modifica la información de la serie
                } else if (plataforma instanceof Cancion) {
                    ((Cancion) plataforma).modificarInformacion(); // Modifica la información de la canción
                } else if (plataforma instanceof EfectoDeSonido) {
                    ((EfectoDeSonido) plataforma).modificarInformacion(); // Modifica la información del efecto de sonido
                }
            } else {
                System.out.println("El ID proporcionado no corresponde al tipo esperado.");
            }
        } else {
            System.out.println("No se encontró un elemento con ID " + id + ".");
        }
    }

    // Muestra el menú para mostrar información y maneja la visualización de los elementos
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
            scanner.nextLine(); // Limpia el buffer del escáner
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
        } while (opcionMostrar != 5); // Continúa hasta que se elija la opción de salir (5)
    }

    // Elimina información de la plataforma basándose en el tipo de contenido
    private void eliminarInformacion(Scanner scanner) {
        System.out.println("\n----- Menú de Eliminación -----");
        System.out.println("1. Eliminar Películas");
        System.out.println("2. Eliminar Series");
        System.out.println("3. Eliminar Canciones");
        System.out.println("4. Eliminar Efectos de Sonido");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opción: ");
        int opcionEliminar = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer del escáner
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

    // Elimina un elemento específico dado su tipo
    private void eliminarElementos(Class<?> tipo, Scanner scanner) {
        System.out.print("Ingrese el ID del elemento a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer del escáner
        if (plataformas.remove(id) != null) { // Intenta eliminar el elemento del mapa usando el ID como clave
            System.out.println("Elemento eliminado.");
        } else {
            System.out.println("No se encontró un elemento con ID " + id + ".");
        }
    }

     private <T extends ElementoMultimedia> void ordenarPorSeleccion(List<T> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (lista.get(j).getDuracion() < lista.get(minIndex).getDuracion()) {
                    minIndex = j;
                }
            }
            T temp = lista.get(minIndex);
            lista.set(minIndex, lista.get(i));
            lista.set(i, temp);
        }
    }

    private <T extends ElementoMultimedia> void ordenarPorInsercion(List<T> lista) {
        int n = lista.size();
        for (int i = 1; i < n; i++) {
            T clave = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j).getDuracion() > clave.getDuracion()) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
            }
            lista.set(j + 1, clave);
        }
    }
    // Muestra información de todas las películas, ordenadas por duración
        private void mostrarPeliculas() {
        System.out.println("\n--- Información de Películas ---");
        List<Pelicula> peliculas = new ArrayList<>();
        for (Plataforma plataforma : plataformas.values()) {
            if (plataforma instanceof Pelicula) {
                peliculas.add((Pelicula) plataforma);
            }
        }

        System.out.println("1. Ordenar por Selección");
        System.out.println("2. Ordenar por Inserción");
        System.out.print("Seleccione el tipo de ordenamiento: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        System.out.println("Películas antes de ordenar:");
        for (Pelicula pelicula : peliculas) {
            pelicula.mostrarInfo();
        }

        // Aplicar el ordenamiento seleccionado
        switch (opcion) {
            case 1:
                ordenarPorSeleccion(peliculas);
                break;
            case 2:
                ordenarPorInsercion(peliculas);
                break;
            default:
                System.out.println("Opción inválida. Se usará ordenamiento por selección por defecto.");
                ordenarPorSeleccion(peliculas);
                break;
        }

        System.out.println("Películas después de ordenar:");
        for (Pelicula pelicula : peliculas) {
            pelicula.mostrarInfo();
            System.out.println("---------------------------------------");
        }
     }
    // Muestra información de todas las series, ordenadas por duración
        private void mostrarSeries() {
        System.out.println("\n--- Información de Series ---");
        List<Serie> series = new ArrayList<>();
        for (Plataforma plataforma : plataformas.values()) {
            if (plataforma instanceof Serie) {
                series.add((Serie) plataforma);
            }
        }

        System.out.println("1. Ordenar por Selección");
        System.out.println("2. Ordenar por Inserción");
        System.out.print("Seleccione el tipo de ordenamiento: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        System.out.println("Series antes de ordenar:");
        for (Serie serie : series) {
            serie.mostrarInfo();
        }

        // Aplicar el ordenamiento seleccionado
        switch (opcion) {
            case 1:
                ordenarPorSeleccion(series);
                break;
            case 2:
                ordenarPorInsercion(series);
                break;
            default:
                System.out.println("Opción inválida. Se usará ordenamiento por selección por defecto.");
                ordenarPorSeleccion(series);
                break;
        }

        System.out.println("Series después de ordenar:");
        for (Serie serie : series) {
            serie.mostrarInfo();
            System.out.println("---------------------------------------");
        }
    }

    private void mostrarCanciones() {
        System.out.println("\n--- Información de Canciones ---");
        List<Cancion> canciones = new ArrayList<>();
        for (Plataforma plataforma : plataformas.values()) {
            if (plataforma instanceof Cancion) {
                canciones.add((Cancion) plataforma);
            }
        }

        System.out.println("1. Ordenar por Selección");
        System.out.println("2. Ordenar por Inserción");
        System.out.print("Seleccione el tipo de ordenamiento: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        System.out.println("Canciones antes de ordenar:");
        for (Cancion cancion : canciones) {
            cancion.mostrarInfo();
        }

        // Aplicar el ordenamiento seleccionado
        switch (opcion) {
            case 1:
                ordenarPorSeleccion(canciones);
                break;
            case 2:
                ordenarPorInsercion(canciones);
                break;
            default:
                System.out.println("Opción inválida. Se usará ordenamiento por selección por defecto.");
                ordenarPorSeleccion(canciones);
                break;
        }

        System.out.println("Canciones después de ordenar:");
        for (Cancion cancion : canciones) {
            cancion.mostrarInfo();
            System.out.println("---------------------------------------");
        }
    }

    private void mostrarEfectosDeSonido() {
        System.out.println("\n--- Información de Efectos de Sonido ---");
        List<EfectoDeSonido> efectos = new ArrayList<>();
        for (Plataforma plataforma : plataformas.values()) {
            if (plataforma instanceof EfectoDeSonido) {
                efectos.add((EfectoDeSonido) plataforma);
            }
        }

        System.out.println("1. Ordenar por Selección");
        System.out.println("2. Ordenar por Inserción");
        System.out.print("Seleccione el tipo de ordenamiento: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        System.out.println("Efectos de sonido antes de ordenar:");
        for (EfectoDeSonido efecto : efectos) {
            efecto.mostrarInfo();
        }

        // Aplicar el ordenamiento seleccionado
        switch (opcion) {
            case 1:
                ordenarPorSeleccion(efectos);
                break;
            case 2:
                ordenarPorInsercion(efectos);
                break;
            default:
                System.out.println("Opción inválida. Se usará ordenamiento por selección por defecto.");
                ordenarPorSeleccion(efectos);
                break;
        }

        System.out.println("Efectos de sonido después de ordenar:");
        for (EfectoDeSonido efecto : efectos) {
            efecto.mostrarInfo();
            System.out.println("---------------------------------------");
        }
    }
    
    // Obtiene una lista de todos los contenidos de tipo Video disponibles en la plataforma
    public List<Video> obtenerContenidosDisponibles() {
        List<Video> contenidos = new ArrayList<>(); // Lista para almacenar los contenidos de tipo Video encontrados
        for (Plataforma plataforma : plataformas.values()) {
            if (plataforma instanceof Video) {
                contenidos.add((Video) plataforma); // Añade los contenidos de tipo Video a la lista
            }
        }
        return contenidos; // Devuelve la lista de contenidos disponibles
    }
}