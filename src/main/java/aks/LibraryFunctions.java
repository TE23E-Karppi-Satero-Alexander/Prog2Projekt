package aks;

import java.util.List;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.HttpResponse;


/* Alexander Karppi Säterö 
Klassen sköter programmets funktioner */

public class LibraryFunctions {
    private List<Book> books = new ArrayList<>();
    private List<Magazine> magazines = new ArrayList<>();

    // Skapa gson objekt
    Gson gson = new Gson();
    // Server url
    String baseUrl = "http://10.151.168.5:3124/";

    // Variabler för att ta emot data
    int status;
    String body;
    HttpResponse<String> response;

    // Hämta böcker
    public boolean getBooks() {
        // Testa att hämta böcker
        try {
            response = Unirest.get(baseUrl + "books").asString();
        } catch (UnirestException e) {
            // Felmeddelande
            IO.println("Undantag uppkoppling: " + e.getLocalizedMessage());
            return false;
        }
        // Hämta status
        status = response.getStatus();
        // Kolla ifall status är ok
        if (status != 200) {
            IO.println("Fel från server, statuskod: " + status);
            return false;
        }

        // Hämta informationen i body
        String responsBody = response.getBody();

        // Konvertera json till ArrayList med Book objekt
        Type bookType = new TypeToken<ArrayList<Book>>(){}.getType();
        books = gson.fromJson(responsBody, bookType);

        IO.println("Antal böcker hämtade: " + books.size());
        return true;
    }
}
