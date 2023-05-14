import ea.Bild;
import ea.Knoten;
import ea.Rechteck;

/**
 * @author Max
 * @version 2
 */
public class Chest extends Rechteck {

    private final Bild picture;
    private final Knoten room;

    /**
     * creates a chest and it´s hitbox
     *
     * @param x      x-Coordinate
     * @param y      y-Coordinate
     * @param length length
     * @param height height
     */
    public Chest(int x, int y, int length, int height, Knoten room) {
        super(x, y, length, height);
        this.room = room;
        picture = new Bild(x, y, length, height, "pictures/kiste.png");
        this.sichtbarSetzen(false);
        room.add(this);
        room.add(picture);
    }


    public void remove() {
        room.entfernen(picture);
        room.entfernen(this);
    }
}
