package aks;

/*  Alexander Karppi Säterö 
    Programmet kan ...
 */
public class Main {
    public static void main(String[] args) {
        LibraryFunctions bibliotek = new LibraryFunctions();
        // Meny loop
        while (true) {
            IO.println("""
                    \nBibliotek
                    1. Hämta böcker
                    2. Hämta tidningar
                    3. Skriv ut hämtade
                    4. Lägg till bok
                    5. Lägg till tidning
                    6. Avsluta
                    """);
                String val = IO.readln("Ditt val: ");
                switch (val) {
                    case "1":
                        bibliotek.getBooks();
                        break;
                    case "2":
                        
                        break;
                
                    case "3":
                        
                        break;
                
                    case "4":
                        
                        break;
                
                    case "5":
                        
                        break;
                
                    default:
                        IO.println("Ogiltigt alternativ");
                        break;
                }
        }
    }
}