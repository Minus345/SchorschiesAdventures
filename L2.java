
/**
 * Level 1.
 *
 * @author Max
 * @version 1
 */
public class L2 extends Level {
    /**
     * Konstruktor für Objekte der Klasse L2
     */
    public L2() {
        super();
    }

    /**
     * Generiert die Map
     */

    private Tuer tuer;
    private Stahltraeger weg;


    public void genereiere() {
        Main.setAktiveLevel(this);
        Main.getPlayer().GanzNachVornBringen();
        System.out.println("Lade Level 2");
        // Weg
        weg = new Stahltraeger(800);
        weg.NachHintenBringen();
        weg.PositionSetzen(0, 400);

        tuer = new Tuer();
        tuer.NachHintenBringen();
        tuer.PositionSetzen(500,350);
    }

    public void isEPressed() {
        if (Main.getPlayer().Berührt(tuer)) {
            System.out.println("tür wurde geöffnet - Nextes Level Laden");
            weg.remove();
            tuer.remove();
            Level level = new L1();
            level.genereiere();
        }
    }


    public void playerIsRight() {

    }

    public void playerIsLeft() {

    }
}

