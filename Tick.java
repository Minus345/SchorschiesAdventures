import ea.TastenLosgelassenReagierbar;
import ea.TastenReagierbar;
import ea.Ticker;

public class Tick implements Ticker, TastenReagierbar, TastenLosgelassenReagierbar {

    private boolean continueJumping;
    private int jumpCounter;

    private boolean w;
    private boolean a;
    private boolean d;


    /**
     * the method is called every tick
     */
    public void tick() {
        //wenn nichts unter dir ist dann nach unten fallen (nicht springen)
        if (!Main.getPlayer().schneidet(Main.getAktiveLevel().getFloor()) && !continueJumping) {
            Main.getPlayer().setPosition(Main.getPlayer().getX(), Main.getPlayer().getY() + 8);
        }

        if (Main.getAktiveLevel().getLava() != null && Main.getPlayer().schneidet(Main.getAktiveLevel().getLava())) { //berührung mit Lava
            //stoppen();
            System.out.println("in Lava gefallen");
        }

        if (continueJumping) {
            jumpCounter++;
            //Wenn Player vom Boden weg ist und gegen die Decke stöst
            if (jumpCounter > 10 && isJumpIntoSealing()) {
                Main.getPlayer().setPosition(Main.getPlayer().getX(), Main.getPlayer().getY() + 70);
                jumpCounter = 0;
                continueJumping = false;
            }
            if (jumpCounter < 20) { //höhe vom Sprung in Zeit
                Main.getPlayer().setPosition(Main.getPlayer().getX(), Main.getPlayer().getY() - 8);
            } else {
                jumpCounter = 0;
                continueJumping = false;
            }
        }

        //Is Right
        if (Main.getPlayer().getX() > 900) {
            Main.getAktiveLevel().playerIsRight();
        }

        //Is Left
        if (Main.getPlayer().getX() < 0) {
            Main.getAktiveLevel().playerIsLeft();
        }

        if (a && !Main.getPlayer().getLeftHitBox().schneidet(Main.getAktiveLevel().getFloor())) { //checks if the player runs into stairs on the ground - left
            Main.getPlayer().setPosition(Main.getPlayer().getX() - 6, Main.getPlayer().getY());
        }
        if (d && !Main.getPlayer().getRightHitBox().schneidet(Main.getAktiveLevel().getFloor())) { //checks if the player runs into stairs on the ground - right
            Main.getPlayer().setPosition(Main.getPlayer().getX() + 6, Main.getPlayer().getY());
        }
    }

    //are the same methods????
    private boolean allowJumpFormGround() {
        if (Main.getPlayer().schneidet(Main.getAktiveLevel().getFloor())) {
            return true;
        }
        return false;
    }

    private boolean isJumpIntoSealing() {
        if (Main.getPlayer().schneidet(Main.getAktiveLevel().getFloor())) {
            return true;
        }
        return false;
    }

    /**
     * is called whenever a key is pressed and executes the key funktion
     *
     * @param i input key
     */
    @Override
    public void reagieren(int i) {
        switch (i) {
            case 22:
                //System.out.println("W");
                if (allowJumpFormGround()) {
                    System.out.println("jump");
                    Main.getPlayer().setPosition(Main.getPlayer().getX(), Main.getPlayer().getY() - 2);
                    continueJumping = true;
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

    /**
     * is called whenever a key is not more pressed
     *
     * @param i input key
     */
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
