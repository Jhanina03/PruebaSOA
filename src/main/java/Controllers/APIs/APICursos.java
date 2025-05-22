/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.APIs;

import Models.CursoEstudiante;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 *
 * @author jhani
 */
public class APICursos {
    private String URL;
    private HttpResponse<String> response;
    private HttpClient client;
    private final Gson gson;

    public APICursos(String apiPath) {
        this.URL = apiPath;
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public void GET() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(URL))
            .header("Content-Type", "application/json")
            .GET()
            .build();
        this.response = this.client.send(request, BodyHandlers.ofString());
    }
    
public void POST(CursoEstudiante curso) throws Exception {
    String body = gson.toJson(curso);
    HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(this.URL))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(body))
            .build();
    this.response = this.client.send(request, BodyHandlers.ofString());
}

    public String fetchRawData() {
        return (this.response != null) ? this.response.body() : null;
    }
}