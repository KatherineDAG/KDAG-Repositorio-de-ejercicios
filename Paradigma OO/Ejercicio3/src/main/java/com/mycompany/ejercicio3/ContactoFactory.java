package com.mycompany.ejercicio3;

import java.util.Date;

/**
 *
 * @author kathy
 */

public class ContactoFactory implements ObjetoFactory{

    @Override
    public ObjAgenda createContacto(String parentezco, String nombre, String telefono) {
         return (ObjAgenda) new ContactoFamiliar(parentezco, nombre, telefono);
    }

    @Override
    public ObjAgenda createEvento(int cantidadAsistentes, Date fecha, String nombre) {
        throw new UnsupportedOperationException("No se pueden crear eventos con ContactoFactory."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
   
    
}
