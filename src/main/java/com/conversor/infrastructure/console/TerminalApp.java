package com.conversor.infrastructure.console;

import com.conversor.application.port.in.Cambiable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class TerminalApp {

    private boolean isIniciado = true;
    private List<CambioOpciones> listaDeOpciones;

    //Dependencias
    private Cambiable cambiable;


    public TerminalApp(Cambiable cambiable) {
        this.cambiable = cambiable;
        this.listaDeOpciones = new ArrayList<>();
        this.iniciarListaDeOpciones();
    }


    void iniciarListaDeOpciones() {
        listaDeOpciones.add(new CambioOpciones(1, "1.- Dolar ==> Peso Argentino",  this::fromDolarToArgentino));
        listaDeOpciones.add(new CambioOpciones(2, "2.- Peso Argentino ==> Dolar Estadounidense", this::fromArgentinoToDolar));
        listaDeOpciones.add(new CambioOpciones(3, "3.- Dolar Estadounindense ==> Real Brasilenio", this::fromDolarToReal));
        listaDeOpciones.add(new CambioOpciones(4, "4.- Real Brasilenio ==> Dolar Estadounidense", this::fromRealToDolar));
        listaDeOpciones.add(new CambioOpciones(5, "5.- Dolar Estadounidense ==> Peso Colombiano", this::fromDolarToColombiano));
        listaDeOpciones.add(new CambioOpciones(6, "6.- Peso Colombiano ==> Dolar Estadounidense", this::fromColombianoToDolar));
        listaDeOpciones.add(new CambioOpciones(7, "7.- Salir", this::salir));
    }

    public void fromDolarToArgentino() {
        out.println("Ingresa el valor que deseas convertir:");
        Double valorACambiar = new Scanner(System.in).nextDouble();
        Double monedaCambiada = cambiable.cambiarMoneda("USD", "ARS", valorACambiar);
        mostrarResultado(valorACambiar, monedaCambiada, "USD", "ARS");
    }

    public void fromArgentinoToDolar() {
        out.println("Ingresa el valor que deseas convertir:");
        Double valorACambiar = new Scanner(System.in).nextDouble();
        Double monedaCambiada = cambiable.cambiarMoneda("ARS", "USD", valorACambiar);
        mostrarResultado(valorACambiar, monedaCambiada, "ARS", "USD");
    }

    public void fromDolarToReal() {
        out.println("Ingresa el valor que deseas convertir:");
        Double valorACambiar = new Scanner(System.in).nextDouble();
        Double monedaCambiada = cambiable.cambiarMoneda("USD", "BRL", valorACambiar);
        mostrarResultado(valorACambiar, monedaCambiada, "USD", "BRL");
    }

    public void fromRealToDolar() {
        out.println("Ingresa el valor que deseas convertir:");
        Double valorACambiar = new Scanner(System.in).nextDouble();
        Double monedaCambiada = cambiable.cambiarMoneda("BRL", "USD", valorACambiar);
        mostrarResultado(valorACambiar, monedaCambiada, "BRL", "USD");
    }

    public void fromDolarToColombiano() {
        out.println("Ingresa el valor que deseas convertir:");
        Double valorACambiar = new Scanner(System.in).nextDouble();
        Double monedaCambiada = cambiable.cambiarMoneda("USD", "COP", valorACambiar);
        mostrarResultado(valorACambiar, monedaCambiada, "USD", "COP");
    }

    public void fromColombianoToDolar() {
        out.println("Ingresa el valor que deseas convertir:");
        Double valorACambiar = new Scanner(System.in).nextDouble();
        Double monedaCambiada = cambiable.cambiarMoneda("COP", "USD", valorACambiar);
        mostrarResultado(valorACambiar, monedaCambiada, "COP", "USD");
    }

    public void salir() {
        this.isIniciado = false;
    }


    public void mostrarResultado(Double valorACambiar, Double valorCambiado, String fromMoneda, String toMoneda) {
        out.println("El valor " +
                valorACambiar +
                " [" + fromMoneda + "]" +
                " corresponde a un valor final de =>> " + valorCambiado +
                " [" + toMoneda + "]");
    }


    //Toddo inicia aqui
    public void iniciar() {
        do {
            out.println("***************************************************");
            out.println("Sea bienvenido/a al Conversor de Moneda =]");

            //mostramos las opciones
            listaDeOpciones.forEach(x -> out.println(x.getOpcion()));

            out.println("***************************************************\n");
            out.println("Elije una opcion valida:");
            int opcionUser = new Scanner(System.in).nextInt();

            listaDeOpciones.forEach(x -> {
                if (x.getNro() == opcionUser) {
                    x.getEjecutarOpcion().run();
                }
            });

        } while (isIniciado);
    }

}
