/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionAnalistas {
   private List<AnalistaMarketing> analistas;

    public GestionAnalistas() {
        this.analistas = new ArrayList<>();
    }

    public void agregarAnalista(AnalistaMarketing analista) {
        analistas.add(analista);
    }

    public void modificarAnalista(Scanner scanner) {
        System.out.print("Ingrese el nombre del analista a modificar: ");
        String nombre = scanner.nextLine();
        for (AnalistaMarketing analista : analistas) {
            if (analista.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Analista encontrado. Ingrese los nuevos datos.");
                System.out.print("Ingrese el nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                System.out.print("Ingrese la nueva especialidad: ");
                String nuevaEspecialidad = scanner.nextLine();
                System.out.print("Ingrese los nuevos años de experiencia: ");
                int nuevosAniosExperiencia = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
                System.out.print("Ingrese la hora de registro (formato HH:mm) o presione Enter para usar la hora actual: ");
                String horaRegistro = scanner.nextLine();

                analista.setNombre(nuevoNombre);
                analista.setEspecialidad(nuevaEspecialidad);
                analista.setAniosExperiencia(nuevosAniosExperiencia);

                Tiempo nuevoTiempo = new Tiempo();
                if (!horaRegistro.isEmpty()) {
                    nuevoTiempo.establecerHora(horaRegistro);
                } else {
                    nuevoTiempo.capturarHora();
                }
                analista.setTiempoRegistro(nuevoTiempo);

                System.out.println("Datos del analista modificados exitosamente.");
                analista.mostrarInformacion();
                return;
            }
        }
        System.out.println("Analista no encontrado.");
    }

    public void mostrarAnalistas() {
        if (analistas.isEmpty()) {
            System.out.println("No hay analistas registrados.");
        } else {
            for (AnalistaMarketing analista : analistas) {
                analista.mostrarInformacion();
            }
        }
    }

    public void realizarEncuesta(Scanner scanner) {
        for (AnalistaMarketing analista : analistas) {
            analista.realizarEncuesta(scanner);
        }
    }

    public void mostrarDatosRecopilados(Scanner scanner) {
        System.out.print("Ingrese el nombre del analista para mostrar datos recopilados: ");
        String nombre = scanner.nextLine();
        for (AnalistaMarketing analista : analistas) {
            if (analista.getNombre().equalsIgnoreCase(nombre)) {
                analista.mostrarComentariosRecopilados();
                analista.mostrarCampañasColaboradas();
                return;
            }
        }
        System.out.println("Analista no encontrado.");
    }

    public void mostrarMenuPrincipal(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Menú de Gestión de Analistas ---");
            System.out.println("1. Modificar Analista");
            System.out.println("2. Mostrar Analistas");
            System.out.println("3. Realizar Encuesta");
            System.out.println("4. Colaborar en Campaña");
            System.out.println("5. Mostrar Datos Recopilados");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

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
                    for (AnalistaMarketing analista : analistas) {
                        analista.colaborarEnCampania(scanner);
                    }
                    break;
                case 5:
                    mostrarDatosRecopilados(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del menú de gestión de analistas...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        } while (opcion != 6);
    }
}
