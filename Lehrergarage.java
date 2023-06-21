import ea.Bild;
import ea.Knoten;
import ea.Text;

public class Lehrergarage extends Level
{
    private Knoten level;
    private Knoten boden;
    private Knoten lavaBoden;
    private Floor bod;
    private Door door1;
    private Heidrich npc1;
    private Text story1;
    private Text story2;
    private Text story3;
    private Text story4;
    private int geredet = 0;

    public Lehrergarage()
    {
        super();
    }

    public void generate()
    {

    }

    public void generate(int x, int y)
    {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level ?: Lehrergarage");
        Main.setLevelname("Lehrergarage");

        level = new Knoten();
        boden = new Knoten();
        lavaBoden = new Knoten();

        bod = new Floor(0, 400, 3000, level);
        boden.add(bod);

        door1 = new Door(30, 300, 100, 100, level);

        npc1 = new Heidrich(760, 205, 140, 215, level);
        
        Main.getFrame().add(level);
        if (Main.getPlayer() != null) Main.getPlayer().remove();
        if (Main.getPlayer() != null) Main.getPlayer().add();
        Main.getPlayer().positionSetzen(x, y);
    }

    public void isEPressed()
    {
        if (Main.getPlayer().schneidet(door1) && level.besitzt(door1))
        {
            System.out.println("Tür wurde geöffnet - Lade PHNBRechts");
            Main.getFrame().entfernen(level);
            Level level1 = new PHNBRechts();
            level1.generate(830, 350);
        }
        
        if (Main.getPlayer().schneidet(npc1) && level.besitzt(npc1)) 
        {
            //Text text text => s. Physikraum
        }
        
        if (Main.getPlayer().schneidet(npc1) && level.besitzt(npc1) && Inv.hasPotion) 
        {
            //Verwandlung, text text text => s. Physikraum
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

