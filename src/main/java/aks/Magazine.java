package aks;
/*  Alexander Karppi Säterö
    Klassen Magazine för bibliotekets magasin
 */
public class Magazine extends LibraryItem{
    private int issueNumber;
    private String category;
    private int publishedYear;

    // Konstruktor
    public Magazine(String id, String title, boolean isAvailable, int issueNumber, String category, int publishedYear){
        super(id, title, isAvailable);
        this.issueNumber = issueNumber;
        this.category = category;
        this.publishedYear = publishedYear;
    }

    // Getters
    public int getIssueNumber() {return issueNumber;}

    public String category() {return category;}

    public int publishedYear() {return publishedYear;}

    @Override
    public String getInfo() {return "ID: " + id + "Titel: " + title + "Tillgänlighet: " + isAvailable + "Upplaga: " + issueNumber + "Kategori: " + category + "Publiceringsår: " + publishedYear;}
}
