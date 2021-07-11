package opkarol.heroeswars.entity.database;

import opkarol.heroeswars.Heroeswars;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

import static opkarol.heroeswars.utils.FileUtils.saveCustomYml;

public class EntityFileGenerator {


    public EntityFileGenerator() {
        saveCustomYml(configuration, entityFile);
    }

    private static final File entityFile = new File(Heroeswars.getPlugin().getDataFolder() + "/entity/entity.yml");
    private static final FileConfiguration configuration = YamlConfiguration.loadConfiguration(entityFile);

    public static FileConfiguration getEntityFile() {
        return configuration;
    }
}


/*
Entities:
 1:
  name: T
  speed: 2f
  health: 20
  type: Zombie
  baby: true

 */