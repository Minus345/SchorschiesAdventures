import ea.Bild;
import ea.Knoten;
import ea.Rechteck;

/**
 * @author Fynn
 * @version 2
 */
public class Schulbank extends Chest {

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
        super(x,y, length, height, room);
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
