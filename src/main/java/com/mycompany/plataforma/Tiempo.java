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
     private static final long serialVersionUID = 1L;
     private int hora, minuto, segundo;
    
     public void capturarHora() {
        Calendar now = Calendar.getInstance();
        this.hora = now.get(Calendar.HOUR_OF_DAY);
        this.minuto = now.get(Calendar.MINUTE);
        this.segundo = now.get(Calendar.SECOND);
    }

    public void imprimeUniversal() {
        System.out.printf("%02d:%02d:%02d\n", hora, minuto, segundo);
    }
}
