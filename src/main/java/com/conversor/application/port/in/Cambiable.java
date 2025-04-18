package com.conversor.application.port.in;

import com.conversor.domain.model.Moneda;

public interface Cambiable {
    Moneda cambiarMoneda(Moneda fromMoneda, Moneda toMoneda);
}
