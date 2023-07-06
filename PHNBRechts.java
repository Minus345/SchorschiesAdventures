import ea.Bild;
import ea.Knoten;

public class PHNBRechts extends Level
{
    private Knoten level;
    private Knoten boden;
    private Knoten lavaBoden;
    private Floor bod;
    private Door door1;

    public PHNBRechts()
    {
        super();
    }

    public void generate()
    {

    }
    public void generate(int x, int y)
    {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level ?: Pausenhof Neubau Rechts");
        Main.setLevelname("Neubau Pausenhof Rechts");
        Main.setText("");

        level = new Knoten();
        boden = new Knoten();
        lavaBoden = new Knoten();

        Bild background = new Bild(0, 0, 960, 400, "pictures/hintergrund/NPL.png");
        level.add(background);

        bod = new Floor(0, 400, 3000, level);
        boden.add(bod);
        
        door1 = new Door(830, 300, 100, 100, level);

        Main.getFrame().add(level);
        Main.getPlayer().setPosition(x, y);
    }

    public void isEPressed()
    {
        if (Main.getPlayer().schneidet(door1) && level.besitzt(door1))
        {
            System.out.println("Tür wurde geöffnet - Lade Lehrergarage");
            Main.getFrame().entfernen(level);
            Level level1 = new Lehrergarage();
            level1.generate(30,300);
        }
    }

    public void playerIsLeft()
    {
        Main.getFrame().entfernen(level);
        Level level1 = new PHNBLinks();
        level1.generate(900, (int) Main.getPlayer().getY());
    }

    @Override
    public Knoten getFloor()
    {
        return boden;
    }

    @Override
    public Knoten getLava()
    {
        return lavaBoden;
    }
}

