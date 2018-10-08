package PMO_maven1;

import java.util.HashMap;

public class Toyota {
    private Enum<Plattform> plattform;
    private Enum<Ausstattung> ausstattung;
    public HashMap<Enum <Plattform>,Double> plattformPreise = new HashMap <Enum <Plattform>,Double>();
    public HashMap<Enum <Ausstattung>,Double> ausstattungPreise = new HashMap <Enum <Ausstattung>,Double>();


    public Toyota(){
        initialisierePlattformpreise();
        initialisiereAustattungspreise();
    }


    public void initialisierePlattformpreise(){
        plattformPreise.put(Plattform.YARIS, 17500.00);
        plattformPreise.put(Plattform.AYGO, 15950.00);
        plattformPreise.put(Plattform.AVENSIS, 19850.00);
        plattformPreise.put(Plattform.HILUX, 25120.00);
    }

    public void initialisiereAustattungspreise() {
        ausstattungPreise.put(Ausstattung.BASIC, 2210.00);
        ausstattungPreise.put(Ausstattung.SPORT, 4680.00);
        ausstattungPreise.put(Ausstattung.LUXUS, 7950.00);
    }

    public void setPlattform(Enum<Plattform> plattform){
        this.plattform = plattform;
    }

    public void setAusstattung(Enum<Ausstattung> ausstattung){
        this.ausstattung = ausstattung;
    }

    public Enum<Plattform> getPlattform(){
        return plattform;
    }

    public Enum<Ausstattung> getAusstattung(){
        return ausstattung;
    }



}
