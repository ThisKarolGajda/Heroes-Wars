package opkarol.heroeswars.entity.database;


import opkarol.heroeswars.entity.Entity;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

public class EntitySaver {

    private static final FileConfiguration configuration = EntityFileGenerator.getEntityFile();

    private static final HashMap<String, Entity> map = new HashMap<>();

    public void loadHashMap() {
        ConfigurationSection sec = configuration.getConfigurationSection("Entities");
        if (sec != null) {
            for (String key : sec.getKeys(false)) {
                String path = "Entities." + key + ".";
                map.put(key, new Entity(configuration.getString(path + "name"), configuration.getDouble(path + "speed"), configuration.getInt(path + "health"), configuration.getString(path + "type"), configuration.getBoolean(path + "baby")));
            }
        }
    }


    public static Entity getEntityFromConfig(String configsName){
        return map.get(configsName);

    }
}

