import ea.Bild;
import ea.Knoten;
import ea.Text;

public class Tutorial extends Level
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
    private Text story7;
    private Text story8;
    private Text story9;
    private Text story10;
    private Text story11;

    public Tutorial()
    {
        super();
    }

    public void generate()
    {

    }

    public void generate(int x, int y)
    {
        Main.setAktiveLevel(this);
        System.out.println("Lade Tutorial");
        Main.setLevelname("Tutorial");
        Main.setText("");

        level = new Knoten();
        boden = new Knoten();
        lavaBoden = new Knoten();

        story1 = new Text("Zusätzlich ist heute Vollmond... Das kann nichts gutes heißen...", 60, 100);
        story2 = new Text("Alle Lehrer sind durch den Fluch des Mondes verzaubert.", 60, 140);
        story3 = new Text("Vermeintliche Freunde sind deine Feinde, und Lehrer, die du lieber", 60, 180);
        story4 = new Text("meiden würdest sind deine Verbündeten. Sei vorsichtig auf deinem Weg durch ", 60, 220);
        story5 = new Text("das Schulgebäude. Vielleicht findest du etwas, um dich und die Lehrer zu ", 60, 260);
        story6 = new Text("retten, bevor die totale Mondfinsternis eintritt, und die Mächte des ", 60, 300);
        story7 = new Text("Bösen das  Schulhaus in Trümmer reißen. Viel Erfolg bei deinem Abenteuer!", 60, 340);
        story8 = new Text("Willkommen bei Schorschies Adventure!", 260, 420);
        story9 = new Text("Steuere mit (A) und (S). Springe mit (W). Interagiere mit (E).", 220, 460);
        story10 = new Text("Drücke (E), um zu beginnen. Viel Spaß!", 260, 500);
        story1.farbeSetzen("weiss");
        story2.farbeSetzen("weiss");
        story3.farbeSetzen("weiss");
        story4.farbeSetzen("weiss");
        story5.farbeSetzen("weiss");
        story6.farbeSetzen("weiss");
        story7.farbeSetzen("weiss");
        story8.farbeSetzen("weiss");
        story9.farbeSetzen("weiss");
        story10.farbeSetzen("weiss");
        level.add(story1);
        level.add(story2);
        level.add(story3);
        level.add(story4);
        level.add(story5);
        level.add(story6);
        level.add(story7);
        level.add(story8);
        level.add(story9);
        level.add(story10);

        Main.getFrame().add(level);
    }

    public void isEPressed()
    {
        Main.getFrame().entfernen(level);
        Level level1 = new L0();
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

