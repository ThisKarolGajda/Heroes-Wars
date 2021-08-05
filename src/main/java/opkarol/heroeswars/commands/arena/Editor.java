package opkarol.heroeswars.commands.arena;

import opkarol.heroeswars.Heroeswars;
import opkarol.heroeswars.game.arena.Arena;
import opkarol.heroeswars.game.arena.database.ArenaDatabase;
import opkarol.heroeswars.game.arena.editor.inventory.events.holder.EditorHolderDatabase;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Editor implements CommandExecutor {
    public static Object returnValue;

    public static Object getReturnValue() {
        return returnValue;
    }

    public static void setReturnValue(Object returnValue) {
        Editor.returnValue = returnValue;
    }
    private static String clickOnBlockSpawn;
    private static String successfulSetSpawns;
    private static String successfulSetSpawn1;
    private static String clickOnBlockBound;
    private static String successfulSetBounds;
    private static String successfulSetBound1;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("H&W.test") || !player.isOp()) {
            return false;
        }
        if (args.length == 0) {
            return false;
        }

        if (args[0] == null || args[1] == null) {
            return false;
        }

        if (EditorHolderDatabase.isNotActiveEditor(player)) {
            String object = args[1];
            Arena arena = ArenaDatabase.getArenaFromList(args[0]);
            assert arena != null;
            setReturnValue(null);
            switch (object) {
                case "spawn" -> {
                    final int[] i = {1};
                    EditorHolderDatabase.addActiveEditor(player);
                    BukkitTask task = new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.sendMessage(clickOnBlockSpawn + i[0]);
                            if (getReturnValue() != null) {
                                if (i[0] == 1) {
                                    arena.setSpawn1((Location) returnValue);
                                    i[0]++;
                                    setReturnValue(null);
                                    player.sendMessage(successfulSetSpawn1);
                                } else {
                                    arena.setSpawn2((Location) returnValue);
                                    EditorHolderDatabase.removeEditor(player);
                                    this.cancel();
                                    player.sendMessage(successfulSetSpawns);
                                }
                            }
                        }

                    }.runTaskTimerAsynchronously(Heroeswars.getPlugin(), 10, 20);
                }

                case "bound" -> {
                    final int[] i2 = {1};
                    EditorHolderDatabase.addActiveEditor(player);
                    BukkitTask task2 = new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.sendMessage(clickOnBlockBound + i2[0]);
                            if (getReturnValue() != null) {
                                if (i2[0] == 1) {
                                    arena.setBound1((Location) returnValue);
                                    i2[0]++;
                                    setReturnValue(null);
                                    player.sendMessage(successfulSetBound1);
                                } else {
                                    arena.setBound2((Location) returnValue);
                                    EditorHolderDatabase.removeEditor(player);
                                    this.cancel();
                                    player.sendMessage(successfulSetBounds);
                                }
                            }
                        }

                    }.runTaskTimerAsynchronously(Heroeswars.getPlugin(), 10, 20);
                }
            }
        }
        return false;
    }

    public static void setClickOnBlockBound(String clickOnBlockBound) {
        Editor.clickOnBlockBound = clickOnBlockBound;
    }

    public static void setClickOnBlockSpawn(String clickOnBlockSpawn) {
        Editor.clickOnBlockSpawn = clickOnBlockSpawn;
    }

    public static void setSuccessfulSetBound1(String successfulSetBound1) {
        Editor.successfulSetBound1 = successfulSetBound1;
    }

    public static void setSuccessfulSetBounds(String successfulSetBounds) {
        Editor.successfulSetBounds = successfulSetBounds;
    }

    public static void setSuccessfulSetSpawn1(String successfulSetSpawn1) {
        Editor.successfulSetSpawn1 = successfulSetSpawn1;
    }

    public static void setSuccessfulSetSpawns(String successfulSetSpawns) {
        Editor.successfulSetSpawns = successfulSetSpawns;
    }
}
