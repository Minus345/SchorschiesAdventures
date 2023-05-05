import ea.Text;

import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Inv.
 *
 * @author Max
 * @version 2
 */
public class Inv {
    public static boolean hasPotion;
    private static Text text;
    private static String invList;
    private static ArrayList<Key> keys = new ArrayList<>();

    public static void createInv() {
        text = new Text("text",200,200,20);
        Main.getFrame().add(text);
        updateInv();
    }

    public static void updateInv() {
        invList = "Inventar:";
        if (isHasPotion()) {
            invList = invList + " Trank";
        }

        String textKeys = "";
        for (int j = 0; j <= keys.size() - 1; j++) {
            textKeys = textKeys + " " + keys.get(j).getName();
        }

        invList = invList + " " + textKeys;

        text.setzeInhalt(invList);
        text.positionSetzen(600, 20);
    }

    public static boolean isHasPotion() {
        return hasPotion;
    }

    public static void setHasPotion(boolean hasPotion) {
        Inv.hasPotion = hasPotion;
    }

    public static void addKey(Key key) {
        keys.add(key);
        updateInv();
    }

    public static void removeKey(Key key) {
        keys.remove(key);
        updateInv();
    }

    public static void removeKey(String name) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).getName().equals(name)) {
                keys.remove(i);
            }
        }
        updateInv();
    }

    public static boolean hasKey(String name) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
