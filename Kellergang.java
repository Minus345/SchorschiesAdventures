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

        bod = new Floor(0, 400, 3000, level);
        boden.add(bod);

        Main.getFrame().add(level);
        if (Main.getPlayer() != null) Main.getPlayer().remove();
        if (Main.getPlayer() != null) Main.getPlayer().add();
        Main.getPlayer().positionSetzen(0, 300);
    }

    public void isEPressed()
    {

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

}
