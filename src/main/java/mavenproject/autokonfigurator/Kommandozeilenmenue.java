package mavenproject.autokonfigurator;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


/**
 * Diese Klasse stellt alle Methoden für das Kommandozeilenemenü zur Verfügung
 */
public class Kommandozeilenmenue {
    public boolean end = false;
    Scanner scan = new Scanner(System.in);
    Autokonfigurator autokonfigurator = new Autokonfigurator();
    Toyota auto;

    public void starteMenu() {
        System.out.println("*****************Willkommen im Toyote-Autokonfigurator!*****************\n\n");
        do {
            plattformAuswahl();
            zusammenfassungAusgeben();
            naechsterSchritt();
        }
        while (end = false);
    }

    public void plattformAuswahl(){

        System.out.println("W\u00E4hlen Sie ein Modell");
        System.out.println("1-> Yaris");
        System.out.println("2-> Aygo");
        System.out.println("3-> Avensis");
        System.out.println("4-> Hilux");
        int plattformWahl =999;
        try {
            plattformWahl = scan.nextInt();
            scan.nextLine();
        }
        catch (InputMismatchException ex) {
            System.out.println("Bitte geben Sie eine Ganzzahl ein!");
            plattformAuswahl();
        }
        if(plattformWahl >=1 && plattformWahl <=4) {
            auto = autokonfigurator.ermittlePlattformpreis(plattformWahl);
        }
        else {
            System.out.println("Ung\u00DCltige Auswahl");
            plattformAuswahl();
        }

        ausstattungsAuswahl();

    }

    public void ausstattungsAuswahl(){
        System.out.println("W\u00E4hlen Sie ein Ausstattungspaket");
        System.out.println("1-> Basic");
        System.out.println("2-> Sport");
        System.out.println("3-> Luxus");
        int ausstattungsWahl =999;
        try{
            ausstattungsWahl = scan.nextInt();
            scan.nextLine();
        }
        catch (InputMismatchException ex) {
            System.out.println("Auswahl ung\u00DCltig.");
            ausstattungsAuswahl();
        }

        if(ausstattungsWahl >=1 && ausstattungsWahl <=3) {
            auto = autokonfigurator.ermittleAusstattungspreis(ausstattungsWahl);
        }
        else {
            System.out.println("Ung\u00DCltige Auswahl");
            ausstattungsAuswahl();
        }

    }

    public void zusammenfassungAusgeben(){
        System.out.println(autokonfigurator.getZusammenfassung());
    }

    public void naechsterSchritt () {
        System.out.println("Wie wollen Sie fortfahren?");
        System.out.println("1-> Bestellung abschicken");
        System.out.println("2-> Konfiguration \u00C4ndern");
        System.out.println("3-> Neue Konfiguration beginnen");
        System.out.println("4-> Autokonfigurator beenden");
        int auswahl =999;
        try {
            auswahl = scan.nextInt();
            scan.nextLine();
        }
        catch (InputMismatchException ex) {
            System.out.println("Ung\u00DCltige Auswahl");
            naechsterSchritt();
        }
        if (auswahl >=1 && auswahl <=4){
            switch (auswahl) {
                case 1:

                    System.out.println("Ihr neuer Toyota "+ auto.getPlattform()+ " wird am " + getLieferdatum() + " geliefert");
                    System.out.println("Vielen Dank für Ihre Bestellung");
                    end = true;
                    break;

                case 2: int konfigAuswahl = konfigurationBearbeiten();
                if (konfigAuswahl == 1) {
                    plattformAuswahl();
                    zusammenfassungAusgeben();
                    naechsterSchritt();
                }
                else {
                    ausstattungsAuswahl();
                    zusammenfassungAusgeben();
                    naechsterSchritt();

                }
                    break;

                case 3: plattformAuswahl();
                case 4:
                    System.out.println("Auf Wiedersehen!");
                    end = true;
                    break;
            }
        }
        else {
            System.out.println("Ung\u00DCltige Auswahl");
            naechsterSchritt();
        }
    }

    public int konfigurationBearbeiten() {
        System.out.println("Welchen Teil der Konfiguration moechten Sie aendern?");
        System.out.println("1-> Marke");
        System.out.println("2-> Ausstattungspaket");
        int auswahl = 999;
        try {
            auswahl = scan.nextInt();
            scan.nextLine();
        } catch (InputMismatchException ex) {
            System.out.println("Ung\u00DCltige Auswahl");
            konfigurationBearbeiten();
        }
        if (auswahl == 1 || auswahl == 2) {
            return auswahl;
        } else {
            System.out.println("Ung\u00DCltige Auswahl");
            konfigurationBearbeiten();
        }
        return 0;
    }

    public LocalDate getLieferdatum () {
        LocalDate heute = LocalDate.now();
        LocalDate lieferdatum = heute.plus(3, ChronoUnit.WEEKS);
        return lieferdatum;
    }

}
