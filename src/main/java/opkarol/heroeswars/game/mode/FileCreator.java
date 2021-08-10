package opkarol.heroeswars.game.mode;

import opkarol.heroeswars.Heroeswars;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

import static opkarol.heroeswars.utils.FileUtils.saveCustomYml;

public class FileCreator {

    private static final File file = new File(Heroeswars.getPlugin().getDataFolder() + "/mode/modes.yml");
    private static final FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);

    public FileCreator(){
        saveCustomYml(configuration, file);
    }

    public static File getFile() {
        return file;
    }


    public static FileConfiguration getConfiguration() {
        return configuration;
    }
}
