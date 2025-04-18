package com.conversor.infrastructure.console;

import com.conversor.domain.model.Moneda;

public class CambioOpciones {

    private int nroOpcion;
    private Moneda fromMoneda;
    private Moneda toMoneda;

    public CambioOpciones() {

    }

    public CambioOpciones(int nroOpcion, Moneda fromMoneda, Moneda toMoneda) {
        this.nroOpcion = nroOpcion;
        this.fromMoneda = fromMoneda;
        this.toMoneda = toMoneda;
    }

    public int getNroOpcion() {
        return nroOpcion;
    }

    public void setNroOpcion(int nroOpcion) {
        this.nroOpcion = nroOpcion;
    }

    public String getOpcionCambio() {
        return nroOpcion + ") " + fromMoneda.getNombre() + " =>> " + toMoneda.getNombre();
    }

    public Moneda getFromMoneda() {
        return fromMoneda;
    }

    public void setFromMoneda(Moneda fromMoneda) {
        this.fromMoneda = fromMoneda;
    }

    public Moneda getToMoneda() {
        return toMoneda;
    }

    public void setToMoneda(Moneda toMoneda) {
        this.toMoneda = toMoneda;
    }

}
