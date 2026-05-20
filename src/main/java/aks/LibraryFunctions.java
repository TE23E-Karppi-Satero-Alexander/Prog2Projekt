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
        Type bookType = new TypeToken<ArrayList<Book>>() {}.getType();
        books = gson.fromJson(responsBody, bookType);

        IO.println("Antal böcker hämtade: " + books.size());
        return true;
    }

    // Hämta tidningar
    public boolean getMagazine() {
        // Testa att hämta tidningar
        try {
            response = Unirest.get(baseUrl + "magazines").asString();
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

        // Konvertera json till ArrayList med Magazine objekt
        Type magazineType = new TypeToken<ArrayList<Magazine>>() {}.getType();
        magazines = gson.fromJson(responsBody, magazineType);

        IO.println("Antal tidningar hämtade: " + magazines.size());
        return true;
    }

    // Lägg till ny bok till lista
    public void addBook(){
        // Användaren bestämmer nya boken
        String id = String.valueOf(books.size()+1);
        String title = IO.readln("Ange titel: ");
        String author = IO.readln("Ange författare: ");
        String genre = IO.readln("Ange genre: ");
        int pages = Integer.parseInt(IO.readln("Ange antal sidor: "));

        // Skapa ny bok
        Book bookToAdd = new Book(id, title, true, author, genre, pages);
        books.add(bookToAdd);
        IO.println("Boken " + title + " har skapats");
    }
}
