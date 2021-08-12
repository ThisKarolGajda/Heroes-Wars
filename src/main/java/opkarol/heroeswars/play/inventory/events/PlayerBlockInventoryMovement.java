package opkarol.heroeswars.play.inventory.events;


import opkarol.heroeswars.game.mode.GameDatabase;
import opkarol.heroeswars.game.queue.Queue;
import opkarol.heroeswars.game.queue.files.QueueDatabase;
import opkarol.heroeswars.play.inventory.holder.PlayInventoryHolder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Objects;

public class PlayerBlockInventoryMovement extends QueueDatabase implements Listener {
    HashMap<Player, Queue> hashMap = new HashMap<>();

    @EventHandler(priority = EventPriority.MONITOR)
    public void playerBlockInventoryMovement(@NotNull InventoryClickEvent event){
        if (event.getInventory().getHolder() instanceof PlayInventoryHolder) {
            event.setCancelled(true);
            if (event.getRawSlot() == -999) return;
            ItemStack item = event.getCurrentItem();
            if (item == null) return;
            Queue queue = QueueDatabase.getQueueFromGameMode(GameDatabase.getGameModeFromListString(Objects.requireNonNull(item.getItemMeta()).getDisplayName()));
            changeActiveQueuing((Player) event.getWhoClicked(), queue);
            event.getWhoClicked().closeInventory();
        }
    }

    private static String addedToQueue;
    private static String removedFromQueue;

    public void changeActiveQueuing(Player player, Queue queue){
        if (!isActiveQueuing(player)){
            hashMap.put(player, queue);
            player.sendMessage(replaceQueueValue(addedToQueue, queue));
            addPlayerFromQueue(queue, player);
            replaceQueue(queue);
        } else {
            Queue oldQueue = getActiveQueue(player);
            removeActiveQueuing(player);
            if (oldQueue != queue){
                hashMap.put(player, queue);
                removePlayerFromQueue(oldQueue, player);
                addPlayerFromQueue(queue, player);
                replaceQueue(queue);
                player.sendMessage(replaceQueueValue(addedToQueue, queue));
            } else {
                removePlayerFromQueue(queue, player);
                replaceQueue(queue);
                player.sendMessage(replaceQueueValue(removedFromQueue, queue));
            }
        }
    }

    public void removePlayerFromQueue(Queue queue, Player player) {
        queue.getPlayerQueue().remove(player);
    }

    public void addPlayerFromQueue(Queue queue, Player player) {
        queue.getPlayerQueue().add(player);
    }

    public String replaceQueueValue(String message, Queue queue){
        return message.replace("%queue_name%", queue.getGameMode().getGameName());
    }

    public void removeActiveQueuing(Player player){
        hashMap.remove(player);
    }

    public boolean isActiveQueuing(Player player){
        return !(hashMap.get(player) == null);
    }

    public Queue getActiveQueue(Player player){
        if (isActiveQueuing(player)) return hashMap.get(player);
        return null;
    }

    public static void setAddedToQueue(String addedToQueue) {
        PlayerBlockInventoryMovement.addedToQueue = addedToQueue;
    }

    public static void setRemovedFromQueue(String removedFromQueue) {
        PlayerBlockInventoryMovement.removedFromQueue = removedFromQueue;
    }
}
