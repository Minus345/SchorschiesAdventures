import ea.Bild;
import ea.Knoten;
import ea.Rechteck;

/**
 * @author Max
 * @version 2
 */
public class Tuer extends Rechteck {
    /**
     * Erstellt eine Tür
     */

    private Bild bild;
    public Tuer(int x, int y, int length, int height) {
        super(x, y, length, height);
        bild = new Bild(x, y, length, height, "pictures/tuer.png");
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
