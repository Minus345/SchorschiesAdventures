import ea.Bild;
import ea.Knoten;
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
    private Bild bild;
    public Kiste(int x, int y, int length, int height)
    {
        super(x, y, length, height);
        bild = new Bild(x, y, length, height, "pictures/kiste.png");
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
