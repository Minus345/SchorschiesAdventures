
import ea.Bild;
import ea.Knoten;
import ea.Text;

/**
 * Beschreiben Sie hier die Klasse L4.
 *
 * @author Kevin
 * @version (eine Versionsnummer oder ein Datum)
 */
public class L7 extends Level {
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Knoten level;
    private Knoten boden;
    private Door door;
    private Floor weg;
    private Knoten lavaBoden;
    private NPCGöder npc2;
    private Text story1;
    private Text story2;
    private Text story3;
    private Text story4;
    private Text story5;
    private Text story6;
    private Text story7;
    private int geredet;

    /**
     * Konstruktor für Objekte der Klasse L4
     */
    public L7() {
        super();
    }

    @Override
    public void generate() {

    }

    @Override

    public void generate(int x, int y) {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level 4: A11");
        Main.setText("Altbau Raum A11");
        Main.setLevelname("L7");
        geredet = 0;

        level = new Knoten();
        boden = new Knoten();

        Bild background = new Bild(0, 0, 960, 400, "pictures/hintergrund/H0.png");
        level.add(background);
        door = new Door(480, 300, 100, 100, level);

        weg = new Floor(0, 400, 1280, level);
        boden.add(weg);
        npc2 = new NPCGöder(600, 300, 100, 200, level);

        Main.getFrame().add(level);
        Main.getPlayer().setPosition(x, y);
    }

    @Override
    public void isEPressed() {
        if (Main.getPlayer().schneidet(door)) {
            System.out.println("Tür wurde geöffnet - Nextes Level Laden");

            Main.getFrame().entfernen(level);
            Level level3 = new L3();
            level3.generate(640, 300);
        }
        if (Main.getPlayer().schneidet(npc2) && level.besitzt(npc2) && geredet == 0 && !Inv.hasPotion) {
            story1 = new Text("Salve servus! Dein triceps brachii", 20, 500);
            story2 = new Text("schaut nicht so aus als hättest du viel manus pila gespielt.", 20, 540);
            story1.farbeSetzen("weiss");
            story2.farbeSetzen("weiss");
            level.add(story1);
            level.add(story2);
            geredet = 1;
            return;
        }
        if (Main.getPlayer().schneidet(npc2) && level.besitzt(npc2) && geredet == 1 && !Inv.hasPotion) {
            level.entfernen(story1);
            level.entfernen(story2);
            story3 = new Text("Was hattest du etwa kein Latein?", 20, 500);
            story4 = new Text("Abire!", 20, 540);
            story3.farbeSetzen("weiss");
            story4.farbeSetzen("weiss");
            level.add(story3);
            level.add(story4);
            geredet = 2;
            return;
        }
        if (Main.getPlayer().schneidet(npc2) && level.besitzt(npc2) && Inv.hasPotion) {
            level.entfernen(story3);
            level.entfernen(story4);
            story5 = new Text("Oha, der Trank hat besser funktioniert als mein Microsoft", 20, 500);
            story6 = new Text("Surface, ich spreche einfach mit den Lehrern auf Latein, dann kommen wir hier raus.", 20, 540);
            story5.farbeSetzen("weiss");
            story6.farbeSetzen("weiss");
            level.add(story5);
            level.add(story6);
            geredet = 3;
            Inv.setHasPotion(false);
            return;
        }
        if (Main.getPlayer().schneidet(npc2) && level.besitzt(npc2) && geredet == 3) {
            level.entfernen(story5);
            level.entfernen(story6);
            story7 = new Text("Drücke E um das Spiel zu beenden", 20, 500);

            story7.farbeSetzen("weiss");

            level.add(story7);

            geredet = 4;
            return;
        }
        if (Main.getPlayer().schneidet(npc2) && level.besitzt(npc2) && geredet == 4) {
            Main.getFrame().entfernen(level);
            Level level1 = new EndeGoldie();
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
