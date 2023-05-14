import ea.Knoten;
import ea.Rechteck;

/**
 * @author Max
 * @version 2
 */
public class Lava extends Rechteck {
    private Knoten room;

    /**
     * creates lava
     */
    public Lava(Knoten room) {
        super(0, 0, 0, 0);
        this.room = room;
        breiteSetzen(200);
        hoeheSetzen(25);
        farbeSetzen("gelb");
        room.add(this);
    }

    /**
     * @param length length for the lava
     */
    public Lava(int length, Knoten room) {
        super(0, 0, 0, 0);
        breiteSetzen(length);
        hoeheSetzen(25);
        farbeSetzen("gelb");
        room.add(this);
    }

}
