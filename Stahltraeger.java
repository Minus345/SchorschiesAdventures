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
        super();
        GrößeSetzen(200, 25);
        FarbeSetzen("grau");
    }

    /**
     * Konstruktor mit Breitenangabe
     * @param breite Breite des Stahlträgers
     */
    public Stahltraeger(int breite)
    {
        super();
        GrößeSetzen(breite, 25);
        FarbeSetzen("grau");
    }

    /**
     * Entfernt alles
     */
    public void remove(){
        Entfernen();
    }

}
