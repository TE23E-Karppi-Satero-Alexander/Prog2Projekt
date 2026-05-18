package aks;
/*  Alexander Karppi Säterö
    Klassen Book för bibliotekets böcker
 */
public class Book extends LibraryItem{
    private String author;
    private String genre;
    private int pages;

    // Konstruktor
    public Book(String id, String title, boolean isAvailable, String author, String genre, int pages){
        super(id, title, isAvailable);
        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }

    // Getters
    public String getAuthor(){return author;}

    public String getGenre(){return genre;}

    public int getPages(){return pages;}

    @Override
    public String getInfo() {return "ID: " + id + "Titel: " + title + "Tillgänlighet: " + isAvailable + "Författare: " + author + "Genre: " + genre + "Antal sidor: " + pages;}
}
