package com.mycompany.ejercicio2;

import java.util.Date;

/**
 *
 * @author kathy
 */

public class prestamo {
    private socio socio;
    private libro libro;
    private Date fecha;

    public prestamo(socio soc, libro lib, Date fecha) {
        this.socio = socio;
        this.libro = libro;
        this.fecha = fecha;
    }

    public socio getSocio() {
        return socio;
    }

    public libro getLibro() {
        return libro;
    }

    public Date getFecha() {
        return fecha;
    }
    
}
