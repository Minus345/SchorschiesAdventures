import ea.Bild;
import ea.Knoten;
import ea.Rechteck;

/**
 * @author Max
 * @version 2
 */
public class Potion extends Rechteck {
    private final Bild picture;

    /**
     * creates a potion and it´s hitbox
     *
     * @param x      x-Coordinate
     * @param y      y-Coordinate
     * @param length length
     * @param height height
     */
    public Potion(int x,int y,int length, int height) {
        super(x, y, length, height);
        picture = new Bild(x, y, length, height, "pictures/potion.png");
        this.sichtbarSetzen(false);
    }

    public Bild getBild() {
        return picture;
    }

    public void remove(Knoten level) {
        level.entfernen(picture);
        level.entfernen(this);
    }
}
