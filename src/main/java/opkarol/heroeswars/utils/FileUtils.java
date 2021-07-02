package opkarol.heroeswars.utils;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static void saveCustomYml(FileConfiguration ymlConfig, File ymlFile) {
        try {
            ymlConfig.save(ymlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addDefault(FileConfiguration configuration, String path, Object object){
        configuration.addDefault(path, object);
    }

    public static void setObject(FileConfiguration configuration, String path, Object object){
        configuration.set(path, object);
    }
}
