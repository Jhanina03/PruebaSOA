/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Parsers.Responses;

import Controllers.APIs.APICursos;
import Models.Curso;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author jhani
 */
public class ResponseCurso {
    private final APICursos api;
    private final Gson gson;

    public ResponseCurso(APICursos api) {
        this.api = api;
        this.gson = new Gson();
    }

    public ArrayList<Curso> parseResponses() {
        String body = api.fetchRawData();
        Type listType = new TypeToken<ArrayList<Curso>>(){}.getType();
        return gson.fromJson(body, listType);
    }
}