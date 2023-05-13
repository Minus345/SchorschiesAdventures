import ea.Rechteck;

/**
 * @author Max
 * @version 2
 */
public class Floor extends Rechteck {

    /**
     * creates a floor element
     */
    public Floor() {
        super(200, 25, 255, 25);
        farbeSetzen("grau");
    }

    /**
     * @param length length of the floor
     */
    public Floor(int length) {
        super(200, 25, length, 25);
        farbeSetzen("grau");
    }
}
