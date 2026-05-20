package aks;

/*  Alexander Karppi Säterö 
    Programmet kan hämta böcker och tidningars information från en server till en lista och skriva ut det i konsolen. 
    Programmet kan också ta emot nya böcker och tidning som sparas i samma lista (inte på servern). 
 */
public class Main {
    public static void main(String[] args) {
        LibraryFunctions bibliotek = new LibraryFunctions();
        // Meny loop
        boolean loop = true;
        while (loop) {
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
                        bibliotek.getMagazine();
                        break;
                    case "3":
                        String alternativ = IO.readln("Skriv ut hämtade böcker eller tidningar (1/2): ");
                        switch (alternativ) {
                            case "1":
                                bibliotek.printBooks();
                                break;
                            case "2":
                                bibliotek.printMagazines();
                                break;
                            default:
                                IO.println("\nOgiltigt alternativ");
                                break;
                        }
                        break;
                
                    case "4":
                        bibliotek.addBook();
                        break;
                
                    case "5":
                        bibliotek.addMagazine();
                        break;
                
                    case "6":
                        IO.println("\nAvslutar");
                        loop = false;
                        break;

                    default:
                        IO.println("Ogiltigt alternativ");
                        break;
                }
        }
    }
}