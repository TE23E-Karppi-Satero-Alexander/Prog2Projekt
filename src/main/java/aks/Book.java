package aks;
/*  Alexander Karppi Säterö
    Klassen Book för bibliotekets böcker
 */
public class Book extends LibraryItem{
    private String author;
    private String genre;
    private int pages;

    // Getters
    public String getAuthor(){return author;}

    public String getGenre(){return genre;}
    
    public int getPages(){return pages;}
}
