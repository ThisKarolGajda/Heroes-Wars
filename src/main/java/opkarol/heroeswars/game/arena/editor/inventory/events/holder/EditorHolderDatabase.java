package opkarol.heroeswars.game.arena.editor.inventory.events.holder;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class EditorHolderDatabase {

    private static HashMap<Player, Boolean> activeEditor = new HashMap<>();

    public static HashMap<Player, Boolean> getActiveEditor(){
        return activeEditor;
    }

    public static void setActiveEditor(HashMap<Player, Boolean> activeEditor) {
        EditorHolderDatabase.activeEditor = activeEditor;
    }

    public static void addActiveEditor(Player player){
        activeEditor.put(player, true);
    }

    public static boolean isActiveEditor(Player player){
        return activeEditor.containsKey(player);
    }

    public static void removeEditor(Player player){
        activeEditor.remove(player);
    }

}
