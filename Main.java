/**
 * Jump 'n' Run-Spiel mit dem Protagonisten Dorian
 *
 * @author Johannes Neumeyer
 * @version 1.0
 */

public class Main extends Ereignisbehandlung {
    private static boolean running;
    private static Level aktiveLevel;
    private static Player player;

    public static void main(String[] args){
        new Main();
    }
    public Main() {
        super();
        running = true;

        Text text = new Text();
        text.TextSetzen("← a | d →: Gehen     w : Springen");
        text.PositionSetzen(300, 500);

        TaktdauerSetzen(50);

        Starten();

        Level l1 = new L1();
        l1.genereiere();

        player = new Player();
        player.ZumStartpunktGehen();
        player.GanzNachVornBringen();

        Inv.createInv();
    }


    /**
     * Mitverantwortlich für die Steuerung von Dorian
     */
    @Override
    void TaktImpulsAusführen() {
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
}
