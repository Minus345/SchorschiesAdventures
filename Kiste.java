import ea.Rechteck;

/**
 * @author Max
 * @version 1
 */
public class Kiste extends Rechteck
{
    /**
     * Konstruktor für Objekte der Klasse Kiste
     */
    public Kiste()
    {
        super(0,0,0,0);
        breiteSetzen(50);
        hoeheSetzen(50);
        farbeSetzen("braun");
    }

}
