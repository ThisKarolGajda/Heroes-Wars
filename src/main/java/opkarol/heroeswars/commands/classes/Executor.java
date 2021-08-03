package opkarol.heroeswars.commands.classes;

import opkarol.heroeswars.classes.database.ClassSaver;
import opkarol.heroeswars.classes.gui.ClassesMainGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Executor implements CommandExecutor {
    ClassesMainGui cgui;

    public Executor(){
        cgui = new ClassesMainGui(new ClassSaver().getClassList());
        cgui.setGui();
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("H&W.test") || !player.isOp()) {
            return false;
        }
        player.openInventory(cgui.gui);
        return false;
    }

}
