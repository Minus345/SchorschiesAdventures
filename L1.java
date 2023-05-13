import ea.Bild;
import ea.Knoten;

/**
 * Level 1.
 *
 * @author Max
 * @version 2
 */
public class L1 extends Level {
    public L1() {
        super();
    }

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
        weg = new Floor(800);
        weg.positionSetzen(0, 400);
        level.add(weg);
        boden.add(weg);

        plattform = new Floor(400);
        plattform.positionSetzen(50, 300);
        level.add(plattform);
        boden.add(plattform);

        lava = new Lava(100);
        lava.positionSetzen(450, 350);
        level.add(lava);
        lavaBoden.add(lava);

        door = new Door(30, 350, 100, 100);
        level.add(door);
        level.add(door.getPicture());

        chest = new Chest(250, 250, 100, 100);
        level.add(chest);
        level.add(chest.getPicture());

        potion = new Potion(200, 280, 100, 100);
        level.add(potion);
        level.add(potion.getBild());

        key = new Key("bester Schluessel", 400, 280, 100, 100);
        level.add(key);
        level.add(key.getPicture());

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
            Level level2 = new L2();
            level2.generate();
        }
        if (Main.getPlayer().schneidet(chest) && level.besitzt(chest)) {
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
    public Knoten getFloor() {
        return boden;
    }

    @Override
    public Knoten getLava() {
        return lavaBoden;
    }
}
