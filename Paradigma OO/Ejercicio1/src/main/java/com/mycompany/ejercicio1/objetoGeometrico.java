package com.mycompany.ejercicio1;

/**
 *
 * @author kathy
 */

public class objetoGeometrico extends objetoRepresentable{
    private String tipo;

    public objetoGeometrico(String tip) {
        this.tipo = tip;
    }
    
    @Override
    void dibujar() {
        System.out.println("Objeto geométrico: " + tipo);
    }
    
}
