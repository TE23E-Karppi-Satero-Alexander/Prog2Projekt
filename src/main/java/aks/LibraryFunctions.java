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
Klassen sköter programmets funktionalitet */

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
        String responseBody = response.getBody();

        // Konvertera json till ArrayList med Book objekt
        Type bookType = new TypeToken<ArrayList<Book>>() {}.getType();
        books = gson.fromJson(responseBody, bookType);

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
        String responseBody = response.getBody();

        // Konvertera json till ArrayList med Magazine objekt
        Type magazineType = new TypeToken<ArrayList<Magazine>>() {}.getType();
        magazines = gson.fromJson(responseBody, magazineType);

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

        // Skapa ny bok och lägg till i lista
        Book bookToAdd = new Book(id, title, true, author, genre, pages);
        books.add(bookToAdd);
        IO.println("Boken " + title + " har skapats");
    }

    // Lägg till ny tidning till lista
    public void addMagazine(){
        // Användaren bestämmer nya tidningen
        String id = String.valueOf(magazines.size()+1);
        String title = IO.readln("Ange titel: ");
        int issueNumber = Integer.parseInt(IO.readln("Ange utgåva: "));
        String category = IO.readln("Ange kategori: ");
        int publishedYear = Integer.parseInt(IO.readln("Ange publiceringsår: "));

        // Skapa ny tidning och lägg till i lista
        Magazine magazineToAdd = new Magazine(id, title, true, issueNumber, category, publishedYear);
        magazines.add(magazineToAdd);
        IO.println("Tidningen " + title + " har skapats");
    }

    // Skriv ut alla böcker
    public void printBooks(){
        for (Book book : books) {
            IO.println(book.getInfo());
        }
    }

    // Skriv ut alla tidningar
    public void printMagazines(){
        for (Magazine magazine : magazines) {
            IO.println(magazine.getInfo());
        }
    }
}
