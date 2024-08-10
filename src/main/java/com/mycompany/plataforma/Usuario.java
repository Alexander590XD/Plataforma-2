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

public class Usuario implements IUsuario {
   private String nombre;
    private String contrasena;
    private Tiempo tiempoRegistro;
    private Pago pago; // Agregación con la clase Pago

    // Constructor
    public Usuario(String nombre, String contrasena, Tiempo tiempoRegistro, Pago pago) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.tiempoRegistro = tiempoRegistro;
        this.pago = pago;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getContrasena() {
        return contrasena;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.print("Hora de registro: ");
        tiempoRegistro.imprimeUniversal();
        if (pago != null) {
            System.out.println("Información de Pago:");
            pago.mostrarInformacion();
        } else {
            System.out.println("No se ha registrado ninguna información de pago.");
        }
    }

    public boolean iniciarSesion(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    public static Usuario registrarUsuario() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese nombre de usuario: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese contraseña: ");
        String contrasena = scanner.nextLine();
        
        // Captura el tiempo de registro
        Tiempo tiempo = new Tiempo();
        tiempo.capturarHora();
        
        // Captura la información de pago
        System.out.println("Ingrese la información de pago:");
        Pago pago = Pago.capturarPago();
        
        return new Usuario(nombre, contrasena, tiempo, pago);
    }
}

