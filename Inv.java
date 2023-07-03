import ea.Text;

import java.util.ArrayList;

/**
 * @author Max
 * @version 2
 */
public class Inv {
    private static final ArrayList<Key> keys = new ArrayList<>();
    public static boolean hasPotion;
    private static Text text;

    /**
     * creates the inventory and the display text in the upper right corner
     */
    public static void createInv() {
        text = new Text("text", 200, 200);
        Main.getFrame().add(text);
        updateInv();
    }

    /**
     * updates the inventory so the new items are visible to the player
     */
    public static void updateInv() {
        String invList = "Inventar:";
        if (isHasPotion()) {
            invList = invList + " Trank";
        }

        StringBuilder textKeys = new StringBuilder();
        for (int j = 0; j <= keys.size() - 1; j++) {
            textKeys.append(" ").append(keys.get(j).getName());
        }

        invList = invList + " " + textKeys;

        text.setzeInhalt(invList);
        text.positionSetzen(30, 640);
    }

    public static boolean isHasPotion() {
        return hasPotion;
    }

    public static void setHasPotion(boolean hasPotion) {
        Inv.hasPotion = hasPotion;
    }

    /**
     * adds a key to the key list
     *
     * @param key key
     */
    public static void addKey(Key key) {
        keys.add(key);
        updateInv();
    }

    /**
     * removes the key out of the key list
     *
     * @param key key
     */
    public static void removeKey(Key key) {
        keys.remove(key);
        updateInv();
    }

    /**
     * removes the key out of the key list
     *
     * @param name key-name
     */
    @SuppressWarnings("SuspiciousListRemoveInLoop")
    public static void removeKey(String name) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).getName().equals(name)) {
                keys.remove(i);
            }
        }
        updateInv();
    }

    /**
     * checks if the key is in the inventory
     *
     * @param name key-name
     */
    public static boolean hasKey(String name) {
        for (Key key : keys) {
            if (key.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
