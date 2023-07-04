import ea.Bild;
import ea.Knoten;
import ea.Text;

/**
 * Physikraum
 *
 * @author Fynn
 */
public class Physikraum extends Level 
{
    private Door door1;
    private Floor Stufe1;
    private Floor Stufe2;
    private Floor Stufe3;
    private Floor Stufe4;
    private Floor Stufe5;
    private Floor Stufe6;
    private Floor Stufe7;
    private Schulbank Schulbank;
    private Schulbank Schulbank1;
    private Schulbank Schulbank2;
    private Schulbank Schulbank3;
    private Schulbank Schulbank4;
    private Potion potion;
    private Knoten level;
    private Knoten boden;
    private Knoten lavaBoden;
    private Rieger npc1;
    private Text story1;
    private Text story2;
    private Text story3;
    private Text story4;
    private int geredet = 0;

    public Physikraum() 
    {
        super();
    }

    public void generate() 
    {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level ?: Physikraum");
        Main.setLevelname("Physikraum");
        Main.setText("Viele Schrecken haben hier stattgefunden...");

        level = new Knoten();
        boden = new Knoten();
        lavaBoden = new Knoten();

        Bild background = new Bild(0, 0, 960, 720, "pictures/hintergrund/physikraum.png");
        level.add(background);

        npc1 = new Rieger(1, 188, 140, 215, level);

        door1 = new Door(880, 180, 100, 100, level);
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
        Schulbank = new Schulbank(450, 220, 120, 120, level);
        Schulbank1 = new Schulbank(300, 240, 120, 120, level);
        Schulbank2 = new Schulbank(600, 200, 120, 120, level);
        Schulbank3 = new Schulbank(750, 180, 120, 120, level);
        Schulbank4 = new Schulbank(150, 260, 120, 120, level);
        Main.getFrame().add(level);
        Main.getPlayer().setPosition(910, 230);
    }

    @Override
    public void isEPressed() {
        if (Main.getPlayer().schneidet(door1) && level.besitzt(door1)) 
        {
            System.out.println("Tür wurde geöffnet - Nächstes Level Laden");
            Main.getFrame().entfernen(level);
            Level level1 = new PHNBLinks();
            level1.generate(25,300);
        }

        if (Main.getPlayer().schneidet(npc1) && level.besitzt(npc1) && geredet == 0) 
        {
            story1 = new Text("Servus, du brauchst einen Trank um die Lehrer wieder in ihren ", 20, 500);
            story2 = new Text("alten Zustand zurück zu versetzen.", 20, 540);
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
            story3 = new Text("Ich hätte schwören können ich habe ihn irgendwo in diesem Raum gesehen", 20, 500);
            story4 = new Text("Vielleicht durchsuchst du mal die Schulbänke, viel Erfolg!", 20, 540);
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

        if (Main.getPlayer().schneidet(Schulbank) && level.besitzt(Schulbank)) 
        {
            System.out.println("Du hast die Schulbank durchsucht");
            Inv.setHasPotion(true);
            Inv.updateInv();
            Main.setText("Du hast hier einen Trank gefunden, hoffen wir, dass das der Richtige ist");
        }

        if (Main.getPlayer().schneidet(Schulbank1) && level.besitzt(Schulbank1)) 
        {
            System.out.println("Du hast die Schulbank durchsucht");
            Main.setText("Nichts war dort außer ein paar alter Kaugummis");
        }

        if (Main.getPlayer().schneidet(Schulbank2) && level.besitzt(Schulbank2)) 
        {
            System.out.println("Du hast die Schulbank durchsucht");
            Main.setText("Ihhh was ist das? Ach eigentlich willst du es garnicht so genau wissen");
        }

        if (Main.getPlayer().schneidet(Schulbank3) && level.besitzt(Schulbank3)) 
        {
            System.out.println("Du hast die Schulbank durchsucht");
            Main.setText("Wer hat diese Popel hier unten dran geschmiert? Ekelhaft");
        }

        if (Main.getPlayer().schneidet(Schulbank4) && level.besitzt(Schulbank4)) 
        {
            System.out.println("Du hast die Schulbank durchsucht");
            Main.setText("Alles was hier zu finden war ist eine alte Physikschulaufgabe");
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