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
    private Tiempo tiempoRegistro;
    private Pago pago;
    private List<ListaReproduccion> listasReproduccion;
    private List<String> favoritos;
    private Recomendacion recomendacion;

    // Constructor
    public Usuario(String nombre, String contrasena, Tiempo tiempoRegistro, Pago pago) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.tiempoRegistro = tiempoRegistro;
        this.pago = pago;
        this.listasReproduccion = new ArrayList<>();
        this.favoritos = new ArrayList<>();
        this.recomendacion = new Recomendacion();
    }

    @Override
    public void mostrarInformacion() {
        Recomendaciones();
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
        
        Tiempo tiempo = new Tiempo();
        tiempo.capturarHora();
        
        System.out.println("Ingrese la información de pago:");
        Pago pago = Pago.capturarPago();
        
        return new Usuario(nombre, contrasena, tiempo, pago);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getContrasena() {
        return contrasena;
    }

    public void agregarContenidoALista(String nombreListaAgregar, String contenidoAgregar) {
        for (ListaReproduccion lista : listasReproduccion) {
            if (lista.getNombre().equals(nombreListaAgregar)) {
                lista.agregarContenido(contenidoAgregar);
                return;
            }
        }
        System.out.println("Lista no encontrada.");
    }

    public void crearListaReproduccion(String nombreLista) {
        ListaReproduccion nuevaLista = new ListaReproduccion(nombreLista);
        listasReproduccion.add(nuevaLista);
    }

    public void agregarFavorito(String contenidoFavorito) {
        if (!favoritos.contains(contenidoFavorito)) {
            favoritos.add(contenidoFavorito);
        }
    }

    public void eliminarFavorito(String contenidoEliminar) {
        favoritos.remove(contenidoEliminar);
    }

    private void Recomendaciones() {
        System.out.println("Recomendaciones personalizadas: ");
        recomendacion.mostrarRecomendaciones();
    }
}

