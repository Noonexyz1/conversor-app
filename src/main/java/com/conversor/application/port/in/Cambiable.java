package com.conversor.application.port.in;

public interface Cambiable {
    Double cambiarMoneda(String fromMoneda, String toMoneda, Double valorACambiar);
}
