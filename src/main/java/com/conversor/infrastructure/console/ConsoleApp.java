package com.conversor.infrastructure.console;

import com.conversor.application.adapter.MonedaImpl;
import com.conversor.application.port.in.Cambiable;
import com.conversor.application.port.out.CambiableAbstractApi;
import com.conversor.domain.model.Moneda;
import com.conversor.infrastructure.api.MonedaAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {

    private boolean isIniciado = true;
    private int nroOpcionCont = 0;
    private List<CambioOpciones> listaMonedas = new ArrayList<>();

    public ConsoleApp() {
        listaMonedas.add(
                new CambioOpciones(
                        ++nroOpcionCont,
                        new Moneda("Dolar", "USD", 0),
                        new Moneda("Peso Aregentido", "ARS", 0)
                ));
        listaMonedas.add(
                new CambioOpciones(
                        ++nroOpcionCont,
                        new Moneda("Peso Argentino", "ARS", 0),
                        new Moneda("Dólar Estadounidense", "USD", 0)
                ));

        listaMonedas.add(
                new CambioOpciones(
                        ++nroOpcionCont,
                        new Moneda("Dólar Estadounidense", "USD", 0),
                        new Moneda("Real Brasileño", "BRL", 0)
                ));

        listaMonedas.add(
                new CambioOpciones(
                        ++nroOpcionCont,
                        new Moneda("Real Brasileño", "BRL", 0),
                        new Moneda("Dólar Estadounidense", "USD", 0)
                ));

        listaMonedas.add(
                new CambioOpciones(
                        ++nroOpcionCont,
                        new Moneda("Dólar Estadounidense", "USD", 0),
                        new Moneda("Peso Colombiano", "COP", 0)
                ));

        listaMonedas.add(
                new CambioOpciones(
                        ++nroOpcionCont,
                        new Moneda("Peso Colombiano", "COP", 0),
                        new Moneda("Dólar Estadounidense", "USD", 0)
                ));
    }

    public void iniciar() {
        do {
            System.out.println("***************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");

            listaMonedas.forEach(x -> System.out.println(x.getOpcionCambio()));

            System.out.println(nroOpcionCont + 1 + ") Salir");
            System.out.println("***************************************************");
            System.out.println("Elije una opcion valida:");

            Scanner scanner = new Scanner(System.in);
            int opcionUser = scanner.nextInt();

            listaMonedas.forEach(x -> {
                if (x.getNroOpcion() == opcionUser) {
                    System.out.println("Ingresa el valor que deseas convertir:");
                    double valorUser = scanner.nextDouble();
                    x.getFromMoneda().setValor(valorUser);

                    CambiableAbstractApi cambiableAbstractApi = new MonedaAdapter();
                    Cambiable cambiable = new MonedaImpl(cambiableAbstractApi);

                    Moneda moneda = cambiable.cambiarMoneda(x.getFromMoneda(), x.getToMoneda());
                    System.out.println("El valor " +
                            x.getFromMoneda().getValor() +
                            " [" + x.getFromMoneda().getAbreviacion() + "]" +
                            " corresponde a un valor final de =>> " + moneda.getValor() +
                            " [" + moneda.getAbreviacion() + "]");

                }
                if (nroOpcionCont + 1  == opcionUser) {
                    isIniciado = false;
                }
            });

        } while (isIniciado);

    }

    public static void main(String[] args) {
        new ConsoleApp().iniciar();
    }
}
