import ea.TastenLosgelassenReagierbar;
import ea.TastenReagierbar;
import ea.Ticker;

public class Tick implements Ticker, TastenReagierbar, TastenLosgelassenReagierbar {

    private int springenCounter;
    private boolean jumpWeiter;
    private boolean jumpIntoSealing;
    private int jumpCounter;
    private boolean w;
    private boolean a;
    private boolean d;


    public void tick() {
        //wenn nichts unter dir ist dann nach unten fallen (nicht springen)
        if (!Main.getPlayer().schneidet(Main.getAktiveLevel().getBoden()) && !jumpWeiter) {
            Main.getPlayer().positionSetzen(Main.getPlayer().getX(), Main.getPlayer().getY() + 8);
            springenCounter = 0;
        }

        if (Main.getAktiveLevel().getLava() != null && Main.getPlayer().schneidet(Main.getAktiveLevel().getLava())) { //berührung mit Lava
            //stoppen();
            System.out.println("in Lava gefallen");
        }

        if (jumpWeiter) {
            jumpCounter++;
            //Wenn Player vom Boden weg ist und gegen die Decke stöst
            if (jumpCounter > 10 && isJumpIntoSealing()) {
                Main.getPlayer().positionSetzen(Main.getPlayer().getX(), Main.getPlayer().getY() + 50);
                jumpCounter = 0;
                jumpWeiter = false;
            }
            if (jumpCounter < 20) { //höhe vom Sprung in Zeit
                Main.getPlayer().positionSetzen(Main.getPlayer().getX(), Main.getPlayer().getY() - 8);
            } else {
                jumpCounter = 0;
                jumpWeiter = false;
            }
        }


        if (Main.getPlayer().getX() > 750) {
            Main.getAktiveLevel().playerIsRight();
        }

        if (Main.getPlayer().getY() < 0) {
            Main.getAktiveLevel().playerIsLeft();
        }

        if (a) {
            Main.getPlayer().positionSetzen(Main.getPlayer().getX() - 6, Main.getPlayer().getY());
        }
        if (d) {
            Main.getPlayer().positionSetzen(Main.getPlayer().getX() + 6, Main.getPlayer().getY());
        }
    }

    private boolean allowJumpFormGround() {
        if (Main.getPlayer().schneidet(Main.getAktiveLevel().getBoden())) {
            return true;
        }
        return false;
    }

    private boolean isJumpIntoSealing() {
        if (Main.getPlayer().schneidet(Main.getAktiveLevel().getBoden())) {
            return true;
        }
        return false;
    }

    @Override
    public void reagieren(int i) {
        switch (i) {
            case 22:
                //System.out.println("W");
                if (allowJumpFormGround()) {
                    System.out.println("jump");
                    Main.getPlayer().positionSetzen(Main.getPlayer().getX(), Main.getPlayer().getY() - 2);
                    jumpWeiter = true;
                }
                break;
            case 0:
                a = true;
                //System.out.println("A");
                break;
            case 3:
                d = true;
                //System.out.println("D");
                break;
            case 18:
                //System.out.println("S");
                break;
            case 4:
                //System.out.println("E");
                Main.getAktiveLevel().isEPressed();
                break;
            default:
                System.out.println(i);
                break;
        }
    }

    public void tasteLosgelassen(int i) {
        switch (i) {
            case 22:
                //System.out.println("W");
                break;
            case 0:
                a = false;
                //System.out.println("A");
                break;
            case 3:
                d = false;
                //System.out.println("D");
                break;
            case 18:
                //System.out.println("S");
                break;
            case 4:
                //System.out.println("E");
                break;
            default:
                System.out.println(i);
                break;
        }
    }
}
