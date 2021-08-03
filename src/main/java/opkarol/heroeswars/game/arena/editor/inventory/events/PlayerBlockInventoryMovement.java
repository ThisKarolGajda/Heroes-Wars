package opkarol.heroeswars.game.arena.editor.inventory.events;

import opkarol.heroeswars.game.arena.database.ArenaDatabase;
import opkarol.heroeswars.game.arena.editor.inventory.holder.EditorInventoryHolder;
import opkarol.heroeswars.utils.ArenaUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PlayerBlockInventoryMovement implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void playerBlockInventoryMovement(InventoryClickEvent event){
        if (event.getInventory().getHolder() instanceof EditorInventoryHolder) {
            event.setCancelled(true);
            event.getWhoClicked().spigot().sendMessage(ArenaUtils.getArenaInformation(ArenaDatabase.getArenaFromList(event.getSlot() + 1)));
            event.getWhoClicked().closeInventory();
        }
    }
}
