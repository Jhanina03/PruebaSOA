/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Parsers.Responses;

import Controllers.APIs.APIEstudiantes;
import Models.Estudiante;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ResponseEstudiante { 
 
    private final APIEstudiantes api; 
    private final Gson gson; 
 
    public ResponseEstudiante(APIEstudiantes api) { 
        this.api = api; 
        this.gson = new Gson(); 
    } 
 
    public ArrayList<Estudiante> parseResponses() { 
        String body = api.fetchRawData(); 
        Type listType = new TypeToken<ArrayList<Estudiante>>() { 
        }.getType(); 
        return gson.fromJson(body, listType); 
    } 
 
    public Estudiante parseResponse() { 
        String body = api.fetchRawData(); 
        return gson.fromJson(body, Estudiante.class); 
    } 
 
    public boolean parseSuccess() throws Exception { 
        String response = api.fetchRawData(); 
        if ("1".equals(response) || "true".equalsIgnoreCase(response)) { 
            return true; 
        } else if ("0".equals(response) || "false".equalsIgnoreCase(response)) { 
            return false; 
        } 
        throw new Exception("Respuesta inesperada de la API: " + response); 
    } 
}