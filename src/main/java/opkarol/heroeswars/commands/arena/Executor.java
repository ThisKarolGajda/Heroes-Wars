package opkarol.heroeswars.commands.arena;

import opkarol.heroeswars.game.arena.database.ArenaDatabase;
import opkarol.heroeswars.game.arena.editor.inventory.EditorInventory;
import opkarol.heroeswars.utils.ArenaUtils;
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
        if (args.length != 0){
            if (ArenaDatabase.getArenaFromList(args[0]) == null) return false;
           sender.spigot().sendMessage(ArenaUtils.getArenaInformation(ArenaDatabase.getArenaFromList(args[0])));
        } else {
            player.openInventory(new EditorInventory().getInventory());
        }
        return true;
    }
}
