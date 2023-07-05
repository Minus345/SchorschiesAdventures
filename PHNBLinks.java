import ea.Bild;
import ea.Knoten;

public class PHNBLinks extends Level
{
    private Knoten level;
    private Knoten boden;
    private Knoten lavaBoden;
    private Floor bod;
    private Door door1;
    private Door door2;

    public PHNBLinks()
    {
        super();
    }

    public void generate()
    {

    }
    public void generate(int x, int y)
    {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level ?: Pausenhof Neubau Links");
        Main.setLevelname("Neubau Pausenhof Links");
        Main.setText("Du hörst Eulen schreien");

        level = new Knoten();
        boden = new Knoten();
        lavaBoden = new Knoten();

        Bild background = new Bild(0, 0, 960, 400, "pictures/hintergrund/NPR.png");
        level.add(background);

        door1 = new Door(430, 300, 100, 100, level);
        door2 = new Door(5, 300, 100, 100, level);
        bod = new Floor(0, 400, 3000, level);
        boden.add(bod);

        Main.getFrame().add(level);
        Main.getPlayer().setPosition(x, y);
    }

    public void isEPressed()
    {
        if (Main.getPlayer().schneidet(door1) && level.besitzt(door1))
        {
            System.out.println("Tür wurde geöffnet - Lade Kellergang");
            Main.getFrame().entfernen(level);
            Level level1 = new Kellergang();
            level1.generate(910,230);
            return;
        }

        if (Main.getPlayer().schneidet(door2) && level.besitzt(door2))
        {
            System.out.println("Tür wurde geöffnet - Lade Physikraum");
            Main.getFrame().entfernen(level);
            Level level2 = new Physikraum();
            level2.generate();
            return;
        }

    }

    public void playerIsRight()
    {
        Main.getFrame().entfernen(level);
        Level level3 = new PHNBRechts();
        level3.generate(1, (int) Main.getPlayer().getY());
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


