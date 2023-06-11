import ea.Bild;
import ea.Knoten;

/**
 * Level 1.
 *
 * @author Max
 * @version 2
 */
public class Debug1 extends Level {
    private Door door;
    private Knoten tuerRaum;
    private Lava lava;
    private Floor weg;
    private Floor plattform;
    private Chest chest;
    private Potion potion;
    private Key key;
    private Knoten level;
    private Knoten boden;
    private Knoten lavaBoden;
    private Npc1 npc1;

    public Debug1() {
        super();
    }

    public void generate() {
        Main.setAktiveLevel(this);
        System.out.println("Lade Debug 1");
        Main.setText("Debug 1");

        level = new Knoten();
        boden = new Knoten();
        lavaBoden = new Knoten();

        Bild background = new Bild(0, 0, 1000, 500, "pictures/hintergrund/hintergrund.png");
        level.add(background);

        weg = new Floor(0, 400, 800, level);
        boden.add(weg);

        plattform = new Floor(50, 300, 960, level);
        boden.add(plattform);

        lava = new Lava(100, level);
        lava.positionSetzen(450, 350);
        lavaBoden.add(lava);

        door = new Door(30, 350, 100, 100, level);

        chest = new Chest(250, 250, 100, 100, level);

        potion = new Potion(200, 280, 100, 100, level);

        key = new Key("bester Schluessel", 400, 280, 100, 100, level);

        npc1 = new Npc1(20, 20, 100, 100, level);

        Main.getFrame().add(level);
        if (Main.getPlayer() != null) Main.getPlayer().remove();
        if (Main.getPlayer() != null) Main.getPlayer().add();
    }

    @Override
    public void isEPressed() {
        if (Main.getPlayer().schneidet(door) && level.besitzt(door)) {
            System.out.println("tür wurde geöffnet - Nextes Level Laden");
            Inv.removeKey("bester Schluessel");
            Main.getFrame().entfernen(level);
            Level level2 = new Debug2();
            level2.generate();
        }
        if (Main.getPlayer().schneidet(chest) && level.besitzt(chest)) {
            System.out.println("Kiste wurde geöffnet");
            npc1.remove();
        }
        if (Main.getPlayer().schneidet(potion) && level.besitzt(potion)) {
            System.out.println("Der Trank wurde gefunden");
            Inv.setHasPotion(true);
            potion.remove();
            Inv.updateInv();
        }
        if (Main.getPlayer().schneidet(key) && level.besitzt(key)) {
            System.out.println("Der Schluesel wurde gefunden");
            key.remove();
            Inv.addKey(key);
        }
    }

    public Knoten getFloor() {
        return boden;
    }

    public Knoten getLava() {
        return lavaBoden;
    }
}
