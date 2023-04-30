
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
    private Potion potion;
    private Key key;


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

        potion = new Potion();
        potion.PositionSetzen(200,280);
        potion.NachHintenBringen();

        key = new Key("bester Schluessel");
        key.PositionSetzen(400,280);
        key.NachHintenBringen();
    }

    public void isEPressed() {
        if (Main.getPlayer().Berührt(tuer)) {
            System.out.println("tür wurde geöffnet - Nextes Level Laden");
            Inv.removeKey("bester Schluessel");
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
        if (Main.getPlayer().Berührt(potion)) {
            System.out.println("Der Trank wurde gefunden");
            Inv.setHasPotion(true);
            potion.remove();
            Inv.updateInv();
        }
        if (Main.getPlayer().Berührt(key)) {
            System.out.println("Der Schluesel wurde gefunden");
            key.remove();
            Inv.addKey(key);
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
