/*
DOCUMENTACIÓN DE LA DIFERENCIA ENTRE UN EAGER SINGLETON Y UN LAZY SINGLETON
    -EAGER SINGLETON: La instancia se crea en el momento en que la clase es cargada por el ClassLoader, 
        lo que garantiza que siempre haya una instancia disponible. Esto puede ser útil en aplicaciones donde 
        se necesita acceso rápido y constante a la instancia del Singleton. Sin embargo, puede resultar en un 
        consumo de recursos innecesario si la instancia no se utiliza con frecuencia.
    -LAZY SINGLETON: La instancia se crea solo cuando se llama al método getInstance(), lo que ahorra recursos 
        si la instancia no se utiliza en todas las partes de la aplicación. Sin embargo, requiere una verificación
        de seguridad para evitar que múltiples hilos creen instancias en paralelo (doble comprobación o uso de 
        bloqueos), lo que puede introducir cierta complejidad.
    -¿Cuál le parece que sea mejor utilizar en la implementación del problema y por qué?
     En este caso, dado que la creación de la agenda puede ser un proceso costoso y no se necesita necesariamente 
     al inicio de la aplicación, un Lazy Singleton podría ser más apropiado.Porque, ahorra recursos y permite crear
     la instancia de Agenda solo cuando sea necesario.
*/


package com.mycompany.ejercicio3;

import java.util.Date;

/**
 *
 * @author kathy
 */

public class Main {

    public static void main(String[] args) {
         // Obtén una instancia de la agenda (Singleton)
        Agenda agenda = Agenda.getInstance();

        // Configura la fábrica de contactos
        ContactoFactory contactoFactory = new ContactoFactory();
        agenda.setObjetoFactory(contactoFactory);

        // Crea un contacto
        ObjAgenda contacto = agenda.crearContacto("Familiar", "Juan", "69854147");
        agenda.getListaObjetos().add(contacto);
        agenda.getContactos().add(contacto.toString());

        // Configura la fábrica de eventos
        EventoFactory eventoFactory = new EventoFactory();
        agenda.setObjetoFactory(eventoFactory);

        // Crea un evento
        ObjAgenda evento = agenda.crearEvento(50, new Date(), "Reunión de trabajo");
        agenda.getListaObjetos().add(evento);
        agenda.getEventos().add(evento.toString());

        // Imprime los contactos y eventos en la agenda
        System.out.println("Contactos:");
        for (String contactoStr : agenda.getContactos()) {
            System.out.println(contactoStr);
        }

        System.out.println("\nEventos:");
        for (String eventoStr : agenda.getEventos()) {
            System.out.println(eventoStr);
        }
    }
    
    /*Resultado al ejecutarlo:
    Contactos:
    ContactoFamiliar: 
     Nombre= Juan
    Telefono= 69854147
    Parentezco= Familiar

    Eventos:
    EventoReunion: 
    Nombre= Reunión de trabajo
    Fecha= Wed Nov 08 23:07:49 CST 2023
    Cantidad de Asistentes= 50
    */
}
