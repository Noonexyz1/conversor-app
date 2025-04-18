package com.conversor.domain.model;

public class Moneda {

    private String nombre;
    private String abreviacion;
    private double valor;


    public Moneda() {

    }

    public Moneda(String nombre, String abreviacion, double valor) {
        this.nombre = nombre;
        this.abreviacion = abreviacion;
        this.valor = valor;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "nombre='" + nombre + '\'' +
                ", abreviacion='" + abreviacion + '\'' +
                ", valor=" + valor +
                '}';
    }
}
