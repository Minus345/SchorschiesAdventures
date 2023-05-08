import ea.Bild;
import ea.Knoten;
import ea.Raum;
import ea.Rechteck;

/**
 * Beschreiben Sie hier die Klasse Trank.
 * 
 * @author Max
 * @version 1
 */
public class Potion extends Rechteck {
    private Bild bild;
    public Potion(int x,int y,int length, int height) {
        super(x, y, length, height);
        bild = new Bild(x, y, length, height, "pictures/potion.png");
        this.sichtbarSetzen(false);
    }

    public Bild getBild() {
        return bild;
    }

    public void remove(Knoten level) {
        level.entfernen(bild);
        level.entfernen(this);
    }
}
