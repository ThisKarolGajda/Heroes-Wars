package opkarol.heroeswars.play.inventory;

import opkarol.heroeswars.game.mode.GameMode;
import opkarol.heroeswars.game.queue.Queue;
import opkarol.heroeswars.game.queue.QueueDatabase;
import opkarol.heroeswars.play.inventory.holder.PlayInventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PlayInventory extends QueueDatabase {
    private static String name;
    private static int size;

    public Inventory inventory = Bukkit.createInventory(new PlayInventoryHolder(), size, name);

    public static void setName(String name) {
        PlayInventory.name = name;
    }

    public static void setSize(int size) {
        PlayInventory.size = size;
    }

    public PlayInventory(){
        int i = 0;
        for (GameMode mode : getGameQueue().keySet()){
            Queue queue = getQueueFromGameMode(mode);
            inventory.setItem(i, generateQueueIcon(queue));
            i++;
        }
    }

    private static String iconNameText;
    private static String iconLoreText;
    public ItemStack generateQueueIcon(Queue queue) {
        ItemStack itemStack = new ItemStack(Material.OAK_WOOD);
        ItemMeta meta = itemStack.getItemMeta();
        List<String> lore = new ArrayList<>();
        assert meta != null;

        meta.setDisplayName(iconNameText.replace("%queue_icon_name%", queue.getGameMode().getGameName()));
        lore.add(iconLoreText.replace("%queue_icon_size%", String.valueOf(queue.getPlayerQueue().size())));

        meta.setLore(lore);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public static void setIconLoreText(String iconLoreText) {
        PlayInventory.iconLoreText = iconLoreText;
    }

    public static void setIconNameText(String iconNameText) {
        PlayInventory.iconNameText = iconNameText;
    }
}

