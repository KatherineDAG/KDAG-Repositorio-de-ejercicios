package com.mycompany.ejercicio3;

import java.util.LinkedList;

/**
 *
 * @author kathy
 */

public class ContactoFamiliar extends Contacto{
    private String parentezco;

    public ContactoFamiliar(String parentezco, String nombre, String telefono) {
        super(nombre, telefono);
        this.parentezco = parentezco;
    }

    public void imprimir() {
        System.out.println(this.toString());
    }
    

    @Override
    public String toString() {
        return "ContactoFamiliar: \n Nombre= " + getNombre() +
                                   "\nTelefono= " + getTelefono() +
                                   "\nParentezco= " + parentezco;
    }
    
    
}
