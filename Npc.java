import ea.Bild;
import ea.Knoten;
import ea.Rechteck;
import ea.Text;

/**
 * Klass for the npc, with Methods for setting the position and removing the npc with it´s hitbox, picture and name
 *
 * @author max
 * @version 2
 */
public abstract class Npc extends Rechteck {
    private final Bild picture;
    private final Knoten room;
    private Text name;

    /**
     * creates a Nec with a hitbox (Rechteck)
     *
     * @param x      x-Coordinate of the npc and it´s hitbox
     * @param y      y-Coordinate of the npc and it´s hitbox
     * @param length length of the npc and it´s hitbox
     * @param height height of the npc and it´s hitbox
     * @param room   the room where they will be placed in
     * @param path   the path to the picture of the npc
     * @param name   the display name of the npc
     */
    public Npc(int x, int y, int length, int height, Knoten room, String path, String name) {
        super(x, y, length, height);
        this.room = room;
        this.picture = new Bild(x, y, length, height, path); // path to picture
        farbeSetzen("rot");
        this.name = new Text(name, x, y);
        this.name.farbeSetzen("rot");
        this.sichtbarSetzen(false);
        room.add(this);
        room.add(picture);
        room.add(this.name);
        positionSetzen(x, y);
    }

    /**
     * overrides the "positionSetzen" method form the "Rechteck" klass, so that the hitbox, the picture and the text are moved
     *
     * @param x x-Coordinate
     * @param y y-Coordinate
     */
    @Override
    public void positionSetzen(float x, float y) {
        super.positionSetzen(x, y);
        picture.positionSetzen(x, y);
        name.positionSetzen(x, y);
    }

    /**
     * removes the hitbox, picture and name from the screen
     */
    public void remove() {
        room.entfernen(this);
        room.entfernen(picture);
        room.entfernen(name);
    }
}
