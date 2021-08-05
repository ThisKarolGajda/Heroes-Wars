package opkarol.heroeswars.utils;

import opkarol.heroeswars.game.money.MoneyLoader;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class MoneyUtils extends MoneyLoader {
    private static String sendMessage;

    public static void printMoney(@NotNull CommandSender sender, @NotNull Player target, int money){
        sender.sendMessage(sendMessage.replace("%user%", target.getName()).replace("%money%", String.valueOf(money)));
    }

    public static void removePartPlayerMoney(UUID player, int money){
        setPlayerMoney(player, getPlayerMoney(player)-money);
    }

    public static void setDefaultMoney(UUID player){
        if(playerBankAccountExists(player)) {
            setPlayerMoney(player, getCurrencyClass().getStartMoney());
        } else addPlayerToMap(player, getCurrencyClass().getStartMoney());

    }

    public static void setSendMessage(String sendMessage) {
        MoneyUtils.sendMessage = sendMessage;
    }
}
