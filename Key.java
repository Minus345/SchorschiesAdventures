import ea.Bild;
import ea.Knoten;
import ea.Rechteck;

/**
 * Beschreiben Sie hier die Klasse Schluessel.
 * 
 * @author Max
 * @version 1
 */
public class Key extends Rechteck {
    /**
     * Erzeugt einen Schluessel
     */
    private Bild bild;
    private String name;
    public Key(String name,int x,int y, int length, int height) {
        super(x, y, length, height);
        this.name = name;
        bild = new Bild(x, y, length, height, "pictures/key.png");
        this.sichtbarSetzen(false);
    }

    public String getName() {
        return name;
    }

    public Bild getBild() {
        return bild;
    }

    public void remove(Knoten level) {
        level.entfernen(bild);
        level.entfernen(this);
    }
}
