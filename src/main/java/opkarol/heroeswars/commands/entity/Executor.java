package opkarol.heroeswars.commands.entity;

import opkarol.heroeswars.entity.Entity;
import opkarol.heroeswars.entity.SpawnEntity;
import opkarol.heroeswars.entity.database.EntitySaver;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Executor implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("H&W.test") || !player.isOp()) {
            return false;
        }

        if (args[0] == null){
            return false;
        }

        String objectToSpawnName = args[0];
        Location location = player.getLocation();;
        Entity entity = EntitySaver.getEntityFromConfig(objectToSpawnName);

        if (entity == null){
            return false;
        }

        if (args.length == 2){
            int times = Integer.parseInt(args[1]);
            new SpawnEntity().spawnEntity(location, entity, times);
            return true;
        } else if (args.length == 1){
            new SpawnEntity().spawnEntity(location, entity);
            return true;
        } else {
            //Bad usage
            return false;
        }
    }
}
