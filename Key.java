
/**
 * Beschreiben Sie hier die Klasse Schluessel.
 * 
 * @author Max
 * @version 1
 */
public class Key extends Item
{
    /**
     * Erzeugt einen Schluessel
     */
    private String name;
    public Key(String name) {
        super();
        this.name = name;
        GrößeSetzen(25, 25);
        FarbeSetzen("magenta");
    }

    public void remove(){
        Entfernen();
    }

    public String getName() {
        return name;
    }
}
