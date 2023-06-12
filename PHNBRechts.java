import ea.Bild;
import ea.Knoten;
import ea.Text;

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

        level = new Knoten();
        boden = new Knoten();
        lavaBoden = new Knoten();

        bod = new Floor(0, 400, 3000, level);
        boden.add(bod);

        Main.getFrame().add(level);
        if (Main.getPlayer() != null) Main.getPlayer().remove();
        if (Main.getPlayer() != null) Main.getPlayer().add();
        Main.getPlayer().positionSetzen(x, y);
    }

    public void isEPressed()
    {

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
