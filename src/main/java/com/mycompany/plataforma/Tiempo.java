/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author pato4
 */
public class Tiempo implements Serializable {
    private int hora;
    private int minuto;
    private int segundo;

    // Captura la hora actual
    public void capturarHora() {
        Calendar now = Calendar.getInstance();
        this.hora = now.get(Calendar.HOUR_OF_DAY);
        this.minuto = now.get(Calendar.MINUTE);
        this.segundo = now.get(Calendar.SECOND);
    }

    // Establece la hora desde un string en formato HH:mm
    public void establecerHora(String horaStr) {
        try {
            String[] partes = horaStr.split(":");
            if (partes.length == 2) {
                this.hora = Integer.parseInt(partes[0]);
                this.minuto = Integer.parseInt(partes[1]);
                this.segundo = 0; // Establece los segundos a 0 si no están especificados
            } else {
                throw new IllegalArgumentException("Formato de hora no válido.");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Formato de hora no válido. Usando hora actual.");
            capturarHora();
        }
    }

    // Imprime la hora en formato universal
    public void imprimeUniversal() {
        System.out.printf("%02d:%02d:%02d\n", hora, minuto, segundo);
    }
}
