
package com.mycompany.ejercicio3;

import java.util.Date;

/**
 *
 * @author kathy
 */
public class EventoFactory implements ObjetoFactory{

    @Override
    public ObjAgenda createContacto(String parentezco, String nombre, String telefono) {
        throw new UnsupportedOperationException("No se pueden crear contactos con EventoFactory."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ObjAgenda createEvento(int cantidadAsistentes, Date fecha, String nombre) {
        return new EventoReunion(cantidadAsistentes, fecha, nombre);
    }
    
}
