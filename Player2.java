import ea.Bild;
import ea.Knoten;
import ea.Rechteck;
import ea.Game;
/**
 * Beschreiben Sie hier die Klasse Player2.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Player2 extends Rechteck{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    protected final Bild picture;
    protected final Knoten room;
    protected final Rechteck rightHitBox;
    protected final Rechteck leftHitBox;
    protected final int hight;
    protected final int length;

    /**
     * Konstruktor für Objekte der Klasse Player2
     */
   public Player2(int x, int y, int length, int height, Knoten room) {
        super(x, y, length, height);
        this.room = room;
        picture = new Bild(x, y, length, height, "pictures/animation/1.png");
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
