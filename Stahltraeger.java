import ea.Rechteck;

/**
 * Ein Stahlträger
 *
 * @author Max
 * @version 1.0
 */
public class Stahltraeger extends Rechteck
{

    /**
     * Erzeugt einen Boden
     */
    public Stahltraeger()
    {
        super(200,25,255,25);
        farbeSetzen("grau");
    }

    /**
     * Konstruktor mit Breitenangabe
     * @param breite Breite des Stahlträgers
     */
    public Stahltraeger(int breite)
    {
        super(200,25,breite,25);
        farbeSetzen("grau");
    }
}
