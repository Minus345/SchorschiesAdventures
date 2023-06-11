import ea.Bild;
import ea.Knoten;
import ea.Text;

public class PHNBLinksvonPhy extends Level
{
    private Knoten level;
    private Knoten boden;
    private Knoten lavaBoden;
    private Floor bod;
    private Door door1;
    private Door door2;

    public PHNBLinksvonPhy()
    {
        super();
    }

    public void generate()
    {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level ?: Pausenhof Neubau Links");
        Main.setLevelname("Neubau Pausenhof Links");

        level = new Knoten();
        boden = new Knoten();
        lavaBoden = new Knoten();

        door1 = new Door(430, 300, 100, 100, level);
        door2 = new Door(5, 300, 100, 100, level);
        bod = new Floor(0, 400, 3000, level);
        boden.add(bod);

        Main.getFrame().add(level);
        if (Main.getPlayer() != null) Main.getPlayer().remove();
        if (Main.getPlayer() != null) Main.getPlayer().add();
        Main.getPlayer().positionSetzen(25, 350);
    }

    public void isEPressed()
    {
        if (Main.getPlayer().schneidet(door1) && level.besitzt(door1))
        {
            System.out.println("Tür wurde geöffnet - Nächstes Level Laden");
            Main.getFrame().entfernen(level);
            Level level1 = new Kellergang();
            level1.generate();
        }

        if (Main.getPlayer().schneidet(door2) && level.besitzt(door2))
        {
            System.out.println("Tür wurde geöffnet - Nächstes Level Laden");
            Main.getFrame().entfernen(level);
            Level level2 = new Physikraum();
            level2.generate();
        }

    }

    public void playerIsRight()
    {
        Main.getFrame().entfernen(level);
        Level level3 = new PHNBRechts();
        level3.generate();
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

