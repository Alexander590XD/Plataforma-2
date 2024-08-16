/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plataforma;

import java.util.Scanner;

public class AnalistaMarketingImpl extends AnalistaMarketing {

   public AnalistaMarketingImpl(String nombre, String especialidad, int aniosExperiencia, Tiempo tiempoRegistro) {
        super(nombre, especialidad, aniosExperiencia, tiempoRegistro);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Especialidad: " + getEspecialidad());
        System.out.println("Años de experiencia: " + getAniosExperiencia());
        System.out.print("Hora de registro: ");
        getTiempoRegistro().imprimeUniversal();
    }

    @Override
    public void realizarEncuesta(Scanner scanner) {
        System.out.println("Realizando encuesta...");
        // Implementar la lógica de encuesta aquí.
    }

    @Override
    public void colaborarEnCampania(Scanner scanner) {
        System.out.println("Colaborando en campaña...");
        // Implementar la lógica para colaborar en una campaña aquí.
    }

    @Override
    public void mostrarComentariosRecopilados() {
        System.out.println("Comentarios recopilados:");
        // Implementar la lógica para mostrar comentarios aquí.
    }

    @Override
    public void mostrarCampañasColaboradas() {
        System.out.println("Campañas colaboradas:");
        // Implementar la lógica para mostrar campañas colaboradas aquí.
    }
}
