import ea.Rechteck;

/**
 * @author Max
 * @version 2
 */
public class Lava extends Rechteck {

    /**
     * creates lava
     */
    public Lava() {
        super(0, 0, 0, 0);
        breiteSetzen(200);
        hoeheSetzen(25);
        farbeSetzen("gelb");
    }

    /**
     * @param length length for the lava
     */
    public Lava(int length) {
        super(0, 0, 0, 0);
        breiteSetzen(length);
        hoeheSetzen(25);
        farbeSetzen("gelb");
    }

}
