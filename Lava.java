import ea.Rechteck;

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
        super(0,0,0,0);
        breiteSetzen(200);
        hoeheSetzen(25);
        farbeSetzen("gelb");
    }

    /**
     * Konstruktor mit Breitenangabe
     * @param breite Breite der Lava
     */
    public Lava(int breite)
    {
        super(0,0,0,0);
        breiteSetzen(breite);
        hoeheSetzen(25);
        farbeSetzen("gelb");
    }

}
