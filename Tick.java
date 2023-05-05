import ea.TastenReagierbar;
import ea.Ticker;

public class Tick implements Ticker, TastenReagierbar {
    public void tick() {
    }

    @Override
    public void reagieren(int i) {
        switch (i) {
            case 22:
                System.out.println("W");
                break;
            case 0:
                System.out.println("A");
                break;
            case 18:
                System.out.println("S");
                break;
            case 3:
                System.out.println("D");
                break;
            case 4:
                System.out.println("E");
                break;
            default:
                System.out.println(i);
                break;
        }
    }
}
