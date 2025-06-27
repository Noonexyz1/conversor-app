package com.conversor.infrastructure.console;

public class CambioOpciones {

    private int nro;
    private String opcion;
    private Runnable ejecutarOpcion;


    public CambioOpciones() {

    }

    public CambioOpciones(int nro, String opcion, Runnable ejecutarOpcion) {
        this.nro = nro;
        this.opcion = opcion;
        this.ejecutarOpcion = ejecutarOpcion;
    }


    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public Runnable getEjecutarOpcion() {
        return ejecutarOpcion;
    }

    public void setEjecutarOpcion(Runnable ejecutarOpcion) {
        this.ejecutarOpcion = ejecutarOpcion;
    }
}
