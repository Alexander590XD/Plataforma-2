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
public class Pago {
    private double monto;
    private String fecha;
    private String tipo; // Por ejemplo: "Crédito", "Débito", etc.

    // Constructor
    public Pago(double monto, String fecha, String tipo) {
        this.monto = monto;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    // Getters y Setters
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Método para capturar información de pago
    public static Pago capturarPago() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el monto del pago: ");
        double monto = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese la fecha del pago ('aaa-mm-dd: ");
        String fecha = scanner.nextLine();

        System.out.print("Ingrese el tipo de pago ('Crédito', 'Débito'): ");
        String tipo = scanner.nextLine();

        return new Pago(monto, fecha, tipo);
    }

    // Método para mostrar la información del pago
    public void mostrarInformacion() {
        System.out.println("Monto: $" + monto);
        System.out.println("Fecha: " + fecha);
        System.out.println("Tipo: " + tipo);
    }
}
