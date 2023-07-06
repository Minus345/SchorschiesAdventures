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

    private Bild picture;
    private Bild[] arrayr;
    private Bild[] arrayl;
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
        picture = new Bild(x, y, length, height, "pictures/animation/1r.png");
        arrayr = new Bild[6];
        arrayr[0] = new Bild(x, y, length, height, "pictures/animation/1r.png");
        arrayr[1] = new Bild(x, y, length, height, "pictures/animation/2r.png");
        arrayr[2] = new Bild(x, y, length, height, "pictures/animation/3r.png");
        arrayr[3] = new Bild(x, y, length, height, "pictures/animation/4r.png");
        arrayr[4] = new Bild(x, y, length, height, "pictures/animation/5r.png");
        arrayr[5] = new Bild(x, y, length, height, "pictures/animation/6r.png");

        arrayl = new Bild[6];
        arrayl[0] = new Bild(x, y, length, height, "pictures/animation/1.png");
        arrayl[1] = new Bild(x, y, length, height, "pictures/animation/2.png");
        arrayl[2] = new Bild(x, y, length, height, "pictures/animation/3.png");
        arrayl[3] = new Bild(x, y, length, height, "pictures/animation/4.png");
        arrayl[4] = new Bild(x, y, length, height, "pictures/animation/5.png");
        arrayl[5] = new Bild(x, y, length, height, "pictures/animation/6.png");


        this.sichtbarSetzen(false);
        farbeSetzen("rot");
        positionSetzen(0, 0);
        room.add(this);

        rightHitBox = new Rechteck(x, y, (float) length / 2, (float) height / 2);
        rightHitBox.farbeSetzen("gruen");
        room.add(rightHitBox);
        leftHitBox = new Rechteck(x, y, (float) length / 2, (float) height / 2);
        leftHitBox.farbeSetzen("blau");
        room.add(leftHitBox);

        rightHitBox.sichtbarSetzen(false);
        leftHitBox.sichtbarSetzen(false);

        this.hight = height;
        this.length = length;

        room.add(picture);
    }

    /**
     * sets the picture vor the animation Rechts
     */
    public void setPictureRechts(int x) {
        room.entfernen(picture);
        this.picture = arrayr[x];
        picture.positionSetzen(Main.getPlayer().getX(), Main.getPlayer().getY());
        room.add(picture);
    }

    /**
     * sets the picture vor the animation Rechts
     */
    public void setPictureLinks(int x) {
        room.entfernen(picture);
        this.picture = arrayl[x];
        picture.positionSetzen(Main.getPlayer().getX(), Main.getPlayer().getY());
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
        //setPictureRechts(0);
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

    /**
     * returns the right Hitbox
     * @return
     */
    public Rechteck getRightHitBox() {
        return rightHitBox;
    }

    /**
     * returns the left Hitbox
     * @return
     */
    public Rechteck getLeftHitBox() {
        return leftHitBox;
    }
}
