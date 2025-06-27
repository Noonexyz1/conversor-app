package com.conversor.infrastructure.api;

import com.conversor.application.port.out.CambiableAbstractApi;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MonedaAdapter implements CambiableAbstractApi {

    @Override
    public Double valorDeConversion(String fromMonedaCode, String toMonedaCode) {
        //Talvez seria mejor que me mandes el valor numerico y luego el tipo de cambio que quiero cambiarlo,
        //seria mas facil no?

        Double valorDeConversion = 0.0;

        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/a5b23f22106c3a11a27e71c3/pair/" +
                fromMonedaCode + "/" + toMonedaCode;

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

            valorDeConversion = Double.parseDouble(req_result);

        } catch (Exception e) {
            System.out.println(e);
        }
        return valorDeConversion;
    }
}
