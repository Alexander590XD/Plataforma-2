/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pato4
 */

public class Usuario implements IUsuario {
    private String nombre;
    private String contrasena;
    Tiempo tiempoRegistro;
    Pago pago;
    private List<ListaReproduccion> listasReproduccion;
    private List<String> favoritos;
    private Recomendacion recomendacion; // Recomendaciones personalizadas

    // Constructor
    public Usuario(String nombre, String contrasena, Tiempo tiempoRegistro, Pago pago) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.tiempoRegistro = tiempoRegistro;
        this.pago = pago;
        this.listasReproduccion = new ArrayList<>();
        this.favoritos = new ArrayList<>();
        this.recomendacion = new Recomendacion(); // Inicializar recomendaciones
    }

    // Métodos adicionales

    public void verContenido(String contenido) {
        // Aumentar el historial de visualización cuando se ve contenido
        recomendacion.agregarVisualizacion(contenido);
    }

    public void mostrarRecomendaciones() {
        recomendacion.mostrarRecomendaciones();
    }

    @Override
    public void mostrarInformacion() {
        mostrarRecomendaciones();
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

    @Override
    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getContrasena() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void agregarContenidoALista(String nombreListaAgregar, String contenidoAgregar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void crearListaReproduccion(String nombreLista) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void agregarFavorito(String contenidoFavorito) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void eliminarFavorito(String contenidoEliminar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

