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
    private Text story5;
    private Text story6;
    private Text story7;
    private Text story8;
    private Text story9;
    private Text story10;
    private Text story11;
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
        Main.setText("Es riecht nach Benzin");

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
        Main.getPlayer().setPosition(x, y);
    }

    public void isEPressed()
    {
        if (Main.getPlayer().schneidet(door1) && level.besitzt(door1))
        {
            System.out.println("Tür wurde geöffnet - Lade PHNBRechts");
            Main.getFrame().entfernen(level);
            Level level1 = new PHNBRechts();
            level1.generate(830, 300);
        }

        if (Main.getPlayer().schneidet(npc1) && level.besitzt(npc1) && !Inv.hasPotion && geredet == 0) 
        {
            story1 = new Text("System.Out.println(''Java... BlueJ... *murmel*", 20, 500);
            story2 = new Text("muss programmieren...", 20, 540);
            story1.farbeSetzen("weiss");
            story2.farbeSetzen("weiss");
            level.add(story1);
            level.add(story2);
            geredet = 1;
            return;
        }

        if (geredet == 1) 
        {
            level.entfernen(story1);
            level.entfernen(story2);
            story3 = new Text("Schüler! Nachschrift! Ich kriege dich!'');", 20, 500);
            story4 = new Text("*streckt Hände aus und greift nach dir*", 20, 540);
            story3.farbeSetzen("weiss");
            story4.farbeSetzen("weiss");
            level.add(story3);
            level.add(story4);
            geredet = 2;
            return;
        }

        if (geredet == 2) 
        {
            level.entfernen(story3);
            level.entfernen(story4);
            geredet = 3;
            return;
        }

        if (Main.getPlayer().schneidet(npc1) && level.besitzt(npc1) && Inv.hasPotion) 
        {
            story5 = new Text("*puff* ... System.Out.println('' Wo bin ich?", 20, 500);
            story6 = new Text("Was machst du hier? Was ist passiert?", 20, 540);
            story7 = new Text("Wieso bin ich in der Garage?'');", 20, 580);
            story5.farbeSetzen("weiss");
            story6.farbeSetzen("weiss");
            story7.farbeSetzen("weiss");
            level.add(story5);
            level.add(story6);
            level.add(story7);
            geredet = 4;
            return;
        }

        if (geredet == 4) 
        {
            level.entfernen(story5);
            level.entfernen(story6);
            level.entfernen(story7);
            story8 = new Text("System.Out.println:(''Komm, wir sollten hier", 20, 500);
            story9 = new Text("so schnell wie möglich raus! Ich hacke das", 20, 540);
            story10 = new Text("Garagentor, dann können wir entkommen!'');", 20, 580);
            story8.farbeSetzen("weiss");
            story9.farbeSetzen("weiss");
            story10.farbeSetzen("weiss");
            level.add(story8);
            level.add(story9);
            level.add(story10);
            geredet = 5;
            return;
        }

        if (geredet == 5)
        {
            level.entfernen(story8);
            level.entfernen(story9);
            level.entfernen(story10);
            story11 = new Text("Drücke E, um das Spiel zu beenden", 60, 550);
            story11.farbeSetzen("weiss");
            level.add(story11);
            geredet = 6;
            return;
        }

        if (geredet == 6)
        {
            Main.getFrame().entfernen(level);
            Level level1 = new EndeWaldrich();
            level1.generate(300, 300);
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

