package mavenproject.autokonfigurator;

/**
 * Diese Klasse hat nur die Aufgabe das Kommandozeilenmenue zu starten
 */
public class App 
{
    public static void main( String[] args )
    {
        Kommandozeilenmenue menue =  new Kommandozeilenmenue();
        menue.starteMenu();
    }
}
