package com.mycompany.ejercicio1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kathy
 */

public class hoja {
    private List<objetoRepresentable> grupo;
    
    public hoja(){
        grupo=new ArrayList();
    }
    
     public void agregar(objetoRepresentable g) {
        grupo.add(g);
    }
    
    public void dibujar() {
        System.out.println("Contenido de la hoja:");
        for (objetoRepresentable object : grupo) {
            object.dibujar();
        }
    }
}
