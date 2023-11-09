package com.mycompany.ejercicio2;

/**
 *
 * @author kathy
 */

public class libro {
    private int codigo;
    private String titulo; 
    private String autor;
    private boolean disponible;
    
    public libro(int cod,String tit, String aut){
        this.codigo=cod;
        this.titulo=tit;
        this.autor=aut;
        this.disponible=true;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void prestar() {
        disponible = false;
    }

    public void devolver() {
        disponible = true;
    }

}
