package opkarol.heroeswars.utils;

import opkarol.heroeswars.Heroeswars;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigUtils {
    public static FileConfiguration getConfig() {
        return Heroeswars.getPlugin().getConfig();
    }

    public static String getString(String path) {
        return getConfig().getString(path);
    }
}
