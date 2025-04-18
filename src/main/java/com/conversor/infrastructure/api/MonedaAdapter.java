package com.conversor.infrastructure.api;

import com.conversor.application.port.out.CambiableAbstractApi;
import com.conversor.domain.model.Moneda;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MonedaAdapter implements CambiableAbstractApi {

    @Override
    public Moneda cambiarMonedaAbs(Moneda fromMoneda, Moneda toMoneda) {
        Moneda monedaCambiada = toMoneda;

        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/a5b23f22106c3a11a27e71c3/pair/" +
                fromMoneda.getAbreviacion() + "/" + toMoneda.getAbreviacion();

        try {
            // Making Request
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            // Accessing object
            String req_result = jsonobj.get("conversion_rate").getAsString();

            monedaCambiada.setValor(Double.parseDouble(req_result) * fromMoneda.getValor());

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return monedaCambiada;
    }
}
