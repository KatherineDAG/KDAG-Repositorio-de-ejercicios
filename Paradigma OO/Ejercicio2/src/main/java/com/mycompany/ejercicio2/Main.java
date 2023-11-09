package com.mycompany.ejercicio2;

import java.util.Date;

/**
 *
 * @author kathy
 */

public class Main {

    public static void main(String[] args) {
       
        
        biblioteca biblio= new biblioteca();
        
        socio soc1=new socio(1,"Carmen","150 street");
        socio soc2=new socio(2,"Juancho","calle juancito");
        
        libro lib1=new libro(2,"Crónicas de una muerte anunciada","Gabriel García Márquez");
        libro lib12=new libro(4,"El peregrino","Paulo Cohelo");
        libro lib3=new libro(6,"Las crónicas de Spiderwick","Holly Black");
        libro lib4=new libro(8,"Orgullo y prejucio","Jane Austen");
        libro lib5=new libro(9,"Drácula","Bram Stoker");
        
        biblio.agregarSocio(soc2);
        biblio.agregarSocio(soc1);
        biblio.agregarLibro(lib12);
        biblio.agregarLibro(lib1);
        biblio.agregarLibro(lib3);
        biblio.agregarLibro(lib4);
        biblio.agregarLibro(lib5);
        
        Date fechaPrestamo = new Date();

        biblio.prestarLibro(1, 2, fechaPrestamo);
        biblio.prestarLibro(1, 4, fechaPrestamo);
        biblio.prestarLibro(1, 9, fechaPrestamo);
        biblio.prestarLibro(1, 8, fechaPrestamo);
        biblio.prestarLibro(2, 6, fechaPrestamo);
        
        System.out.println("Socios con más de 3 libros prestados:");
        for (socio socio : biblio.sociosConMasDe3LibrosPrestados()) {
            System.out.println("Número de socio: " + socio.getNumeroSocio() + ", Nombre: " + socio.getNombre());
        }
        
    }
    
    /*Resultados al ejecutar:
    Socios con más de 3 libros prestados:
    Número de socio: 1, Nombre: Carmen
    */
}
