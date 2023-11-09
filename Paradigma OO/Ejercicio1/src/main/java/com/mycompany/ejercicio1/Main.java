package com.mycompany.ejercicio1;

/**
 *
 * @author kathy
 */

public class Main {

    public static void main(String[] args) {
        hoja page = new hoja();

        texto text1 = new texto("Hola, soy un texto.");
        objetoGeometrico circulo = new objetoGeometrico("Círculo");
        objetoGeometrico rectangulo = new objetoGeometrico("Rectángulo");

        grupo group1 = new grupo();
        texto text2 = new texto("Texto dentro del grupo");
        group1.addObject(text2);

        grupo unirGruposaHoja = new grupo();
        unirGruposaHoja.addObject(text1);
        unirGruposaHoja.addObject(circulo);
        unirGruposaHoja.addObject(group1);
        unirGruposaHoja.addObject(rectangulo);

        page.agregar(unirGruposaHoja);
        page.dibujar();
    }
    
    /* Resultado al ejecutar: 
    
    Contenido de la hoja:
    Grupo:
    Texto: Hola, soy un texto.
    Objeto geométrico: Círculo
    Grupo:
    Texto: Texto dentro del grupo
    Objeto geométrico: Rectángulo
    
    */
}
