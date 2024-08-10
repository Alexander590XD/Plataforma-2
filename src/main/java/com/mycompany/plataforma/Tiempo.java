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
public class Tiempo {
        private int hora;
    private int minutos;
    private int segundos;

    public Tiempo() {
    }

    public Tiempo(int hora, int minutos, int segundos) {
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public void capturarHora() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la hora: ");
        this.hora = scanner.nextInt();

        System.out.print("Ingrese los minutos: ");
        this.minutos = scanner.nextInt();

        System.out.print("Ingrese los segundos: ");
        this.segundos = scanner.nextInt();
    }

    public void establecerHora(int hora, int minutos, int segundos) {
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public void imprimeEstandar() {
        System.out.printf("%02d:%02d:%02d %s\n",
                ((hora == 0 || hora == 12) ? 12 : hora % 12),
                minutos, segundos, (hora < 12 ? "AM" : "PM"));
    }

    public void imprimeUniversal() {
        System.out.printf("%02d:%02d:%02d\n", hora, minutos, segundos);
    }
}
