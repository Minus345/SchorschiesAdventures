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
    private final Rechteck rightHitBox;
    private final Rechteck leftHitBox;
    private final int hight;
    private final int length;

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
        positionSetzen(0, 0);
        room.add(this);

        rightHitBox = new Rechteck(x, y, (float) length / 2, (float) height / 2);
        rightHitBox.farbeSetzen("gruen");
        room.add(rightHitBox);
        leftHitBox = new Rechteck(x, y, (float) length / 2, (float) height / 2);
        leftHitBox.farbeSetzen("blau");
        room.add(leftHitBox);

        this.sichtbarSetzen(false);
        rightHitBox.sichtbarSetzen(false);
        leftHitBox.sichtbarSetzen(false);

        this.hight = height;
        this.length = length;

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
        rightHitBox.positionSetzen(x + (float) length / 2, y + (float) this.hight / 4);
        leftHitBox.positionSetzen(x, y + (float) this.hight / 4);
    }

    /**
     * adds the player and the hitbox to the room
     */
    public void add() {
        room.add(this);
        room.add(picture);
        room.add(rightHitBox);
        room.add(leftHitBox);
    }

    /**
     * removes the player and the hitbox to the room
     */
    public void remove() {
        room.entfernen(this);
        room.entfernen(picture);
        room.entfernen(rightHitBox);
        room.entfernen(leftHitBox);
    }

    public Rechteck getRightHitBox() {
        return rightHitBox;
    }

    public Rechteck getLeftHitBox() {
        return leftHitBox;
    }
}
