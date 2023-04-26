
/**
 * Level 1.
 *
 * @author Max
 * @version 1
 */
public class L1 extends Level {
    /**
     * Konstruktor für Objekte der Klasse L1
     */
    public L1() {
        super();
    }

    /**
     * Generiert die Map
     */

    private Tuer tuer;
    private Lava lava;
    private Stahltraeger weg;
    private Stahltraeger plattform;
    private Kiste kiste;


    public void genereiere() {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level 1");
        // Weg
        weg = new Stahltraeger(800);
        weg.PositionSetzen(0, 400);
        weg.NachHintenBringen();

        plattform = new Stahltraeger(400);
        plattform.PositionSetzen(50, 300);
        plattform.NachHintenBringen();

        lava = new Lava(100);
        lava.PositionSetzen(450, 350);
        lava.NachHintenBringen();

        tuer = new Tuer();
        tuer.PositionSetzen(30, 350);
        tuer.NachHintenBringen();

        kiste = new Kiste();
        kiste.PositionSetzen(250,250);
        kiste.NachHintenBringen();
    }

    public void isEPressed() {
        if (Main.getPlayer().Berührt(tuer)) {
            System.out.println("tür wurde geöffnet - Nextes Level Laden");
            tuer.remove();
            lava.remove();
            weg.remove();
            kiste.remove();
            plattform.remove();
            Level level = new L2();
            level.genereiere();
        }
        if (Main.getPlayer().Berührt(kiste)) {
            System.out.println("Kiste wurde geöffnet");
        }
    };

    public void playerIsRight() {
        System.out.println("Rechter Rand");
    }

    @Override
    public void playerIsLeft() {

    }

    @Override
    void TaktImpulsAusführen() {

    }
}
