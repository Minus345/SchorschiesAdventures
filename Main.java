import ea.Figur;
import ea.Game;
import ea.Knoten;

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
    private static Figur player;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        super(1920, 1080);
        frame = new Knoten();
        wurzel.add(frame);
        new L1().generate();
        Tick tick = new Tick();
        manager.anmelden(tick, 200);
        player = new Figur("mario.eaf");
        player.positionSetzen(200,200);
        frame.add(player);
        tastenReagierbarAnmelden(tick);
    }

    @Override
    public void tasteReagieren(int i) {

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

    public static Figur getPlayer() {
        return player;
    }
}
