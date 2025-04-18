package com.conversor.application.port.out;

import com.conversor.domain.model.Moneda;

public interface CambiableAbstractApi {
    Moneda cambiarMonedaAbs(Moneda fromMoneda, Moneda toMoneda);
}
