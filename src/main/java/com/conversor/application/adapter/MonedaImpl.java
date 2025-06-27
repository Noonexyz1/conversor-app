package com.conversor.application.adapter;

import com.conversor.application.port.in.Cambiable;
import com.conversor.application.port.out.CambiableAbstractApi;

public class MonedaImpl implements Cambiable {

    private final CambiableAbstractApi cambiableAbstractApi;

    public MonedaImpl(CambiableAbstractApi cambiableAbstractApi) {
        this.cambiableAbstractApi = cambiableAbstractApi;
    }


    @Override
    public Double cambiarMoneda(String fromMoneda, String toMoneda, Double valorACambiar) {
        Double rateValue = cambiableAbstractApi.valorDeConversion(fromMoneda, toMoneda);
        return rateValue * valorACambiar;
    }
}
