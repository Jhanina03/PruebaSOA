/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.APIs;

import Models.Estudiante;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 *
 * @author Usuario
 */
public class APIEstudiantes {

    private String URL;
    private HttpResponse<String> response;
    private HttpClient client;
    private final Gson gson;

    public APIEstudiantes(String apiPath) {
        this.URL = apiPath;
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    // Ahora recibe directamente RequestEstudiante en vez de RequestParser<Estudiante>
    public void GET() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        this.response = this.client.send(request, BodyHandlers.ofString());
    }

    public void GET(String cedula) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "?cedula=" + cedula))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        this.response = this.client.send(request, BodyHandlers.ofString());
    }

    public void POST(Estudiante estudiante) throws Exception {
        String body = gson.toJson(estudiante);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(this.URL))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(body))
                .build();
        this.response = this.client.send(request, BodyHandlers.ofString());
    }

    public void PUT(Estudiante estudiante) throws Exception {
        String body = gson.toJson(estudiante);
        String params = "?cedula=" + estudiante.cedula;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + params))
                .header("Content-Type", "application/json")
                .PUT(BodyPublishers.ofString(body))
                .build();
        this.response = this.client.send(request, BodyHandlers.ofString());
    }

    public void DELETE() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();
        this.response = this.client.send(request, BodyHandlers.ofString());
    }

    public String fetchRawData() {
        return (this.response != null) ? this.response.body() : null;
    }
}
