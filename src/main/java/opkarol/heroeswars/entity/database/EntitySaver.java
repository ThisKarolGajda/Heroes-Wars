package opkarol.heroeswars.entity.database;


import opkarol.heroeswars.entity.Entity;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class EntitySaver {

    FileConfiguration configuration = EntityFileGenerator.getEntityFile();

    List<Entity> list = new ArrayList<>();

    public EntitySaver() {
        ConfigurationSection sec = configuration.getConfigurationSection("Entities");
        if (sec != null) {
            for (String key : sec.getKeys(false)) {
                String path = "Entities." + key + ".";
                list.add(new Entity(configuration.getString(path + "name"), configuration.getDouble(path + "speed"), configuration.getInt(path + "health"), (EntityType) configuration.get(path + "type"), configuration.getBoolean(path + "baby")));
            }
        }
    }

    public List<Entity> getEntityList() {
        return this.list;
    }
}
