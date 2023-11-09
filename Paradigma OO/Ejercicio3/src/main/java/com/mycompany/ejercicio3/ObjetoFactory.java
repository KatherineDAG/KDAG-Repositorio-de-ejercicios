package com.mycompany.ejercicio3;

import java.util.Date;

/**
 *
 * @author kathy
 */

public interface ObjetoFactory {
    ObjAgenda createContacto(String parentezco, String nombre, String telefono);
    ObjAgenda createEvento(int cantidadAsistentes, Date fecha, String nombre);

}
