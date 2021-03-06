package opkarol.heroeswars.game.arena.database;

import opkarol.heroeswars.Heroeswars;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

import static opkarol.heroeswars.utils.FileUtils.addDefault;
import static opkarol.heroeswars.utils.FileUtils.saveCustomYml;

public class ArenaFileGenerator {

    public ArenaFileGenerator() {
        setConfigurationSettings();
        saveCustomYml(configuration, file);
        saveCustomYml(configuration2, file2);
        new ArenaDatabase().arenaLoader();
    }

    private static final File file = new File(Heroeswars.getPlugin().getDataFolder() + "/arena/arenas.yml");
    private static final FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);

    public static FileConfiguration getArenaFile() {
        return configuration;
    }

    public static File getArenaFileMain(){ return file;}

    private static final File file2 = new File(Heroeswars.getPlugin().getDataFolder() + "/arena/arenaSettings.yml");
    private static final FileConfiguration configuration2 = YamlConfiguration.loadConfiguration(file2);

    public static FileConfiguration getConfigurationSettings(){
        return configuration2;
    }

    public static void setConfigurationSettings(){
        if (!file2.exists()){
            addDefault(configuration2, "Inventory.name","Inventory Name");
            addDefault(configuration2, "Inventory.size", 27);
        }
    }
}
