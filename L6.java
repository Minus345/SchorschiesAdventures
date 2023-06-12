import ea.Knoten;
/**
 * Beschreiben Sie hier die Klasse L4.
 * 
 * @author Kevin
 * @version (eine Versionsnummer oder ein Datum)
 */
public class L6 extends Level
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
  private Knoten level;
  private Knoten boden;
  private Door door;
  private Floor weg;
  private Knoten lavaBoden;
  

    /**
     * Konstruktor für Objekte der Klasse L4
     */
    public L6()
    {
        super();
    }

    public void generate() {
        Main.setAktiveLevel(this);
        System.out.println("Lade Level 4: A12");
        Main.setText("Altbau Raum A12");

        level = new Knoten();
        boden = new Knoten();

        
        door = new Door(480, 300, 100, 100, level);

        weg = new Floor(0, 400, 1280, level);
        boden.add(weg);

        Main.getFrame().add(level);
        if (Main.getPlayer() != null) Main.getPlayer().remove();
        if (Main.getPlayer() != null) Main.getPlayer().add();
    }

    @Override
    public void isEPressed() 
    {
        if (Main.getPlayer().schneidet(door))
        {
            System.out.println("Tür wurde geöffnet - Nextes Level Laden");
            
            Main.getFrame().entfernen(level);
            Level level3 = new L3();
            level3.generate();
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
