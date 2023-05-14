import ea.Knoten;
import ea.Rechteck;

/**
 * @author Max
 * @version 2
 */
public class Floor extends Rechteck {
    private Knoten room;

    /**
     * creates a floor element
     */
    public Floor(Knoten room) {
        super(200, 25, 255, 25);
        this.room = room;
        farbeSetzen("grau");
        room.add(this);
    }

    /**
     * @param length length of the floor
     */
    public Floor(int x, int y, int length, Knoten room) {
        super(x, y, length, 25);
        this.room = room;
        farbeSetzen("grau");
        room.add(this);
    }
}
