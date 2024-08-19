/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author pato4
 */
public class Pago implements Serializable {
     private static final long serialVersionUID = 1L;
    private String tipoPago;
    private double monto;

    // Método estático para capturar información de pago
    public static Pago capturarPago() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tipo de pago: ");
        String tipoPago = scanner.nextLine();
        System.out.print("Ingrese el monto: ");
        double monto = scanner.nextDouble();
        return new Pago(tipoPago, monto);
    }

    // Constructor
    public Pago(String tipoPago, double monto) {
        this.tipoPago = tipoPago;
        this.monto = monto;
    }

    // Método de instancia para mostrar información de pago
    public void mostrarInformacion() {
        System.out.println("Tipo de pago: " + tipoPago);
        System.out.println("Monto: " + monto);
    }
}
