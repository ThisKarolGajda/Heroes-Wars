package opkarol.heroeswars.game.arena.editor.inventory;

import opkarol.heroeswars.game.arena.Arena;
import opkarol.heroeswars.game.arena.database.ArenaDatabase;
import opkarol.heroeswars.game.arena.database.ArenaFileGenerator;
import opkarol.heroeswars.game.arena.editor.inventory.holder.EditorInventoryHolder;
import opkarol.heroeswars.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class EditorInventory {
    String guiTitle = ArenaFileGenerator.getConfigurationSettings().getString("Inventory.name");
    int guiSize = ArenaFileGenerator.getConfigurationSettings().getInt("Inventory.size");

    public Inventory gui = Bukkit.createInventory(new EditorInventoryHolder(), guiSize, Objects.requireNonNull(ColorUtils.formatText(guiTitle)));

    public EditorInventory(){
        setGui();
    }

    public void setGui() {
        int i = 0;
        ItemStack itemStack = new ItemStack(Material.ACACIA_PLANKS);
        ItemMeta meta;
        for (Arena arena : ArenaDatabase.getArenaList()){
            meta = itemStack.getItemMeta();
            assert meta != null;
            meta.setDisplayName(arena.getArenaName());
            itemStack.setItemMeta(meta);
            gui.setItem(i, itemStack);
            i++;
        }
    }

    public Inventory getInventory(){
        return gui;
    }
}
