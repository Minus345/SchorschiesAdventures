import ea.Bild;
import ea.Knoten;
import ea.Raum;
import ea.Rechteck;

public class Player extends Rechteck {

    private final Bild picture;
    private final Knoten room;

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

    public Bild getPicture() {
        return picture;
    }

    public void setPosition(float x, float y) {
        this.positionSetzen(x,y);
        picture.positionSetzen(x,y);
    }

    public void add() {
        room.add(this);
        room.add(picture);
    }
    public void remove() {
        room.entfernen(this);
        room.entfernen(picture);
    }

}
