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

    /**
     * Main method where all starts
     * create all necessary objects
     */
    public Main() {
        super(1208, 720);
        //this.sicherheitsFrage("Schorschies Adventure");
        //this.nachrichtSchicken("Starting");
        //this.mausAnmelden(new Maus(3));
        frame = new Knoten();
        wurzel.add(frame);

        subtitles = new Text("Text", 0, 450);
        wurzel.add(subtitles);

        Text debugText = new Text("Debug V2", 0, 0);
        wurzel.add(debugText);

        Inv.createInv();

        new L1().generate();

        player = new Player(200, 200, 50, 50, frame);
        player.setPosition(0, 0);

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
    public static void setText(String text) {
        subtitles.setzeInhalt(text);
    }

    @Override
    public void tasteReagieren(int i) {
    }
}
