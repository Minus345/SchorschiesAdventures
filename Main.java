import ea.Game;
import ea.Knoten;
import ea.Text;

/**
 * Beschreiben Sie hier die Klasse Main.
 *
 * @author Max
 * @version 2
 */

public class Main extends Game {
    private static Knoten frame;
    private static boolean running;
    private static Level aktiveLevel;
    private static Player player;
    private static Text subtitles;
    private static Text debugText;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        super(1920, 1080);
        //this.sicherheitsFrage("Schorschies Adventure");
        //this.nachrichtSchicken("Starting");
        //this.mausAnmelden(new Maus(3));
        frame = new Knoten();
        wurzel.add(frame);

        subtitles = new Text("Text", 0, 450);
        wurzel.add(subtitles);

        debugText = new Text("Debug", 0, 0);
        wurzel.add(debugText);

        Inv.createInv();

        new L1().generate();

        //player = new Figur("mario.eaf");
        player = new Player(200, 200, 50, 50, frame);
        player.setPosition(0,0);

        Tick tick = new Tick();
        manager.anmelden(tick, 50);
        tastenReagierbarAnmelden(tick);
        tastenLosgelassenReagierbarAnmelden(tick);

    }

    @Override
    public void tasteReagieren(int i) {

    }

    public static void removePlayer() {
        player.remove();
    }

    public static void addPlayer() {
        player.add();
    }

    public static Knoten getFrame() {
        return frame;
    }

    public static boolean isRunning() {
        return running;
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

    public static void setText(String text) {
        subtitles.setzeInhalt(text);
    }
}
