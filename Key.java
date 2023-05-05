
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
        breiteSetzen(25);
        hoeheSetzen(25);
        farbeSetzen("magenta");
    }

    public String getName() {
        return name;
    }
}
