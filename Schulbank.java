import ea.Bild;
import ea.Knoten;
import ea.Rechteck;

/**
 * @author Fynn
 */
public class Schulbank extends Rechteck {

    private final Bild picture;
    private final Knoten room;

    /**
     * creates a chest and itÂ´s hitbox
     *
     * @param x      x-Coordinate
     * @param y      y-Coordinate
     * @param length length
     * @param height height
     */
    public Schulbank(int x, int y, int length, int height, Knoten room) {
        super(x, y, length, height);
        this.room = room;
        picture = new Bild(x, y, length, height, "pictures/Schulbank.png");
        this.sichtbarSetzen(false);
        room.add(this);
        room.add(picture);
    }

    public void remove() {
        room.entfernen(picture);
        room.entfernen(this);
    }
}
