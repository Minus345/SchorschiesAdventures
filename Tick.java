import ea.TastenLosgelassenReagierbar;
import ea.TastenReagierbar;
import ea.Ticker;

public class Tick implements Ticker, TastenReagierbar, TastenLosgelassenReagierbar {

    private boolean continueJumping;
    private int jumpCounter;

    private boolean w;
    private boolean a;
    private boolean d;

    private int x = 0;
    private int y = 0;
    private int x1 = 0;
    private int y1 = 0;

    /**
     * the method is called every tick
     */
    public void tick() {
        if(Main.getPlayer() == null) return;
        //wenn nichts unter dir ist dann nach unten fallen (nicht springen)
        if (!Main.getPlayer().schneidet(Main.getAktiveLevel().getFloor()) && !continueJumping) {
            Main.getPlayer().setPosition(Main.getPlayer().getX(), (float) (Main.getPlayer().getY() + 8));
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
            if (jumpCounter < 13) { //höhe vom Sprung in Zeit
                Main.getPlayer().setPosition(Main.getPlayer().getX(), (float) (Main.getPlayer().getY() - 8));
                //System.out.println(jumpCounter + "  " + x);
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

        if(d){
            x++;
            if(x == 5){
               // System.out.println("animation");
                y++;
                if(y == 5){
                    y = 0;
                }
                x = 0;
            }
            switch(y){
                case 0:
                    Main.getPlayer().setPictureRechts(0);
                    break;
                case 1:    
                    Main.getPlayer().setPictureRechts(1);
                    break;
                case 2:
                    Main.getPlayer().setPictureRechts(2);
                    break;
                case 3:
                    Main.getPlayer().setPictureRechts(3);
                    break;
                case 4:
                    Main.getPlayer().setPictureRechts(4);
                    break;
                case 5:
                    Main.getPlayer().setPictureRechts(5);
                    break;

            }
        }

        if(a){
            x1++;
            if(x1 == 5){
                //System.out.println("animation");
                y1++;
                if(y1 == 5){
                    y1 = 0;
                }
                x1 = 0;
            }
            switch(y1){
                case 0:
                    Main.getPlayer().setPictureLinks(0);
                    break;
                case 1:    
                    Main.getPlayer().setPictureLinks(1);
                    break;
                case 2:
                    Main.getPlayer().setPictureLinks(2);
                    break;
                case 3:
                    Main.getPlayer().setPictureLinks(3);
                    break;
                case 4:
                    Main.getPlayer().setPictureLinks(4);
                    break;
                case 5:
                    Main.getPlayer().setPictureLinks(5);
                    break;

            }
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
                    //System.out.println("jump");
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
