import ea.Knoten;

/**
 * Level 1.
 *
 * @author Max
 * @version 2
 */
public class L1 extends Level {
    /**
     * Konstruktor für Objekte der Klasse L1
     */
    public L1() {
        super();
    }

    /**
     * Generiert die Map
     */

    private Tuer tuer;
    private Lava lava;
    private Stahltraeger weg;
    private Stahltraeger plattform;
    private Kiste kiste;
    private Potion potion;
    private Key key;
    private Knoten level;


    public void generate() {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level 1");
        level = new Knoten();
        // Weg
        weg = new Stahltraeger(800);
        weg.positionSetzen(0, 400);
        level.add(weg);

        plattform = new Stahltraeger(400);
        plattform.positionSetzen(50, 300);
        level.add(plattform);

        lava = new Lava(100);
        lava.positionSetzen(450, 350);
        level.add(lava);

        tuer = new Tuer();
        tuer.positionSetzen(30, 350);
        level.add(tuer);

        kiste = new Kiste();
        kiste.positionSetzen(250,250);
        level.add(kiste);

        potion = new Potion();
        potion.positionSetzen(200,280);
        level.add(potion);

        key = new Key("bester Schluessel");
        key.positionSetzen(400,280);
        level.add(key);

        Main.getFrame().add(level);
    }

    @Override
    public void isEPressed() {

    }

    @Override
    public void playerIsRight() {

    }

    @Override
    public void playerIsLeft() {

    }
}
