import java.util.Scanner;
 //projekti on tehty yksin laitoin vielä tänne
public class App {
    public static void main(String[] args) {
        System.out.println("--- Hirsipuu ---");
        String[] sanat = {"kana", "kissa", "koira", "ohjelmointi", "elokuvateatteri", "tietokonepöytä", "puhelin", "vuoristorata"};    // Lista sanoista joilla pelataan
        String sana = sanat[(int) (Math.random() * sanat.length)];          // Satunnaisesti valitaan yksi sanoista
        hirsipuu(sana);                                                     // Aloitetaan peli
    }
 
    static public void hirsipuu(String sana){
        char[] arvattava = new char[sana.length()];     // Alustetaan "sensuroitu" versio arvattavasta sanasta
        int arvauksia = 5;      // Pelaajan "elämät"
        String käytetyt = "";   // Alustetaan merkkijono syötetyille merkeille
        int i = 0;
        while(i<sana.length()){             // Tässä hoidetaan se "sensurointi"
            arvattava[i]='*';
            if(sana.charAt(i) == ' '){
                arvattava[i] = ' ';
            }
            i++;
        }
        tilanne(arvattava, arvauksia, käytetyt);
 
        System.out.println("Syötä arvauksesi: ");
        Scanner syöte = new Scanner(System.in);         // Kysytään käyttäjältä syöte
        while (arvauksia > 0){
            char arvausSyöte = syöte.next().charAt(0);  // Syötteestä otetaan ensimmäinen kirjain (mitä syötteen kuuluisikin olla)
            käytetyt = käytetyt + " " + arvausSyöte;    // Lisätään äsken syötetty kirjain käytetyt-listalle
            if(sana.contains(arvausSyöte + "")){        // Katsotaan onko arvattavassa sanassa syötettyä merkkiä. Jos on,
                for(int x = 0; x < sana.length(); x++){ // sersuroidusta versiosta lähtee *-merkki ja paljastaa mikä kirjain siinä oli
                    if(sana.charAt(x) == arvausSyöte){
                        arvattava[x] = arvausSyöte;
                    }
                }
            }
            else{
                arvauksia--;   
                System.out.println("Antamasi kirjain ei löydy sanasta");                         // Jos sanasta ei löydy syötettyä merkkiä, pelaaja menettää yhden "elämän"
            }
            if(sana.equals(String.valueOf(arvattava))){ // Tarkistetaan, onko sana on paljastunut kokonaan, jos on, pelaaja voittaa
                System.out.println("Vau :^) voitit pelin!\nArvuutettava sana oli: " + sana);
                break;
            }
            tilanne(arvattava, arvauksia, käytetyt); 
            System.out.println("Syötä arvauksesi: ");
        }
    }
 
    // Tulostetaan mikä tilanne pelaajalla on 
    // Kuinka paljon arvuutetusta sanasta on näkyvillä, monta arvausta jäljellä, mitä kirjaimia on jo syötetty, sekä hirttopuun tulostus
    // kunnon printtihelvetti ei kande scrollaa alas
    public static void tilanne(char[] arvattava, int arvauksia, String käytetyt) {
        if (arvauksia == 5) {
            System.out.println("\n\nArvuutettava sana: ");
            System.out.println(arvattava);
            System.out.println("Aiemmat arvauksesi: " + "\n" + käytetyt);
            System.out.println("Arvauksia jäljellä: " + "\n" + arvauksia);
 
            System.out.println("       ");
            System.out.println("         | ");
            System.out.println("         | ");
            System.out.println("         | ");
            System.out.println("         | ");
            System.out.println("       __| \n");
        }
        if (arvauksia == 4) {
            System.out.println("\n\nArvuutettava sana: ");
            System.out.println(arvattava);
            System.out.println("Aiemmat arvauksesi: " + "\n" + käytetyt);
            System.out.println("Arvauksia jäljellä: " + "\n" + arvauksia);
 
            System.out.println("    ______ ");
            System.out.println("         | ");
            System.out.println("         | ");
            System.out.println("         | ");
            System.out.println("         | ");
            System.out.println("       __| \n");
        }
        if (arvauksia == 3) {
            System.out.println("\n\nArvuutettava sana: ");
            System.out.println(arvattava);
            System.out.println("Aiemmat arvauksesi: " + "\n" + käytetyt);
            System.out.println("Arvauksia jäljellä: " + "\n" + arvauksia);
 
            System.out.println("    ______ ");
            System.out.println("    O    | ");
            System.out.println("         | ");
            System.out.println("         | ");
            System.out.println("         | ");
            System.out.println("       __| \n");
        }
        if (arvauksia == 2) {
            System.out.println("\n\nArvuutettava sana: ");
            System.out.println(arvattava);
            System.out.println("Aiemmat arvauksesi: " + "\n" + käytetyt);
            System.out.println("Arvauksia jäljellä: " + "\n" + arvauksia);
 
            System.out.println("    ______ ");
            System.out.println("    O    | ");
            System.out.println("    |    | ");
            System.out.println("         | ");
            System.out.println("         | ");
            System.out.println("      ___| \n");
        }
        if (arvauksia == 1) {
            System.out.println("\n\nArvuutettava sana: ");
            System.out.println(arvattava);
            System.out.println("Aiemmat arvauksesi: " + "\n" + käytetyt);
            System.out.println("Arvauksia jäljellä: " + "\n" + arvauksia);
 
            System.out.println("    ______ ");
            System.out.println("    O    | ");
            System.out.println("   _|_   | ");
            System.out.println("    |    | ");
            System.out.println("         | ");
            System.out.println("      ___| \n");
        }
        if (arvauksia == 0) {
            System.out.println("\n\nArvuutettava sana: ");
            System.out.println(arvattava);
            System.out.println("Aiemmat arvauksesi: " + "\n" + käytetyt);
            System.out.println("Arvauksia jäljellä: " + "\n" + arvauksia);
 
            System.out.println("    ______ ");
            System.out.println("    O    | ");
            System.out.println("   _|_   | ");
            System.out.println("    |    | ");
            System.out.println("   /|    | ");
            System.out.println("      ___| \n");
            System.out.println("Hävisit pelin :_D");
            System.exit(1);
        }
    }
}
