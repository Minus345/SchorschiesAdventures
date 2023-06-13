import ea.Knoten;

/**
 * Beschreiben Sie hier die Klasse L4.
 *
 * @author Kevin
 * @version (eine Versionsnummer oder ein Datum)
 */
public class L5 extends Level {
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Knoten level;
    private Knoten boden;
    private Door door;
    private Floor weg;
    private Knoten lavaBoden;
    private Chest chest;


    public L5() {
        super();
    }
 @Override
    public void generate()
    {
        
    }
    @Override
    public void generate(int x,int y) {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level 5: A13");
        Main.setText("Altbau Raum A13");

        level = new Knoten();
        boden = new Knoten();


        door = new Door(480, 300, 100, 100, level);

        chest = new Chest(100, 335, 100, 100, level);

        weg = new Floor(0, 400, 1280, level);
        boden.add(weg);

        Main.getFrame().add(level);
        if (Main.getPlayer() != null) Main.getPlayer().remove();
        if (Main.getPlayer() != null) Main.getPlayer().add();
        Main.getPlayer().positionSetzen(x, y);
    }

    @Override
    public void isEPressed() {
        if (Main.getPlayer().schneidet(door)) {
            System.out.println("Tür wurde geöffnet - Nextes Level Laden");

            Main.getFrame().entfernen(level);
            Level level1 = new L1();
            level1.generate(640,350);
        }
        if (Main.getPlayer().schneidet(chest) && !Inv.hasKey("Schlüssel")) {
            System.out.println("Kiste wurde geöffnet, Schlüssel erhalten");
            Inv.addKey(new Key("Schlüssel", 0, 0, 0, 0, level));

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

