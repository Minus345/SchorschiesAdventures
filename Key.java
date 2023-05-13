import ea.Bild;
import ea.Knoten;
import ea.Rechteck;

/**
 * @author Max
 * @version 2
 */
public class Key extends Rechteck {
    private final Bild picture;
    private final String name;

    /**
     * creates a key and it´s hitbox
     *
     * @param x      x-Coordinate
     * @param y      y-Coordinate
     * @param length length
     * @param height height
     * @param name   the name of the key wich is displayed in the inventory
     */
    public Key(String name, int x, int y, int length, int height) {
        super(x, y, length, height);
        this.name = name;
        picture = new Bild(x, y, length, height, "pictures/key.png");
        this.sichtbarSetzen(false);
    }

    public String getName() {
        return name;
    }

    public Bild getPicture() {
        return picture;
    }

    public void remove(Knoten level) {
        level.entfernen(picture);
        level.entfernen(this);
    }
}
