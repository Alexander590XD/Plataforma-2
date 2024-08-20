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

    // Método genérico para ordenar una lista de elementos multimedia usando el algoritmo de selección
    private <T extends ElementoMultimedia> void ordenarPorSeleccion(List<T> lista) {
        int n = lista.size(); // Obtiene el tamaño de la lista
        for (int i = 0; i < n - 1; i++) { // Recorre cada elemento de la lista, excepto el último
            int minIndex = i; // Asume que el elemento actual es el mínimo
            for (int j = i + 1; j < n; j++) { // Compara el elemento actual con los siguientes elementos
                if (lista.get(j).getDuracion() < lista.get(minIndex).getDuracion()) {
                    minIndex = j; // Actualiza el índice del elemento mínimo
                }
            }
            // Intercambia el elemento en la posición actual con el elemento mínimo encontrado
            T temp = lista.get(minIndex); // Almacena temporalmente el elemento mínimo
            lista.set(minIndex, lista.get(i)); // Coloca el elemento actual en la posición del mínimo
            lista.set(i, temp); // Coloca el elemento mínimo en la posición actual
        }
    }

    // Método genérico para ordenar una lista de elementos multimedia usando el algoritmo de inserción
    private <T extends ElementoMultimedia> void ordenarPorInsercion(List<T> lista) {
        int n = lista.size(); // Obtiene el tamaño de la lista
        for (int i = 1; i < n; i++) { // Comienza desde el segundo elemento hasta el final
            T clave = lista.get(i); // Toma el elemento actual para insertar en la parte ordenada
            int j = i - 1; // El índice del último elemento de la parte ordenada
            // Mueve los elementos que son mayores que la clave una posición a la derecha
            while (j >= 0 && lista.get(j).getDuracion() > clave.getDuracion()) {
                lista.set(j + 1, lista.get(j)); // Mueve el elemento a la derecha
                j = j - 1; // Mueve el índice hacia la izquierda
            }
            // Inserta la clave en su posición correcta en la parte ordenada
            lista.set(j + 1, clave);
        }
    }

    // Método para mostrar la información de todas las películas, ordenadas por duración
    private void mostrarPeliculas() {
        System.out.println("\n" + "-".repeat(40)); // Línea superior
        System.out.println("  ** Información de Películas **  "); // Título centralizado
        System.out.println("-".repeat(40)); // Línea inferior

        List<Pelicula> peliculas = new ArrayList<>(); // Crea una lista para almacenar las películas

        // Recorre todos los elementos de la colección 'plataformas'
        for (Plataforma plataforma : plataformas.values()) {
            // Verifica si el elemento es una instancia de Pelicula
            if (plataforma instanceof Pelicula) {
                peliculas.add((Pelicula) plataforma); // Añade la película a la lista
            }
        }

        // Muestra las opciones de ordenamiento al usuario
        System.out.println("\nSeleccione el tipo de ordenamiento:");
        System.out.println("1. Ordenar por Selección");
        System.out.println("2. Ordenar por Inserción");
        System.out.print("Ingrese su opción: ");
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario
        int opcion = scanner.nextInt(); // Lee la opción del usuario

        // Muestra la información de las películas antes de ordenar
        System.out.println("\nPelículas antes de ordenar:");
        for (Pelicula pelicula : peliculas) {
            pelicula.mostrarInfo(); // Muestra la información de cada película
            System.out.println("-".repeat(40)); // Línea de separación
        }

        // Aplica el método de ordenamiento seleccionado por el usuario
        switch (opcion) {
            case 1:
                ordenarPorSeleccion(peliculas); // Ordena por selección si el usuario elige la opción 1
                break;
            case 2:
                ordenarPorInsercion(peliculas); // Ordena por inserción si el usuario elige la opción 2
                break;
            default:
                System.out.println("Opción inválida. Se usará ordenamiento por selección por defecto.");
                ordenarPorSeleccion(peliculas); // Usa selección por defecto si la opción es inválida
                break;
        }

        // Muestra la información de las películas después de ordenar
        System.out.println("\nPelículas después de ordenar:");
        for (Pelicula pelicula : peliculas) {
            pelicula.mostrarInfo(); // Muestra la información de cada película después de ordenar
            System.out.println("-".repeat(40)); // Línea de separación
        }
    }

    // Método para mostrar la información de todas las series, ordenadas por duración
    private void mostrarSeries() {
        System.out.println("\n" + "-".repeat(40)); // Línea superior
        System.out.println("    ** Información de Series **    "); // Título centralizado
        System.out.println("-".repeat(40)); // Línea inferior

        List<Serie> series = new ArrayList<>(); // Crea una lista para almacenar las series

        // Recorre todos los elementos de la colección 'plataformas'
        for (Plataforma plataforma : plataformas.values()) {
            // Verifica si el elemento es una instancia de Serie
            if (plataforma instanceof Serie) {
                series.add((Serie) plataforma); // Añade la serie a la lista
            }
        }

        // Muestra las opciones de ordenamiento al usuario
        System.out.println("\nSeleccione el tipo de ordenamiento:");
        System.out.println("1. Ordenar por Selección");
        System.out.println("2. Ordenar por Inserción");
        System.out.print("Ingrese su opción: ");
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario
        int opcion = scanner.nextInt(); // Lee la opción del usuario

        // Muestra la información de las series antes de ordenar
        System.out.println("\nSeries antes de ordenar:");
        for (Serie serie : series) {
            serie.mostrarInfo(); // Muestra la información de cada serie
            System.out.println("-".repeat(40)); // Línea de separación
        }

        // Aplica el método de ordenamiento seleccionado por el usuario
        switch (opcion) {
            case 1:
                ordenarPorSeleccion(series); // Ordena por selección si el usuario elige la opción 1
                break;
            case 2:
                ordenarPorInsercion(series); // Ordena por inserción si el usuario elige la opción 2
                break;
            default:
                System.out.println("Opción inválida. Se usará ordenamiento por selección por defecto.");
                ordenarPorSeleccion(series); // Usa selección por defecto si la opción es inválida
                break;
        }

        // Muestra la información de las series después de ordenar
        System.out.println("\nSeries después de ordenar:");
        for (Serie serie : series) {
            serie.mostrarInfo(); // Muestra la información de cada serie después de ordenar
            System.out.println("-".repeat(40)); // Línea de separación
        }
    }

    // Método para mostrar la información de todas las canciones, ordenadas por duración
    private void mostrarCanciones() {
        System.out.println("\n" + "-".repeat(40)); // Línea superior
        System.out.println("  ** Información de Canciones **  "); // Título centralizado
        System.out.println("-".repeat(40)); // Línea inferior

        List<Cancion> canciones = new ArrayList<>(); // Crea una lista para almacenar las canciones

        // Recorre todos los elementos de la colección 'plataformas'
        for (Plataforma plataforma : plataformas.values()) {
            // Verifica si el elemento es una instancia de Cancion
            if (plataforma instanceof Cancion) {
                canciones.add((Cancion) plataforma); // Añade la canción a la lista
            }
        }

        // Muestra las opciones de ordenamiento al usuario
        System.out.println("\nSeleccione el tipo de ordenamiento:");
        System.out.println("1. Ordenar por Selección");
        System.out.println("2. Ordenar por Inserción");
        System.out.print("Ingrese su opción: ");
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario
        int opcion = scanner.nextInt(); // Lee la opción del usuario

        // Muestra la información de las canciones antes de ordenar
        System.out.println("\nCanciones antes de ordenar:");
        for (Cancion cancion : canciones) {
            cancion.mostrarInfo(); // Muestra la información de cada canción
            System.out.println("-".repeat(40)); // Línea de separación
        }

        // Aplica el método de ordenamiento seleccionado por el usuario
        switch (opcion) {
            case 1:
                ordenarPorSeleccion(canciones); // Ordena por selección si el usuario elige la opción 1
                break;
            case 2:
                ordenarPorInsercion(canciones); // Ordena por inserción si el usuario elige la opción 2
                break;
            default:
                System.out.println("Opción inválida. Se usará ordenamiento por selección por defecto.");
                ordenarPorSeleccion(canciones); // Usa selección por defecto si la opción es inválida
                break;
        }

        // Muestra la información de las canciones después de ordenar
        System.out.println("\nCanciones después de ordenar:");
        for (Cancion cancion : canciones) {
            cancion.mostrarInfo(); // Muestra la información de cada canción después de ordenar
            System.out.println("-".repeat(40)); // Línea de separación
        }
    }

    // Método para mostrar la información de todos los efectos de sonido, ordenados por duración
    private void mostrarEfectosDeSonido() {
        System.out.println("\n" + "-".repeat(40)); // Línea superior
        System.out.println("** Información de Efectos de Sonido **"); // Título centralizado
        System.out.println("-".repeat(40)); // Línea inferior

        List<EfectoDeSonido> efectos = new ArrayList<>(); // Crea una lista para almacenar los efectos de sonido

        // Recorre todos los elementos de la colección 'plataformas'
        for (Plataforma plataforma : plataformas.values()) {
            // Verifica si el elemento es una instancia de EfectoDeSonido
            if (plataforma instanceof EfectoDeSonido) {
                efectos.add((EfectoDeSonido) plataforma); // Añade el efecto de sonido a la lista
            }
        }

        // Muestra las opciones de ordenamiento al usuario
        System.out.println("\nSeleccione el tipo de ordenamiento:");
        System.out.println("1. Ordenar por Selección");
        System.out.println("2. Ordenar por Inserción");
        System.out.print("Ingrese su opción: ");
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario
        int opcion = scanner.nextInt(); // Lee la opción del usuario

        // Muestra la información de los efectos de sonido antes de ordenar
        System.out.println("\nEfectos de sonido antes de ordenar:");
        for (EfectoDeSonido efecto : efectos) {
            efecto.mostrarInfo(); // Muestra la información de cada efecto de sonido
            System.out.println("-".repeat(40)); // Línea de separación
        }

        // Aplica el método de ordenamiento seleccionado por el usuario
        switch (opcion) {
            case 1:
                ordenarPorSeleccion(efectos); // Ordena por selección si el usuario elige la opción 1
                break;
            case 2:
                ordenarPorInsercion(efectos); // Ordena por inserción si el usuario elige la opción 2
                break;
            default:
                System.out.println("Opción inválida. Se usará ordenamiento por selección por defecto.");
                ordenarPorSeleccion(efectos); // Usa selección por defecto si la opción es inválida
                break;
        }

        // Muestra la información de los efectos de sonido después de ordenar
        System.out.println("\nEfectos de sonido después de ordenar:");
        for (EfectoDeSonido efecto : efectos) {
            efecto.mostrarInfo(); // Muestra la información de cada efecto de sonido después de ordenar
            System.out.println("-".repeat(40)); // Línea de separación
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