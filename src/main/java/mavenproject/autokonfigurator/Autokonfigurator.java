package PMO_maven1;

public class Autokonfigurator {

    private Toyota auto = new Toyota();
    private String zusammenfassung = "Bestell\u00DCbersicht: \n";


    public Toyota ermittlePlattformpreis(int auswahl) {
        switch(auswahl) {
            case 1: auto.setPlattform(Plattform.YARIS);
            break;
            case 2: auto.setPlattform(Plattform.AYGO);
            break;
            case 3: auto.setPlattform(Plattform.AVENSIS);
            break;
            case 4: auto.setPlattform(Plattform.HILUX);
            break;
            default: return null;
        }
        return auto;
    }

    public Toyota ermittleAusstattungspreis (int auswahl){
        switch(auswahl){
            case 1: auto.setAusstattung(Ausstattung.BASIC);
            break;
            case 2: auto.setAusstattung(Ausstattung.SPORT);
            break;
            case 3: auto.setAusstattung(Ausstattung.LUXUS);
            break;
            default: return null;
        }
        return auto;
    }

    public String getZusammenfassung(){
        double gesamtpreis = auto.plattformPreise.get(auto.getPlattform())+ auto.ausstattungPreise.get(auto.getAusstattung());

        zusammenfassung = zusammenfassung + "Plattform: "+  auto.getPlattform()+ " Plattformpreis: "+
                auto.plattformPreise.get(auto.getPlattform()) +" € \n" + "Ausstattung: "+ auto.getAusstattung()+
                " Ausstattungspreis: " + auto.ausstattungPreise.get(auto.getAusstattung()) + "€ \n" + "Gesamtpreis: "+ gesamtpreis +
                "€ \n";

        return zusammenfassung;
    }
}
