/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionAnalistas {
   // Lista para almacenar los analistas de marketing
    private List<AnalistaMarketing> analistas;

    // Constructor de la clase
    public GestionAnalistas() {
        // Inicializa la lista de analistas como una nueva ArrayList vacía
        this.analistas = new ArrayList<>();
    }

    // Método para agregar un nuevo analista a la lista
    public void agregarAnalista(AnalistaMarketing analista) {
        analistas.add(analista);
    }

    // Método para modificar los datos de un analista existente
    public void modificarAnalista(Scanner scanner) {
        // Solicita al usuario el nombre del analista a modificar
        System.out.print("Nombre del analista a modificar: ");
        String nombre = scanner.nextLine();
        
        // Recorre la lista de analistas para encontrar el analista con el nombre proporcionado
        for (AnalistaMarketing analista : analistas) {
            if (analista.getNombre().equalsIgnoreCase(nombre)) {
                // Si el analista es encontrado, solicita los nuevos datos
                System.out.println("Analista encontrado. Proporcione los nuevos datos.");
                
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                
                System.out.print("Nueva especialidad: ");
                String nuevaEspecialidad = scanner.nextLine();
                
                System.out.print("Años de experiencia actualizados: ");
                int nuevosAniosExperiencia = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                System.out.print("Hora de registro (formato HH:mm) o presione Enter para utilizar la hora actual: ");
                String horaRegistro = scanner.nextLine();
                
                // Actualiza la información del analista
                analista.setNombre(nuevoNombre);
                analista.setEspecialidad(nuevaEspecialidad);
                analista.setAniosExperiencia(nuevosAniosExperiencia);
                
                // Maneja la hora de registro
                Tiempo nuevoTiempo = new Tiempo();
                if (!horaRegistro.isEmpty()) {
                    nuevoTiempo.establecerHora(horaRegistro);
                } else {
                    nuevoTiempo.capturarHora();
                }
                analista.setTiempoRegistro(nuevoTiempo);
                
                // Muestra la información actualizada del analista
                System.out.println("Datos del analista actualizados exitosamente.");
                analista.mostrarInformacion();
                
                // Mostrar el mensaje de bienvenida con los nuevos datos
                analista.mostrarMensajeBienvenida();
                return;
            }
        }
        // Mensaje de error si el analista no es encontrado
        System.out.println("No se encontró el analista con el nombre proporcionado.");
    }

    // Método para mostrar la información de todos los analistas registrados
    public void mostrarAnalistas() {
        // Verifica si la lista está vacía
        if (analistas.isEmpty()) {
            System.out.println("No hay analistas registrados en el sistema.");
        } else {
            // Recorre la lista y muestra la información de cada analista
            for (AnalistaMarketing analista : analistas) {
                analista.mostrarInformacion();
                // Mostrar el mensaje de bienvenida para cada analista
                analista.mostrarMensajeBienvenida();
            }
        }
    }

    // Método para realizar una encuesta a todos los analistas
    public void realizarEncuesta(Scanner scanner) {
        // Recorre la lista y llama al método realizarEncuesta de cada analista
        for (AnalistaMarketing analista : analistas) {
            analista.realizarEncuesta(scanner);
        }
    }

    // Método para mostrar los datos recopilados por un analista específico
    public void mostrarDatosRecopilados(Scanner scanner) {
        // Solicita el nombre del analista para mostrar los datos recopilados
        System.out.print("Nombre del analista para mostrar los datos recopilados: ");
        String nombre = scanner.nextLine();
        
        // Recorre la lista para encontrar el analista con el nombre proporcionado
        for (AnalistaMarketing analista : analistas) {
            if (analista.getNombre().equalsIgnoreCase(nombre)) {
                // Si el analista es encontrado, muestra los comentarios y campañas colaboradas
                analista.mostrarComentariosRecopilados();
                analista.mostrarCampañasColaboradas();
                return;
            }
        }
        // Mensaje de error si el analista no es encontrado
        System.out.println("No se encontró el analista con el nombre proporcionado.");
    }

    // Método para mostrar el menú principal de gestión de analistas
    public void mostrarMenuPrincipal(Scanner scanner) {
        int opcion;
        do {
            // Muestra las opciones del menú
            System.out.println("\n--- Menú de Gestión de Analistas ---");
            System.out.println("1. Modificar analista");
            System.out.println("2. Mostrar analistas");
            System.out.println("3. Realizar encuesta");
            System.out.println("4. Colaborar en campaña");
            System.out.println("5. Mostrar datos recopilados");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            // Ejecuta la opción seleccionada por el usuario
            switch (opcion) {
                case 1:
                    modificarAnalista(scanner);
                    break;
                case 2:
                    mostrarAnalistas();
                    break;
                case 3:
                    realizarEncuesta(scanner);
                    break;
                case 4:
                    // Llama al método colaborarEnCampania de cada analista en la lista
                    for (AnalistaMarketing analista : analistas) {
                        analista.colaborarEnCampania(scanner);
                    }
                    break;
                case 5:
                    mostrarDatosRecopilados(scanner);
                    break;
                case 6:
                    // Mensaje de salida del menú
                    System.out.println("Saliendo del menú de gestión de analistas...");
                    break;
                default:
                    // Mensaje de opción no válida
                    System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
            }
        } while (opcion != 6); // Continúa mostrando el menú hasta que el usuario seleccione la opción de salir
    }
}
