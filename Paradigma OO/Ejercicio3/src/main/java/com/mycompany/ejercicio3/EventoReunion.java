package com.mycompany.ejercicio3;

import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author kathy
 */

public class EventoReunion extends Evento{
    private int cantidadAsistentes;

    public EventoReunion(int cantidadAsistentes, Date fecha, String nombre) {
        super(fecha, nombre);
        this.cantidadAsistentes = cantidadAsistentes;
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

 
    
    @Override
    public String toString() {
        return "EventoReunion: \nNombre= " + getNombre() +
                                   "\nFecha= " + getFecha() +
                                   "\nCantidad de Asistentes= " + this.cantidadAsistentes;
    }
    
}
