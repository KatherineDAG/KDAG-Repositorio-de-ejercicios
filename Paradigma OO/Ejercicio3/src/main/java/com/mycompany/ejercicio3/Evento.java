package com.mycompany.ejercicio3;

import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author kathy
 */
public class Evento implements ObjAgenda{
     private Date fecha;
    private String nombre;

    public Evento(Date fecha, String nombre) {
        this.fecha = fecha;
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void imprimir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
