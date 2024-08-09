/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.plataforma;
import java.util.Scanner;

/**
 *
 * @author pato4
 */
public abstract class Plataforma {

    protected String nombre;
    
    public Plataforma(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nombre de la Plataforma: ");
        this.nombre = scanner.nextLine();
    }
    
    public Plataforma(String nombre){
         this.nombre = nombre;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void mostrarPlata(){
        System.out.println("Nombre de la Plataforma: " + nombre);
    }
}
