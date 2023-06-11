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

    /**
     * Main method where all starts
     * create all necessary objects
     */
    public Main() {
        super(960, 720);
        frame = new Knoten();
        wurzel.add(frame);

        subtitles = new Text("", 0, 450);
        subtitles.setzeFarbe("black");
        wurzel.add(subtitles);

        levelName = new Text("", 0, 0);
        levelName.setzeFarbe("black");
        wurzel.add(levelName);

        Inv.createInv();

        player = new Player(200, 200, 50, 50, frame);
        player.setPosition(0, 0);

        new Physikraum().generate();

        Tick tick = new Tick();
        manager.anmelden(tick, 50);
        tastenReagierbarAnmelden(tick);
        tastenLosgelassenReagierbarAnmelden(tick);

    }

    public static void main(String[] args) {
        new Main();
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

    /**
     * @param text the text for the subtitles for the story
     */
    public static void setText(String text)
    {
        subtitles.setzeInhalt(text);
    }

    public static void setLevelname(String text)
    {
        levelName.setzeInhalt(text);
    }

    /**
     * @param colour the colour for the subtitles for the story
     */
    public static void setSubtitleColour(String colour)
    {
        subtitles.setzeFarbe(colour);
    }

    public static void setLevelNameColour(String colour)
    {
        levelName.setzeFarbe(colour);
    }

    @Override
    public void tasteReagieren(int i) {
    }
}
