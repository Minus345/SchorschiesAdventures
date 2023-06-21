import ea.Knoten;

/**
 * Beschreiben Sie hier die Klasse L3.
 * 
 * @author Kevin
 * @version (eine Versionsnummer oder ein Datum)
 */
public class L3 extends Level
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Knoten level;
    private Knoten boden;
    private Door door1;
    private Door door2;
    private Floor Weg;
    private Knoten lavaBoden;

    /**
     * Konstruktor für Objekte der Klasse L3
     */
    public L3()
    {
        // Instanzvariable initialisieren
        super();
    }

    @Override
    public void generate()
    {
        
    }
    @Override
    public void generate(int x, int y) {

        Main.setAktiveLevel(this);
        System.out.println("Lade Level 3: Altbaugang(2)");
        Main.setText("Altbaugang");
        level = new Knoten();
        boden = new Knoten();

        door1 = new Door(320, 300, 100, 100, level);
        door2 = new Door(640, 300, 100, 100, level);

        Weg = new Floor(0, 400, 1280, level);
        boden.add(Weg);

        Main.getFrame().add(level);
        if (Main.getPlayer() != null) Main.getPlayer().remove();
        if (Main.getPlayer() != null) Main.getPlayer().add();
        Main.getPlayer().positionSetzen(x, y);
    }

    @Override
    public void isEPressed() 
    {
        if (Main.getPlayer().schneidet(door1))
        {
            System.out.println("Tür wurde geöffnet - Nextes Level Laden");

            Main.getFrame().entfernen(level);
            Level level6 = new L6();
            level6.generate(480,350);
        }
        if (Main.getPlayer().schneidet(door2))
        {
            System.out.println("Tür wurde geöffnet - Nextes Level Laden");

            Main.getFrame().entfernen(level);
            Level level7 = new L7();
            level7.generate(480,350);
        }
    }

    @Override
    public void playerIsLeft() 
    {
        Main.getFrame().entfernen(level);
        Level level3 = new L1();
        level3.generate(900,350);
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
