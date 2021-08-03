package opkarol.heroeswars.game.arena.editor.inventory.events;

import opkarol.heroeswars.commands.arena.Editor;
import opkarol.heroeswars.game.arena.editor.inventory.events.holder.EditorHolderDatabase;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreakBlockEvent implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void playerBreakBlockEvent(BlockBreakEvent event){
        if(!EditorHolderDatabase.isActiveEditor(event.getPlayer())) return;
        Editor.setReturnValue(event.getBlock().getLocation());
        event.setCancelled(true);
    }
}
