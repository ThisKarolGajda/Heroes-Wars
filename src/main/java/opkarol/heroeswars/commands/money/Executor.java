package opkarol.heroeswars.commands.money;

import opkarol.heroeswars.utils.MoneyUtils;
import opkarol.heroeswars.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

public class Executor extends MoneyUtils implements CommandExecutor {
    private static String dontHavePermission = "";
    private static String lastArgumentNotInteger = "";
    private static String targetDoesntExists = "";
    private static String badUsage = "";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission("H&W.test") || !sender.isOp()) {
            sender.sendMessage(dontHavePermission);
            return false;
        }

        if (args.length == 0 && sender instanceof Player) {
            Player player = (Player) sender;
            printMoney(sender, player, getPlayerMoney(player.getUniqueId()));
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);
        UUID uuid;
        if (target == null) {
            uuid = Bukkit.getOfflinePlayer(args[0]).getUniqueId();
        } else uuid = target.getUniqueId();

        if (sender.hasPermission("") || sender.isOp()) {
            if (args.length >= 3) {
                String amountString = args[2].replaceAll("/\\D+/g", "");
                if(!Utils.isNumeric(amountString)){
                    sender.sendMessage(lastArgumentNotInteger);
                    return false;
                }
                int amount = Integer.parseInt(amountString);
                switch (args[1]) {
                    case "set" -> setPlayerMoney(uuid, amount);
                    case "remove" -> removePartPlayerMoney(uuid, amount);
                    case "add" -> addPlayerMoney(uuid, amount);
                }
                return false;
            }

            if (Bukkit.getPlayer(uuid) == null) {
                sender.sendMessage(targetDoesntExists);
                return false;
            }

            if (args.length == 1) {
                printMoney(sender, Objects.requireNonNull(Bukkit.getPlayer(uuid)), getPlayerMoney(uuid));
                return false;
            }
        } else sender.sendMessage(dontHavePermission);


        sender.sendMessage(badUsage);
        return false;
    }

    public static void setBadUsage(String badUsage2) {
        badUsage = badUsage2;
    }

    public static void setDontHavePermission(String dontHavePermission2) {
        dontHavePermission = dontHavePermission2;
    }

    public static void setLastArgumentNotInteger(String lastArgumentNotInteger2) {
        lastArgumentNotInteger = lastArgumentNotInteger2;
    }

    public static void setTargetDoesntExists(String targetDoesntExists2) {
        targetDoesntExists = targetDoesntExists2;
    }
}
