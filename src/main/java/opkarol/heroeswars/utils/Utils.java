package opkarol.heroeswars.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Map;

public class Utils {

    public static boolean isNumeric(String str) {
        ParsePosition pos = new ParsePosition(0);
        NumberFormat.getInstance().parse(str, pos);
        return str.length() == pos.getIndex();
    }

    /*public static Player getPlayerFromMap(@NotNull Map<String, Object> player){
        return Bukkit.getPlayer(String.valueOf(player.keySet()));
    }

    public static Map<String, Object> getMapFromPlayer(Player player){
        return player.serialize();
    }

     */

}
