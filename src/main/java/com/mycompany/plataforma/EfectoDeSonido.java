/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author pato4
 */
public class EfectoDeSonido extends Audio {

    private String tipo;
    private String descripcion;

    public EfectoDeSonido() {
        super();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tipo de efecto: ");
        this.tipo = scanner.nextLine();

        System.out.print("Descripción: ");
        this.descripcion = scanner.nextLine();
    }

    public EfectoDeSonido(String nombre, int idElemento, String titulo, int duracion, String calidad, LocalDate fechalanzamiento,
            String artista, String album, String genero, String compositor, String discografica, String letra, String tipo, String descripcion) {
        super(nombre, idElemento, titulo, duracion, calidad, fechalanzamiento, artista, album, genero, compositor,discografica, letra);
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void reproducirEfecto() {
        System.out.println("Reproduciendo efecto de sonido: " + super.getTitulo());
    }

    public void mostrarInfoEfecto() {
        super.mostrarInfo();
        System.out.println("Tipo de efecto: " + tipo);
        System.out.println("Descripción: " + descripcion);
    }
}
