/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mayormenorventanas;

/**
 *
 * @author Admin
 */
public class Ranking implements Comparable<Object>{
    private String nombre;
    private int numero_intentos;

    public Ranking(String nombre, int numero_intentos) {
        this.nombre = nombre;
        this.numero_intentos = numero_intentos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero_intentos() {
        return numero_intentos;
    }

    @Override
    public String toString() {
        return  "nombre=" + nombre + 
                " necesitó " 
                + numero_intentos + " intentos";
    }

    @Override
    public int compareTo(Object o) {
        Ranking r=(Ranking)o;
        if (r.numero_intentos>numero_intentos)
        {
            return 1;
        }
        else
        {
            return -1;
        }
               
    }
    
}
