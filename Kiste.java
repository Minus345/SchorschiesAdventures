
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
        super();
        GrößeSetzen(50, 50);
        FarbeSetzen("braun");
    }

    public void remove() {
        Entfernen();
    }

}
