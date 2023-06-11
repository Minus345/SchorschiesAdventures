import ea.Knoten;

/**
 * The Superclass level
 *
 * @author Max
 * @version 1.0
 */
public abstract class Level {
    public Level() {
        super();
    }

    /**
     * generates the level
     */
    public abstract void generate();

    /**
     * will be called when the player presses "e"
     */
    public abstract void isEPressed();

    /**
     * will be called wenn the player is near the right boarder
     */
    public void playerIsRight(){
        Main.getPlayer().setPosition(900, Main.getPlayer().getY());
    }

    /**
     * will be called wenn the player is near the left boarder
     */
    public  void playerIsLeft(){
        Main.getPlayer().setPosition(0, Main.getPlayer().getY());
    }

    /**
     * @return returns the "Knoten" floor, where all objekts, from the floor, are stored in
     */
    public abstract Knoten getFloor();

    /**
     * @return returns the "Knoten" lava, where all objekts, which are lava, are stored in
     */
    public abstract Knoten getLava();

}
