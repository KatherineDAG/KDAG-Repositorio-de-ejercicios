package com.mycompany.ejercicio2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author kathy
 */
public class biblioteca {
    private List<socio> soc;
    private List<libro> lib;

    public biblioteca() {
        soc = new ArrayList<>();
        lib = new ArrayList<>();
    }

    public void agregarSocio(socio socio) {
        soc.add(socio);
    }

    public void agregarLibro(libro libro) {
        lib.add(libro);
    }

    public void prestarLibro(int numeroSocio, int codigoLibro, Date fecha) {
        socio socio = soc.stream().filter(s -> s.getNumeroSocio() == numeroSocio).findFirst().orElse(null);
        libro libro = lib.stream().filter(l -> l.getCodigo() == codigoLibro).findFirst().orElse(null);

        if (socio != null && libro != null && libro.isDisponible()) {
            if (socio.getPrestamos().stream().noneMatch(p -> p.getLibro() == libro)) {
                libro.prestar();
                socio.prestarLibro(libro, fecha);
            } else {
                System.out.println("El libro ya ha sido prestado a este socio.");
            }
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }

    public void devolverLibro(int numeroSocio, int codigoLibro) {
        socio socio = soc.stream().filter(s -> s.getNumeroSocio() == numeroSocio).findFirst().orElse(null);
        libro libro = lib.stream().filter(l -> l.getCodigo() == codigoLibro).findFirst().orElse(null);

        if (socio != null && libro != null) {
            libro.devolver();
            socio.devolverLibro(libro);
        }
    }

    public List<socio> sociosConMasDe3LibrosPrestados() {
        return soc.stream()
                .filter(socio -> socio.getNumeroLibrosPrestados() > 3)
                .collect(Collectors.toList());
    }
    
}
