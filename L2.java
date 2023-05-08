import ea.Knoten;
import ea.Raum;

/**
 * Level 1.
 *
 * @author Max
 * @version 1
 */
public class L2 extends Level {
    /**
     * Konstruktor für Objekte der Klasse L2
     */
    public L2() {
        super();
    }

    private Tuer tuer;
    private Stahltraeger weg;
    private Knoten level;
    private Knoten boden;

    @Override
    public void generate() {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level 2");
        Main.setText("Level 2");

        level = new Knoten();
        boden = new Knoten();
        // Weg
        weg = new Stahltraeger(800);
        weg.positionSetzen(0, 400);
        level.add(weg);
        boden.add(weg);


        tuer = new Tuer(500,350,100,100);
        level.add(tuer);
        level.add(tuer.getBild());

        Main.getFrame().add(level);
        Main.getPlayer().positionSetzen(200,200);

        if (Main.getPlayer() != null) Main.removePlayer();
        if (Main.getPlayer() != null) Main.addPlayer();
    }

    public void isEPressed() {
        if (Main.getPlayer().schneidet(tuer)) {
            System.out.println("tür wurde geöffnet - Nextes Level Laden");
            Main.getFrame().entfernen(level);
            Level level1 = new L1();
            level1.generate();
        }
    }


    public void playerIsRight() {

    }

    public void playerIsLeft() {

    }

    @Override
    public Knoten getBoden() {
        return boden;
    }

    @Override
    public Knoten getLava() {
        return null;
    }
}

