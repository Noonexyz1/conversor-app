package com.conversor.infrastructure;

import com.conversor.application.adapter.MonedaImpl;
import com.conversor.application.port.in.Cambiable;
import com.conversor.application.port.out.CambiableAbstractApi;
import com.conversor.infrastructure.api.MonedaAdapter;
import com.conversor.infrastructure.console.TerminalApp;

public class ConsoleApp {

    public static void main(String[] args) {
        //Primero Resolvemos las injecion de dependencia
        //Porque esto es de instrastructure y tambien esta app de terminal
        CambiableAbstractApi cambiableAbstractApi = new MonedaAdapter();
        Cambiable cambiable = new MonedaImpl(cambiableAbstractApi);

        new TerminalApp(cambiable).iniciar();
    }
}
