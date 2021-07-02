package opkarol.heroeswars.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class ColorUtils {

    public static String formatText(String toFormat) {
        if(toFormat==null){
            return "注意！このメッセージは正しくロードされていません。サーバー管理者に連絡してください。!";
        }
        return ChatColor.translateAlternateColorCodes('&', toFormat);
    }


    public static List<String> formatList(List<String> lore){
        List<String> Lore = new ArrayList<>();
        for(String s : lore){
            Lore.add(formatText(s));
        }
        return Lore;
    }


}
