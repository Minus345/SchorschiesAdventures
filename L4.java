import ea.Knoten;
import ea.Bild;
import ea.Text;
/**
 * Beschreiben Sie hier die Klasse L4.
 *
 * @author Kevin
 * @version (eine Versionsnummer oder ein Datum)
 */
public class L4 extends Level {
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Knoten level;
    private Knoten boden;
    private Door door;
    private Floor weg;
    private Knoten lavaBoden;
    private Loldea npc2;
    private int geredet=0;
     private Text story1;
    private Text story2;
    private Text story3;
    private Text story4;
    private Text story5;
    private Text story6;
    private Text story7;
   
    public L4() {
        super();
    }
     @Override
    public void generate()
    {
        
    }
    @Override

    public void generate(int x,int y) {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level 4: A14(1)");
        Main.setText("Altbau Raum A14");
        Main.setLevelname("L4");

        level = new Knoten();
        boden = new Knoten();
        
        Bild background = new Bild(0, 0, 960, 400, "pictures/hintergrund/H0.png");
        level.add(background); 

        door = new Door(480, 300, 100, 100, level);

        weg = new Floor(0, 400, 1280, level);
        boden.add(weg);

        npc2 = new Loldea(100, 180, 200, 250, level);

        Main.getFrame().add(level);
        Main.getPlayer().setPosition(x, y);
    }

    @Override
    public void isEPressed() {
        if (Main.getPlayer().schneidet(door)) {
            System.out.println("Tür wurde geöffnet - Nextes Level Laden");

            Main.getFrame().entfernen(level);
            Level level1 = new L1();
            level1.generate(320,300);
        }
        
        if (Main.getPlayer().schneidet(npc2)&&level.besitzt(npc2)&&geredet==0&&!Inv.hasPotion)
        {
            story1 = new Text("Was haben ein Mercedes-Mechaniker und  ", 20, 500);
            story2 = new Text("ein Astronom gemeinsam? Beide hängen ständig unterm großen Wagen!", 20, 540);
            story1.farbeSetzen("weiss");
            story2.farbeSetzen("weiss");
            level.add(story1);
            level.add(story2);
            geredet = 1;
            return; 
        }
        if (Main.getPlayer().schneidet(npc2)&&level.besitzt(npc2)&&geredet==1&&!Inv.hasPotion)
        {   
            level.entfernen(story1);
            level.entfernen(story2);
            story3 = new Text("Haha, Moment mal.", 20, 500);
            story4 = new Text("Warum hast du nicht über meinen Witz gelacht... Verschwinde!", 20, 540);
            story3.farbeSetzen("weiss");
            story4.farbeSetzen("weiss");
            level.add(story3);
            level.add(story4);
            geredet = 2;
            return; 
        }
        if (Main.getPlayer().schneidet(npc2)&&level.besitzt(npc2)&&Inv.hasPotion)
        {
            level.entfernen(story3);
            level.entfernen(story4);
            story5 = new Text("Was- ist- passiert....", 20, 500);
            story6 = new Text("Ich verändere mit meinen Astronomischen Fähigkeiten den Stand des Mondes.", 20, 540);
            story5.farbeSetzen("weiss");
            story6.farbeSetzen("weiss");
            level.add(story5);
            level.add(story6);
            geredet = 3;
            Inv.setHasPotion(false);
            return; 
        }
        if (Main.getPlayer().schneidet(npc2)&&level.besitzt(npc2)&&geredet==3)
        {
            level.entfernen(story5);
            level.entfernen(story6);
            story7 = new Text("Drücke E um das Spiel zu beenden", 20, 500);
            
            story7.farbeSetzen("weiss");
           
            level.add(story7);
            ;
            geredet = 4;
            return; 
        }
        if( Main.getPlayer().schneidet(npc2)&&level.besitzt(npc2)&&geredet==4)
        {
            Main.getFrame().entfernen(level);
            Level level1 = new EndeLoldea();
            level1.generate(300, 300);
        }
    }


    @Override
    public Knoten getFloor() {
        return boden;
    }

    @Override
    public Knoten getLava() {
        return lavaBoden;
    }

}

