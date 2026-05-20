package aks;
/*  Alexander Karppi Säterö
    Klassen LibraryItem
 */
public class LibraryItem {
    protected String id;
    protected String title;
    protected boolean isAvailable;

    // Konstruktor
    public LibraryItem(String id, String title, boolean isAvailable){
        this.id = id;
        this.title = title;
        this.isAvailable = isAvailable;
    }

    // Getters
    public String getId() {return id;}

    public String getTitle() {return title;}

    public boolean isAvailable() {return isAvailable;}

    public String getInfo() {return "ID: " + id + " Titel: " + title + " Tillgänlighet: " + isAvailable;}
}
