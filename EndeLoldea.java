import ea.Bild;
import ea.Knoten;
import ea.Text;

public class EndeLoldea extends Level
{
    private Knoten level;
    private Knoten boden;
    private Knoten lavaBoden;
    private Text story1;
    private Text story2;
    private Text story3;
    private Text story4;

    public EndeLoldea()
    {
        super();
    }

    public void generate()
    {

    }

    public void generate(int x, int y)
    {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level ?: EndeLoldea");
        Main.setLevelname("Ende 3/4");
        Main.setText("");

        level = new Knoten();
        boden = new Knoten();
        lavaBoden = new Knoten();

        story1 = new Text("Du hast es geschafft! Herzlichen Glückwunsch!", 100, 480);
        story2 = new Text("Du konntest dem Fluch entkommen und hast es aus dem HLG geschafft", 100, 520);
        story3 = new Text("Dies ist nur eins von vier möglichen Enden, die du erreichen kannst", 100, 560);
        story4 = new Text("Wenn es dir nicht gefällt, spiele einfach nochmal!", 100, 600);
        story1.farbeSetzen("weiss");
        story2.farbeSetzen("weiss");
        story3.farbeSetzen("weiss");
        story4.farbeSetzen("weiss");
        level.add(story1);
        level.add(story2);
        level.add(story3);
        level.add(story4);

        Main.getFrame().add(level);
        if (Main.getPlayer() != null) Main.getPlayer().remove();
        if (Main.getPlayer() != null) Main.getPlayer().add();
        Main.getPlayer().remove();
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

