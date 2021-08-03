package opkarol.heroeswars.commands.arena;

import opkarol.heroeswars.game.arena.editor.inventory.EditorInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Executor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("H&W.test") || !player.isOp()) {
            return false;
        }
        player.openInventory(new EditorInventory().getInventory());
        return false;
    }
}
