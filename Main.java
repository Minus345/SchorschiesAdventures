import ea.Game;
import ea.Knoten;
import ea.Text;

/**
 * @author Max
 * @version 2
 */

public class Main extends Game {
    private static Knoten frame;
    private static Level aktiveLevel;
    private static Player player;
    private static Text subtitles;
    private static Text levelName;
    private static boolean runningAnimation;

    /**
     * Main method where all starts
     * create all necessary objects
     */
    public Main() {
        super(960, 720);

        runningAnimation = true;
        System.out.println("running animation enabled");

        frame = new Knoten();
        wurzel.add(frame);

        subtitles = new Text("", 0, 450);
        subtitles.setzeFarbe("weiss");
        wurzel.add(subtitles);

        levelName = new Text("", 0, 0);
        levelName.setzeFarbe("weiss");
        wurzel.add(levelName);

        Inv.createInv();


        //player = new Player(100, 100, 100, 100, frame);
        //new L7().generate(300, 300);
        //Inv.setHasPotion(true);


        Tick tick = new Tick();
        manager.anmelden(tick, 50);
        tastenReagierbarAnmelden(tick);
        tastenLosgelassenReagierbarAnmelden(tick);

        new Intro().generate(100, 300);

    }

    /**
     * Main method to start
     *
     * @param args - "active" -> to start with player animation
     */
    public static void main(String[] args) {
        new Main();
    }

    /**
     * returns the active Frame
     *
     * @return
     */
    public static Knoten getFrame() {
        return frame;
    }

    /**
     * return the active Level
     *
     * @return
     */
    public static Level getAktiveLevel() {
        return aktiveLevel;
    }

    /**
     * sets the aktive Level so it can be displayed
     *
     * @param aktiveLevel
     */
    public static void setAktiveLevel(Level aktiveLevel) {
        Main.aktiveLevel = aktiveLevel;
    }

    /**
     * reruns the active Player
     *
     * @return
     */
    public static Player getPlayer() {
        return player;
    }

    /**
     * sets the active player
     * there should only be one player
     *
     * @param player
     */
    public static void setPlayer(Player player) {
        Main.player = player;
    }

    /**
     * @param text the text for the subtitles for the story
     */
    public static void setText(String text) {
        subtitles.setzeInhalt(text);
    }

    /**
     * sets the level name
     *
     * @param text
     */
    public static void setLevelname(String text) {
        levelName.setzeInhalt(text);
    }

    /**
     * @param colour the colour for the subtitles for the story so that it can be changed when the background ist not black
     */
    public static void setTextColour(String colour) {
        subtitles.setzeFarbe(colour);
    }

    /**
     * a
     *
     * @param colour the colour for the subtitles for the story so that it can be changed when the background ist not black
     */
    public static void setLevelNameColour(String colour) {
        levelName.setzeFarbe(colour);
    }

    /**
     * the parameter for the player animation
     * if it´s true the animation is aktiv
     *
     * @return
     */
    public static boolean isRunningAnimation() {
        return runningAnimation;
    }

    /**
     * sets the running animation for the player
     *
     * @param runningAnimation
     */
    public static void setRunningAnimation(boolean runningAnimation) {
        Main.runningAnimation = runningAnimation;
    }

    @Override
    public void tasteReagieren(int i) {
    }

}
