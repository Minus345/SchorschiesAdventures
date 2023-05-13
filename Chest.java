import ea.Bild;
import ea.Knoten;
import ea.Rechteck;

/**
 * @author Max
 * @version 2
 */
public class Chest extends Rechteck {

    private final Bild picture;

    /**
     * creates a chest and it´s hitbox
     *
     * @param x      x-Coordinate
     * @param y      y-Coordinate
     * @param length length
     * @param height height
     */
    public Chest(int x, int y, int length, int height) {
        super(x, y, length, height);
        picture = new Bild(x, y, length, height, "pictures/kiste.png");
        this.sichtbarSetzen(false);
    }

    public Bild getPicture() {
        return picture;
    }

    public void remove(Knoten level) {
        level.entfernen(picture);
        level.entfernen(this);
    }
}