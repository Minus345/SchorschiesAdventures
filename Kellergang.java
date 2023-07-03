import ea.Bild;
import ea.Knoten;

/**
 * Kellergang
 *
 * @author Fynn
 */

public class Kellergang extends Level {
    private Knoten level;
    private Knoten boden;
    private Knoten lavaBoden;
    private Floor bod;
    private Floor Stufe1;
    private Floor Stufe2;
    private Floor Stufe3;
    private Floor Stufe4;
    private Floor Stufe5;
    private Floor Stufe6;
    private Door door1;


    public Kellergang() {
        super();
    }

    @Override
    public void generate() {

    }

    @Override
    public void generate(int x, int y) {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level ?: Kellergang");
        Main.setLevelname("Kellergang");
        Main.setText("");

        level = new Knoten();
        boden = new Knoten();
        lavaBoden = new Knoten();

        Bild background = new Bild(0, 0, 960, 720, "pictures/hintergrund/steinwand.png");
        level.add(background);

        door1 = new Door(885, 180, 100, 100, level);
        bod = new Floor(0, 400, 3000, level);
        Stufe1 = new Floor(710, 380, 250,level);
        Stufe2 = new Floor(750, 360, 250,level);
        Stufe3 = new Floor(790, 340, 250,level);
        Stufe4 = new Floor(830, 320, 250,level);
        Stufe5 = new Floor(870, 300, 250,level);
        Stufe6 = new Floor(910, 280, 250,level);
        boden.add(Stufe1);
        boden.add(Stufe2);
        boden.add(Stufe3);
        boden.add(Stufe4);
        boden.add(Stufe5);
        boden.add(Stufe6);
        boden.add(bod);

        Main.getFrame().add(level);
        if (Main.getPlayer() != null) Main.getPlayer().remove();
        if (Main.getPlayer() != null) Main.getPlayer().add();
        Main.getPlayer().positionSetzen(x, y);
    }

    public void isEPressed() {
        if (Main.getPlayer().schneidet(door1) && level.besitzt(door1)) {
            System.out.println("Tür wurde geöffnet - Lade Pausenhof Links");
            Main.getFrame().entfernen(level);
            Level level1 = new PHNBLinks();
            level1.generate(450, 300);
        }
    }

    public void playerIsLeft()
    {
        Main.getFrame().entfernen(level);
        Level level1 = new L0();
        level1.generate(300, 300);
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

