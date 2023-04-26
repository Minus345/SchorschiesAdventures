
/**
 * Beschreiben Sie hier die Klasse Level.
 * 
 * @author Max
 * @version 1.0
 */
public abstract class Level extends Ereignisbehandlung
{

    private boolean tuerOpend;

    /**
     * Konstruktor für Objekte der Klasse Level
     */
    public Level()
    {
        super();
    }

    /**
     * generiert das Level
     */
    public abstract void genereiere();

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
}
