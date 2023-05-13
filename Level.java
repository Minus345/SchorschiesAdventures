import ea.Knoten;

/**
 * Beschreiben Sie hier die Klasse Level.
 *
 * @author Max
 * @version 1.0
 */
public abstract class Level {
    private boolean tuerOpend;
    private Knoten boden;
    private Knoten lava;

    public Level() {
        super();
    }

    /**
     * generates the level
     */
    public abstract void generate();

    /**
     * will be called wenn the player press "e"
     */
    public abstract void isEPressed();

    /**
     * will be called wenn the player is near the right boarder
     */
    public abstract void playerIsRight();

    /**
     * will be called wenn the player is near the left boarder
     */
    public abstract void playerIsLeft();

    /**
     * @return returns the "Knoten" floor, where all objekts, from the floor, are stored in
     */
    public abstract Knoten getFloor();

    /**
     * @return returns the "Knoten" lava, where all objekts, which are lava, are stored in
     */
    public abstract Knoten getLava();

}
