
/**
 * Beschreiben Sie hier die Klasse Trank.
 * 
 * @author Max
 * @version 1
 */
public class Potion extends Item
{
    public Potion() {
        super();
        GrößeSetzen(25, 25);
        FarbeSetzen("grün");
    }

    public void remove() {
        Entfernen();
    }

}
