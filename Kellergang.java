import ea.Bild;
import ea.Knoten;
import ea.Text;

/**
 * Kellergang
 *
 * @author Fynn
 */

public class Kellergang extends Level
{
    private Knoten level;
    private Knoten boden;
    private Knoten lavaBoden;
    private Floor bod;
    private Door door1;


    public Kellergang()
    {
        super();
    }

    public void generate()
    {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level ?: Kellergang");
        Main.setLevelname("Kellergang");

        level = new Knoten();
        boden = new Knoten();
        lavaBoden = new Knoten();

        door1 = new Door(880, 180, 100, 100, level);
        bod = new Floor(0, 400, 3000, level);
        boden.add(bod);

        Main.getFrame().add(level);
        if (Main.getPlayer() != null) Main.getPlayer().remove();
        if (Main.getPlayer() != null) Main.getPlayer().add();
        Main.getPlayer().positionSetzen(0, 300);
    }

    public void isEPressed()
    {
        if (Main.getPlayer().schneidet(door1) && level.besitzt(door1))
        {
            System.out.println("Tür wurde geöffnet - Nächstes Level Laden");
            Main.getFrame().entfernen(level);
            Level level1 = new PHNBLinks();
            level1.generate(430,350);
        }
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

