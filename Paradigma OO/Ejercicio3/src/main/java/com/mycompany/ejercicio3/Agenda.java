package com.mycompany.ejercicio3;

import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author kathy
 */

public class Agenda {
    private static Agenda instance;
    private LinkedList<Object> listaObjetos;
    private LinkedList<String> contactos;
    private LinkedList<String> eventos;

    private Agenda() {
        listaObjetos = new LinkedList<>();
        contactos = new LinkedList<>();
        eventos = new LinkedList<>();
    }

    public static Agenda getInstance() {
        if (instance == null) {
            instance = new Agenda();
        }
        return instance;
    }

    public LinkedList<String> getContactos() {
        return contactos;
    }

    public LinkedList<String> getEventos() {
        return eventos;
    }

    public LinkedList<Object> getListaObjetos() {
        return listaObjetos;
    }
    
    private ObjetoFactory objetoFactory;

    public void setObjetoFactory(ObjetoFactory factory) {
        this.objetoFactory = factory;
    }

    public ObjAgenda crearContacto(String parentezco, String nombre, String telefono) {
        return objetoFactory.createContacto(parentezco, nombre, telefono);
    }

    public ObjAgenda crearEvento(int cantidadAsistentes, Date fecha, String nombre) {
        return objetoFactory.createEvento(cantidadAsistentes, fecha, nombre);
    }
    
}
