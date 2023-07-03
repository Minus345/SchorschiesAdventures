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
        Main.setPlayer(new Player(200, 200, 100, 100, Main.getFrame()));
        Main.setAktiveLevel(this);
        System.out.println("Lade Level 0: Startlevel");
        Main.setLevelname("Kellergewölbe");
        Main.setText("Du hörst Ratten und ein Tropfen");

        level = new Knoten();
        boden = new Knoten();
        lavaBoden = new Knoten();

        door1 = new Door(30, 300, 100, 100, level);
        door2 = new Door(250, 300, 100, 100, level);

        chest = new Chest(550, 340, 100, 100, level);

        weg = new Floor(0, 400, 960, level);
        boden.add(weg);

        Main.getFrame().add(level);
        if (Main.getPlayer() != null) Main.getPlayer().remove();
        if (Main.getPlayer() != null) Main.getPlayer().add();
        Main.getPlayer().setPosition(x, y);
    }

    @Override
    public void isEPressed() {
        if (Main.getPlayer().schneidet(door2) && level.besitzt(door2)) {
            if (Inv.hasKey("Schlüssel")) {
                Main.getFrame().entfernen(level);
                Level levelnew = new Kellergang();
                levelnew.generate(1, 300);
                return;
            } else {
                Main.setText("Tür verschlossen");
            }
            if (Inv.hasKey("Kellerschluessel")) {
                Main.setText("Der Schlüssel passt nicht");
            }
        }
        if (Main.getPlayer().schneidet(chest) && level.besitzt(chest)) {
            if (!Inv.hasKey("Kellerschlüssel"))
            {
                Main.setText("Kiste wurde geöffnet: Kellerschlüssel gefunden!");
                Inv.addKey(new Key("Kellerschlüssel", 0, 0, 0, 0, level));
            }
            else
            {
                Main.setText("Du hast diese Kiste bereits geöffnet");
            }
        }
        if (Main.getPlayer().schneidet(door1) && level.besitzt(door1)) {
            if (Inv.hasKey("Kellerschlüssel")) {
                System.out.println("Tür wurde geöffnet - Nextes Level Laden");
                Main.getFrame().entfernen(level);
                Level level1 = new L1();
                level1.generate(100, 300);
            } else {
                Main.setText("Tür verschlossen");
            }
        }
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
