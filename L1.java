import ea.Bild;
import ea.Knoten;

/**
 * Beschreiben Sie hier die Klasse L1.
 *
 * @author Kevin
 * @version (eine Versionsnummer oder ein Datum)
 */
public class L1 extends Level {
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen

    private Door door1;
    private Door door2;
    private Knoten tuerRaum;
    private Floor weg;
    private Knoten level;
    private Knoten boden;
    private Knoten lavaBoden;

    // Konstruktor
    public L1() {
        super();
    }
    
    @Override
    public void generate()
    {
        
    }

    @Override
    public void generate(int x, int y) {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level 2: Altbaugang(1)");
        Main.setText("Altbaugang");
        Main.setLevelname("L1");

        level = new Knoten();
        boden = new Knoten();

        Bild background = new Bild(0, 0, 960, 400, "pictures/hintergrund/H0.png");
        level.add(background);

        door1 = new Door(320, 300, 100, 100, level);
        door2 = new Door(640, 300, 100, 100, level);

        weg = new Floor(0, 400, 1280, level);
        boden.add(weg);
        
        

        Main.getFrame().add(level);
        Main.getPlayer().setPosition(x, y);
    }

    @Override
    public void isEPressed() {
        if (Main.getPlayer().schneidet(door1)) {
            System.out.println("Tür wurde geöffnet - Nextes Level Laden");

            Main.getFrame().entfernen(level);
            Level level4 = new L4();
            level4.generate(480,300);
        }
        if (Main.getPlayer().schneidet(door2)) {
            System.out.println("Tür wurde geöffnet - Nextes Level Laden");

            Main.getFrame().entfernen(level);
            Level level5 = new L5();
            level5.generate(480,300);
        }
    }

    @Override
    public void playerIsRight() {
        Main.getFrame().entfernen(level);
        Level level3 = new L3();
        level3.generate(100,300);
    }

    @Override
    public void playerIsLeft() {
        Main.getFrame().entfernen(level);
        Level level0 = new L0();
        level0.generate(100,300);
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

