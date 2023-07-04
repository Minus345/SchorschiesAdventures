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
    private static Player playerTemp;
    private static boolean runningAnimation;

    /**
     * Main method where all starts
     * create all necessary objects
     */
    public Main(String animation) {
        super(960, 720);
        if (animation.equals("active")){
            runningAnimation = true;
            System.out.println("running animation enabled");
        }else{
            runningAnimation = false;
            System.out.println("running animation disabled");
        }

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

        Tick tick = new Tick();
        manager.anmelden(tick, 50);
        tastenReagierbarAnmelden(tick);
        tastenLosgelassenReagierbarAnmelden(tick);

        new Intro().generate(100, 300);

    }

    public static void main(String[] args) {
        new Main(args[0]);
    }

    public static Knoten getFrame() {
        return frame;
    }

    public static Level getAktiveLevel() {
        return aktiveLevel;
    }

    public static void setAktiveLevel(Level aktiveLevel) {
        Main.aktiveLevel = aktiveLevel;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Main.player = player;
    }

    public static Player getPlayerTemp() {
        return playerTemp;
    }

    /**
     * @param text the text for the subtitles for the story
     */
    public static void setText(String text) {
        subtitles.setzeInhalt(text);
    }

    public static void setLevelname(String text) {
        levelName.setzeInhalt(text);
    }

    /**
     * @param colour the colour for the subtitles for the story
     */
    public static void setTextColour(String colour) {
        subtitles.setzeFarbe(colour);
    }

    public static void setLevelNameColour(String colour) {
        levelName.setzeFarbe(colour);
    }

    @Override
    public void tasteReagieren(int i) {
    }

    public static boolean isRunningAnimation() {
        return runningAnimation;
    }

    public static void setRunningAnimation(boolean runningAnimation) {
        Main.runningAnimation = runningAnimation;
    }

    public static void warte(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
