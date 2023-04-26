
/**
 * Beschreiben Sie hier die Klasse Lava.
 * 
 * @author Max
 * @version 1.0
 */
public class Lava extends Rechteck
{

    /**
     * Konstruktor für Objekte der Klasse Lava
     */
    public Lava()
    {
        super();
        GrößeSetzen(200, 25);
        FarbeSetzen("gelb");
    }

    /**
     * Konstruktor mit Breitenangabe
     * @param breite Breite der Lava
     */
    public Lava(int breite)
    {
        super();
        GrößeSetzen(breite, 25);
        FarbeSetzen("gelb");
    }

    /**
     * Entfernt alles
     */
    public void remove(){
        Entfernen();
    }

}
