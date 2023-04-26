/**
 * Spielfigur Dorian
 *
 * @author Johannes Neumeyer
 * @version 1.0
 */
public class Player extends Figur {
    private boolean stop;
    private int springenCounter;
    private boolean jumpWeiter;
    private boolean jumpIntoSealing;

    private int jumpCounter;

    public Player() {
        super();
        stop = false;
        FigurFestlegen();
        PositionSetzen(300, 350);
    }

    /**
     * @param taste die gedrückte Taste
     */
    @Override
    void TasteGedrückt(char taste) {
        //System.out.println(taste);
        if (!Main.isRunning()) return;
        switch (taste) {
            case 'w':
                if (allowJumpFormGround()) {
                    System.out.println("jump");
                    PositionSetzen(XPositionGeben(), YPositionGeben() - 2);
                    jumpWeiter = true;
                }
                break;
            case 'a':
                System.out.println("links");
                PositionSetzen(XPositionGeben() - 6, YPositionGeben());
                break;
            case 'd':
                System.out.println("rechts");
                PositionSetzen(XPositionGeben() + 6, YPositionGeben());
                break;

            case 'e':
                Main.getAktiveLevel().isEPressed();
        }
    }

    private boolean allowJumpFormGround() {
        if (Berührt("grau")) {
            return true;
        }
        return false;
    }

    private boolean isJumpIntoSealing() {
        if (Berührt("grau")) {
            return true;
        }
        return false;
    }


    @Override
    void AktionAusführen() {
        //wenn nichts unter dir ist dann nach unten fallen (nicht springen)
        if (!Berührt("grau") && !jumpWeiter) {
            PositionSetzen(XPositionGeben(), YPositionGeben() + 8);
            springenCounter = 0;
        }

        if (Berührt("gelb")) { //berührung mit Lava
            stoppen();
            System.out.println("in Lava gefallen");
        }

        if (jumpWeiter) {
            jumpCounter++;
            //Wenn Player vom Boden weg ist und gegen die Decke stöst
            if (jumpCounter > 10 && isJumpIntoSealing()) {
                PositionSetzen(XPositionGeben(), YPositionGeben() + 40);
                jumpCounter = 0;
                jumpWeiter = false;
            }
            if (jumpCounter < 20) { //höhe vom Sprung in Zeit
                PositionSetzen(XPositionGeben(), YPositionGeben() - 8);
            } else {
                jumpCounter = 0;
                jumpWeiter = false;
            }
        }

        //System.out.println(XPositionGeben());

        if(XPositionGeben() > 750 ){
            Main.getAktiveLevel().playerIsRight();
        }

        if(XPositionGeben() < 0 ){
            Main.getAktiveLevel().playerIsLeft();
        }

    }

    /**
     * Stoppt das Spiel, z. B. wenn Dorian das Ziel eines Levels erreicht hat
     */
    public void stoppen() {
        stop = true;
    }

    /**
     * Legt das Aussehen von Dorian fest.
     */
    private void FigurFestlegen() {
        GrößeSetzen(50);

        FigurteilFestlegenRechteck(0, 0, 50, 50, "rot");

    }

    public boolean isStop() {
        return stop;
    }

}
