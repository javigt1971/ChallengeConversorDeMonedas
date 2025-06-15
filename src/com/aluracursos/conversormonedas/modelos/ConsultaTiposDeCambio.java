package com.aluracursos.conversormonedas.modelos;

import com.aluracursos.conversormonedas.modelos.RespuestaAPI;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaTiposDeCambio {
    public RespuestaAPI consultaRespuestaCompleta() {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/e6d48a6ba243a00948b17d65/latest/USD");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), RespuestaAPI.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
