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

    /**
     * Konstruktor für Objekte der Klasse Level
     */
    public Level() {
        super();
    }

    /**
     * generiert das Level
     */
    public abstract void generate();

    /**
     * wird vom Player aufgerufen, wenn er "e" drückt
     */
    public abstract void isEPressed();

    /**
     * wird vom Player aufgerufen, wenn er am rechten Rand ist
     */
    public abstract void playerIsRight();

    /**
     * wird vom Player aufgerufen, wenn er am linken Rand ist
     */
    public abstract void playerIsLeft();

    public abstract Knoten getBoden();

    public abstract Knoten getLava();

}
