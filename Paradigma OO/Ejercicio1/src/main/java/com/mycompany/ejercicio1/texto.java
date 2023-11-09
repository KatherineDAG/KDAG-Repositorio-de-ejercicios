package com.mycompany.ejercicio1;

/**
 *
 * @author kathy
 */

public class texto extends objetoRepresentable{
    private String texto;

    public texto(String text) {
        this.texto = text;
    }


    @Override
    void dibujar() {
        System.out.println("Texto: " + texto);
    }
    
}
