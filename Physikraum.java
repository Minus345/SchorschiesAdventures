import ea.Bild;
import ea.Knoten;

/**
 * Physikraum
 */
public class Physikraum extends Level
{
    private Door door1;
    private Knoten tuerRaum;
    private Floor Stufe1;
    private Floor Stufe2;
    private Floor Stufe3;
    private Floor Stufe4;
    private Floor Stufe5;
    private Floor Stufe6;
    private Floor Stufe7;
    private Schulbank Schulbank;
    private Potion potion;
    private Knoten level;
    private Knoten boden;
    private Knoten lavaBoden;

    public Physikraum()
    {
        super();
    }

    public void generate()
    {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level ?: Physikraum");
        Main.setText("Physikraum");

        level = new Knoten();
        boden = new Knoten();
        lavaBoden = new Knoten();

        Bild background = new Bild(0, 0, 1000, 500, "pictures/physikraum.png");
        level.add(background);

        door1 = new Door(880,180 , 100, 100, level);
        Stufe1 = new Floor(0, 400, 3000, level);
        Stufe2 = new Floor(150, 380, 3000, level);
        Stufe3 = new Floor(300, 360, 3000, level);
        Stufe4 = new Floor(450, 340, 3000, level);
        Stufe5 = new Floor(600, 320, 3000, level);
        Stufe6 = new Floor(750, 300, 3000, level);
        Stufe7 = new Floor(900, 280, 3000, level);
        boden.add(Stufe1);
        boden.add(Stufe2);
        boden.add(Stufe3);
        boden.add(Stufe4);
        boden.add(Stufe5);
        boden.add(Stufe6);
        boden.add(Stufe7);
        Schulbank = new Schulbank(450, 240, 100, 100, level);

        Main.getFrame().add(level);
        if (Main.getPlayer() != null) Main.getPlayer().remove();
        if (Main.getPlayer() != null) Main.getPlayer().add();
    }

    @Override
    public void isEPressed()
    {
        if (Main.getPlayer().schneidet(door1) && level.besitzt(door1))
        {
            System.out.println("Tür wurde geöffnet - Nächstes Level Laden");
            Main.getFrame().entfernen(level);
            Level level1 = new L0();
            level1.generate();
        }

        if (Main.getPlayer().schneidet(Schulbank) && level.besitzt(Schulbank))
        {
            System.out.println("Du hast die Schulbank durchsucht");
            Inv.setHasPotion(true);
            Inv.updateInv();
            System.out.println("Du hast hier einen Trank gefunden, was der wohl macht?");
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