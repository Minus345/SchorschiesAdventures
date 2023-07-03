import ea.Bild;
import ea.Knoten;
import ea.Text;

public class Intro extends Level
{
    private Knoten level;
    private Knoten boden;
    private Knoten lavaBoden;
    private Text story1;
    private Text story2;
    private Text story3;
    private Text story4;
    private Text story5;
    private Text story6;

    public Intro()
    {
        super();
    }

    public void generate()
    {

    }

    public void generate(int x, int y)
    {
        Main.setAktiveLevel(this);
        System.out.println("Lade Intro");
        Main.setLevelname("Intro");
        Main.setText("");

        level = new Knoten();
        boden = new Knoten();
        lavaBoden = new Knoten();

        story1 = new Text("Es ist Freitag Nachmittag. Du sitzt in deiner Informatik Nachschrift bei", 60, 100);
        story2 = new Text("deiner Lieblingslehrerin, Frau Waldrich. Zu ihrer Enttäuschung hast du jedoch", 60, 140);
        story3 = new Text("nicht gelernt, weshalb du dich im Keller versteckst, bis die Zeit vorbei ist,", 60, 180);
        story4 = new Text("um nicht mitschreiben zu müssen", 60, 220);
        story5 = new Text("Du schläfst ein. Das klicken eines Schlosses weckt dich. Du bist eingesperrt!", 60, 260);
        story6 = new Text("Drücke (E), um fortzufahren.", 260, 320);
        story1.farbeSetzen("weiss");
        story1.farbeSetzen("weiss");
        story2.farbeSetzen("weiss");
        story3.farbeSetzen("weiss");
        story4.farbeSetzen("weiss");
        story5.farbeSetzen("weiss");
        story6.farbeSetzen("weiss");
        level.add(story1);
        level.add(story2);
        level.add(story3);
        level.add(story4);
        level.add(story5);
        level.add(story6);

        Main.getFrame().add(level);
    }

    public void isEPressed()
    {
        Main.getFrame().entfernen(level);
        Level level1 = new Tutorial();
        level1.generate(300, 300);
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

