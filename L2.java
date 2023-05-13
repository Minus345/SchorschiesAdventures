import ea.Knoten;

/**
 * Level 2.
 *
 * @author Max
 * @version 2
 */
public class L2 extends Level {
    public L2() {
        super();
    }

    private Door door;
    private Floor weg;
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
        weg = new Floor(800);
        weg.positionSetzen(0, 400);
        level.add(weg);
        boden.add(weg);


        door = new Door(500,350,100,100);
        level.add(door);
        level.add(door.getPicture());

        Main.getFrame().add(level);
        Main.getPlayer().positionSetzen(200,200);

        if (Main.getPlayer() != null) Main.getPlayer().remove();
        if (Main.getPlayer() != null) Main.getPlayer().add();
    }

    public void isEPressed() {
        if (Main.getPlayer().schneidet(door)) {
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
    public Knoten getFloor() {
        return boden;
    }

    @Override
    public Knoten getLava() {
        return null;
    }
}

