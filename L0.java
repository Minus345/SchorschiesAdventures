import ea.Bild;
import ea.Knoten;

/**
 * Level 0: Anfangslevel
 *
 * @author
 */
public class L0 extends Level {
    private Door door1;
    private Door door2;
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

    // Konstruktor
    public L0() {
        super();
    }

    @Override
    public void generate() {
    }

    @Override
    public void generate(int x, int y) {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level 0: Startlevel");
        Main.setText("Kellergewölbe");

        level = new Knoten();
        boden = new Knoten();
        lavaBoden = new Knoten();

        door1 = new Door(30, 350, 100, 100, level);
        door2 = new Door(130, 350, 100, 100, level);

        chest = new Chest(250, 340, 100, 100, level);

        weg = new Floor(0, 400, 800, level);
        boden.add(weg);

        Main.getFrame().add(level);
        if (Main.getPlayer() != null) Main.getPlayer().remove();
        if (Main.getPlayer() != null) Main.getPlayer().add();
        Main.getPlayer().positionSetzen(x, y);
    }

    @Override
    public void isEPressed() {
        if (Main.getPlayer().schneidet(door1) && level.besitzt(door1)) {
            if (Inv.hasKey("Kellerschluessel")) {
                System.out.println("Tür wurde geöffnet - Nextes Level Laden");
                Inv.removeKey("Kellerschluessel");
                Main.getFrame().entfernen(level);
                Level level1 = new L1();
                level1.generate(100, 300);
            } else {
                System.out.println("Tür verschlossen.");
            }
        }
        if (Main.getPlayer().schneidet(door2) && level.besitzt(door2)) {
            if (Inv.hasKey("Kellerschluessel")) {
                System.out.println("Das Schloss scheint verbogen... Der Schlüssel passt nicht.");
            }

            if (Inv.hasKey("Schlüssel")) {
                Main.getFrame().entfernen(level);
                Level levelnew = new Kellergang();
                levelnew.generate(1, 350);
            } else {
                System.out.println("Tür ist verschlossen");
            }
        }
        if (Main.getPlayer().schneidet(chest) && level.besitzt(chest)) {
            System.out.println("Kiste wurde geöffnet");
            Inv.addKey(new Key("Kellerschluessel", 0, 0, 0, 0, level));
            System.out.println("Kellerschlüssel gefunden!");
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
