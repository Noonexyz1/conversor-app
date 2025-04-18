package com.conversor.application.adapter;

import com.conversor.application.port.in.Cambiable;
import com.conversor.application.port.out.CambiableAbstractApi;
import com.conversor.domain.model.Moneda;

public class MonedaImpl implements Cambiable {

    private final CambiableAbstractApi cambiableAbstractApi;

    public MonedaImpl(CambiableAbstractApi cambiableAbstractApi) {
        this.cambiableAbstractApi = cambiableAbstractApi;
    }

    @Override
    public Moneda cambiarMoneda(Moneda fromMoneda, Moneda toMoneda) {
        return cambiableAbstractApi.cambiarMonedaAbs(fromMoneda, toMoneda);
    }
}
