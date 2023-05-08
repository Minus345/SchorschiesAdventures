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
    private Knoten tuerRaum;
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

        Bild background = new Bild(0, 0, 1000, 500, "pictures/hintergrund.png");
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
        level.add(tuer);
        level.add(tuer.getBild());

        kiste = new Kiste(250, 250, 100, 100);
        level.add(kiste);
        level.add(kiste.getBild());

        potion = new Potion(200, 280, 100, 100);
        level.add(potion);
        level.add(potion.getBild());

        key = new Key("bester Schluessel", 400, 280, 100, 100);
        level.add(key);
        level.add(key.getBild());

        Main.getFrame().add(level);
        if (Main.getPlayer() != null) Main.removePlayer();
        if (Main.getPlayer() != null) Main.addPlayer();
    }

    @Override
    public void isEPressed() {
        if (Main.getPlayer().schneidet(tuer) && level.besitzt(tuer)) {
            System.out.println("tür wurde geöffnet - Nextes Level Laden");
            Inv.removeKey("bester Schluessel");
            Main.getFrame().entfernen(level);
            Level level2 = new L2();
            level2.generate();
        }
        if (Main.getPlayer().schneidet(kiste) && level.besitzt(kiste)) {
            System.out.println("Kiste wurde geöffnet");
        }
        if (Main.getPlayer().schneidet(potion) && level.besitzt(potion)) {
            System.out.println("Der Trank wurde gefunden");
            Inv.setHasPotion(true);
            potion.remove(level);
            Inv.updateInv();
        }
        if (Main.getPlayer().schneidet(key) && level.besitzt(key)) {
            System.out.println("Der Schluesel wurde gefunden");
            key.remove(level);
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
