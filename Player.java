import ea.Bild;
import ea.Knoten;
import ea.Rechteck;


/**
 * Klass for the player, with Methods for setting the position, add and removing the player
 *
 * @author max
 * @version 2
 */
public class Player extends Rechteck {

    private final Bild picture;
    private final Knoten room;

    /**
     * Creates the player and it´s hitbox ("Rechteck")
     *
     * @param x      x-Coordinate of the player and it´s hitbox
     * @param y      y-Coordinate of the player and it´s hitbox
     * @param length the length of the player and it´s hitbox
     * @param height the height of the player and it´s hitbox
     * @param room   the "Knoten" where the player and the hitbox needs to be added in
     */
    public Player(int x, int y, int length, int height, Knoten room) {
        super(x, y, length, height);
        this.room = room;
        picture = new Bild(x, y, length, height, "pictures/axolotl klein.png");
        farbeSetzen("rot");
        //this.sichtbarSetzen(false);
        positionSetzen(0, 0);
        room.add(this);
        room.add(picture);
    }

    /**
     * sets the position for the player and the hitbox
     *
     * @param x x-Coordinate
     * @param y Y-Coordinate
     */
    public void setPosition(float x, float y) {
        this.positionSetzen(x, y);
        picture.positionSetzen(x, y);
    }

    /**
     * adds the player and the hitbox to the room
     */
    public void add() {
        room.add(this);
        room.add(picture);
    }

    /**
     * removes the player and the hitbox to the room
     */
    public void remove() {
        room.entfernen(this);
        room.entfernen(picture);
    }

}
