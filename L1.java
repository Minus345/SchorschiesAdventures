import ea.Bild;
import ea.Knoten;

/**
 * Level 1.
 *
 * @author Max
 * @version 2
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
    private Knoten level;
    private Knoten boden;
    private Knoten lavaBoden;


    public void generate() {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level 1");
        Main.setText("Level 1");

        level = new Knoten();
        boden = new Knoten();
        lavaBoden = new Knoten();

        Bild background = new Bild(0,0,1000,500,"pictures/hintergrund.png");
        level.add(background);

        // Weg
        weg = new Stahltraeger(800);
        weg.positionSetzen(0, 400);
        level.add(weg);
        boden.add(weg);

        plattform = new Stahltraeger(400);
        plattform.positionSetzen(50, 300);
        level.add(plattform);
        boden.add(plattform);

        lava = new Lava(100);
        lava.positionSetzen(450, 350);
        level.add(lava);
        lavaBoden.add(lava);

        tuer = new Tuer(30, 350, 100, 100);
        //tuer.positionSetzen(30, 350);
        level.add(tuer);

        kiste = new Kiste();
        kiste.positionSetzen(250, 250);
        level.add(kiste);

        potion = new Potion();
        potion.positionSetzen(200, 280);
        level.add(potion);

        key = new Key("bester Schluessel");
        key.positionSetzen(400, 280);
        level.add(key);

        Main.getFrame().add(level);
    }

    @Override
    public void isEPressed() {
        if (Main.getPlayer().schneidet(tuer)) {
            System.out.println("tür wurde geöffnet - Nextes Level Laden");
            Inv.removeKey("bester Schluessel");
            Main.getFrame().entfernen(level);
            Level level2 = new L2();
            level2.generate();
        }
        if (Main.getPlayer().schneidet(kiste)) {
            System.out.println("Kiste wurde geöffnet");
        }
        if (Main.getPlayer().schneidet(potion)) {
            System.out.println("Der Trank wurde gefunden");
            Inv.setHasPotion(true);
            level.entfernen(potion);
            Inv.updateInv();
        }
        if (Main.getPlayer().schneidet(key)) {
            System.out.println("Der Schluesel wurde gefunden");
            level.entfernen(key);
            Inv.addKey(key);
        }
    }

    @Override
    public void playerIsRight() {

    }

    @Override
    public void playerIsLeft() {

    }

    @Override
    public Knoten getBoden() {
        return boden;
    }

    @Override
    public Knoten getLava() {
        return lavaBoden;
    }
}
