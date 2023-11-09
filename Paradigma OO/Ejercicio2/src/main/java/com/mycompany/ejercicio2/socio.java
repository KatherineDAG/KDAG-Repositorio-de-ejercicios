package com.mycompany.ejercicio2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kathy
 */
public class socio {
    private int numero;
    private String nombre;
    private String direccion;
    private List<prestamo> prestamos;
    
    public socio(int num,String nom,String direc){
        this.numero = num;
        this.nombre=nom;
        this.direccion=direc;
        this.prestamos = new ArrayList<>();
    }
    
    
    public int getNumeroSocio() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<prestamo> getPrestamos() {
        return prestamos;
    }

    public int getNumeroLibrosPrestados() {
        return prestamos.size();
    }

    public void prestarLibro(libro lib, Date fecha) {
        prestamos.add(new prestamo(this, lib, fecha));
    }

    public void devolverLibro(libro lib) {
        prestamos.removeIf(prestamo -> prestamo.getLibro() == lib);
    }
}
