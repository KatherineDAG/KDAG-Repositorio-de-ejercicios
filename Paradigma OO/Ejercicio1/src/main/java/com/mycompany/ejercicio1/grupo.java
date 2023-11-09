package com.mycompany.ejercicio1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kathy
 */

public class grupo extends objetoRepresentable{
    private List<objetoRepresentable> grupoObjetos;

    public grupo() {
        grupoObjetos = new ArrayList<>();
    }

    public void addObject(objetoRepresentable grupo) {
        grupoObjetos.add(grupo);
    }


    @Override
    void dibujar() {
       System.out.println("Grupo:");
        for (objetoRepresentable grupo : grupoObjetos) {
            grupo.dibujar();
        }
    }
    
}
